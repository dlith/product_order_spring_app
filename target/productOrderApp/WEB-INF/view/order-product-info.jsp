<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>Order product info</h2>
<br>

<form:form action="saveOrderProduct" modelAttribute="order">

    <form:hidden path="id"/>

    <c:forEach var="pr" items="${freeProducts}">
        <form:checkbox path="products" value="$${pr}"/>
        ${pr.id} &nbsp; ${pr.name} &nbsp; ${pr.description}
        <br>
    </c:forEach>

    <br>
    <br>
    <input type="submit" value="OK">
</form:form>

</body>
</html>