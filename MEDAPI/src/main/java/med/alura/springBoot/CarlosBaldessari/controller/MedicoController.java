package med.alura.springBoot.CarlosBaldessari.controller;

import med.alura.springBoot.CarlosBaldessari.medicos.DadosCadastrosMedicosDTO;
import med.alura.springBoot.CarlosBaldessari.medicos.MedicoRepository;
import med.alura.springBoot.CarlosBaldessari.medicos.medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastro(@RequestBody DadosCadastrosMedicosDTO dados){


        repository.save(new medico(dados));


        }
}
