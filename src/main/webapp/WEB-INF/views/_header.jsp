<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HotelApp</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
  <div class="container">
    <div class="navbar">
      <div class="brand">
        <!-- Solo el logo (archivo dentro del WAR: /Img/LOGO.png) -->
        <a href="${pageContext.request.contextPath}/app/" aria-label="Inicio">
          <img class="logo" src="${pageContext.request.contextPath}/Img/LOGO.png" alt="HotelApp">
        </a>
      </div>
      <nav>
        <a href="${pageContext.request.contextPath}/app/">Inicio</a>
        <a href="${pageContext.request.contextPath}/app/hoteles">Hoteles</a>
        <a href="${pageContext.request.contextPath}/app/mis-reservas">Mis reservas</a>
        <c:choose>
          <c:when test="${not empty sessionScope.usuario}">
            <form style="display:inline" action="${pageContext.request.contextPath}/app/logout" method="post">
              <button class="btn btn-primary">Salir (${sessionScope.usuario.nombre})</button>
            </form>
          </c:when>
          <c:otherwise>
            <a href="${pageContext.request.contextPath}/app/login" class="link">Entrar</a>
          </c:otherwise>
        </c:choose>
      </nav>
    </div>
    <hr/>
