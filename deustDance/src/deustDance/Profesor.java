package deustDance;



import java.util.List;

public class Profesor extends Persona{
	
	private int id;
	private List<Alumno> listaAlumnos;
	private int grupo;
	private List<Baile> listaBailes;
	private List<Clase> listaClases;
	
	public Profesor(int id,String nombre, String apellidos, String usuario, String contrasenia, int telefono, String domicilio,
			List<Alumno> listaAlumnos, int grupo, List<Baile> listaBailes, List<Clase> listaClases) {
		super(nombre, apellidos, usuario, contrasenia, telefono, domicilio);
		this.id = id;
		this.listaAlumnos = listaAlumnos;
		this.grupo = grupo;
		this.listaBailes = listaBailes;
		this.listaClases = listaClases;
	}
	
	public Profesor(String nom, String app, String usu, String con, int tel, String dom, int grup) {
		super();
	}
	
	public Profesor() {
		super();
		this.id = 1;
		this.listaAlumnos = null;
		this.grupo = 0;
		this.listaBailes = null;
		this.listaClases = null;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public List<Baile> getListaBailes() {
		return listaBailes;
	}

	public void setListaBailes(List<Baile> listaBailes) {
		this.listaBailes = listaBailes;
	}

	public List<Clase> getListaClases() {
		return listaClases;
	}

	public void setListaClases(List<Clase> listaClases) {
		this.listaClases = listaClases;
	}

	@Override
	public String toString() {
		return "Profesor [listaAlumnos=" + listaAlumnos + ", grupo=" + grupo + ", listaBailes=" + listaBailes
				+ ", listaClases=" + listaClases + ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getUsuario()=" + getUsuario() + ", getContrasenia()=" + getContrasenia() + ", getTelefono()="
				+ getTelefono() + ", getDomicilio()=" + getDomicilio()+ "]";
	}
		

}
