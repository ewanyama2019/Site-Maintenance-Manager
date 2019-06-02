package models;

import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource{

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/site_maintenance_test", "postgres", "wanyama123"); //Those with linux or windows use two strings for username and password
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteEngineersQuery = "DELETE FROM engineers *;";
            String deleteSitesQuery = "DELETE FROM sites *;";
            con.createQuery(deleteEngineersQuery).executeUpdate();
            con.createQuery(deleteSitesQuery).executeUpdate();
        }
    }
}
