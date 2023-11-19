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
	
	/*VOLCADO DE ALUMNOS DESDE LA BASE DE DATOS A LA LISTA*/
	
	public static void volcadoAlumnosaLista(Connection conn) {
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
				double calificacion = rs.getDouble("calificacion");
				Alumno a = new Alumno(nombre, apellido, usuario, contrasenia, calificacion);
				listaAlumnos.add(a);
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
