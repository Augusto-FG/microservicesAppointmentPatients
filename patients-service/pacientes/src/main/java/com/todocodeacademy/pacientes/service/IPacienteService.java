package com.todocodeacademy.pacientes.service;

import java.util.List;
import com.todocodeacademy.pacientes.model.Paciente;

public interface IPacienteService {
    public List <Paciente> getPacientes();
    
    public void savePaciente (Paciente pac);
    
    public void deletePaciente (Long id);
    
    public Paciente findPaciente(Long id);
    
    public void editPaciente (Long id, Paciente pac);
    
    //public Paciente findPacienteByDni(String dni);

    public Paciente findPacienteDni(String dni);
}
