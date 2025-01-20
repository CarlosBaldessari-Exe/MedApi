package med.alura.springBoot.CarlosBaldessari.domain.medicos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);


    @Query ("""
            SELECT  m FROM Medico m where m.ativo=ture and
            m.id not in(select c.medico.id from Consulta c where c.data = :data)
             m.especialidade = :especialidade order by rand()
            LIMIT 1
            """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, @NotNull @Future LocalDate data);

}
