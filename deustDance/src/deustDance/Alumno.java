package deustDance;

import java.util.Date;

public class Alumno extends Persona{
	
	private Baile baileAsignado;
	private Profesor profesorAsignado;
	private Clase claseAsignada;
	private double dinero;
	
	


	public Alumno(String nombre, String apellidos, int edad, String email, String dni, String contrasenia, Date fNac,
			String direccion, String codPostal, String telefono, Sexo sexo, Baile baileAsignado,
			Profesor profesorAsignado, Clase claseAsignada, double dinero) {
		super(nombre, apellidos, edad, email, dni, contrasenia, fNac, direccion, codPostal, telefono, sexo);
		this.baileAsignado = baileAsignado;
		this.profesorAsignado = profesorAsignado;
		this.claseAsignada = claseAsignada;
		this.dinero = dinero;
	}
	
	

	public Alumno(String nombre, String apellidos, int edad, String email, String contrasenia, String dni, String fNac,
			String direccion, String codPostal, String telefono, Sexo sexo) {
		super(nombre, apellidos, edad, email, contrasenia, dni, fNac, direccion, codPostal, telefono, sexo);
		
	}



	public Baile getBaileAsignado() {
		return baileAsignado;
	}

	public void setBaileAsignado(Baile baileAsignado) {
		this.baileAsignado = baileAsignado;
	}

	public Profesor getProfesorAsignado() {
		return profesorAsignado;
	}

	public void setProfesorAsignado(Profesor profesorAsignado) {
		this.profesorAsignado = profesorAsignado;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	
	public Clase getClaseAsignada() {
		return claseAsignada;
	}

	public void setClaseAsignada(Clase claseAsignada) {
		this.claseAsignada = claseAsignada;
	}

	@Override
	public String toString() {
		return "Nombre: " + getNombre() + ", Apellidos: " + getApellidos() + ", Edad: " + getEdad()
				+ ", Dni: " + getDni() + ", Fecha de nacimiento" + getfNac() + ", baile asignado=" + baileAsignado
				+ ", profesor asignado=" + profesorAsignado + ", clase asignada: " + claseAsignada;
	}

	
	
	

	

	


	

	
	
	
	
	
	

}
