package com.gestion.empleados.servicio;

import java.util.List;

import com.gestion.empleados.modelo.Estudiante;

public interface EstudianteServicio {

	
//	INTERFACE principal
	
	
//	metodo lista
	public List<Estudiante> listarTodosEstudiante();
	
//	metodo guarda
	//public Estudiante : Estudiante es lo q retorna no olvida
	public Estudiante guardarEstudiante(Estudiante estudiante);
	
	
	//obtener Estudiante por id 
	public Estudiante obtenerEstudiantePorId(Long id);
	
	
	//metodo actualizar
	public Estudiante actualizarEstudiante(Estudiante estudiante);
	
	
	//metodo eliminar
	//void no retorna nada
	public void eliminarEstudiante(Long id);
}
