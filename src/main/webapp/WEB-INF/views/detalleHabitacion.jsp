<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="es_CL" />
<%@ include file="_header.jsp" %>

<c:if test="${not empty error}">
  <div class="card" style="border-color:#ffdddd;color:#a11">⚠ ${error}</div>
</c:if>

<div class="card">
  <h2 style="margin:0">${habitacion.hotel.nombre} — Habitación ${habitacion.numero}</h2>
  <p style="margin:.5rem 0">${habitacion.tipo} · Capacidad: ${habitacion.capacidad}</p>
  <p><b>Precio por noche:</b> <fmt:formatNumber value="${habitacion.precioPorNoche}" type="currency"/></p>

  <form action="${pageContext.request.contextPath}/app/do-reservar" method="post">
    <input type="hidden" name="habitacionId" value="${habitacion.id}">
    <div class="row">
      <div><label>Entrada</label><input type="date" name="inicio" required></div>
      <div><label>Salida</label><input type="date" name="fin" required></div>
    </div>
    <br><button class="btn btn-primary" type="submit">Reservar</button>
  </form>
</div>

<%@ include file="_footer.jsp" %>
