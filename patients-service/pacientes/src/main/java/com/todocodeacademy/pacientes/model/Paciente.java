/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todocodeacademy.pacientes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
//Las anotaciones @Getter y @Setter de Lombok generan automáticamente los métodos getters y setters para los campos de la clase. Esto reduce la verbosidad del código, ya que no necesitas escribir estos métodos manualmente.
/**
 *
 * @author Usuario
 */
@Entity //indica que la clase Paciente es una entidad JPA, lo que significa que está mapeada a una tabla en la base de datos. En términos simples, esta anotación marca la clase como persistente, permitiendo que sea gestionada por el sistema de persistencia de Java

public class Paciente {
    @Id //La anotación @Id se aplica al campo idPaciente y especifica que este campo es la clave primaria de la entidad. La clave primaria es un campo único que identifica de manera única a cada instancia de la entidad
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //La anotación @GeneratedValue se utiliza junto con @Id para especificar cómo se generará el valor de la clave primaria. En este caso, se ha seleccionado GenerationType.IDENTITY, lo que indica que el valor se generará automáticamente por la base de datos utilizando una estrategia de identidad. Esto es comúnmente utilizado con bases de datos que admiten la autoincrementación de columnas, como en MySQL.
    private Long  idPaciente;
    private String dni;
    private String nombre;
    private String apellido;
    @Temporal(TemporalType.DATE)
    //La anotación @Temporal se aplica al campo fechaNac y especifica el tipo de mapeo temporal que se utilizará. TemporalType.DATE indica que solo se debe mapear la fecha, sin incluir la información de la hora. Esto es útil cuando solo estás interesado en la fecha de nacimiento y no necesitas la precisión de la hora y los minutos.
    private LocalDate fechaNac;
    private String telefono;

    public Paciente() {//por qué necesitamos un  contructor vacio?
    }

    public Paciente(Long idPaciente, String dni, String nombre, String apellido, LocalDate fechaNac, String telefono) {
        this.idPaciente = idPaciente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
    }
    
    
    
    
    
}
