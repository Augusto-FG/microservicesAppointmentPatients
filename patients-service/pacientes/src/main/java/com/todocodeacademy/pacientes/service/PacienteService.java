
package com.todocodeacademy.pacientes.service;

import java.util.List;
import com.todocodeacademy.pacientes.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todocodeacademy.pacientes.repository.IPacienteRepository;

@Service //siempre se hace en la clase que implementa, no en la interfaz
public class PacienteService implements IPacienteService {
/////esto es una inyeccion de dependencias del REPOSITORIO (NO de la interfaz) que extiende de JpaRepository//////////////////////
    @Autowired
    private IPacienteRepository pacienteRepo; //creamos pacienteRepo
////////////////////////////////////////////////////////////////////////////////    
    @Override
//Cuando se marca un método con @Override, estás indicando que ese método es una implementación específica de un método definido en una interfaz o clase padre. Esto ayuda a mejorar la legibilidad del código y a prevenir errores de programación, ya que el compilador verificará que el método que estás intentando sobrescribir realmente existe en la clase padre o en la interfaz. Si no existe, el compilador generará un error.
    public List<Paciente> getPacientes() {
        return pacienteRepo.findAll();
    }

    @Override
    public void savePaciente(Paciente pac) {
        pacienteRepo.save(pac);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepo.deleteById(id);
    }
    @Override
    public Paciente findPaciente(Long id) {
        return pacienteRepo.findById(id).orElse(null);
    }

    @Override
    public void editPaciente(Long id, Paciente pac) {
        this.savePaciente(pac);
    }

    @Override
    public Paciente findPacienteDni(String dni) {
        return pacienteRepo.findByDni(dni);
    }

    
}
