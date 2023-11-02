<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Management</title>
</head>
<body>
<h1>Account Management</h1>

<form action="AccountServlet" method="GET">
    <input type="submit" name="sort" value="Sort by Last Access Time">
</form>

<table>
    <tr>
        <th>Email</th>
        <th>Display Name</th>
        <th>Creation Date</th>
        <th>Last Access Time</th>
    </tr>
    <% for (Account account : accountList) { %>
    <tr>
        <td><%= account.getEmail() %></td>
        <td><%= account.getDisplayName() %></td>
        <td><%= account.getCreationDate() %></td>
        <td><%= account.getLastAccessTime() %></td>
    </tr>
    <% } %>
</table>

<form action="AccountServlet" method="GET">
    <input type="submit" name="prevPage" value="Previous Page" <% if (currentPage == 1) out.print("disabled"); %>>
    Page: <%= currentPage %>
    <input type="submit" name="nextPage" value="Next Page" <% if (currentPage == totalPages) out.print("disabled"); %>>
</form>
</body>
</html>