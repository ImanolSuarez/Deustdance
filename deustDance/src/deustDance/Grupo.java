package deustDance;

import java.util.ArrayList;
import java.util.HashMap;

public class Grupo {
	protected int codigo;
	protected String nombre;
	protected Profesor profesor;
	
	protected ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	protected HashMap<Integer, Alumno> mapaAlumnos = new HashMap<Integer, Alumno>();
	
	public Grupo() {
		
	}

	public Grupo(int codigo, String nombre, Profesor profesor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.profesor = profesor;
	}
	
	public HashMap<Integer, Alumno> getMapaAlumnos(){
		return mapaAlumnos;
	}
	
	public void setMapaAlumnos(HashMap<Integer, Alumno> mapaAlumnos) {
		this.mapaAlumnos = mapaAlumnos;
	}
	
	public ArrayList<Alumno> getListaAlumnos(){
		return listaAlumnos;
	}
	
	public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	
	public Grupo(String nombre, Profesor profesor) {
		this.codigo = 0;
		this.nombre = nombre;
		this.profesor = profesor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	@Override
	public String toString() {
		return codigo + " " + nombre + "";
	}
	
}
