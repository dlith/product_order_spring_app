<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>
<h2>List of products</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>price</th>
        <th>created</th>
        <th>modified</th>
        <th>operations</th>
    </tr>
    <c:forEach var="prod" items="${allProducts}">
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="prodId" value="${prod.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteProduct">
            <c:param name="idProduct" value="${prod.id}"/>
        </c:url>
    <tr>
        <td>${prod.name}</td>
        <td>${prod.description}</td>
        <td>${prod.price}</td>
        <td>${prod.created}</td>
        <td>${prod.modified}</td>
        <td>
            <input type="button" value="Update" onclick="window.location.href='${updateButton}'">
        </td>
        <td>
            <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'">
        </td>
    <tr>
    </c:forEach>
</table>
<br>
<br>
<input type="button" value="Add"
       onclick="window.location.href='addNewProduct'"/>

</body>
</html>