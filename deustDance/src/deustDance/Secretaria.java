package deustDance;

public class Secretaria extends Persona{

	public Secretaria(String nombre, String apellidos, String usuario, String contrasenia, int telefono, String domicilio) {
	    super(nombre, apellidos, usuario, contrasenia, telefono, domicilio);
	}


	@Override
	public String toString() {
		return "Nombre de la secretaria: " + getNombre() + ", apellidos: " + getApellidos() + ", usuario: "
				+ getUsuario() + ", contraseña: " + getContrasenia() +  ", telefono: " + getTelefono() + ", domicilio: " + getDomicilio();
	}
	
	

	

	
	
	
	
	

}
