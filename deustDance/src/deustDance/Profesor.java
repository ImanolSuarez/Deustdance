package deustDance;


import java.util.Date;
import java.util.List;

public class Profesor extends Persona{
	
	private List<Alumno> listaAlumnos;
	private List<Baile> listaBailes;
	private List<Clase> listaClases;
	
	public Profesor(String nombre, String apellidos, int edad, String dni, Date fNac, String direccion,
			String codPostal, String telefono, List<Alumno> listaAlumnos, List<Baile> listaBailes,
			List<Clase> listaClases) {
		super(nombre, apellidos, edad, dni, fNac, direccion, codPostal, telefono);
		this.listaAlumnos = listaAlumnos;
		this.listaBailes = listaBailes;
		this.listaClases = listaClases;
	}

	public Profesor(String nombre, String apellidos, int edad, String dni, Date fNac, String direccion,
			String codPostal, String telefono) {
		super(nombre, apellidos, edad, dni, fNac, direccion, codPostal, telefono);
	
	}

	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	public List<Baile> getListaBailes() {
		return listaBailes;
	}

	public void setListaBailes(List<Baile> listaBailes) {
		this.listaBailes = listaBailes;
	}

	public List<Clase> getListaClases() {
		return listaClases;
	}

	public void setListaClases(List<Clase> listaClases) {
		this.listaClases = listaClases;
	}

	@Override
	public String toString() {
		return "Nombre del profesor: " + getNombre() + ", apellidos: " + getApellidos() + ", edad: "
				+ getEdad() + ", dni: " + getDni() + ", fecha de nacimiento: " + getfNac() + ", lista de alumnos=" + listaAlumnos
				+ ", lista de bailes=" + listaBailes + ", lista de clases=" + listaClases;
	}
	
	
	
	
	
	
	

}
