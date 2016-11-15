package com.database.project.eventManagmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sujith on 11/6/16.
 */
public class DbConnection {
    private String connectionURL = "jdbc:mysql://localhost/<schema_name>";
    private String user = "<user>";
    private String password = "<password>";

    public Connection connectToDb() throws SQLException {
        return DriverManager.getConnection(connectionURL, user, password);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        DbConnection dbConnection = new DbConnection();
        Connection connection = null;
        try {
            connection = dbConnection.connectToDb();
        }
        finally {
            dbConnection.disconnectFromDb(connection);
        }
    }

    private void disconnectFromDb(Connection connection) throws SQLException {
        connection.close();
    }
}
