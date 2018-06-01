package com.codecool;

import com.codecool.dao.UsersDAO;
import com.codecool.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

    private static final String DB_URL ="jdbc:sqlite:database.sql";
    private static Connection dbConnection;

    public static void main( String[] args ) {

        String sql1 = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n"
                + "	login text NOT NULL UNIQUE,\n"
                + "	salt INTEGER NOT NULL,\n"
                + "	password text NOT NULL,\n"
                + "	name text NOT NULL,\n"
                + "	surname text NOT NULL,\n"
                + "	email text NOT NULL UNIQUE,\n"
                + "	role text NOT NULL\n"
                + ");";

        String sql2 = "CREATE TABLE IF NOT EXISTS classroom_names (\n"
                + "	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n"
                + " name TEXT NOT NULL\n"
                + ");";



        String sql3 = "CREATE TABLE IF NOT EXISTS classroom (\n"
                + "	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n"
                + " user_id INTEGER NOT NULL,\n"
                + " classroom_name_id INTEGER NOT NULL,\n"
                + " FOREIGN KEY (user_id) REFERENCES users (id),\n"
                + " FOREIGN KEY (classroom_name_id) REFERENCES clasroom_names (id) \n"
                + ");";


        String sql4 = "CREATE TABLE IF NOT EXISTS assignments (\n"
                + "	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n"
                + "	description text NOT NULL,\n"
                + " classroom_id INTEGER NOT NULL,\n"
                + " FOREIGN KEY (classroom_id) REFERENCES clasroom (id)\n"
                + ");";


        String sql5 = "CREATE TABLE IF NOT EXISTS picked_assignments (\n"
                + "	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n"
                + " assignments_id INTEGER NOT NULL,\n"
                + " user_id INTEGER NOT NULL,\n"
                + "	solution text,\n"
                + " FOREIGN KEY (assignments_id) REFERENCES clasroom (id),\n"
                + " FOREIGN KEY (user_id) REFERENCES users (id)\n"
                + ");";

        String sql6 = "CREATE TABLE IF NOT EXISTS attention_list (\n"
                + "	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n"
                + " classroom_id INTEGER NOT NULL,\n"
                + " user_id INTEGER NOT NULL,\n"
                + "	date text NOT NULL,\n"
                + " FOREIGN KEY (classroom_id) REFERENCES clasroom (id),\n"
                + " FOREIGN KEY (user_id) REFERENCES users (id)\n"
                + ");";



        try {
            dbConnection = DriverManager.getConnection(DB_URL);
            Statement stmt = dbConnection.createStatement();
            stmt.execute(sql1);
            stmt.execute(sql2);
            stmt.execute(sql3);
            stmt.execute(sql4);
            stmt.execute(sql5);
            stmt.execute(sql6);
            UsersDAO dao = new UsersDAO();
            User user = new User("admin","1234","Code","Cool","codecool@codecool.com","manager");
            dao.insertData(user);


        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }

}