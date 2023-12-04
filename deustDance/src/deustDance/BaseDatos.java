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
		String sql = "CREATE TABLE IF NOT EXIST Alumno(id Integer, nombre String, apellido String, usuario String, contraseña String, telefono int, domicilio String, idBaile Integer, idProfesor Integer, idClase Integer, dinero double, grupo int, calificacion double)";
		String sq2 = "CREATE TABLE IF NOT EXIST Profesor(id Integer, nombre String, apellido String, usuario String, contraseña String, telefono int, domicilio String, grupo Integer)";
		String sq3 = "CREATE TABLE IF NOT EXIST Baile(id Integer, idProfesor Integer, descripcion String, tipo String, precio Double, horas int)";
		String sq4 = "CREATE TABLE IF NOT EXIST BaileProfesor(idProfesor Integer, idBaile Integer)";
		String sq5 = "CREATE TABLE IF NOT EXIST AlumnoProfesor(idProfesor Integer, idAlumno Integer)";
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.executeUpdate(sq2);
			st.executeUpdate(sq3);
			st.executeUpdate(sq4);
			st.executeUpdate(sq5);
			st.close();
		}catch (SQLException e) {
			// TODO: handle exception
		}
	}
	/*Seleccionar todos los alumnos a los que les da clase el profesor 1*/
	public static List<Alumno> obtenerAlumnosProfesor(Connection con, int idProfesor){
		String sql = "SELECT * FROM Alumno A, AlumnoProfesor AP WHERE A.idProfesor=AP.idProfesor AND idProfesor="+idProfesor;
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
				Alumno a = new Alumno(id, nombre, apellido, usuario, contra, idBaile, domicilio, domicilio, id_Profesor, idClase, dinero, grupo, calificacion);
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
		String sql = "SELECT * FROM Baile BA, BaileProfesor BP WHERE BA.idProfesor = BP.idProfesor AND idPofesor =" + idProfesor; //"SELECT BA FROM Baile BA, PROFESOR PR WHERE BA.idProfesor = PR.idProfesor AND idPofesor ="
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				int id_Profesor = rs.getInt("idProfesor");
				String descripcion = rs.getString("descripcion");
				String tipo = rs.getString("tipo");
				Double precio = rs.getDouble("precio");
				int horas = rs.getInt("horas");
				Baile b = new Baile(id, idProfesor, descripcion, tipo, id_Profesor, horas);
				l.add(b);
			}
			rs.close();
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
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
	public static void insertarProfesorBD(Connection conn, Alumno p) {
		String sql = String.format("INSERT INTO Profesor VALUES('%d','%s','%s','%s','%s','%d','%s','%s','%s','%d','%.2f','%d','%.2f' )",p.getId(), p.getNombre(), p.getApellidos(), p.getUsuario(), p.getContrasenia(), p.getTelefono(),p.getDomicilio(),p.getBaileAsignado(), p.getProfesorAsignado(), p.getClaseAsignada(), p.getDinero(), p.getGrupo(), p.getCalificacion());
		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);
			stm.close();
		}catch (SQLException e) {
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
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String usuario = rs.getString("usuario");
				String contrasenia = rs.getString("contraseña");
				int telefono = rs.getInt("telefono");
				String domicilio = rs.getString("domicilio");
				String baile = rs.getString("baile");
				String profesor = rs.getString("profesor");
				String clase = rs.getString("clase");
				double dinero = rs.getDouble("dinero");
				int grupo = rs.getInt("grupo");
				double calificacion = rs.getDouble("calificacion");
				//Alumno a = new Alumno(nombre, apellido, usuario, contrasenia, telefono, domicilio, null, null, null, dinero, grupo, calificacion);
				//listaAlumnos.add(a);
				
			}
			rs.close();
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAlumnos;
		
	}
	
	
}
