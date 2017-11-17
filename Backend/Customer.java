package Backend;

public class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
