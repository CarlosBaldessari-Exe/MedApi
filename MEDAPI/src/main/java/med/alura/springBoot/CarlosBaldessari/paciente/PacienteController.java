package med.alura.springBoot.CarlosBaldessari.paciente;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastradosPacientesDTO dados){
        repository.save(new Paciente(dados));
    }
    @GetMapping
    public Page<DadosListagemPacientes> listar (@PageableDefault(sort = {"name"}, size = 10)Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPacientes::new);


    }


    @PutMapping
    @Transactional
    public void Atualizar(@RequestBody @Valid AtualizacaoDadosPacientes dados){
        var paciente = repository.getReferenceById(dados.Id());
        paciente.atualizarInformacoes(dados);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();//Esto inactiva el usuario, no lo borra

    }
}
