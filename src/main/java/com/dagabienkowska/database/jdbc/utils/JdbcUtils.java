package com.dagabienkowska.database.jdbc.utils;

import com.dagabienkowska.database.dao.RunDao;

import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
        private final static JdbcUtils instance = new JdbcUtils();
        private Connection connection;

        private JdbcUtils() {


                String dbPassword = "SDAWr)tk!q2098";
                String dbUser = "root";
                String connectionString = "jdbc:mysql://localhost:3306/biegi";
                String connectionOptions = "?serverTimezone=UTC&useSSL=false&createDatabaseIfNotExist" +
                        "=true&allowPublicKeyRetrieval=true";

                Properties prop = new Properties();
                prop.put("password", dbPassword);
                prop.put("user", dbUser);

                try {
                        connection = DriverManager.getConnection(connectionString, prop);
                } catch (SQLException e) {
                        e.printStackTrace();
                }

        }
        public static JdbcUtils getInstance(){
                return instance;
        }

        public Connection getConnection(){
                return connection;
        }
}
