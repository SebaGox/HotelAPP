package cl.tuempresa.hotelapp.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class CharsetFilter implements Filter {
  @Override public void init(FilterConfig filterConfig) {}
  @Override public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    req.setCharacterEncoding("UTF-8");
    res.setCharacterEncoding("UTF-8");
    chain.doFilter(req, res);
  }
  @Override public void destroy() {}
}
