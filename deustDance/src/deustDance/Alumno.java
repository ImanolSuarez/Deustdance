package deustDance;

import java.util.Date;

public class Alumno extends Persona{
	
	private Baile baileAsignado;
	private Profesor profesorAsignado;
	private Clase claseAsignada;
	private double dinero;
	private double calificacion;
	
	
	public Alumno(String nombre, String apellidos, int grupo, String usuario, String contrasenia, Baile baileAsignado,
			Profesor profesorAsignado, Clase claseAsignada, double dinero, double calificacion) {
		super(nombre, apellidos, grupo, usuario, contrasenia);
		this.baileAsignado = baileAsignado;
		this.profesorAsignado = profesorAsignado;
		this.claseAsignada = claseAsignada;
		this.dinero = dinero;
		this.calificacion = calificacion;
	}
	
	

	public Alumno(String nombre, String apellidos, int grupo, String usuario, String contrasenia) {
		super(nombre, apellidos, grupo, usuario, contrasenia);
		
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
	
	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return "Nombre del alumno: " + getNombre() + ", apellidos: " + getApellidos() + ", grupo asignado:"
				+ getGrupo() + ", baile asignado: " + baileAsignado + ", profesor asignado: " + profesorAsignado
				+ ", clase asignada: " + claseAsignada + ", dinero: " + dinero + ", calificacion: " + calificacion;
	}
	

	
	
	

	

	


	

	
	
	
	
	
	

}
