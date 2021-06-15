package br.edu.ifpb.ConnectionDBSingleton;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static Connection connection;

    public static Connection getInstance() {
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }


    public java.sql.Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:" + System.getenv("SQLiteBDPath") + "\\database.db";

            return DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException ex) {
            throw  new RuntimeException(ex);
        }
    }

}

