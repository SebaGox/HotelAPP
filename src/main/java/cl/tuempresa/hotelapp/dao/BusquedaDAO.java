package cl.tuempresa.hotelapp.dao;

import java.time.LocalDate;
import java.util.List;

import cl.tuempresa.hotelapp.model.Habitacion;
import cl.tuempresa.hotelapp.model.Hotel;
import cl.tuempresa.hotelapp.model.ReservaEstado;
import cl.tuempresa.hotelapp.persistence.JPAUtil;
import jakarta.persistence.EntityManager;

public class BusquedaDAO {

  public List<Habitacion> habitacionesDisponibles(String ciudad, LocalDate inicio, LocalDate fin) {
    EntityManager em = JPAUtil.getEM();
    try {
      String jpql = "SELECT h FROM Habitacion h " +
        "WHERE h.hotel.ciudad = :ciudad AND h.disponible = TRUE AND " +
        "NOT EXISTS (SELECT r FROM Reserva r WHERE r.habitacion = h AND r.estado <> :cancelada " +
        "AND :inicio < r.fechaFin AND :fin > r.fechaInicio)";
      return em.createQuery(jpql, Habitacion.class)
               .setParameter("ciudad", ciudad)
               .setParameter("cancelada", ReservaEstado.CANCELADA)
               .setParameter("inicio", inicio)
               .setParameter("fin", fin)
               .getResultList();
    } finally { em.close(); }
  }

  public Hotel buscarHotel(Long id) {
    EntityManager em = JPAUtil.getEM();
    try { return em.find(Hotel.class, id); } finally { em.close(); }
  }

  public Habitacion buscarHabitacion(Long id) {
    EntityManager em = JPAUtil.getEM();
    try { return em.find(Habitacion.class, id); } finally { em.close(); }
  }

  /* NUEVO: lista de hoteles para la página /hoteles */
  public List<Hotel> listarHoteles() {
    EntityManager em = JPAUtil.getEM();
    try {
      return em.createQuery("SELECT h FROM Hotel h ORDER BY h.estrellas DESC, h.nombre ASC", Hotel.class)
               .getResultList();
    } finally { em.close(); }
  }
}
