package deustDance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseDatos {
	
	/*METODO QUE REALIZA LA CONEXION A LA BASE DE DATOS*/
	
	public static Connection initBD(String nombreBD) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/*METODO QUE REALIZA EL CRIERRE DE LA BASE DE DATOS*/
	
	public static void closeBD(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*CEACION DE TABLAS TABLAS*/
	
	/*Añadir alumnos*/
	public static void crearTabla(Connection con) {
		String drop = "DROP TABLE IF EXISTS Alumno";
		String sql = "CREATE TABLE IF NOT EXISTS Alumno(id Integer, nombre String, apellido String, usuario String, contraseña String, telefono int, domicilio String, idBaile Integer, idProfesorAlumno Integer, idClase Integer, dinero double, grupo int, calificacion double)";
		String drop4 = "DROP TABLE IF EXISTS Profesor";
		String sq2 = "CREATE TABLE IF NOT EXISTS Profesor(id Integer, nombre String, apellido String, usuario String, contraseña String, telefono int, domicilio String, grupo Integer)";
		String drop2 = "DROP TABLE IF EXISTS Baile";
		String sq3 = "CREATE TABLE IF NOT EXISTS Baile(id Integer, idProfesorBaile Integer, descripcion String, tipo String, precio Double, horas int)";
		String sq4 = "CREATE TABLE IF NOT EXISTS BaileProfesor(idProfesor Integer, idBaile Integer)";
		String sq5 = "CREATE TABLE IF NOT EXISTS AlumnoProfesor(idProfesor Integer, idAlumno Integer)";
		String drop3 = "DROP TABLE IF EXISTS Clase";
		String sq6 = "CREATE TABLE IF NOT EXISTS Clase(id Integer, nombre String, idProfesorClase Integer)";
		String sq7 = "CREATE TABLE IF NOT EXISTS ClaseProfesor(idProfesor Integer, idClase Integer)";
		String drop5 = "DROP TABLE IF EXISTS Secretaria";
		String sq8 = "CREATE TABLE IF NOT EXISTS Secretaria(nombre String, apellido String, usuario String, contraseña String, telefono int, domicilio String)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(drop);
			st.executeUpdate(sql);
			st.executeUpdate(drop4);
			st.executeUpdate(sq2);
			st.executeUpdate(drop2);
			st.executeUpdate(sq3);
			st.executeUpdate(sq4);
			st.executeUpdate(sq5);
			st.executeUpdate(drop3);
			st.executeUpdate(sq6);
			st.executeUpdate(sq7);
			st.executeUpdate(drop5);
			st.executeUpdate(sq8);
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();	
		}
	}
	/*Seleccionar todos los alumnos a los que les da clase el profesor 1*/
	public static List<Alumno> obtenerAlumnosProfesor(Connection con, int idProfesor){
		String sql = "SELECT * FROM Alumno AL, alumnoprofesor AP WHERE AL.idProfesorAlumno=AP.idProfesor AND idProfesor= '"+idProfesor+"'";
		List<Alumno> l = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String usuario = rs.getString("usuario");
				String contra = rs.getString("contraseña");
				int tf = rs.getInt("telefono");
				String domicilio = rs.getString("domicilio");
				int idBaile = rs.getInt("idBaile");
				int id_Profesor = rs.getInt("idProfesor");
				int idClase = rs.getInt("idClase");
				double dinero = rs.getDouble("dinero");
				int grupo = rs.getInt("grupo");
				double calificacion = rs.getDouble("calificacion");
				Alumno a = new Alumno(id, nombre, apellido, usuario, contra, tf, domicilio, idBaile, id_Profesor, idClase, dinero, grupo, calificacion);
				l.add(a);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;		
	}
	/*listado de Bailes que que da un determinado profesor*/
	
	public static List<Baile> obtenerBaileProfesor(Connection con, int idProfesor){
		List<Baile> l = new ArrayList<>();
		String sql = "SELECT * FROM Baile BA, BaileProfesor BP WHERE BA.idProfesorBaile = BP.idProfesor AND idProfesor =" + idProfesor; //"SELECT BA FROM Baile BA, PROFESOR PR WHERE BA.idProfesor = PR.idProfesor AND idPofesor ="
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				int id_Profesor = rs.getInt("idProfesorBaile");
				String descripcion = rs.getString("descripcion");
				String tipo = rs.getString("tipo");
				Double precio = rs.getDouble("precio");
				int horas = rs.getInt("horas");
				Baile b = new Baile(id, id_Profesor, descripcion, tipo, precio, horas);
				l.add(b);
			}
			rs.close();
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	/*Listado de todas las clases que da un profesor*/
	
	public static List<Clase> obtenerClaseProfesor(Connection con, int idProfesor){
		List<Clase> listaClases = new ArrayList<>();
		String sql = "SELECT * FROM Clase CL, ClaseProfesor CP WHERE CL.idProfesorClase = CP.idProfesor AND idProfesor =" + idProfesor;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int id_Profesor = rs.getInt("idProfesor");
				Clase c = new Clase(id, nombre, id_Profesor);
				listaClases.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaClases;
	}
	
	/*INSERTAR UN Alumno NUEVO*/
	public static void insertarAlumnoBD(Connection conn, Alumno p) {
		String sql = String.format("INSERT INTO Alumno VALUES('%d','%s','%s','%s','%s','%d','%s','%s','%s','%d','%.2f','%d','%.2f' )",p.getId(), p.getNombre(), p.getApellidos(), p.getUsuario(), p.getContrasenia(), p.getTelefono(),p.getDomicilio(),p.getBaileAsignado(), p.getProfesorAsignado(), p.getClaseAsignada(), p.getDinero(), p.getGrupo(), p.getCalificacion());
		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*INSERTAR UN Profesor NUEVO*/
	public static void insertarProfesorBD(Connection conn, Profesor p) {
		String sql = String.format("INSERT INTO Profesor VALUES('%d','%s','%s','%s','%s','%d','%s','%d')",p.getId(), p.getNombre(), p.getApellidos(), p.getUsuario(), p.getContrasenia(), p.getTelefono(),p.getDomicilio(), p.getGrupo());
		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*Insertar una secretaria nueva*/
	public static void insertarSecretariaBD(Connection con, Secretaria s) {
		String sql = String.format("INSERT INTO SECRETARIA VALUES('%s','%s','%s','%s','%d','%s')", s.getNombre(), s.getApellidos(), s.getUsuario(), s.getContrasenia(), s.getTelefono(), s.getDomicilio());
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*VOLCADO DE ALUMNOS DESDE LA BASE DE DATOS A LA LISTA*/
	public static List<Alumno> volcadoAlumnosaLista(Connection conn) {
		List<Alumno> listaAlumnos = new ArrayList<>();
		String sql = "SELECT * FROM alumno";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String usuario = rs.getString("usuario");
				String con = rs.getString("contraseña");
				int tel = rs.getInt("telefono");
				String domicilio = rs.getString("domicilio");
				int idBaile = rs.getInt("idBaile");
				int idProfesor = rs.getInt("idProfesorAlumno");
				int idClase = rs.getInt("idClase");
				double dinero = rs.getDouble("dinero");
				int grupo = rs.getInt("grupo");
				double calificacaion = rs.getDouble("calificacion");
				Alumno a = new Alumno(id, nombre, apellido, usuario, con, tel, domicilio, idBaile, idProfesor, idClase, dinero, grupo, calificacaion);
				listaAlumnos.add(a);
			}
			rs.close();
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAlumnos;
	}
	
	/*VOLCADO DE PROFESORES DESDE LA BASE DE DATOS A LA LISTA*/
		public static List<Profesor> volcadoProfesorsaLista(Connection con){
			List<Profesor> l = new ArrayList<>();
			List<Alumno> listaAlumnos = new ArrayList<>();
			List<Baile> listaBaile = new ArrayList<>();
			List<Clase> listaClase = new ArrayList<>();
			String sql = "SELECT * FROM PROFESOR";
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					String apellido = rs.getString("apellido");
					String usuario = rs.getString("usuario");
					String contra = rs.getString("contraseña");
					int tel = rs.getInt("telefono");
					String domicilio = rs.getString("domicilio");
					int grupo = rs.getInt("grupo");
					listaAlumnos = BaseDatos.obtenerAlumnosProfesor(con, id);
					listaBaile = BaseDatos.obtenerBaileProfesor(con, id);
					listaClase = BaseDatos.obtenerClaseProfesor(con, id);
					Profesor p = new Profesor(id, nombre, apellido, usuario, contra, tel, domicilio, listaAlumnos, grupo, listaBaile, listaClase);
					l.add(p);
				}
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return l;
		}

		/*VOLCADO DE SECRETARIOS DESDE LA BASE DE DATOS A LA LISTA*/
		public static List<Secretaria> volcadoSecretariosaLista(Connection con){
			List<Secretaria> l = new ArrayList<>();
			String sql = "SELECT * FROM Secretaria";
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					String nombre = rs.getString("nombre");
					String apellido = rs.getString("apellido");
					String usuario = rs.getString("usuario");
					String contra = rs.getString("contraseña");
					int tel = rs.getInt("telefono");
					String domicilio = rs.getString("domicilio");
					Secretaria s = new Secretaria(nombre, apellido, usuario, contra, tel, domicilio);
					l.add(s);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return l;
		}
	
	
}
