package Backend;

import CustomErrors.InternalServerException;
import CustomErrors.UserDoesNotExist;
import CustomErrors.UsernameExistsException;
import CustomErrors.WrongCredentialsException;

import java.sql.*;

public class DatabaseAccess {
    private final String databaseName = "fodder";
    private final String user = "root";
    private final String password = "root";
    private Connection connect = null;
    private Statement statement = null;

    public DatabaseAccess() throws Exception {
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

    public Customer registerUser(String username, String password, String email) throws InternalServerException, UsernameExistsException {
        if (userExists(username)) {
            throw new UsernameExistsException();
        }

        try {
            PreparedStatement insertUser = connect.prepareStatement("INSERT INTO users (USERNAME, EMAIL, PASSWORD) VALUES (?, ?, ?)");
            insertUser.setString(1, username);
            insertUser.setString(2, password);
            insertUser.setString(3, email);
            insertUser.executeUpdate();

            return new Customer(username, email);
        } catch (SQLException e) {
            throw new InternalServerException();
        }
    }

    public Customer loginUser(String username, String password) throws UserDoesNotExist, InternalServerException, WrongCredentialsException {
        if (!userExists(username)) {
            throw new UserDoesNotExist();
        }

        try {
            PreparedStatement loginQuery = connect.prepareStatement("SELECT * FROM users WHERE USERNAME=?");
            loginQuery.setString(1, username);
            ResultSet result = loginQuery.executeQuery();
            result.first();
            String dbPassword = result.getString("PASSWORD");
            String email = result.getString("EMAIL");

            if (dbPassword.equals(password)) {
                return new Customer(username, email);
            } else {
                throw new WrongCredentialsException();
            }
        } catch (SQLException e) {
            throw new InternalServerException();
        }
    }
}