import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseAccess {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private final String databaseName = "fodder";
    private final String user = "root";
    private final String password = "root";

    DatabaseAccess() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?user=" +
                    user + "&password=" + password + "&useSSL=false&autoReconnect=true");
            statement = connect.createStatement();
            System.out.println("sahi");
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            DatabaseAccess access = new DatabaseAccess();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}