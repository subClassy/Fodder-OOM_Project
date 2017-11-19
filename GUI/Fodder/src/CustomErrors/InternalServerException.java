package CustomErrors;

public class InternalServerException extends Exception {
    public String toString() {
        return "Some Error Occurred";
    }
}
