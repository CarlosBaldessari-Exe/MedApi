package med.alura.springBoot.CarlosBaldessari.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.alura.springBoot.CarlosBaldessari.domain.medicos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody
                                   @Valid
                                       DadosCadastrosMedicosDTO dados,
                                   UriComponentsBuilder uriBuilder){
        var medico= new Medico(dados);
        repository.save(medico);

        var uri= uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedicoDTO(medico));

    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemMedicosDTO>> listar(@PageableDefault(size =10, sort = {"nome"}) Pageable paginacao){

        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicosDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atulizar(@RequestBody @Valid AtualizacaoDadosMedicos dados){
        var medicos = repository.getReferenceById(dados.id());
        medicos.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedicoDTO(medicos));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){

        var medicos = repository.getReferenceById(id);
        medicos.excluir();//Esto inactiva el usuario, no lo borra

        return ResponseEntity.noContent().build();
    }

       @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        
        var medicos = repository.getReferenceById(id);
                return ResponseEntity.ok(new DadosDetalhamentoMedicoDTO(medicos));
    }
}

