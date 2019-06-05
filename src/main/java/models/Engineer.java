
package models;

import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;


public class Engineer {
    private String firstname;
    private String lastname;
    private String email;
    private String ek_number;
    private int id;

    public Engineer(String firstname, String lastname, String ek_number, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.ek_number = ek_number;
        this.id = id;
    }

   // ----------GETTER METHODS ------------------------------

    public String getFirstName() {
        return firstname;
    }

    public String getLasttName() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getEk_number() {
        return ek_number;
    }


    public int getId() {
        return id;
    }

    // ----- SETTER METHODS --------------------------------


    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEk_number(String ek_number) {
        this.ek_number = ek_number;
    }

    public void setId(int id) {
        this.id = id;
    }


    // -----------

    @Override
    public boolean equals(Object otherEngineer) {
        if (!(otherEngineer instanceof Engineer)) {
            return false;
        } else {
            Engineer newEngineer = (Engineer) otherEngineer;
            return this.getFirstName().equals(newEngineer.getFirstName()) && this.getLasttName().equals(newEngineer.getLasttName()) && this.getEk_number().equals(newEngineer.getEk_number()) && this.getEmail().equals(newEngineer.getEmail());
        }
    }

    // ------------SAVE METHOD - CREATES RECORD IN DB ---------------------------------
    public void saveEngineer() {
        try(Connection con =DB.sql2o.open()) {
            String sql = "INSERT INTO engineers (firstname, lastname, ek_number, email) VALUES (:firstname, :lastname, :ek_number, :email)";
            this.id = (int) con.createQuery(sql, true)
                .addParameter("firstname", this.firstname)
                .addParameter("lastname", this.lastname)
                .addParameter("ek_number", this.ek_number)
                .addParameter("email", this.email)
                .executeUpdate()
                .getKey();

        }
    }

    // --------------LISTALL METHOD  --- LISTS ALL ENGINEERS IN THE DB ---------------

    public static List<Engineer> listAllEngineers() {
        String sql = "SELECT * FROM engineers";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Engineer.class);
        }
    }

    // -------------FINDENGINEER METHOD -- FIND ENGINEER INSTANCE IN DB BY ENG_ID ------

    public static Engineer findEngineer(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM engineers where id=:id";
            Engineer engineer = con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(Engineer.class);
            return engineer;
        }
    }

    // ------------

    public List<Site> getEngineerSites() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sites where engineerId=:id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Site.class);
        }
    }

}
