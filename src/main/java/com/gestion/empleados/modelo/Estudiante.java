package com.gestion.empleados.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*@Table(name = "estudiantes") : nombre de la tabla*/
@Entity
@Table(name = "estudiantes")
public class Estudiante {
	
	
//	CLASE MODELO
	
	
	/* campo del id */
//	@GeneratedValue : se genera auto
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	name : nombre de la columna
//	nullable : no puede estar vacia
//	length : longitud para ese campo
	/* unique : datos unicos */
	@Column(name = "nombre",nullable = false,length = 50)
	private String nombre;
	
	@Column(name = "apellido",nullable = false,length = 50)
	private String apellido;
	
	@Column(name = "email",nullable = false,length = 50,unique = true)
	private String email;
	
	// Constructor por defecto (necesario para Hibernate)
    public Estudiante() {
    }

//	CONSTRUCTOR COMPLETO
//	creando el constructor : de manera facil > click derecho > source> generate constructor
	public Estudiante(Long id, String nombre, String apellido, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
//	CONSTRUCTOR SOLO CREA EL OBJETO SIN EL ID
	public Estudiante( String nombre, String apellido, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	
//	creando geters y seters >  de manera facil > click derecho > source > generate getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
//	creando tostring >  de manera facil > click derecho > source >generate tostring
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + "]";
	}
	
	
	
	
	
	
}
