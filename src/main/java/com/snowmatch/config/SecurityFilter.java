package com.snowmatch.config;

import com.snowmatch.anotacoes.SnowAutowired;
import com.snowmatch.dominio.Usuario;
import com.snowmatch.dominio.repositorio.IUsuarioDados;
import com.snowmatch.dominio.servico.TokenSd;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @SnowAutowired
    private TokenSd tokenSd;

    @SnowAutowired
    private IUsuarioDados usuarioDados;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = this.recuperarToken(request);

        if (token != null) {
            Usuario usuario = usuarioDados.findByNome(tokenSd.validarToken(token));
            var autenticacao = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autenticacao);
        }
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        String cabecalhoRequisicao = request.getHeader("Authorization");
        if (cabecalhoRequisicao != null && cabecalhoRequisicao.startsWith("Bearer ")) {
            return cabecalhoRequisicao.replace("Bearer ", "");
        }
        return null;
    }
}
