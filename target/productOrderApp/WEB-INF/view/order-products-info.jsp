<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>
<h2>Ordered products</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>price</th>
    </tr>
    <c:forEach var="prod" items="${product}">
        <tr>
            <td>${prod.name}</td>
            <td>${prod.description}</td>
            <td>${prod.price}</td>
        <tr>
    </c:forEach>
</table>
<br>
<br>
</body>
</html>