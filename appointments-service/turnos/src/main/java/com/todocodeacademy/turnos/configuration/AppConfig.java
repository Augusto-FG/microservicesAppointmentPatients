package com.todocodeacademy.turnos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //anotation para indicar que esta clase es de configuración
public class AppConfig {
    @Bean ("apiConsumir") //guardamos este 'objeto' en 'api consumir'
    // con Bean le estamos diciendo al contenedor de spring que ese método es responsable de crear y devolver un objeto que debe ser administrado por el contenedor de spring
    ///resttemplate es una clase de configuración para poder conectar dos microservicios
    public RestTemplate registrarRestTemplate(){
        return new RestTemplate();
      }   
}
