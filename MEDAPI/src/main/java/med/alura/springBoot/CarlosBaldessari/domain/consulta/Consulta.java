package med.alura.springBoot.CarlosBaldessari.domain.consulta;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.alura.springBoot.CarlosBaldessari.consulta.MotivoCancelamento;
import med.alura.springBoot.CarlosBaldessari.domain.medicos.Medico;
import med.alura.springBoot.CarlosBaldessari.domain.paciente.Paciente;

import java.time.LocalDateTime;

@Table(name = "consulta")
@Entity(name = "consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;
    private  MotivoCancelamento MotivoCncelamento;

    @Column(name = "motivo-cancelamento")
    @Enumerated(EnumType.STRING)
    public void cancelar(@NotNull MotivoCancelamento motivo) {
        this.MotivoCncelamento= motivo;
    }
}
