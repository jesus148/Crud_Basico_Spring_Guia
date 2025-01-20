package com.gestion.empleados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.gestion.empleados.modelo.Estudiante;
import com.gestion.empleados.repository.EstudianteRepositorio;




//
//LA CLASE QUE EJECUTA TODO EL PROYECTO

//SI EJECUTAS DE ESTA FORMA 
//La anotación @SpringBootApplication marca esta clase como la clase principal de la aplicación. Es una combinación de tres anotaciones:

@SpringBootApplication
public class GestionEmpleadosApplication implements CommandLineRunner {

//	Este método inicia la aplicación Spring Boot.
	public static void main(String[] args) {
//		SpringApplication.run(...) levanta el contexto de Spring, inicializa los beans y pone la aplicación en funcionamiento.
		SpringApplication.run(GestionEmpleadosApplication.class, args);
	}
	

	@Autowired
	private EstudianteRepositorio repositorio;
	
	public void run(String...args)throws Exception{
		
//		crea el objeto 
//		Estudiante estuadiante1= new Estudiante("christian","ramirez","cris@gmail");
//		guarda con el repositiorio
//		repositorio.save(estuadiante1);
//		
//		Estudiante estuadiante2= new Estudiante("Jesus","Huaman","jesus@gmail");
//		repositorio.save(estuadiante2);
	}

}



//spring.datasource.url=jdbc:mysql://localhost/control_empleados
//spring.datasource.username=root
//spring.datasource.password=1977
//spring.application.name=gestionEmpleados
//
//spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
//spring.jpa.hibernate.ddl-auto=none    ---- cambiar a none , para q la bd no se crea otra vez
//Esto significa que no creará, actualizará ni validará las tablas en la base de datos. Todo el esquema debe estar configurado manualmente 
//o previamente existente.
//
//
//spring.jpa.show-sql=true
//spring.jpa.properties.hibernate.format_sql=true
//
//debug=true
//server.port=8090








































/*
 * SI EJECUTAS ASI EL PROYECTO POR PRIMERA VEZ
 * CommandLineRunner : basicamente importa los metodos directamente aca , osea no es nesecario una vista algo asi , de tal forma lo ejecuta 
 *                    directamente  aqui.  esta clase puede ejecutar código adicional después de que la aplicación Spring Boot haya arrancado.
 */


//@SpringBootApplication
//public class GestionEmpleadosApplication implements CommandLineRunner {
//
//	public static void main(String[] args) {
//		SpringApplication.run(GestionEmpleadosApplication.class, args);
//	}
//	
////
//     importa al respositorio
//	@Autowired
//	private EstudianteRepositorio repositorio;
//	
//	public void run(String...args)throws Exception{
//        crea los objetos 
//		Estudiante estuadiante1= new Estudiante("christian","ramirez","cris@gmail");
//		repositorio.save(estuadiante1);
//		
//		Estudiante estuadiante2= new Estudiante("Jesus","Huaman","cris@gmail");
//		repositorio.save(estuadiante1);
//	}
//
//}




//spring.datasource.url=jdbc:mysql://localhost/control_empleados
//spring.datasource.username=root
//spring.datasource.password=1977
//spring.application.name=gestionEmpleados
//
//spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
//spring.jpa.hibernate.ddl-auto=create ---- con esto crea otra vez la tabla cada vez q ejecutes la aplicacion
//
//
//spring.jpa.show-sql=true
//spring.jpa.properties.hibernate.format_sql=true
//
//debug=true
//	
//
//server.port=8090
