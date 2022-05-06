<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Product Info</h2>
<br>

<form:form action="saveProduct" modelAttribute="product">
    
    <form:hidden path="id"/>
    
    Name <form:input path="name"/>
    <br>
    <br>
    Surname <form:input path="description"/>
    <br>
    <br>
    Price <form:input path="price"/>
    <br>
    <br>
    <input type="submit" value="OK">
</form:form>

</body>
</html>