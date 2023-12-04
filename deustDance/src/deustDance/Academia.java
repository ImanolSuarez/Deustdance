package deustDance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Academia {
	
	private static List<Baile> listaBailes = new ArrayList<Baile>();
	private static List<Alumno> listaAlumnos = new ArrayList<>();
	private static List<Profesor> listaProfesores = new ArrayList<>();
	private static List<Clase> listaClases = new ArrayList<>();
	private static List<Secretaria> listaSecretaria = new ArrayList<>();
	

	
	
	/*METODOS DE LA CLASE ACADEMIA*/
	
	
	/*METODO PARA AÑADIR ALUMNOS*/
	
	
	public static void cargarAlumnoDesdeBD(Connection conn) {
		listaAlumnos = BaseDatos.volcadoAlumnosaLista(conn);
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
	
	/*Metodo para cargar los datos de prueba de Alumnos en la BD*/
	
	public static void cargarDatosAlumno(Connection con,String nomFich) {
		
		try {
			Scanner sc = new Scanner(new FileReader(nomFich));
			String titulos = sc.nextLine();
			String linea;
			while(sc.hasNext()) {
				linea = sc.nextLine();
				String[] datos = linea.split(";");
				int id = Integer.parseInt(datos[0]);
				String nombre = datos[1];
				String apellido = datos[2];
				String usuario = datos[3];
				String contra = datos[4];
				int tel = Integer.parseInt(datos[5]);
				String domicilio = datos[6];
				String baile = datos[7];
				int profesor = Integer.parseInt(datos[8]);
				int clase = Integer.parseInt(datos[9]);
				Double dinero = Double.parseDouble(datos[10]);
				int grupo = Integer.parseInt(datos[11]);
				double calificacion = Double.parseDouble(datos[12]);
				Alumno a = new Alumno(id, nombre, apellido, usuario, contra, tel, domicilio, baile, profesor, clase, dinero, grupo, calificacion);
				BaseDatos.insertarAlumnoBD(con, a);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void cargarDatosProfesor(Connection con, String file) {
		
		List<Alumno> listaAlumnos = new ArrayList<>();
		List<Baile> listaBaile = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new FileReader(file));
			String titulos = sc.nextLine();
			String linea;
			while(sc.hasNext()) {
				linea = sc.nextLine();
				String datos[] = linea.split(";");
				int id = Integer.parseInt(datos[0]);
				String nombre = datos[1];
				String apellido =  datos[2];
				String usuario = datos[3];
				String contra = datos[4];
				int tf = Integer.parseInt(datos[5]);
				String domicilio = datos[6];
				int grupo = Integer.parseInt(datos[7]);
				
				listaAlumnos = BaseDatos.obtenerAlumnosProfesor(con, id);
				listaBaile = BaseDatos.obtenerBaileProfesor(con, id);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
