package com.codeup.adlister.dao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users{

    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try{
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        }catch(SQLException e){
            throw new RuntimeException("Error connecting to the database (users)");
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

    //turn a result set of users into readable output for users to see
    private List<User> createUsersFromResults(ResultSet rs) throws SQLException {
        List<User> usersList = new ArrayList<>();
        while (rs.next()) {
            usersList.add(extractUser(rs));
        }
        return usersList;
    }

    //search for a user by their name
    @Override
    public User findByUsername(String username) {
        List<User> users = new ArrayList<>();
        String searchSql = "SELECT * FROM users WHERE username LIKE ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(searchSql);
            stmt.setString(1, username); //parameterIndex is calling the '?' in our statement
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                users.add(extractUser(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching for users.", e);
        }
        return users.get(0);
    }

    //Insert a new user into the database
    @Override
    public Long insert(User user) {
        String sql = "INSERT INTO users(username, email, password) VALUES(?, ?, ?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Set the ? parameters inside our sql String
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

}
