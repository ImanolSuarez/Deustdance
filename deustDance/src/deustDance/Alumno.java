package deustDance;


public class Alumno extends Persona{
	
	private Baile baileAsignado;
	private Profesor profesorAsignado;
	private Clase claseAsignada;
	private double dinero;
	private int grupo;
	private double calificacion;
	
	
	public Alumno(String nombre, String apellidos, String usuario, String contrasenia, int telefono, String domicilio,
			Baile baileAsignado, Profesor profesorAsignado, Clase claseAsignada, double dinero, int grupo,
			double calificacion) {
		super(nombre, apellidos, usuario, contrasenia, telefono, domicilio);
		this.baileAsignado = baileAsignado;
		this.profesorAsignado = profesorAsignado;
		this.claseAsignada = claseAsignada;
		this.dinero = dinero;
		this.grupo = grupo;
		this.calificacion = calificacion;
	}
	
	public Alumno() {
		super();
		this.baileAsignado = null;
		this.profesorAsignado = null;
		this.claseAsignada = null;
		this.dinero = 0;
		this.grupo = 0;
		this.calificacion = 0;
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

	public Clase getClaseAsignada() {
		return claseAsignada;
	}

	public void setClaseAsignada(Clase claseAsignada) {
		this.claseAsignada = claseAsignada;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return "Alumno [baileAsignado=" + baileAsignado + ", profesorAsignado=" + profesorAsignado + ", claseAsignada="
				+ claseAsignada + ", dinero=" + dinero + ", grupo=" + grupo + ", calificacion=" + calificacion
				+ ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos() + ", getUsuario()="
				+ getUsuario() + ", getContrasenia()=" + getContrasenia() + ", getTelefono()=" + getTelefono()
				+ ", getDomicilio()=" + getDomicilio() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}