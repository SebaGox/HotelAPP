<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="es_CL" />
<%@ include file="_header.jsp" %>

<h2>Hoteles</h2>
<c:if test="${empty hoteles}">
  <div class="card">Aún no hay hoteles cargados. Agrega algunos en la BD 😉</div>
</c:if>

<div class="grid">
  <c:forEach var="h" items="${hoteles}">
    <div class="hotel-card">
      <c:set var="img" value="${h.imagenUrl}" />
      <c:if test="${empty img}">
        <c:set var="img" value="https://images.unsplash.com/photo-1552566626-52f8b828add9?q=80&w=1600&auto=format&fit=crop" />
      </c:if>
      <img src="${img}" alt="${h.nombre}">
      <div class="info">
        <p class="name">${h.nombre}</p>
        <p class="meta">${h.ciudad} · ${h.estrellas}★</p>
        <div class="actions">
          <a class="link" href="${pageContext.request.contextPath}/app/buscar?ciudad=${h.ciudad}">Ver disponibilidad</a>
        </div>
      </div>
    </div>
  </c:forEach>
</div>

<%@ include file="_footer.jsp" %>
