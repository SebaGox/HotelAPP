package cl.tuempresa.hotelapp.dao;

import java.util.List;

import cl.tuempresa.hotelapp.model.Reserva;
import cl.tuempresa.hotelapp.model.Usuario;
import cl.tuempresa.hotelapp.persistence.JPAUtil;
import jakarta.persistence.EntityManager;

public class ReservaDAO {
  public void guardar(Reserva r) {
    EntityManager em = JPAUtil.getEM();
    try {
      em.getTransaction().begin();
      em.persist(r);
      em.getTransaction().commit();
    } finally { em.close(); }
  }
  public List<Reserva> porUsuario(Usuario u) {
    EntityManager em = JPAUtil.getEM();
    try {
      return em.createQuery("SELECT r FROM Reserva r WHERE r.usuario = :u ORDER BY r.id DESC", Reserva.class)
               .setParameter("u", u)
               .getResultList();
    } finally { em.close(); }
  }
}
