
package com.todocodeacademy.turnos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor //por qué necesitamos un  contructor vacio?
//Cuando JPA crea una instancia de la entidad a partir de los resultados de la consulta de la base de datos, necesita un constructor vacío para inicializar la instancia antes de asignar los valores de las columnas de la base de datos a los campos de la entidad.
@Entity ////indica que la clase Turno es una entidad JPA, que está mapeada a una tabla en la base de datos.
public class Turno {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idTurno;
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;
    private String tratamiento;
    private String nombreCompletoPaciente;   
}
