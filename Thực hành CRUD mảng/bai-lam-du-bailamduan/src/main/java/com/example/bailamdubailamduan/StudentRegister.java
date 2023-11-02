package com.example.bailamdubailamduan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class StudentRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("displayName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        if (password.equals(confirmPassword)) {
            System.out.println("Đăng ký thành công!");
            resp.sendRedirect("login.jsp");
        } else {
            resp.sendRedirect("register.jsp");
            System.out.println("Mật khẩu không chính xác, vui lòng nhập lại");
        }
        System.out.println("name: " + username);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        System.out.println("confirmPassword: " + confirmPassword);
    }
}