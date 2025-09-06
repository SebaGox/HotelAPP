package cl.tuempresa.hotelapp.dao;

import cl.tuempresa.hotelapp.model.Usuario;
import cl.tuempresa.hotelapp.persistence.JPAUtil;
import jakarta.persistence.EntityManager;

public class UsuarioDAO {
  public Usuario buscarPorEmail(String email) {
    EntityManager em = JPAUtil.getEM();
    try {
      return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :e", Usuario.class)
               .setParameter("e", email)
               .getResultStream().findFirst().orElse(null);
    } finally { em.close(); }
  }
  public void guardar(Usuario u) {
    EntityManager em = JPAUtil.getEM();
    try {
      em.getTransaction().begin();
      em.persist(u);
      em.getTransaction().commit();
    } finally { em.close(); }
  }
}
