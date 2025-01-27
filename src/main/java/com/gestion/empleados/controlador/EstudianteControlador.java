package com.gestion.empleados.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping({ "/listado", "/" })
	public String listarTodosEstudiante(Model modelo) {
//		Model modelo :Es un objeto proporcionado por Spring MVC que permite enviar datos desde el controlador a la vista.
//		Se utiliza para agregar atributos (datos) que estarán disponibles en el archivo de la vista que se renderizará.

//		en la variable "estudiantes" sex agrega todo el metodo listarTodosEstudiante
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
		// este metodo solo le envia la variable q contiene el objeto y sus atributos
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
//		el redirect se usa al llamar a un controller
		return "redirect:/listado";
	}
	
	
	
	
	
	
//	CONTROLLER GET ONE ESTUDIANTE POR ID
//	http://localhost:8090/estudiantes/editar/{id}
//	@PathVariable Long id  : es el parametro de la url y Long es integer
	@GetMapping("/estudiantes/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id ,Model modelo ) {
		
//		"estudiante" : es la variable donde se guarda el objeto encontrado x el id
		modelo.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
		
//		retorna a la vista html y le envia la "estudiante" q tiene el objeto encontrado
		return "editar_estudiante";
	}
	
	
	
	
	
	
	
	
//	CONTROLLER ACTUALIZA UN ESTUDIANTE
//	http://localhost:8090/estudiantes/{id}
//	@PathVariable Long id : parametro 
//	@ModelAttribute("estudiante") Estudiante estudiante : un parametro de tipo objeto y de modelo Estudiante
	@PostMapping("/estudiantes/{id}")
	public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante,
			Model modelo) {
		
//		busca x el id al estudiante
		Estudiante estudianteExistente = servicio.obtenerEstudiantePorId(id);
		
		
//		setea los datos del objeto encontrado x el obejto  (@ModelAttribute("estudiante") Estudiante estudiante) estudiante
		estudianteExistente.setId(id);
		estudianteExistente.setNombre(estudiante.getNombre());
		estudianteExistente.setApellido(estudiante.getApellido());
		estudianteExistente.setEmail(estudiante.getEmail());
		
//		le envia los valores seteados
		servicio.actualizarEstudiante(estudianteExistente);
		
		
//		redireccion al controller listado
		return "redirect:/listado";
	}
	
	
	
	
	
	
//	CONTROLLER ELIMINAR
//	http://localhost:8090/estudiantes/{id}
//	@PathVariable Long id : parametro de la url
	@GetMapping("/estudiantes/{id}")
	public String eliminarEstudiante(@PathVariable Long id) {
		
//		elimina x el id
		servicio.eliminarEstudiante(id);
		
//		redireccion al controller listado
		return "redirect:/listado";
	}
	
	
	
	
	
	
	
	

}
