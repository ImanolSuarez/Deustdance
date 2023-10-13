package deustDance;

import java.util.ArrayList;
import java.util.Date;

public class Profesor extends Persona{
	
	private ArrayList<Alumno> listaAlumnos;
	private ArrayList<Baile> listaBailes;
	private ArrayList<Clase> listaClases;
	
	public Profesor(String nombre, String apellidos, int edad, String dni, Date fNac, String direccion,
			String codPostal, String telefono, ArrayList<Alumno> listaAlumnos, ArrayList<Baile> listaBailes,
			ArrayList<Clase> listaClases) {
		super(nombre, apellidos, edad, dni, fNac, direccion, codPostal, telefono);
		this.listaAlumnos = listaAlumnos;
		this.listaBailes = listaBailes;
		this.listaClases = listaClases;
	}

	public Profesor(String nombre, String apellidos, int edad, String dni, Date fNac, String direccion,
			String codPostal, String telefono) {
		super(nombre, apellidos, edad, dni, fNac, direccion, codPostal, telefono);
	
	}

	public ArrayList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	public ArrayList<Baile> getListaBailes() {
		return listaBailes;
	}

	public void setListaBailes(ArrayList<Baile> listaBailes) {
		this.listaBailes = listaBailes;
	}

	public ArrayList<Clase> getListaClases() {
		return listaClases;
	}

	public void setListaClases(ArrayList<Clase> listaClases) {
		this.listaClases = listaClases;
	}

	@Override
	public String toString() {
		return "Nombre del profesor: " + getNombre() + ", apellidos: " + getApellidos() + ", edad: "
				+ getEdad() + ", dni: " + getDni() + ", fecha de nacimiento: " + getfNac() + ", lista de alumnos=" + listaAlumnos
				+ ", lista de bailes=" + listaBailes + ", lista de clases=" + listaClases;
	}
	
	
	
	
	
	
	

}
