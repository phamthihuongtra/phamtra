package com.example.quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "SearchTeacherServlet",value = "/home")
public class SearchTeacherServlet extends HttpServlet {
    JDBC jdbc ;

    @Override
    public void init() throws ServletException {
        jdbc = new JDBC();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
        switch (action) {
            default:
                showFormList(request, response);
                    break;
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void showFormList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Account> accountList = jdbc.getAccountList();
        request.setAttribute("list", accountList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
