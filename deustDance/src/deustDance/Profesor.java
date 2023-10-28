package deustDance;


import java.util.Date;
import java.util.List;

public class Profesor extends Persona{
	private List<Alumno> listaAlumnos;
	private List<Baile> listaBailes;
	private List<Clase> listaClases;
	public Profesor(String nombre, String apellidos, int edad, String email, String dni, String contrasenia, Date fNac,
			String direccion, String codPostal, String telefono, String sexo, List<Alumno> listaAlumnos,
			List<Baile> listaBailes, List<Clase> listaClases) {
		super(nombre, apellidos, edad, email, dni, contrasenia, fNac, direccion, codPostal, telefono, sexo);
		this.listaAlumnos = listaAlumnos;
		this.listaBailes = listaBailes;
		this.listaClases = listaClases;
	}
	@Override
	public String toString() {
		return "Profesor [listaAlumnos=" + listaAlumnos + ", listaBailes=" + listaBailes + ", listaClases="
				+ listaClases + ", getNombre()=" + getNombre() + ", getSexo()=" + getSexo() + ", getApellidos()="
				+ getApellidos() + ", getEdad()=" + getEdad() + ", getDni()=" + getDni() + ", getfNac()=" + getfNac()
				+ ", StrFNac()=" + StrFNac() + ", getDireccion()=" + getDireccion() + ", getCodPostal()="
				+ getCodPostal() + ", getTelefono()=" + getTelefono() + ", getEmail()=" + getEmail()
				+ ", getContrasenia()=" + getContrasenia() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
	
	
}
