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
		String sql = "CREATE TABLE IF NOT EXIST Alumno(nombre String, apellido String, usuario String, contraseña String, telefono int, domicilio String, baile Baile, profesor Profesor, clase Clase, dinero double, grupo int, calificacion double)";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		}catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	
	/*INSERTAR UNA PERSONA NUEVA*/
	public static void insertarPersonaBD(Connection conn, Alumno p) {
		String sql = String.format("INSERT INTO Alumno VALUES('%s','%s','%s','%s','%d','%s','%s','%s','%d','%.2f','%d','%.2f' )", p.getNombre(), p.getApellidos(), p.getUsuario(), p.getContrasenia(), p.getTelefono(),p.getDomicilio(),p.getBaileAsignado(), p.getProfesorAsignado(), p.getClaseAsignada(), p.getDinero(), p.getGrupo(), p.getCalificacion());
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
				Alumno a = new Alumno(nombre, apellido, usuario, contrasenia, telefono, domicilio, null, null, null, dinero, grupo, calificacion);
				listaAlumnos.add(a);
			}
			rs.close();
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAlumnos;
		
	}
	
	
}
