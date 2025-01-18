package med.alura.springBoot.CarlosBaldessari.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.alura.springBoot.CarlosBaldessari.medicos.DadosCadastrosMedicosDTO;
import med.alura.springBoot.CarlosBaldessari.medicos.DadosListagemMedicosDTO;
import med.alura.springBoot.CarlosBaldessari.medicos.MedicoRepository;
import med.alura.springBoot.CarlosBaldessari.medicos.medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody
                         @Valid
                         DadosCadastrosMedicosDTO dados){


        repository.save(new medico(dados));


    }
    @GetMapping
    public Page<DadosListagemMedicosDTO> listar(Pageable paginacao){

        return repository.findAll(paginacao).map(DadosListagemMedicosDTO::new);

    }
}
