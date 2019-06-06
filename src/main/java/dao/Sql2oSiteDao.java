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


    //---------------------SAVE / ADD NEW  SITE ----------------------//
    @Override
    public void saveSite(Site site) {
        try(Connection con = DB.sql2o.open()) { //try to open a connection
            String sql ="INSERT INTO sites (site_name, site_id, region, location, engineerId) VALUES (:site_name, :site_id, :region, :location, :engineerId)"; //raw sql
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .addParameter("site_name", site.getSiteName())
                    .addParameter("site_id", site.getSite_id())
                    .addParameter("region", site.getRegion())
                    .addParameter("location", site.getLocation())
                    .addParameter("engineerId", site.getEngineerId())
                    .executeUpdate()
                    .getKey();  //int id is now the row number (row “key”) of db
            site.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);  // We have error!
        }

    }

    // --------------------FIND /LIST BY ID ------------------------//
    @Override
    public Site findSite(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sites WHERE id=:id";
            Site site = con.createQuery(sql)
                    .addParameter("id", id)  //key/value pair, key must match above
                    .executeAndFetchFirst(Site.class);  //fetch an individual item
            return site;
        }
    }
    // --------------------LIST ALL --------------------------------//
    @Override
    public List<Site> listAllSites() {
        String sql = "SELECT * FROM sites";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Site.class);  //fetch a list
        }
    }

    // --------------------UPDATE METHOD------------------------- //
//    @Override
//    public void updateSite(Site site) {
//        String sql = "UPDATE sites SET site_name = :site_name, site_id = :site_id, region = :region, location = location WHERE id=:id";
//        try(Connection con = DB.sql2o.open()) {
//            con.createQuery(sql)
//                    .addParameter("site_name", site.getSiteName())
//                    .addParameter("site_id", site.getSite_id())
//                    .addParameter("region", site.getRegion())
//                    .addParameter("location", site.getLocation())
//                    .addParameter("engineerId", site.getEngineerId())
//                    .addParameter("id", site.getId())
//                    .executeUpdate();
//        }
//    }

    // -------------------DELETE SITE ----------------------------//
    @Override
    public void deleteSitesById(int id) {
        String sql = "DELETE FROM sites WHERE id=:id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id.", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void ClearAllSites() {
        String sql = "DELETE FROM tasks";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


}
