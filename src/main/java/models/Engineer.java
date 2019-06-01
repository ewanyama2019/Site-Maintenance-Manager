
package models;

import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Engineer {
    private String firstname;
    private String email;
    private int id;

    public Engineer(String firstname, String email) {
        this.firstname = firstname;
        this.email = email;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object otherEngineer) {
        if (!(otherEngineer instanceof Engineer)) {
            return false;
        } else {
            Engineer newEngineer = (Engineer) otherEngineer;
            return this.getFirstName().equals(newEngineer.getFirstName()) && this.getEmail().equals(newEngineer.getEmail());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO engineers (firstname, email) VALUES (:firstname, email)";
            con.createQuery(sql)
                    .addParameter("firstname", this.firstname)
                    .addParameter("email", this.email)
                    .executeUpdate();
        }
    }

    public static List<Engineer> all() {
        String sql = "SELECT * FROM engineers";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Engineer.class);
        }
    }

}
