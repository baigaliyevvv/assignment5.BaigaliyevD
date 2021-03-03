package data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDataBase {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}