package cl.tuempresa.hotelapp.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import cl.tuempresa.hotelapp.dao.ReservaDAO;
import cl.tuempresa.hotelapp.model.Habitacion;
import cl.tuempresa.hotelapp.model.Reserva;
import cl.tuempresa.hotelapp.model.ReservaEstado;
import cl.tuempresa.hotelapp.model.Usuario;

public class ReservaService {
  private final ReservaDAO dao = new ReservaDAO();

  public Reserva crear(Usuario u, Habitacion h, LocalDate inicio, LocalDate fin) {
    if (u == null) throw new IllegalArgumentException("Debes iniciar sesión");
    if (h == null) throw new IllegalArgumentException("Habitación inválida");
    if (fin.isBefore(inicio)) throw new IllegalArgumentException("Fechas inválidas");
    long noches = ChronoUnit.DAYS.between(inicio, fin);
    if (noches <= 0) throw new IllegalArgumentException("Rango mínimo 1 noche");

    BigDecimal total = h.getPrecioPorNoche().multiply(BigDecimal.valueOf(noches));

    Reserva r = new Reserva();
    r.setUsuario(u);
    r.setHabitacion(h);
    r.setFechaInicio(inicio);
    r.setFechaFin(fin);
    r.setTotal(total);
    r.setEstado(ReservaEstado.CREADA);

    dao.guardar(r);
    return r;
  }
}
