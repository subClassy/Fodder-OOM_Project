package CustomErrors;

public class UsernameExistsException extends Exception {
    public String toString() {
        return "Username is taken";
    }
}
