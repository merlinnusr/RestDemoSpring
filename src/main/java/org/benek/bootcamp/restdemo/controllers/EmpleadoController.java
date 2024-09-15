package org.benek.bootcamp.restdemo.controllers;

import org.benek.bootcamp.restdemo.models.Empleado;
import org.benek.bootcamp.restdemo.repositories.EmpleadoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    private final EmpleadoRepository repository;
    public EmpleadoController(EmpleadoRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/empleados")
    public List<Empleado> mostrarEmpleados(){
        return repository.findAll();
    }
    @GetMapping("/empleados/{id}")
    public Empleado getEmpleado(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }
    @PostMapping("/empleados")
    public Empleado crear(@RequestBody Empleado empleado){
        return repository.save(empleado);
    }

    @PutMapping("/empleados/{id}")
    public Empleado update(@RequestBody Empleado empleado, @PathVariable Long id){
        return repository.findById(id)
                .map(empleado1 -> {
                    empleado1.setNombre(empleado.getNombre());
                    empleado1.setPuesto(empleado.getPuesto());
                    return repository.save(empleado1);
                })
                .orElseGet(() ->{
                    return repository.save(empleado);
                });
    }
    @DeleteMapping("/empleados/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
}
