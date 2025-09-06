package cl.tuempresa.hotelapp.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
  private static final EntityManagerFactory emf =
      Persistence.createEntityManagerFactory("HotelPU");
  public static EntityManager getEM() { return emf.createEntityManager(); }
}
