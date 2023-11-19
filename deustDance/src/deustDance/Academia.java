package deustDance;

import java.util.ArrayList;
import java.util.List;

public class Academia {
	
	private static List<Baile> listaBailes = new ArrayList<Baile>();
	private static List<Alumno> listaAlumnos = new ArrayList<>();
	private static List<Profesor> listaProfesores = new ArrayList<>();
	private static List<Clase> listaClases = new ArrayList<>();
	private static List<Secretaria> listaSecretaria = new ArrayList<>();
	

	
	
	/*METODOS DE LA CLASE ACADEMIA*/
	
	
	/*METODO PARA AÑADIR ALUMNOS*/
	
	
	public void cargarAlumnoDeseBD() {
		
	}
	

	public static void anyadirAlumno(Alumno a) {
		listaAlumnos.add(a);
		
	}
	
	public static void anyadirProfesor(Profesor p) {
		listaProfesores.add(p);
		
	}
	
	public static void anyadirSecretario(Secretaria p) {
		listaSecretaria.add(p);
		
	}
	
	/*METODOS PARA BUSCAR ALUMNOS REPETIDOS*/
	
	public static Alumno buscarAlumno(String usuario) {
		
		boolean enc = false;
		Alumno a = null;
		int pos = 0;
		while(!enc && pos < listaAlumnos.size()) {
			a = listaAlumnos.get(pos);
			if(a.getUsuario().equals(usuario)) {
				enc = true;
			}else {
				pos++;
			}
		}
		if(enc) {
			return a;
		}else {
			return null;
		}
	}
	
	/*METODOS PARA BUSCAR PROFESORES REPETIDOS*/
	
	public static Profesor buscarProfesor(String usuario) {
		
		boolean enc = false;
		Profesor a = null;
		int pos = 0;
		while(!enc && pos < listaProfesores.size()) {
			a = listaProfesores.get(pos);
			if(a.getUsuario().equals(usuario)) {
				enc = true;
			}else {
				pos++;
			}
		}
		if(enc) {
			return a;
		}else {
			return null;
		}
	}
	
	
	/*METODOS PARA BUSCAR SECRETARIOS REPETIDOS*/
	
	public static Secretaria buscarSecretario(String usuario) {
		
		boolean enc = false;
		Secretaria a = null;
		int pos = 0;
		while(!enc && pos < listaSecretaria.size()) {
			a = listaSecretaria.get(pos);
			if(a.getUsuario().equals(usuario)) {
				enc = true;
			}else {
				pos++;
			}
		}
		if(enc) {
			return a;
		}else {
			return null;
		}
	}
	
	
	
	
	
	

}
