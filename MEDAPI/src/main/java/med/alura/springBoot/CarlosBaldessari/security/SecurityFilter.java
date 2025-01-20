package med.alura.springBoot.CarlosBaldessari.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.alura.springBoot.CarlosBaldessari.Infra.security.TokenService;
import med.alura.springBoot.CarlosBaldessari.domain.usurario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Chamando Filtro");
        var tokenJWT= recuperarToken(request);

        if(tokenJWT!=null){
        var subject = tokenService.getSubject(tokenJWT);
        var usuario = repository.findByLogin(subject);

        var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("LOGADO NA REQUISICAO");
        }
        filterChain.doFilter(request, response); //NECESARIO PARA LLAMAR LOS PROXIMOS FILTROS EN LA APLICACION

    }

    private String recuperarToken(HttpServletRequest request) {
        var autorizationHeader = request.getHeader("Autorization");

        if (autorizationHeader != null) {
            return autorizationHeader.replace("Bearer ", "");

        }
    return null;

    }
}
