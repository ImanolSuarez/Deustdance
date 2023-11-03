package deustDance;

public class Secretaria extends Persona{

	public Secretaria(String nombre, String apellidos, String usuario, String contrasenia) {
		super(nombre, apellidos, usuario, contrasenia);
		
	}

	@Override
	public String toString() {
		return "Nombre de la secretaria: " + getNombre() + ", apellidos: " + getApellidos() + ", usuario: "
				+ getUsuario() + ", contraseña " + getContrasenia() ;
	}
	
	

	

	
	
	
	
	

}
