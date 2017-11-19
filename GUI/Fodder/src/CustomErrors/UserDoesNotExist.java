package CustomErrors;

public class UserDoesNotExist extends Exception {
    public String toString() {
        return "Username entered does not exist";
    }
}
