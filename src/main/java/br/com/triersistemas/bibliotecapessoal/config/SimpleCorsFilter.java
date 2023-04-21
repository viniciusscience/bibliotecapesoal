package br.com.triersistemas.bibliotecapessoal.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            HttpServletResponse r = (HttpServletResponse) response;
            r.setHeader("Access-Control-Allow-Origin", "*");
            r.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
            r.setHeader("Access-Control-Max-Age", "3600");
            r.setHeader("Access-Control-Allow-Headers", "x-requested-with, , authorization, content-type, USUARIO-EVT, SENHA-EVT, COD-EVT, x-ijt, tokenSngpc");
            chain.doFilter(request, response);
        } else {
            throw new ServletException("CORS works only for HTTP");
        }
    }

    @Override
    public void destroy() {
    }

}