package deustDance;


public class Alumno extends Persona{
	
	private Baile baileAsignado;
	private Profesor profesorAsignado;
	private Clase claseAsignada;
	private double dinero;
	private int grupo;
	private double calificacion;
	
	public Alumno(String nombre, String apellidos, String usuario, String contrasenia, Baile baileAsignado,
			Profesor profesorAsignado, Clase claseAsignada, double dinero, int grupo, double calificacion) {
		super(nombre, apellidos, usuario, contrasenia);
		this.baileAsignado = baileAsignado;
		this.profesorAsignado = profesorAsignado;
		this.claseAsignada = claseAsignada;
		this.dinero = dinero;
		this.grupo = grupo;
		this.calificacion = calificacion;
	}
	
	
	public Alumno(String nombre, String apellidos, String usuario, String contrasenia, double calificacion) {
		super(nombre, apellidos, usuario, contrasenia);
		this.calificacion = calificacion;
		
	}


	public int getGrupo() {
		return grupo;
	}



	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}



	public Baile getBaileAsignado() {
		return baileAsignado;
	}

	public void setBaileAsignado(Baile baileAsignado) {
		this.baileAsignado = baileAsignado;
	}

	public Profesor getProfesorAsignado() {
		return profesorAsignado;
	}

	public void setProfesorAsignado(Profesor profesorAsignado) {
		this.profesorAsignado = profesorAsignado;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	
	public Clase getClaseAsignada() {
		return claseAsignada;
	}

	public void setClaseAsignada(Clase claseAsignada) {
		this.claseAsignada = claseAsignada;
	}
	
	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
	    return "Nombre del alumno: " + getNombre() + ", apellidos: " + getApellidos() + ", baile asignado: " + baileAsignado + ", profesor asignado: " + profesorAsignado
	            + ", clase asignada: " + claseAsignada + ", dinero: " + dinero + ", grupo: " + getGrupo() + ", calificacion: " + calificacion 
	            + ", usuario: " + getUsuario() + ", contraseña: " + getContrasenia();
	}
	

	
	
	

	

	


	

	
	
	
	
	
	

}
