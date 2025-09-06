<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="es_CL" />
<%@ include file="_header.jsp" %>

<h2>Disponibles en <c:out value="${ciudad}" /></h2>

<c:if test="${empty habitaciones}">
  <div class="card">No hay disponibilidad para las fechas indicadas. Probemos otras fechas 🤏.</div>
</c:if>

<c:forEach var="h" items="${habitaciones}">
  <div class="card">
    <h3 style="margin:0">${h.hotel.nombre}</h3>
    <div>${h.hotel.ciudad} · ${h.tipo} · Capacidad: ${h.capacidad}</div>
    <div><b>Precio por noche:</b> <fmt:formatNumber value="${h.precioPorNoche}" type="currency"/></div>
    <div style="margin-top:8px">
      <a class="link" href="${pageContext.request.contextPath}/app/det-habitacion?id=${h.id}">Ver detalle</a>
    </div>
  </div>
</c:forEach>

<%@ include file="_footer.jsp" %>
