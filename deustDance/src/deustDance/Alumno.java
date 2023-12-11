package deustDance;


public class Alumno extends Persona{
	
	private int id;
	private int baileAsignado;
	private int id_profesorAsignado;
	private int id_claseAsignada;
	private double dinero;
	private int grupo;
	private double calificacion;
	
	
	public Alumno(int id,String nombre, String apellidos, String usuario, String contrasenia, int telefono, String domicilio,
			int baileAsignado, int id_profesorAsignado, int id_claseAsignada, double dinero, int grupo,
			double calificacion) {
		super(nombre, apellidos, usuario, contrasenia, telefono, domicilio);
		this.id = id;
		this.baileAsignado = baileAsignado;
		this.id_profesorAsignado = id_profesorAsignado;
		this.id_claseAsignada = id_claseAsignada;
		this.dinero = dinero;
		this.grupo = grupo;
		this.calificacion = calificacion;
	}
	
	public Alumno() {
		super();
		this.id = 1;
		this.baileAsignado = 0;
		this.id_profesorAsignado = 1;
		this.id_claseAsignada = 1;
		this.dinero = 0;
		this.grupo = 0;
		this.calificacion = 0;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_profesorAsignado() {
		return id_profesorAsignado;
	}

	public void setId_profesorAsignado(int id_profesorAsignado) {
		this.id_profesorAsignado = id_profesorAsignado;
	}

	public int getId_claseAsignada() {
		return id_claseAsignada;
	}

	public void setId_claseAsignada(int id_claseAsignada) {
		this.id_claseAsignada = id_claseAsignada;
	}

	public int getBaileAsignado() {
		return baileAsignado;
	}

	public void setBaileAsignado(int baileAsignado) {
		this.baileAsignado = baileAsignado;
	}

	public int getProfesorAsignado() {
		return id_profesorAsignado;
	}

	public void setProfesorAsignado(int id_profesorAsignado) {
		this.id_profesorAsignado = id_profesorAsignado;
	}

	public int getClaseAsignada() {
		return id_claseAsignada;
	}

	public void setClaseAsignada(int id_claseAsignada) {
		this.id_claseAsignada = id_claseAsignada;
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
		return "Alumno [baileAsignado=" + baileAsignado + ", profesorAsignado=" + id_profesorAsignado + ", claseAsignada="
				+ id_claseAsignada + ", dinero=" + dinero + ", grupo=" + grupo + ", calificacion=" + calificacion
				+ ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos() + ", getUsuario()="
				+ getUsuario() + ", getContrasenia()=" + getContrasenia() + ", getTelefono()=" + getTelefono()
				+ ", getDomicilio()=" + getDomicilio() + "]";
	}
	
	
}