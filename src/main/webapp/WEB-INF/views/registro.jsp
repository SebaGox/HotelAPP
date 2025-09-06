<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="es_CL" />
<%@ include file="_header.jsp" %>

<h2>Registro</h2>
<c:if test="${not empty error}">
  <div class="card" style="border-color:#ffdddd;color:#a11">⚠ ${error}</div>
</c:if>

<form class="card" action="${pageContext.request.contextPath}/app/do-registro" method="post">
  <div class="row">
    <div><label>Nombre</label><input name="nombre" placeholder="Tu nombre" required></div>
    <div><label>Correo</label><input type="email" name="email" placeholder="tucorreo@dominio.cl" required></div>
    <div><label>Clave (6+)</label><input type="password" name="password" placeholder="al menos 6 caracteres" required></div>
  </div>
  <br><button class="btn btn-primary">Crear cuenta</button>
</form>

<%@ include file="_footer.jsp" %>
