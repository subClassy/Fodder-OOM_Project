import CustomErrors.InternalServerException;
import java.sql.*;

public class DatabaseAccess {
    private Connection connect = null;
    private Statement statement = null;
    private final String databaseName = "fodder";
    private final String user = "root";
    private final String password = "root";

    DatabaseAccess() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?user=" +
                    user + "&password=" + password + "&useSSL=false&autoReconnect=true");
            statement = connect.createStatement();
        } catch (Exception e) {
            throw e;
        }
    }

    private boolean userExists(String username) throws InternalServerException {
        try {
            PreparedStatement checkUser = connect.prepareStatement("SELECT COUNT(*) AS TOTAL FROM fodder.users WHERE USERNAME=?;");
            checkUser.setString(1, username);
            ResultSet resultSet = checkUser.executeQuery();

            resultSet.first();
            int y = resultSet.getInt("TOTAL");
            return (y > 0);
        } catch (SQLException s) {
            throw new InternalServerException();
        }
    }

    public static void main(String[] args) {
        try {
            DatabaseAccess access = new DatabaseAccess();
            System.out.println(access.userExists("test"));
            System.out.println(access.userExists("toast"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}