
package com.todocodeacademy.turnos.controller;

import com.todocodeacademy.turnos.model.Turno;
import com.todocodeacademy.turnos.service.ITurnoService;
import dto.TurnoDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    
    @Autowired
    private ITurnoService turnoServ;
    //1- crear nuevo turno usamos un DTO para traer la info del json
    @PostMapping("/crear")
    public String crearTurno (@RequestBody TurnoDTO turno){ //este dni se lo pasamos por teclado en el frontend y luego con el servico saveTurno va ir a buscar el nombre del paciente de la ai paciente, porque la entidad turno no pide dni, pide nombre del paciente.
    turnoServ.saveTurno(turno.getFecha(), turno.getTratamiento(), turno.getDniPaciente());
    return "Turno creado correctamente";
    }
    //2-obtener todos los turno
    @GetMapping("/traer")
    public List <Turno> traerTurno(){
        return turnoServ.getTurnos();
    }
    
    //3-eliminar un turno
    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id){
        turnoServ.deleteTurno(id);
        return "El turno fue eliminado corretamente";
    }
    //4-editar un turno
    @PutMapping("/editar/{id_original}")
    public Turno editarTurno (@PathVariable Long id_original, @RequestBody Turno turnoEditar) {
    turnoServ.editTurno(id_original, turnoEditar);
    Turno turnoEditado = turnoServ.findTurno(id_original);
    return turnoEditado;
    }
    
    
    //5-obtener un turno en particular
    @GetMapping("/traer/{id}")
    public Turno traerTurno (@PathVariable Long id){
        return turnoServ.findTurno(id);
    }
    
    
}
