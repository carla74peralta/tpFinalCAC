<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/resources/css/estilo.css">
    <link rel="icon" type="image/x-icon" href="/resources/img/favicon.ico">
    <link rel="shortcut icon" type="image/x-icon" href="/resources/img/favicon.ico">
    <title>Cervecería SpringMVC</title>
  </head>
  <body>
    <h1>Elija un color:</h1>
    <form method="post" action="/consulta">
      <p>
        <select name="color">
          <c:forEach var="color" items="${colores}" >
            <option value="${color}">${color}</option>
          </c:forEach>
        </select>
        <input type="submit" value="Enviar">
      </p>
    </form>
  </body>
</html>
