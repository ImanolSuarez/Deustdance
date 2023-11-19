package deustDance;




public class Persona {
	
	/*COMPONENTES DE LA CLASE PERSONA*/
	
	private String nombre;
	private String apellidos;
	private String usuario;
	private String contrasenia;
	
	/*CONSTRUCTOR DE LA CLASE*/
	
	public Persona(String nombre, String apellidos,  String usuario, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	
	public Persona() {
		super();
		this.nombre = "";
		this.apellidos = "";
		this.usuario = "";
		this.contrasenia = "";
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
		return "nombre: " + nombre + ", apellidos: " + apellidos  + ", usuario: " + usuario
				+ ", contrasenia: " + contrasenia;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
