package com.lowLevelDesign.loggubgframework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseLogAdapter implements LogAdapter{

    private String jdbcUrl;
    private String username;
    private String password;

    public DatabaseLogAdapter(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }


    @Override
    public void append(LogMessage logMessage) {
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO logs (level, message, timestamp) VALUES (?, ?, ?)");
            statement.setString(1, logMessage.getLogLevel().toString());
            statement.setString(2, logMessage.getContent());
            statement.setLong(3, logMessage.getTimestamp());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
