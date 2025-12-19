package project.db;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:sqlite:database.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}

