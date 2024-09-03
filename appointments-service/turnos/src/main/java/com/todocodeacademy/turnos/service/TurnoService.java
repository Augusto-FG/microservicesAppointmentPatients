package com.todocodeacademy.turnos.service;

import com.todocodeacademy.turnos.model.Paciente;
import com.todocodeacademy.turnos.model.Turno;
import com.todocodeacademy.turnos.repository.ITurnoRepository;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service //siempre se hace en la clase que implementa, no en la interfaz
public class TurnoService implements ITurnoService{
    
    /////esto es una inyeccion de dependencias del REPOSITORIO (NO de la interfaz) que extiende de JpaRepository//////////////////////
    @Autowired
    public ITurnoRepository turnoRepo;
    //////////////////////////////////////////////////////////////////////////////7
    //segundo paso, inyectamos dependencia para la utilización de restTemplate, esto viene de appconfig
    //con esto vamos a poder acceder y comunicarnos con determinadas apis
    @Autowired
    private RestTemplate apiConsumir;
    
    @Override
    public List<Turno> getTurnos() {
        return turnoRepo.findAll();
    }

    //@Override se utiliza en Java para indicar que un método en una clase está sobrescribiendo un método con la misma firma (nombre y parámetros) que se define en una superclase o en una interfaz que la clase implementa
    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        
        //buscar el paciente en la api Pacientes
        ///pacientes/traerdni/{dni}
        Paciente pac = apiConsumir.getForObject("http://localhost:9001/pacientes/traerdni/"+dniPaciente, Paciente.class);
        //Paciente pac = apiConsumir.getForObject("http://13.60.205.249/pacientes/traerdni/"+dniPaciente, Paciente.class);
        //Paciente pac = //lo que busca en la api
        String nombreCompletoPaciente = pac.getNombre() + "" + pac.getApellido();
        
        
        Turno turno = new Turno(); //declaro variable?
        turno.setFecha(fecha); //chequear
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(nombreCompletoPaciente); //viene de la api?
        
        turnoRepo.save(turno);
        
    //acá va a necesitar el dni del paciente que viene del controlador. Ver controlller.
    }

    @Override
    public void deleteTurno(Long id) {
   turnoRepo.deleteById(id);}

    @Override
    public Turno findTurno(Long id) {
        return turnoRepo.findById(id).orElse(null); }

    @Override
    public void editTurno(Long id, Turno turno) {
        Turno turn = this.findTurno(id); //Utiliza el método findTurno para recuperar el turno que se va a editar, utilizando el id proporcionado como parámetro. Lo guardamos en la variable turn
        turn.setFecha(turno.getFecha()); // Actualiza la fecha del turno con la fecha proporcionada
        turn.setTratamiento(turno.getTratamiento()); // Actualiza el tratamiento del turno con el tratamiento proporcionado
        turn.setNombreCompletoPaciente( turno.getNombreCompletoPaciente());// Actualiza el nombre completo del paciente del turno con el nombre proporcionado
        // Guarda los cambios en el turno actualizado en el repositorio
        turnoRepo.save(turn);
        //El turno tiene el mismo ID y ya existe en la base de datos, nunca actualizamos la id, save() actualizará sus campos con los valores proporcionados en turn. Si el turno no existe, se creará un nuevo registro en la base de datos. No se creará otro turno con el mismo ID. En este caso, turn está apuntando al turno original que se recuperó de la base de datos, y save() se encargará de actualizar ese mismo turno en la base de datos con los cambios realizados en turn.
    }
    
}
