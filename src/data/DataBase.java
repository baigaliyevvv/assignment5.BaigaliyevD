package data;

import data.interfaces.IDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase implements IDataBase {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String conURL = "jdbc:postgresql://localhost:5432/employees";
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(conURL, "postgres", "herominecraft");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}