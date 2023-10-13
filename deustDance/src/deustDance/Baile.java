package deustDance;

import java.util.ArrayList;

public class Baile {
	
	private String descripcion;
	private Tipo tipoBaile;
	private double precio;
	private int horasDeClase;
	private Profesor profesorAsignado;
	private ArrayList<Alumno> listaAlumnos;
	private Clase claseAsignada;
	
	public Baile(String descripcion, Tipo tipoBaile, double precio, int horasDeClase, Profesor profesorAsignado,
			ArrayList<Alumno> listaAlumnos, Clase claseAsignada) {
		super();
		this.descripcion = descripcion;
		this.tipoBaile = tipoBaile;
		this.precio = precio;
		this.horasDeClase = horasDeClase;
		this.profesorAsignado = profesorAsignado;
		this.listaAlumnos = listaAlumnos;
		this.claseAsignada = claseAsignada;
	}

	public Baile() {
		super();
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Tipo getTipoBaile() {
		return tipoBaile;
	}

	public void setTipoBaile(Tipo tipoBaile) {
		this.tipoBaile = tipoBaile;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getHorasDeClase() {
		return horasDeClase;
	}

	public void setHorasDeClase(int horasDeClase) {
		this.horasDeClase = horasDeClase;
	}

	public Profesor getProfesorAsignado() {
		return profesorAsignado;
	}

	public void setProfesorAsignado(Profesor profesorAsignado) {
		this.profesorAsignado = profesorAsignado;
	}

	public ArrayList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	public Clase getClaseAsignada() {
		return claseAsignada;
	}

	public void setClaseAsignada(Clase claseAsignada) {
		this.claseAsignada = claseAsignada;
	}

	@Override
	public String toString() {
		return "Tipo de baile: "+ tipoBaile + "descripcion: " + descripcion + ", precio: " + precio + "€"
				+ ", horas de clase: " + horasDeClase + ", profesor asignado: " + profesorAsignado + ", lista de alumnos: "
				+ listaAlumnos + ", clase asignada=" + claseAsignada;
	}

	
	
	
	
	
	

}
