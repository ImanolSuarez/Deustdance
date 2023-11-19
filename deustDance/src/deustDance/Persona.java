package deustDance;




public class Persona {
	
	/*COMPONENTES DE LA CLASE PERSONA*/
	
	private String nombre;
	private String apellidos;
	private String usuario;
	private String contrasenia;
	private int telefono;
	private String domicilio;

	
	/*CONSTRUCTOR DE LA CLASE*/
		public Persona(String nombre, String apellidos, String usuario, String contrasenia, int telefono,
			String domicilio) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.telefono = telefono;
		this.domicilio = domicilio;
	}
		
		public Persona() {
			super();
			this.nombre = "";
			this.apellidos = "";
			this.usuario = "";
			this.contrasenia = "";
			this.telefono = 0;
			this.domicilio = "";
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

		public int getTelefono() {
			return telefono;
		}

		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}

		public String getDomicilio() {
			return domicilio;
		}

		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
		}

		@Override
		public String toString() {
			return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario + ", contrasenia="
					+ contrasenia + ", telefono=" + telefono + ", domicilio=" + domicilio + "]";
		}

}
