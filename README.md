# HotelApp (Jakarta • Servlets/JSP/JPA • Tomcat 10)

App web de reservas: buscar por ciudad/fechas, ver detalle, registrarse/login (BCrypt), crear y listar reservas.

## Requisitos
- JDK 11 o 17
- Maven 3.8+
- Tomcat 10.1.x (Jakarta)
- MySQL 8 (el de WAMP sirve)

## Instalación
1. Crear BD `hotelapp` en MySQL (utf8mb4).
2. Ajustar credenciales en `src/main/resources/META-INF/persistence.xml`.
3. Compilar: `mvn clean package -DskipTests`.
4. Copiar `target/hotelapp.war` a `TOMCAT_HOME/webapps/`.
5. Iniciar Tomcat y abrir `http://localhost:9090/hotelapp/app/` .

## Decisiones de diseño
- Front Controller `/app/*`.
- JPA/Hibernate con entidades `Usuario/Hotel/Habitacion/Reserva`.
- DAO + Service.
- JSP + JSTL (**jakarta.tags**) para vistas.
- BCrypt para claves.
- Filtros: `CharsetFilter` (UTF-8) y `AuthFilter` (rutas protegidas).

## Datos de ejemplo
En `docs/seed-hoteles.sql` vienen 5 hoteles reales (Chile) y habitaciones. Ejecuta en phpMyAdmin.

## Problemas comunes
- **URI JSTL**: usar `jakarta.tags.core` y `jakarta.tags.fmt`.
- **MySQL**: si falla el login, revisa `persistence.xml` y agrega `&allowPublicKeyRetrieval=true`.
- **JSP 404**: las vistas están en `/WEB-INF/views/` y se acceden por el Front Controller.

## Licencia
MIT (ver `LICENSE`).
