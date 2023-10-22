package deustDance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona implements Comparable<Persona>{
	
	/*COMPONENTES DE LA CLASE PERSONA*/
	
	private String nombre;
	private String apellidos;
	private Sexo sexo;
	private int edad;
	private String email;
	private String contrasenia;
	private String dni;
	private Date fNac;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private String direccion;
	private String codPostal;
	private String telefono;
	
	/*CONSTRUCTOR DE LA CLASE*/
	
	public Persona(String nombre, String apellidos, int edad, String email,  String dni, String contrasenia, Date fNac, String direccion,
			String codPostal, String telefono, Sexo sexo) {
		super();
		this.sexo = sexo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.email = email;
		this.contrasenia = contrasenia;
		this.dni = dni;
		this.fNac = fNac;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.telefono = telefono;
	}
	
	public Persona(String nombre, String apellidos, int edad,  String email, String contrasenia,  String dni, String fNac, String direccion,
			String codPostal, String telefono, Sexo sexo) {
		super();
		this.sexo = sexo;
		this.nombre = nombre;
		this.email = email;
		this.contrasenia = contrasenia;
		this.apellidos = apellidos;
		this.edad = edad;
		this.dni = dni;
		try {
			this.fNac = sdf.parse(fNac);
		} catch (ParseException e) {
			System.out.println("Fecha erronea");
		}
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.telefono = telefono;
	}
	
	/*GETTERS Y SETTERS DE LA CLASE*/

	
	
	
	public String getNombre() {
		return nombre;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getfNac() {
		return fNac;
	}

	public void setfNac(Date fNac) {
		this.fNac = fNac;
	}
	
	public String StrFNac() {
		return sdf.format(fNac);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", apellidos: " + apellidos + ", edad: " + edad + ", dni: " + dni + ", fecha de nacimiento: "
				+ sdf.format(fNac) + ", direccion: " + direccion + ", codigo postal: " + codPostal + ", telefono: " + telefono;
	}

	@Override
	public int compareTo(Persona o) {
		return dni.compareTo(o.dni);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
