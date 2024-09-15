package org.benek.bootcamp.restdemo.init;

import org.benek.bootcamp.restdemo.models.Empleado;
import org.benek.bootcamp.restdemo.repositories.EmpleadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(EmpleadoRepository repository){
        return args -> {
            Empleado javier = new Empleado("Javier", "Dueno del todo el pedo");
            Empleado oscar = new Empleado("Oscar", "CTO");
            Empleado pedro = new Empleado("Javier", "Programador");
            log.info("Carga inicial: {}", repository.save(javier));
            log.info("Carga inicial: {}", repository.save(oscar));
            log.info("Carga inicial: {}", repository.save(pedro));

        };
    }
}
