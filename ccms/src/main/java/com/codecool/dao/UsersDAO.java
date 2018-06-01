package com.codecool.dao;

import com.codecool.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements  DAOInterface <User> {

   @Override
    public boolean updateData(User user) {
        String sql = "UPDATE users SET " +
                "name = ? ," +
                "surname = ? ," +
                "email = ? ," +
                "role = ? ," +
                "password = ? " +
                "WHERE login = ?";

        try (Connection conn = this.connect();

             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSurname());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getRole());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getLogIn());

            pstmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;


    }


    @Override
    public boolean insertData(User user) {
        String sql = "INSERT INTO users(login, salt, password, name, surname, email, role) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getLogIn());
            pstmt.setInt(2, user.getSalt());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getName());
            pstmt.setString(5, user.getSurname());
            pstmt.setString(6, user.getEmail());
            pstmt.setString(7, user.getRole());

            pstmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            return false;
    }

    @Override
    public boolean deleteData(User user) {
        String sql = "DELETE FROM users WHERE login = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, user.getLogIn());
            // execute the delete statement
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public List<User> getAllUsersWithRoles(String role) {

       List<User> result = new ArrayList<>();
        String sql = "SELECT *  "
                + " FROM users"
                + " WHERE role = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setString(1, role);

            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()){
            result.add(
                    new User(rs.getString("login"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("email"),
                            rs.getString("role"),
                            rs.getInt("salt"))

            );
            }
            return result;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public User getData(int id) {

        String sql = "SELECT login, password, salt, name, surname, email, role "
                + "FROM users WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setInt(1, id);
            //
            ResultSet rs  = pstmt.executeQuery();

//            User(String logIn, String password, String name, String surname, String eMail, String role, int salt)
            return new User(rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("email"),
                    rs.getString("role"),
                    rs.getInt("salt"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User getData(String login) {

        String sql = "SELECT password, salt, name, surname, email, role "
                + "FROM users WHERE login = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setString(1, login);

            ResultSet rs  = pstmt.executeQuery();

            return new User(login,
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("email"),
                    rs.getString("role"),
                    rs.getInt("salt"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public Connection connect() {
        {
            // SQLite connection string
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }
    }

}