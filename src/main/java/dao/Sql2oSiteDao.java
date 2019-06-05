package dao;

import models.DB;
import models.Site;
import org.sql2o.*;
import java.util.List;

public class Sql2oSiteDao implements SiteDao {  //implementing our interface

    private final Sql2o sql2o;

    public Sql2oSiteDao(Sql2o sql2o) {
        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it
    }

    @Override
    public void saveSite(Site site) {
        try(Connection con = DB.sql2o.open()) { //try to open a connection
            String sql ="INSERT INTO sites (name, engineerId) VALUES (:name, :engineerId)"; //raw sql
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .addParameter("name", site.getSiteName())
                    .addParameter("engineerId", site.getEngineerId())
                    .executeUpdate()
                    .getKey();
            site.setId(id);
        }

    }


}
