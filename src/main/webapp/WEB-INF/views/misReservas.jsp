<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="es_CL" />
<%@ include file="_header.jsp" %>

<h2>Mis reservas</h2>

<c:if test="${empty reservas}">
  <div class="card">No tienes reservas… por ahora 😉</div>
</c:if>

<c:forEach var="r" items="${reservas}">
  <div class="card">
    <div><b>${r.habitacion.hotel.nombre}</b> — Habitación ${r.habitacion.numero}</div>
    <div>Desde ${r.fechaInicio} hasta ${r.fechaFin}</div>
    <div>Total: <fmt:formatNumber value="${r.total}" type="currency"/></div>
    <div>Estado: <span class="badge">${r.estado}</span></div>
  </div>
</c:forEach>

<%@ include file="_footer.jsp" %>
