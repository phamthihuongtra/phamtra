<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Duyệt tài khoản giáo viên</title>
    <style>
        body {
            display: flex;
            align-items: center;
            height: 100vh;
            flex-direction: column;
        }
        h2 {
            text-align: center;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        header{
            display: flex;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Account List</h1>
<table>
    <tr>
        <th>Email</th>
        <th>Tên hiển thị</th>
        <th>Ngày tạo tài khoản</th>
        <th>Lượt truy cập cuối</th>
        <th>Trạng thái</th>
        <th>Các thao tác</th>
    </tr>
    <c:forEach var="account" items="${requestScope['list']}">
        <tr>
            <td>${account.getEmail()}</td>
            <td>${account.getDisplayName()}</td>
            <td>${account.getCreatedAt()}</td>
            <td>${account.getLastAccess()}</td>
            <td>${account.getStatus()}</td>
            <td style="justify-content: space-between"><button style="float: left"><a href="">Duyệt</a></button>
                <button style="float: right"><a href="">Không duyệt</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
