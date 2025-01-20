package com.gestion.empleados.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.empleados.modelo.Estudiante;
import com.gestion.empleados.repository.EstudianteRepositorio;

/*@Service : se debe poner esto para decir q es un servicio*/
/*EstudianteServicioImpl hereda de EstudianteServicio*/
@Service
public class EstudianteServicioImpl implements EstudianteServicio {

	
//	SERVICIO CONTROLA CONEXION DEL CONTROLLER AL REPOSITORY
	
	
	/* conectamos al repositorio */
	@Autowired
	private EstudianteRepositorio repositorio ;
	
	
	
	
//	metodo obtiene todo
	@Override
	public List<Estudiante> listarTodosEstudiante() {
		return repositorio.findAll();
	}

	
	
//	metodo guardar registro
	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}



	//metodo para obtener un estudiante por id
	@Override
	public Estudiante obtenerEstudiantePorId(Long id) {
		return repositorio.findById(id).get();
	}



	//metodo actualizar estudiante 
	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
//		el save es igual , osea si ese estudiante ya esta agregado lo actualiza
//		, y si no esta agregado lo registra
		return repositorio.save(estudiante);
	}



	//metodo eliminar estudiante por id
	@Override
	public void eliminarEstudiante(Long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

}
