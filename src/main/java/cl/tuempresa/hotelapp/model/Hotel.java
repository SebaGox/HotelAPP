package cl.tuempresa.hotelapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity @Table(name="hotel")
public class Hotel {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String ciudad;
  private String direccion;

  @Column(columnDefinition="TEXT")
  private String descripcion;

  private int estrellas;

  @Column(name="imagen_url")
  private String imagenUrl; // << NUEVO

  @OneToMany(mappedBy = "hotel")
  private List<Habitacion> habitaciones;

  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getNombre(){return nombre;} public void setNombre(String nombre){this.nombre=nombre;}
  public String getCiudad(){return ciudad;} public void setCiudad(String ciudad){this.ciudad=ciudad;}
  public String getDireccion(){return direccion;} public void setDireccion(String d){this.direccion=d;}
  public String getDescripcion(){return descripcion;} public void setDescripcion(String d){this.descripcion=d;}
  public int getEstrellas(){return estrellas;} public void setEstrellas(int e){this.estrellas=e;}
  public String getImagenUrl(){return imagenUrl;} public void setImagenUrl(String imagenUrl){this.imagenUrl=imagenUrl;}
  public List<Habitacion> getHabitaciones(){return habitaciones;} public void setHabitaciones(List<Habitacion> h){this.habitaciones=h;}
}
