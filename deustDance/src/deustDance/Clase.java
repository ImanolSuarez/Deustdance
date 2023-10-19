package deustDance;


import java.util.List;

public class Clase {
	
	private static int contador = 0;
	private String nombre;
	private List<Profesor> listaProfesores;
	private List<Alumno> listaAlumnos;
	
	public Clase(String nombre, List<Profesor> listaProfesores, List<Alumno> listaAlumnos) {
		super();
		this.contador = contador;
		contador++;
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

	public List<Profesor> getListaProfesores() {
		return listaProfesores;
	}

	public void setListaProfesores(List<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	@Override
	public String toString() {
		return "Nombre de la clase: " + nombre + ", lista de profesores: " + listaProfesores + ", lista de alumnos=" + listaAlumnos;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
