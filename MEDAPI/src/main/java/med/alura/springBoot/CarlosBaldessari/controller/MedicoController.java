package med.alura.springBoot.CarlosBaldessari.controller;

import med.alura.springBoot.CarlosBaldessari.medicos.DadosCadastrosMedicos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @PostMapping
    public void cadastro(
          @RequestBody DadosCadastrosMedicos dados
    ){
        System.out.println(dados);


    }
}
