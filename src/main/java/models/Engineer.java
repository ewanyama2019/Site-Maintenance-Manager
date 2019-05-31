
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
}
