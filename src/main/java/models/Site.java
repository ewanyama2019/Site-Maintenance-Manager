package models;

import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Site {

    private String site_name;
    private String site_id;
    private String region;
    private String location;
    private int engineerId;
    private int id;



    public Site(String site_name, String site_id, String region, String location, int engineerId) {
        this.site_name = site_name;
        this.site_id = site_id;
        this.region = region;
        this.location = location;
        this.engineerId = engineerId;
        this.id = id;


    }

    // -------------- GETTERS ------------------------
    public String getSiteName() {
        return site_name;
    }

    public String getSite_id() {
        return site_id;
    }

    public String getRegion() {
        return region; }

    public String getLocation() {
        return location; }

    public int getEngineerId() {
        return engineerId;
    }

    public int getId() {
        return id;
    }



    //------------- SETTERS -------------------------

    public void setSiteName(String site_name) {
        this.site_name = site_name;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEngineerId(int engineerId) {
        this.engineerId = engineerId;
    }

    public void setId(int id) {
        this.id = id;
    }



    // ------------------------------------

    @Override
    public boolean equals(Object otherSite) {
        if (!(otherSite instanceof Site)) {
            return false;
        } else {
            Site newSite = (Site) otherSite;
            return this.getSiteName().equals(newSite.getSiteName()) && this.getSite_id().equals(newSite.getSite_id()) && this.getRegion().equals(newSite.getRegion()) && this.getLocation().equals(newSite.getLocation()) && this.getEngineerId() == newSite.getEngineerId();
        }
    }

    public int hashCode() {
        return Objects.hash(getSiteName(), getSite_id(), getRegion(), getLocation(), getEngineerId())
    }

    // ---------------------- SAVE SITES METHOD - CREATES RECORD IN DB ------------------------

    public void saveSite() {
        try(Connection con = DB.sql2o.open()) {
            String sql ="INSERT INTO sites (site_name, site_id, region, location, engineerId) VALUES (:site_name, :site_id, :region, :location, :engineerId)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("site_name", this.site_name)
                    .addParameter("site_id", this.site_id)
                    .addParameter("region", this.region)
                    .addParameter("location", this.location)
                    .addParameter("engineerId", this.engineerId)
                    .executeUpdate()
                    .getKey();
        }
    }

    // ---------------------LISTALLSITES METHOD - LIST ALL SITES RECORDS IN THE DB -------------

    public static List<Site> listAllSites() {
        String sql = "SELECT * FROM sites";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Site.class);
        }
    }

    //---------------------FINDSITE METHOD - FIND SITE BY ENGINEER_ID --------------------------

    public static Site findSite(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sites where id=:id";
            Site site = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Site.class);
            return site;
        }
    }





}
