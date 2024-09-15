package org.benek.bootcamp.restdemo.repositories;

import org.benek.bootcamp.restdemo.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
