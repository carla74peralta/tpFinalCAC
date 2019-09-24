<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="/resources/css/estilo.css">
    <link rel="icon" type="image/x-icon" href="/resources/img/favicon.ico">
    <link rel="shortcut icon" type="image/x-icon" href="/resources/img/favicon.ico">
    <title>Cervecería SpringMVC</title>
  </head>
  <body>
    <h1>
      Marcas de cerveza ${colorElegido} recomendadas
    </h1>
    <c:forEach var="cerveza" items="${cervezas}" >
      <p>
        Pruebe: ${cerveza.marca} <br>
        <img src="/resources/img/${cerveza.foto}" alt="${cerveza.marca}">
      </p>
    </c:forEach>
  </body>
</html>
