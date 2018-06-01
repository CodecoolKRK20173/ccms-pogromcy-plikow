package com.codecool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DAOInterface <T> {
    String DB_URL ="jdbc:sqlite:database.sql";

    T getData(int id);
    boolean updateData(T obj);
    boolean insertData(T obj);
    boolean deleteData(T obj);
    Connection connect();

}
