package cl.tuempresa.hotelapp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import cl.tuempresa.hotelapp.dao.BusquedaDAO;
import cl.tuempresa.hotelapp.dao.ReservaDAO;
import cl.tuempresa.hotelapp.model.Habitacion;
import cl.tuempresa.hotelapp.model.Usuario;
import cl.tuempresa.hotelapp.service.ReservaService;
import cl.tuempresa.hotelapp.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FrontController extends HttpServlet {
  private final BusquedaDAO busquedaDAO = new BusquedaDAO();
  private final UsuarioService usuarioService = new UsuarioService();
  private final ReservaService reservaService = new ReservaService();

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String path = req.getPathInfo();
    if (path == null || "/".equals(path)) { forward(req, resp, "index.jsp"); return; }
    switch (path) {
      case "/login":         forward(req, resp, "login.jsp"); break;
      case "/registro":      forward(req, resp, "registro.jsp"); break;
      case "/buscar":        forward(req, resp, "buscar.jsp"); break;
      case "/mis-reservas":  misReservas(req, resp); break;
      case "/det-habitacion":detalleHabitacion(req, resp); break;
      case "/hoteles":       hoteles(req, resp); break; // << NUEVO
      default: resp.sendError(404);
    }
  }

  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String path = req.getPathInfo();
    switch (path) {
      case "/do-login":     doLogin(req, resp); break;
      case "/do-registro":  doRegistro(req, resp); break;
      case "/do-buscar":    doBuscar(req, resp); break;
      case "/do-reservar":  doReservar(req, resp); break;
      case "/logout":       doLogout(req, resp); break;
      default: resp.sendError(404);
    }
  }

  private void hoteles(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    var lista = busquedaDAO.listarHoteles();
    req.setAttribute("hoteles", lista);
    forward(req, resp, "hoteles.jsp");
  }

  private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    Usuario u = usuarioService.login(email, password);
    if (u == null) {
      req.setAttribute("error", "Credenciales inválidas");
      forward(req, resp, "login.jsp");
      return;
    }
    req.getSession(true).setAttribute("usuario", u);
    resp.sendRedirect(req.getContextPath() + "/app/");
  }

  private void doRegistro(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    try {
      Usuario u = usuarioService.registrar(
          req.getParameter("nombre"),
          req.getParameter("email"),
          req.getParameter("password")
      );
      req.getSession(true).setAttribute("usuario", u);
      resp.sendRedirect(req.getContextPath() + "/app/");
    } catch (IllegalArgumentException ex) {
      req.setAttribute("error", ex.getMessage());
      forward(req, resp, "registro.jsp");
    }
  }

  private void doBuscar(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    String ciudad = req.getParameter("ciudad");
    LocalDate inicio = LocalDate.parse(req.getParameter("inicio"));
    LocalDate fin = LocalDate.parse(req.getParameter("fin"));
    List<Habitacion> habs = busquedaDAO.habitacionesDisponibles(ciudad, inicio, fin);
    req.setAttribute("habitaciones", habs);
    req.setAttribute("ciudad", ciudad);
    req.setAttribute("inicio", inicio);
    req.setAttribute("fin", fin);
    forward(req, resp, "resultados.jsp");
  }

  private void detalleHabitacion(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    Long id = Long.valueOf(req.getParameter("id"));
    var h = busquedaDAO.buscarHabitacion(id);
    if (h == null) { resp.sendError(404); return; }
    req.setAttribute("habitacion", h);
    forward(req, resp, "detalleHabitacion.jsp");
  }

  private void doReservar(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    Usuario u = (Usuario) req.getSession().getAttribute("usuario");
    Long idHab = Long.valueOf(req.getParameter("habitacionId"));
    var h = busquedaDAO.buscarHabitacion(idHab);
    LocalDate inicio = LocalDate.parse(req.getParameter("inicio"));
    LocalDate fin = LocalDate.parse(req.getParameter("fin"));
    try {
      new ReservaService().crear(u, h, inicio, fin);
      resp.sendRedirect(req.getContextPath() + "/app/mis-reservas");
    } catch (IllegalArgumentException ex){
      req.setAttribute("error", ex.getMessage());
      req.setAttribute("habitacion", h);
      forward(req, resp, "detalleHabitacion.jsp");
    }
  }

  private void misReservas(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    Usuario u = (Usuario) req.getSession().getAttribute("usuario");
    var reservas = new ReservaDAO().porUsuario(u);
    req.setAttribute("reservas", reservas);
    forward(req, resp, "misReservas.jsp");
  }

  private void doLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    HttpSession s = req.getSession(false);
    if (s != null) s.invalidate();
    resp.sendRedirect(req.getContextPath() + "/app/");
  }

  private void forward(HttpServletRequest req, HttpServletResponse resp, String jsp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/views/" + jsp).forward(req, resp);
  }
}
