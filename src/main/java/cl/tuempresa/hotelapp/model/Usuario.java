package cl.tuempresa.hotelapp.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name = "usuario")
public class Usuario {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;

  @Column(unique = true)
  private String email;

  @Column(name = "password_hash")
  private String passwordHash;

  @Column(name = "fecha_registro")
  private LocalDateTime fechaRegistro = LocalDateTime.now();

  @OneToMany(mappedBy = "usuario")
  private List<Reserva> reservas;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getPasswordHash() { return passwordHash; }
  public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
  public LocalDateTime getFechaRegistro() { return fechaRegistro; }
  public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
  public List<Reserva> getReservas() { return reservas; }
  public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }
}
