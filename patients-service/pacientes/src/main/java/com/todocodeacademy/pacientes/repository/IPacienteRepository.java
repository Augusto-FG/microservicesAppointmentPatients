package com.todocodeacademy.pacientes.repository;

import com.todocodeacademy.pacientes.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//el repository es para que la clase interactue con la base de datos 
@Repository //La anotación @Repository en Spring se utiliza para indicar que una clase es un componente de repositorio, lo que significa que tiene la responsabilidad de interactuar con la capa de persistencia o almacenamiento de datos. En el contexto de Spring Data, se utiliza comúnmente para marcar las clases que acceden a bases de datos 
public interface IPacienteRepository extends JpaRepository <Paciente, Long>{

    //JpaRepository es una interfaz proporcionada por Spring Data JPA, que a su vez es parte del proyecto Spring Data. Esta interfaz proporciona un conjunto de métodos predefinidos para realizar operaciones de persistencia comunes en una base de datos.

//JpaRepository<Paciente, Long> utiliza dos parámetros genéricos.
//Paciente: Indica el tipo de entidad con la que la interfaz va a trabajar. En este caso, se espera que la interfaz maneje operaciones de persistencia para la entidad Paciente.
//Long: Indica el tipo de la clave primaria de la entidad. En este caso, se asume que la clave primaria de la entidad Paciente es de tipo Long.

// En general, al utilizar Spring Data JPA, es recomendable indicar el tipo de dato de la clave primaria en la interfaz que extiende JpaRepository. Esto ayuda a Spring Data JPA a entender cómo manejar las operaciones de persistencia relacionadas con la clave primaria.
//
//La declaración típica es JpaRepository<T, ID>, donde:
//
//T es el tipo de entidad con la que estás trabajando.
//ID es el tipo de la clave primaria.
    //metodo personalizado mediante una consulta personalizada.
    @Query("SELECT p FROM Paciente p WHERE p.dni =:dni")
    Paciente findByDni(String dni);
}
