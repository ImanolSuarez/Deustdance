package deustDance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
	
	/*COMPONENTES DE LA CLASE PERSONA*/
	
	private String nombre;
	private String apellidos;
	private int grupo;
	private String usuario;
	private String contrasenia;
	
	/*CONSTRUCTOR DE LA CLASE*/
	
	public Persona(String nombre, String apellidos, int grupo, String usuario, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.grupo = grupo;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public Persona() {
		super();
		
	}

	public String getNombre() {
		return nombre;
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

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", grupo=" + grupo + ", usuario=" + usuario
				+ ", contrasenia=" + contrasenia + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
