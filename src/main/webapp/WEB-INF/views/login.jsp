<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="es_CL" />
<%@ include file="_header.jsp" %>

<h2>Iniciar sesión</h2>
<c:if test="${not empty error}">
  <div class="card" style="border-color:#ffdddd;color:#a11">⚠ ${error}</div>
</c:if>

<form class="card" action="${pageContext.request.contextPath}/app/do-login" method="post">
  <div class="row">
    <div><label>Correo</label><input type="email" name="email" placeholder="tucorreo@dominio.cl" required></div>
    <div><label>Clave</label><input type="password" name="password" placeholder="tu clave" required></div>
  </div>
  <br><button class="btn btn-primary">Entrar</button>
</form>

<p>¿No tienes cuenta? <a class="link" href="${pageContext.request.contextPath}/app/registro">Regístrate</a></p>

<%@ include file="_footer.jsp" %>
