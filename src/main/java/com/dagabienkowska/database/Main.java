package com.dagabienkowska.database;

import com.dagabienkowska.database.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = JdbcUtils.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement
                ("INSERT INTO runs (id, name, place, start_date, start_time, members_limit)" +
                        "values (?, ?, ?, ?, ?, ?)");

        statement.setInt(1, 1);
        statement.setString(2, "Rzeszowska Piątka");
        statement.setString(3, "Rzeszów");

        java.util.Date now = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(now.getTime());
        statement.setDate(4, sqlDate);
        statement.setDate(5, sqlDate);
        statement.setInt(6, 100);
        statement.execute();


    }
}
