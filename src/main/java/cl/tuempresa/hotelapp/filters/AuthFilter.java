package cl.tuempresa.hotelapp.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthFilter implements Filter {
  @Override public void init(FilterConfig filterConfig) {}

  @Override public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    HttpSession session = req.getSession(false);
    boolean logged = (session != null && session.getAttribute("usuario") != null);

    String uri = req.getRequestURI(); // incluye /contexto/...
    boolean proteger = uri.endsWith("/app/mis-reservas") || uri.endsWith("/app/do-reservar");

    if (proteger && !logged) {
      res.sendRedirect(req.getContextPath() + "/app/login");
      return;
    }
    chain.doFilter(request, response);
  }

  @Override public void destroy() {}
}
