package deustDance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
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
	
	public static void ver() {
		for(Alumno a : listaAlumnos) {
			System.out.println(a);
		}
	}
	
	
	public static void cargarProfesoresDesdeBD(Connection conn) {
		listaProfesores = BaseDatos.volcadoProfesorsaLista(conn);
	}
	
	public static void cargarSecretariaDesdeBD(Connection conn) {
		listaSecretaria = BaseDatos.volcadoSecretariosaLista(conn);
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void cargarDatosProfesor(Connection con, String file) {
		
		List<Alumno> listaAlumnos = new ArrayList<>();
		List<Baile> listaBaile = new ArrayList<>();
		List<Clase> listaClase = new ArrayList<>();
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
				listaClase = BaseDatos.obtenerClaseProfesor(con, id);
				Profesor p = new Profesor(id, nombre, apellido, usuario, contra, tf, domicilio, listaAlumnos, grupo, listaBaile, listaClase);
				BaseDatos.insertarProfesorBD(con, p);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void guardarDatosProfesor(String file) {
		try {
			PrintWriter pw = new PrintWriter(file);
			for(Profesor p : listaProfesores) {
				pw.write(p.getNombre()+";"+p.getApellidos()+"\n");
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
				int idPr = Integer.parseInt(datos[0]);
				String descr = datos[1];
				String tipoBaile = datos[2];
				double precio = Double.parseDouble(datos[3]);
				int horas = Integer.parseInt(datos[4]);
				Baile b = new Baile(idPr, descr, tipoBaile, precio, horas);
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
