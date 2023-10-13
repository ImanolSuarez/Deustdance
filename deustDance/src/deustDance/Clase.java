package deustDance;

import java.util.ArrayList;

public class Clase {
	
	
	private String nombre;
	private ArrayList<Profesor> listaProfesores;
	private ArrayList<Alumno> listaAlumnos;
	
	public Clase( String nombre, ArrayList<Profesor> listaProfesores, ArrayList<Alumno> listaAlumnos) {
		super();
		
		this.nombre = nombre;
		this.listaProfesores = listaProfesores;
		this.listaAlumnos = listaAlumnos;
	}

	public Clase() {
		super();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Profesor> getListaProfesores() {
		return listaProfesores;
	}

	public void setListaProfesores(ArrayList<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

	public ArrayList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	@Override
	public String toString() {
		return "Nombre de la clase: " + nombre + ", lista de profesores: " + listaProfesores + ", lista de alumnos=" + listaAlumnos;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
