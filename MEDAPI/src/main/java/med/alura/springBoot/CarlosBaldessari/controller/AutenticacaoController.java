package med.alura.springBoot.CarlosBaldessari.controller;

import jakarta.validation.Valid;
import med.alura.springBoot.CarlosBaldessari.Infra.security.tokenService;
import med.alura.springBoot.CarlosBaldessari.domain.usurario.DadosAutenticacaoDTO;
import med.alura.springBoot.CarlosBaldessari.domain.usurario.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.Authenticator;

@Controller
@RequestMapping("/login")
public class AutenticacaoController {

    private AuthenticationManager manager;

    @Autowired
    private tokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados){
        var token =new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autentication = manager.authenticate(token);

        return ResponseEntity.ok(tokenService.gerarToken((usuario) autentication.getPrincipal()));

    }
}
