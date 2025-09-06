<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="es_CL" />
<%@ include file="_header.jsp" %>

<div class="hero">
  <h2>Buscar hoteles</h2>
  <form class="card" action="${pageContext.request.contextPath}/app/do-buscar" method="post">
    <div class="row">
      <div><label>Ciudad</label><input name="ciudad" required></div>
      <div><label>Entrada</label><input type="date" name="inicio" required></div>
      <div><label>Salida</label><input type="date" name="fin" required></div>
    </div>
    <br><button class="btn btn-primary">Buscar</button>
  </form>
</div>

<%@ include file="_footer.jsp" %>
