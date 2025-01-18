package med.alura.springBoot.CarlosBaldessari.controller;

import med.alura.springBoot.CarlosBaldessari.paciente.DadosCadastradosPacientes;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class CadastroPacientes{
    public void cadastrar(@RequestBody DadosCadastradosPacientes dados){
        System.out.println("Dados recebidos: " +
                dados);

    }
}
