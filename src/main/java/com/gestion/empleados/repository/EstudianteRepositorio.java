package com.gestion.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.modelo.Estudiante;

/*se debe poner @Repository para la conexion a la bd*/
/*<Estudiante, Long> : clase guia y su id respectivo*/

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long>{

//	REPOSITORIO CONEXION A LA BD
}
