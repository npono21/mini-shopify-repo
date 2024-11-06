package SYSC4806Project;

/**
 * A system user that can log in with username and password.
 */
public abstract class User {
    // private long id; // generate this
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.name.equals(username) && this.password.equals(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [Name: " + name + ", Type: " + getClass().getSimpleName() + "]";
    }
}
