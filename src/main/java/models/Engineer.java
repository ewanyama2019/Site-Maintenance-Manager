
package models;

public class Engineer {
    private String firstname;
    private String email;

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
}
