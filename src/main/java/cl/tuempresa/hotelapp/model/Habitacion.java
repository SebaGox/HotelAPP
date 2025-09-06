package cl.tuempresa.hotelapp.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "habitacion")
public class Habitacion {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false) @JoinColumn(name = "hotel_id")
  private Hotel hotel;

  private String numero;
  private String tipo;
  private int capacidad;

  @Column(name = "precio_por_noche")
  private BigDecimal precioPorNoche;

  private boolean disponible = true;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Hotel getHotel() { return hotel; }
  public void setHotel(Hotel hotel) { this.hotel = hotel; }
  public String getNumero() { return numero; }
  public void setNumero(String numero) { this.numero = numero; }
  public String getTipo() { return tipo; }
  public void setTipo(String tipo) { this.tipo = tipo; }
  public int getCapacidad() { return capacidad; }
  public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
  public BigDecimal getPrecioPorNoche() { return precioPorNoche; }
  public void setPrecioPorNoche(BigDecimal precioPorNoche) { this.precioPorNoche = precioPorNoche; }
  public boolean isDisponible() { return disponible; }
  public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
