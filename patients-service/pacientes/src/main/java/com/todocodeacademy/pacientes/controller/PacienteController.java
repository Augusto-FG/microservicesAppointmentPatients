package com.todocodeacademy.pacientes.controller;

import java.util.List;
import com.todocodeacademy.pacientes.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.todocodeacademy.pacientes.service.IPacienteService;

@RestController
public class PacienteController {
    //primero siempre inyectamos dependencias con autowired
    //Esto es para hacer uso del service, para tener conectado el controller con el service y con el repository
    @Autowired
    private IPacienteService pacienteServ;
    
    //1.crear un nuevo paciente
    @PostMapping ("paciente/crear")
    public String crearPaciente (@RequestBody Paciente pac){ //ponemos public String porque quiero que devuelva un mensaje
    //@RequestBody Paciente pac indica que el cuerpo de la solicitud POST se convertirá automáticamente a un objeto de tipo Paciente y se pasará como argumento al método crearPaciente.   
        pacienteServ.savePaciente(pac); //llamamos al service, el service llama al repository, y el repository llama a la base de datos.
        return "El paciente fue creado correctamente";
    }
    
    //2.traer todos los pacientes
    @GetMapping("pacientes/traer")
    public List <Paciente> traerPacientes(){
        return pacienteServ.getPacientes();
        
    }
    //3.eliminar un paciente
    @DeleteMapping("pacientes/borrar/{id}")
    public String deletePaciente(@PathVariable Long id){
        //@PathVariable es una anotación en Spring MVC que se utiliza para mapear variables de la URL a parámetros de métodos de controladores en Spring.
        //La anotación @PathVariable se utiliza para mapear el valor {id} de la URL ("/pacientes/borrar/{id}") al parámetro id del método deletePaciente(). Esto significa que cuando se realiza una solicitud DELETE a "/pacientes/borrar/123", donde "123" es el ID del paciente que se desea eliminar, Spring Boot tomará ese valor "123" de la URL y lo pasará al método deletePaciente() como el parámetro id.
    pacienteServ.deletePaciente(id);
    return "El paciente fue eliminado correctamente";
    }
    
    
    //4.editar un paciente
   // Controlador REST para manejar la actualización de información de un paciente
    @PutMapping("pacientes/editar/{id_original}")
    public Paciente updatePaciente(@PathVariable Long id_original, @RequestBody Paciente pacienteEditar) {
    // Llama al servicio para editar la información del paciente con el ID original
    pacienteServ.editPaciente(id_original, pacienteEditar);
    
    // Llama al servicio para encontrar y obtener el paciente editado, también se crea pacienteEditado
    Paciente pacienteEditado = pacienteServ.findPaciente(id_original);
    
    // Devuelve el paciente editado como respuesta a la solicitud
    return pacienteEditado;
}

    //5.obtener un paciente en particular
    @GetMapping("/pacientes/traer/{id}")
    public Paciente traerPaciente (@PathVariable Long id) {
        return pacienteServ.findPaciente(id);
    }
    
    @GetMapping("/pacientes/traerdni/{dni}")
    public Paciente traerPacienteDni (@PathVariable String dni) {
        return pacienteServ.findPacienteDni(dni);
    }
}
