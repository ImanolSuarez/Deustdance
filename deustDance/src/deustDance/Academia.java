package deustDance;
import java.util.Map.Entry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class Academia {
	
	static Connection con = BaseDatos.initBD("DeustDance.db");
	private static List<Baile> listaBailes = new ArrayList<Baile>();
	private static List<Alumno> listaAlumnos = new ArrayList<>();
	private static List<Profesor> listaProfesores = new ArrayList<>();
	private static List<Clase> listaClases = new ArrayList<>();
	private static List<Secretaria> listaSecretaria = new ArrayList<>();
	
	
	private static Map<Integer, List<Alumno>> mapaProfesorAlumno = new HashMap<>();
	private static Map<Integer, List<Alumno>> mapaBaileAlumno = new HashMap<>();
	
	
	
	
	/*METODOS DE LA CLASE ACADEMIA*/
	
	public static Map<Integer, List<Alumno>> getMapaProfesorAlumno() {
		return mapaProfesorAlumno;
	}
	
	
	/*METODO PARA AÑADIR ALUMNOS*/
	
	
	public static void cargarAlumnoDesdeBD(Connection conn) {
		listaAlumnos = BaseDatos.volcadoAlumnosaLista(conn);
	}
	
	public static void ver() {
	    System.out.println("Iniciando el método ver()");
	    
	    for (int id : mapaProfesorAlumno.keySet()) {
	        System.out.println("Profesor ID: " + id);
	        
	        List<Alumno> listaAlumno = mapaProfesorAlumno.get(id);
	        
	        for (Alumno a : listaAlumno) {
	            System.out.println("   Alumno: " + a);
	        }
	    }

	    System.out.println("Finalizando el método ver()");
	}
	
	
	public static void cargarProfesoresDesdeBD(Connection conn) {
		listaProfesores = BaseDatos.volcadoProfesorsaLista(conn);
	}
	
	public static void cargarSecretariaDesdeBD(Connection conn) {
		listaSecretaria = BaseDatos.volcadoSecretariosaLista(conn);
	}
	
	public static void borrarTodosLosAlumnos() {
		listaAlumnos.clear();
	}
	
	public static void borrarTodosLosProfesores() {
		listaProfesores.clear();
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
	
	/*CARGAR EL MAPA 1*/
	
	public static Map<Integer, List<Alumno>> cargarMapa() {
	    Map<Integer, List<Alumno>> mapa = new HashMap<>();
	    List<Alumno> listaAlum = BaseDatos.obtenerAlumnos(con); // Asegúrate de tener la conexión (con) disponible
	    System.out.println(listaAlum.size());
	    for (Alumno a : listaAlum) {
	        if (!mapa.containsKey(a.getId_profesorAsignado())) {
	            mapa.put(a.getId_profesorAsignado(), new ArrayList<>());
	        }
	        mapa.get(a.getId_profesorAsignado()).add(a);
	        
	    }
	    
	    for(Entry<Integer, List<Alumno>> e : mapa.entrySet()) {
	    	System.out.println(e.getKey());
	    }
	    return mapa;
	}
	
	/*CARGAR MAPA 2*/
	
	public static Map<Integer, List<Alumno>> cargarMapaTipoAlumno(){
		
		Map<Integer, List<Alumno>> mapa = new HashMap<>();
		List<Alumno> listaAlum = BaseDatos.obtenerAlumnos(con);
		for(Alumno a : listaAlum) {
			if(!mapa.containsKey(a.getBaileAsignado())) {
				mapa.put(a.getBaileAsignado(), new ArrayList<>());
			}
			mapa.get(a.getBaileAsignado()).add(a);
		}
		
		
		return mapa;
	}
	
	/*CARGAR MAPA 3*/
	
	public static Map<Integer, List<Profesor>> cargarMapaTipoProfesor(){
		Map<Integer, List<Profesor>> mapa = new HashMap<>();
		List<Baile> listaBile = BaseDatos.obtenerTodosBailes(con);
		for(Baile b : listaBile) {
			if(!mapa.containsKey(b.getIdBaile())) {
				mapa.put(b.getIdBaile(), new ArrayList<>());
			}
			Profesor p = BaseDatos.obtenerProfesorId(con, b.getIdProfesor());
			mapa.get(b.getIdBaile()).add(p);
		}
		return mapa;
	}
	
	
	/*OBTENER LA LISTA DE ALUMNOS*/
	
	public static List<Alumno> obtenerListaAlumno(int id){
		List<Alumno> l = new ArrayList<>();
		for(Alumno a : mapaProfesorAlumno.get(id)) {
			l.add(a);
		}
		return l;
	}
	
	/*METODOS PARA BUSCAR ALUMNOS REPETIDOS*/
	
	public static boolean contieneAlumno(Alumno alumnoBuscar) {
	    for (Alumno a : listaAlumnos) {
	        if (a.getUsuario().equals(alumnoBuscar.getUsuario())) {
	            return true; // El alumno ya está en la lista
	        }
	    }
	    return false; // El alumno no está en la lista
	}
	
	public static boolean contieneProfesor(Profesor profesorBuscar) {
	    for (Profesor a : listaProfesores) {
	        if (a.getUsuario().equals(profesorBuscar.getUsuario())) {
	            return true; // El alumno ya está en la lista
	        }
	    }
	    return false; // El alumno no está en la lista
	}
	
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
				int baile = Integer.parseInt(datos[6]);
				int profesor = Integer.parseInt(datos[7]);
				int clase = Integer.parseInt(datos[8]);
				Double dinero = Double.parseDouble(datos[9]);
				int grupo = Integer.parseInt(datos[10]);
				double calificacion = Double.parseDouble(datos[11]);
				Alumno a = new Alumno(nombre, apellido, usuario, contra, tel, domicilio, baile, profesor, clase, dinero, grupo, calificacion);
				BaseDatos.insertarAlumnoBD(con, a);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void guardarDatosAlumno(String file) {

		try {
			PrintWriter pw = new PrintWriter(file);
			for(Alumno a : listaAlumnos) {
				pw.write(a.getNombre()+";"+a.getApellidos()+";"+a.getUsuario()+";"+a.getContrasenia()+";"+a.getTelefono()+";"+a.getDomicilio()+";"+a.getBaileAsignado()
							+";"+a.getProfesorAsignado()+";"+a.getId_claseAsignada()+";"+a.getDinero()+";"+a.getGrupo()+";"+a.getCalificacion()+"\n");
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void guardarDatosProfesor(String file) {

		try {
			PrintWriter pw = new PrintWriter(file);
			for(Profesor a : listaProfesores) {
				pw.write(a.getNombre()+";"+a.getApellidos()+";"+a.getUsuario()+";"+a.getContrasenia()+";"+a.getTelefono()
				+";"+a.getDomicilio()+";"+a.getGrupo()+"\n");
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void cargarDatosProfesor(Connection con, String file) {
		
		List<Alumno> listaAlumnos = new ArrayList<>();
		List<Baile> listaBaile = new ArrayList<>();
		List<Clase> listaClase = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new FileReader(file));
			String linea;
			while(sc.hasNext()) {
				linea = sc.nextLine();
				String datos[] = linea.split(";");
				String nombre = datos[0];
				String apellido =  datos[1];
				String usuario = datos[2];
				String contra = datos[3];
				int tf = Integer.parseInt(datos[4]);
				String domicilio = datos[5];
				int grupo = Integer.parseInt(datos[6]);
				listaAlumnos = BaseDatos.obtenerAlumnosProfesor(con);
				listaBaile = BaseDatos.obtenerBaileProfesor(con);
				listaClase = BaseDatos.obtenerClaseProfesor(con);
				Profesor p = new Profesor(nombre, apellido, usuario, contra, tf, domicilio, listaAlumnos, grupo, listaBaile, listaClase);
				BaseDatos.insertarProfesorBD(con, p);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	
	public static void cargarDatosSecretaria(Connection con, String file) {
		
		try {
			Scanner sc = new Scanner(new FileReader(file));
			String titulo = sc.nextLine();
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String[] datos = linea.split(";");
				String nombre = datos[0];
				String apellido =  datos[1];
				String usuario = datos[2];
				String contra = datos[3];
				int tf = Integer.parseInt(datos[4]);
				String domicilio = datos[5];
				Secretaria s = new Secretaria(nombre, apellido, usuario, contra, tf, domicilio);
				BaseDatos.insertarSecretariaBD(con, s);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void cargarDatosBaile(Connection con, String file) {
		
		try {
			Scanner sc = new Scanner(new FileReader(file));
			String titulo = sc.nextLine();
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String[] datos = linea.split(";");
				int id = Integer.parseInt(datos[0]);
				int idPr = Integer.parseInt(datos[1]);
				String descr = datos[2];
				String tipoBaile = datos[3];
				double precio = Double.parseDouble(datos[4]);
				int horas = Integer.parseInt(datos[5]);
				Baile b = new Baile(id, idPr, descr, tipoBaile, precio, horas);
				BaseDatos.insertarBaileBD(con, b);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void cargarDatosClase(Connection conn, String file) {
		
		try {
			Scanner sc = new Scanner(new FileReader(file));
			String titulo = sc.nextLine();
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String[] datos = linea.split(";");
				String nombre = datos[0];
				int idProf = Integer.parseInt(datos[1]);
				Clase c = new Clase(nombre, idProf);
				BaseDatos.insertarClaseBD(conn, c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
