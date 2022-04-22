<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>
<h2>List of orders</h2>
<br>

<table>
    <tr>
        <th>Order name</th>
        <th>Email</th>
        <th>created</th>
        <th>modified</th>
    </tr>
    <c:forEach var="order" items="${allOrders}">
    <c:url var="openOrderButton" value="/openOrderProduct">
        <c:param name="orderId" value="${order.id}"/>
    </c:url>
        <tr>
            <td>${order.orderName}</td>
            <td>${order.email}</td>
            <td>${order.created}</td>
            <td>${order.modified}</td>
            <td>
                <input type="button" value="Open order" onclick="window.location.href='${openOrderButton}'">
            </td>
        <tr>
    </c:forEach>
</table>
<br>
<br>


</body>
</html>