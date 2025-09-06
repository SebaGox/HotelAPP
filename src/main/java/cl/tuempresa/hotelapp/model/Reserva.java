package cl.tuempresa.hotelapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "reserva")
public class Reserva {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false) @JoinColumn(name = "usuario_id")
  private Usuario usuario;

  @ManyToOne(optional = false) @JoinColumn(name = "habitacion_id")
  private Habitacion habitacion;

  @Column(name = "fecha_inicio")
  private LocalDate fechaInicio;

  @Column(name = "fecha_fin")
  private LocalDate fechaFin;

  private BigDecimal total;

  @Enumerated(EnumType.STRING)
  private ReservaEstado estado = ReservaEstado.CREADA;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Usuario getUsuario() { return usuario; }
  public void setUsuario(Usuario usuario) { this.usuario = usuario; }
  public Habitacion getHabitacion() { return habitacion; }
  public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }
  public LocalDate getFechaInicio() { return fechaInicio; }
  public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
  public LocalDate getFechaFin() { return fechaFin; }
  public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
  public BigDecimal getTotal() { return total; }
  public void setTotal(BigDecimal total) { this.total = total; }
  public ReservaEstado getEstado() { return estado; }
  public void setEstado(ReservaEstado estado) { this.estado = estado; }
}
