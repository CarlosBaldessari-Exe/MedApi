package med.alura.springBoot.CarlosBaldessari.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.alura.springBoot.CarlosBaldessari.medicos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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


        repository.save(new Medico(dados));


    }
    @GetMapping
    public Page<DadosListagemMedicosDTO> listar(@PageableDefault(size =10, sort = {"nome"}) Pageable paginacao){

        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicosDTO::new);

    }
    @PutMapping
    @Transactional
    public void atulizar(@RequestBody @Valid AtualizacaoDadosMedicos dados){
        var medicos = repository.getReferenceById(dados.id());
        medicos.atualizarInformacoes(dados);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
           var medicos = repository.getReferenceById(id);
           medicos.excluir();//Esto inactiva el usuario, no lo borra

    }
}
