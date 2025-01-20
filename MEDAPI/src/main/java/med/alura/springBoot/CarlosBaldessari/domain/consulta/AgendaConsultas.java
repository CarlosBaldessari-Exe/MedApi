package med.alura.springBoot.CarlosBaldessari.domain.consulta;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.alura.springBoot.CarlosBaldessari.consulta.DadosCancelamentoConsultaDTO;
import med.alura.springBoot.CarlosBaldessari.domain.ValidacaoException;
import med.alura.springBoot.CarlosBaldessari.domain.medicos.Medico;
import med.alura.springBoot.CarlosBaldessari.domain.medicos.MedicoRepository;
import med.alura.springBoot.CarlosBaldessari.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsultaDTO dadosAgendamentoConsultaDTO){

        if (pacienteRepository.existsById(dadosAgendamentoConsultaDTO.idPaciente())){
            throw new ValidacaoException("ID do paciente nao existente");
        }

        if ( dadosAgendamentoConsultaDTO.idMedico() !=null && !medicoRepository.existsById(dadosAgendamentoConsultaDTO.idMedico())){
            throw new ValidacaoException("ID do medico nao existente");
        }


        var paciente = pacienteRepository.getReferenceById(dadosAgendamentoConsultaDTO.idPaciente());

        var medico = escolherMedico(dadosAgendamentoConsultaDTO);

        var consulta = new Consulta(null, medico, paciente, dadosAgendamentoConsultaDTO.data().atStartOfDay(), null);
        consultaRepository.save(consulta);


    }

    private Medico escolherMedico(DadosAgendamentoConsultaDTO dadosAgendamentoConsultaDTO) {

        if (dadosAgendamentoConsultaDTO.idMedico() != null) {
            return medicoRepository.getReferenceById(dadosAgendamentoConsultaDTO.idMedico());
        }

        if (dadosAgendamentoConsultaDTO.especialidade()== null){
            throw  new ValidacaoException("Especialidade e obrigatoria");

        }
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dadosAgendamentoConsultaDTO.especialidade(), dadosAgendamentoConsultaDTO.data());
    }

    public void cancelar(@Valid DadosCancelamentoConsultaDTO dadosCancelamentoConsulta) {
        if(!consultaRepository.existsById(dadosCancelamentoConsulta.idConsulta())){
            throw new ValidacaoException("Id da consulta nao existe");
        }
        var consulta= consultaRepository.getReferenceById(dadosCancelamentoConsulta.idConsulta());
        consulta.cancelar(dadosCancelamentoConsulta.motivo());

    }
}
