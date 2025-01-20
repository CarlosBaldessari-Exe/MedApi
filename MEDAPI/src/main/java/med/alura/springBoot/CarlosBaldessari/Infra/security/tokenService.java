package med.alura.springBoot.CarlosBaldessari.Infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import med.alura.springBoot.CarlosBaldessari.domain.usurario.usuario;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.tokens.Token;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class tokenService {

    public String gerarToken(usuario usuario){
        try {

            var algorithm = Algorithm.HMAC256("12345678");

            return JWT.create()
                    .withIssuer("MEDAPI")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);

        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar o token jet", exception);

            // Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
