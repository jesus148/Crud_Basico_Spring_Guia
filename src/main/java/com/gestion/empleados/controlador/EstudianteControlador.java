package com.gestion.empleados.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gestion.empleados.modelo.Estudiante;
import com.gestion.empleados.servicio.EstudianteServicio;

@Controller
public class EstudianteControlador {

//	
//	CONTROLADOR 
//	controla los endpoints

	/* conectamos al repositorio */
	@Autowired
	private EstudianteServicio servicio;

	
	
	
	
	
	
//	CONTROLLER LISTAR TODO
//	metodo obtiene todo
//	Model modelo: se usa para retornar a la vista
//	"/estudiantes" : es una ruta 	
//	"/" : es otra ruta 
//	http://localhost:8090/listado o si no http://localhost:8090/
	@GetMapping({ "listado", "/" })
	public String listarTodosEstudiante(Model modelo) {
//		Model modelo :Es un objeto proporcionado por Spring MVC que permite enviar datos desde el controlador a la vista.
//		Se utiliza para agregar atributos (datos) que estarán disponibles en el archivo de la vista que se renderizará.

//		en la variable "estudiantes" se agrega todo el metodo listarTodosEstudiante
		modelo.addAttribute("estudiantes", servicio.listarTodosEstudiante());

//		es el nombre de la vista html  "estudiantes"
		return "estudiantes";
	}

	
	
	
	
	
	
	
//	CONTROLLER DE PRUEBA
//	test de prueba
//	http://localhost:8090/prueba
	@GetMapping("/prueba")
	public String prueba(Model modelo) {
//		"mensaje" : variable donde se pone la data , servira para cosumir en el hmtl
		modelo.addAttribute("mensaje", "Hola desde Thymeleaf");
//	    "prueba" : vista en src/main/resources/templates
		return "prueba";
	}

	
	
	
	
	
	
	// CONTROLLER ENVIA EL OBJETO GUIA
//	http://localhost:8090/estudiantes/nuevo
	@GetMapping("/estudiantes/nuevo")
	public String mostrarFormularioDeRegistrarEstudiante(Model modelo) {

		// creando una instancia
		Estudiante estudiante = new Estudiante();

		// "estudiante" : variable donde se pone un objeto estudiante
		// este metodo solo le envia la variable q contiene el objeto
		modelo.addAttribute("estudiante", estudiante);

		// abre la vista crear_estudiante.html
		return "crear_estudiante";
	}

	
	
	
	
	
	
	
	
//	CONTROLLER AGREGAR ESTUDIANTE
//	http://localhost:8090/estudiante
//	@ModelAttribute("estudiante") : recibe un parametro de tipo estudiante de la vista crear_estudiante sera de tipo Objeto estudiante
	//osea el estudiante de tipo Objeto Estudiante , tendra los datos del formulario 
	@PostMapping("/estudiantes")
	public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		
		//guarda el estudiante con el metodo
		servicio.guardarEstudiante(estudiante);
		
		//redirecciona al controller del listado
		return "redirect:listado";
	}

}
