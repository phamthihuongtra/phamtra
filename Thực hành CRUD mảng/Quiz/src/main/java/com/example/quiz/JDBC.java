package com.example.quiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
    private String localhost = "localhost:3306";
    private String username = "root";
    private String dbname = "quizizz";
    private String password = "password";
    private String url = "jdbc:mysql://" + localhost + "/" + dbname;
    public Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public List<Account> getAccountList() throws SQLException, ClassNotFoundException {
        List<Account> accountList = new ArrayList<>();
        String sql = "SELECT * FROM users ";
        Statement statement = connection().createStatement();
        Account account = new Account();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            account.setEmail(resultSet.getString("email"));
            account.setDisplayName(resultSet.getString("username"));
            account.setCreatedAt(resultSet.getString("createAt"));
            account.setStatus(resultSet.getString("lastAccess"));
            account.setStatus(resultSet.getString("status"));
            accountList.add(account);
        }
        connection().close();
        return accountList;
    }

}


