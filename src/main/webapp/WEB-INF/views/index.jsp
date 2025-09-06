<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="es_CL" />
<%@ include file="_header.jsp" %>

<!-- HERO con imagen externa y logo -->
<div class="hero-landing"
     style="background-image:
       url('https://dynamic-media-cdn.tripadvisor.com/media/photo-o/2e/d5/20/33/exterior.jpg?w=1400&h=800&s=1');">
  <div class="hero-content">
    <img class="hero-logo" src="${pageContext.request.contextPath}/Img/LOGO.png" alt="HotelApp">
    <h1 class="hero-title">Encuentra tu próxima estadía</h1>
    <p class="hero-sub">  </p>
    <p class="hero-sub">Hoteles seleccionados, buen precio y una experiencia sencilla. </p>
  <p class="hero-sub">Sube, mira, reserva. Así de rápido. </p></div>
</div>

<div class="section card">
  <h2 style="margin-top:0">Buscar hoteles</h2>
  <form action="${pageContext.request.contextPath}/app/do-buscar" method="post">
    <div class="row">
      <div>
        <label>Ciudad</label>
        <input name="ciudad" placeholder="Santiago" required>
      </div>
      <div>
        <label>Entrada</label>
        <input type="date" name="inicio" required>
      </div>
      <div>
        <label>Salida</label>
        <input type="date" name="fin" required>
      </div>
    </div>
    <br>
    <button class="btn btn-primary" type="submit">Buscar</button>
  </form>
</div>

<%@ include file="_footer.jsp" %>
