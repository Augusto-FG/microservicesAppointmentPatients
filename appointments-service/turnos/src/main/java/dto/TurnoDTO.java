package dto;
//data transfer objets, es de transferencia de objetos, investigar

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDTO {
    private LocalDate fecha;
    private String tratamiento;
    private String dniPaciente;
    //este patron dto nos va a permitir recibir la info del json que estamos necesitando
}
