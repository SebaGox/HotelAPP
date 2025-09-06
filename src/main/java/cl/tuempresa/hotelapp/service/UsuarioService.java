package cl.tuempresa.hotelapp.service;

import org.mindrot.jbcrypt.BCrypt;

import cl.tuempresa.hotelapp.dao.UsuarioDAO;
import cl.tuempresa.hotelapp.model.Usuario;

public class UsuarioService {
  private final UsuarioDAO dao = new UsuarioDAO();

  public Usuario registrar(String nombre, String email, String password) {
    if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");
    if (email == null || !email.matches("^.+@.+\\..+$")) throw new IllegalArgumentException("Email inválido");
    if (password == null || password.length() < 6) throw new IllegalArgumentException("Password débil");
    if (dao.buscarPorEmail(email) != null) throw new IllegalArgumentException("Email ya registrado");

    Usuario u = new Usuario();
    u.setNombre(nombre);
    u.setEmail(email);
    u.setPasswordHash(BCrypt.hashpw(password, BCrypt.gensalt(12)));
    dao.guardar(u);
    return u;
  }

  public Usuario login(String email, String password) {
    Usuario u = dao.buscarPorEmail(email);
    if (u == null) return null;
    return BCrypt.checkpw(password, u.getPasswordHash()) ? u : null;
  }
}
