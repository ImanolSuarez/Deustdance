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
				String nombre = datos[0];
				String apellido = datos[1];
				String usuario = datos[2];
				String contra = datos[3];
				int tel = Integer.parseInt(datos[4]);
				String domicilio = datos[5];
				//Baile baile = datos[6];
				//Profesor profesor = datos[7];
				//Clase clase = datos[8];
				Double dinero = Double.parseDouble(datos[9]);
				int grupo = Integer.parseInt(datos[10]);
				double calificacion = Double.parseDouble(datos[11]);
				Alumno a = new Alumno(nombre, apellido, usuario, contra, tel, domicilio, null, null, null, tel, grupo, calificacion);
				BaseDatos.insertarPersonaBD(con, a);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
