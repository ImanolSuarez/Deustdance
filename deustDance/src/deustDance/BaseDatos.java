package deustDance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDatos {
	protected static Logger logger = Logger.getLogger(BaseDatos.class.getName());
	protected static Boolean loggerCreado = false;
	
	public static BaseDatos bd = new BaseDatos();
	
	public BaseDatos() {
		
	}
	
	// METODO QUE AJUSTA LOS PARAMETROS DEL LOGGER
	
	public void logger() {
		if(!loggerCreado) {
			logger.setLevel( Level.ALL);
			logger.setUseParentHandlers(false);
			
			try {
				logger.addHandler(new FileHandler("BaseDeDatosAcademia.xml"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		loggerCreado = true;
	}
	
	
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
	
	/*METODO QUE REALIZA EL CIERRE DE LA BASE DE DATOS*/
	
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
		String sq3 = "CREATE TABLE IF NOT EXISTS Baile(id Integer, idProfesorBaile Integer, descripcion String, tipo String, precio double, horas Integer)";
		String drop7 = "DROP TABLE IF EXISTS BaileProfesor";
		String sq4 = "CREATE TABLE IF NOT EXISTS BaileProfesor(idProfesor Integer, idBaile Integer)";
		String drop6 = "DROP TABLE IF EXISTS AlumnoProfesor";
		String sq5 = "CREATE TABLE IF NOT EXISTS AlumnoProfesor(idProfesor Integer, idAlumno Integer)";
		String drop3 = "DROP TABLE IF EXISTS Clase";
		String sq6 = "CREATE TABLE IF NOT EXISTS Clase(id Integer, nombre String, idProfesorClase Integer)";
		String drop8 = "DROP TABLE IF EXISTS ClaseProfesor";
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
			st.executeUpdate(drop7);
			st.executeUpdate(sq4);
			st.executeUpdate(drop6);
			st.executeUpdate(sq5);
			st.executeUpdate(drop3);
			st.executeUpdate(sq6);
			st.executeUpdate(drop8);
			st.executeUpdate(sq7);
			st.executeUpdate(drop5);
			st.executeUpdate(sq8);
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();	
		}
	}
	/*Seleccionar todos los alumnos a los que les da clase el profesor 1*/
	public static List<Alumno> obtenerAlumnosProfesor(Connection con){
		String sql = "SELECT * FROM Alumno AL, alumnoprofesor AP WHERE AL.idProfesorAlumno=AP.idProfesor";
		List<Alumno> l = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
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
				Alumno a = new Alumno(nombre, apellido, usuario, contra, tf, domicilio, idBaile, id_Profesor, idClase, dinero, grupo, calificacion);
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
	
	public static List<Baile> obtenerBaileProfesor(Connection con){
		List<Baile> l = new ArrayList<>();
		String sql = "SELECT * FROM Baile BA, BaileProfesor BP WHERE BA.idProfesorBaile = BP.idProfesor"; // "SELECT BA FROM Baile BA, PROFESOR PR WHERE BA.idProfesor = PR.idProfesor AND idPofesor ="
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
	
	public static List<Clase> obtenerClaseProfesor(Connection con){
		List<Clase> listaClases = new ArrayList<>();
		String sql = "SELECT * FROM Clase CL, ClaseProfesor CP WHERE CL.idProfesorClase = CP.idProfesor";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				int id_Profesor = rs.getInt("idProfesor");
				Clase c = new Clase(nombre, id_Profesor);
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
	
	//Insertar valores a las tablas AlumnoProfesor
	
	public static void insertarAlumnoProfesorBD(Connection con) {
		String sql = "SELECT id, idProfesorAlumno FROM Alumno";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String sql2 = "INSERT INTO AlumnoProfesor (idProfesor, idAlumno) VALUES (?,?) ";
			PreparedStatement prs = con.prepareStatement(sql2);
			while(rs.next()) {
				int idAlumno = rs.getInt("id");
				int idProfesor = rs.getInt("idProfesorAlumno");
				prs.setInt(1, idProfesor);
				prs.setInt(2, idAlumno);
				prs.executeUpdate();
			}
			prs.close();
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	/*Insertar las clases*/
	
	public static void insertarClaseBD(Connection con, Clase c) {
		String sql = String.format("INSERT INTO Clase Values('%d','%s','%d')", c.getNum(), c.getNombre(), c.getIdProfesor());
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Insertar la relacion de los profesor con las clase: la tabla ClaseProfesor*/
	
	public static void insertarClaseProfesor(Connection con) {
		String sql = "SELECT id, idProfesorClase FROM Clase";
		String sql2 = "INSERT INTO ClaseProfesor(idProfesor, idClase) VALUES(?,?)";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			PreparedStatement pst = con.prepareStatement(sql2);
			while(rs.next()) {
				int idProf = rs.getInt("id");
				int idCl = rs.getInt("idProfesorClase");
				pst.setInt(1, idProf);
				pst.setInt(2, idCl);
				pst.executeUpdate();
			}
			pst.close();
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/*Insertar Bile*/
	public static void insertarBaileBD(Connection con, Baile b) {
		String sql = "INSERT INTO Baile (id, idProfesorBaile, descripcion, tipo, precio, horas) VALUES (?, ?, ?, ?, ?, ?)";
	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, b.getIdBaile());
	        ps.setInt(2, b.getIdProfesor());
	        ps.setString(3, b.getDescripcion());
	        ps.setString(4, b.getTipoBaileStr());
	        ps.setDouble(5, b.getPrecio());
	        ps.setInt(6, b.getHorasDeClase());

	        ps.executeUpdate();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	/*Insertar baileProfesor*/
	
	public static void insertarBaileProfesor(Connection con) {
		String sql = "SELECT idProfesorBaile, id FROM Baile";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			String sql2 = "INSERT INTO BaileProfesor (idProfesor, idBaile) VALUES (?,?)";
			PreparedStatement pst = con.prepareStatement(sql2);
			while(rs.next()) {
				int idBaile = rs.getInt("id");
				int idP = rs.getInt("idProfesorBaile");
				pst.setInt(1, idP);
				pst.setInt(2, idBaile);
				pst.executeUpdate();
			}
			pst.close();
			rs.close();
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
				Alumno a = new Alumno(nombre, apellido, usuario, con, tel, domicilio, idBaile, idProfesor, idClase, dinero, grupo, calificacaion);
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
					String nombre = rs.getString("nombre");
					String apellido = rs.getString("apellido");
					String usuario = rs.getString("usuario");
					String contra = rs.getString("contraseña");
					int tel = rs.getInt("telefono");
					String domicilio = rs.getString("domicilio");
					int grupo = rs.getInt("grupo");
					listaAlumnos = BaseDatos.obtenerAlumnosProfesor(con);
					listaBaile = BaseDatos.obtenerBaileProfesor(con);
					listaClase = BaseDatos.obtenerClaseProfesor(con);
					Profesor p = new Profesor( nombre, apellido, usuario, contra, tel, domicilio, listaAlumnos, grupo, listaBaile, listaClase);
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
	
	/*BUSCA SI EL ALUMNO YA ESTA EN LA BASE DE DATOS MEDIANTE EL USUARIO*/
	public static Alumno buscarAlumno(Connection con, String usuario) {
		String sql = String.format("SELECT * FROM Alumno WHERE usuario = '%s'", usuario);
		Alumno a = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String usu = rs.getString("usuario");
				String contra = rs.getString("contraseña");
				int tel = rs.getInt("telefono");
				String domicilio = rs.getString("domicilio");
				int idB = rs.getInt("idBaile");
				int idP = rs.getInt("idProfesorAlumno");
				int idC = rs.getInt("idClase");
				double dinero = rs.getDouble("dinero");
				int grupo = rs.getInt("grupo");
				double calificacion = rs.getDouble("calificacion");
				a = new Alumno(nombre, apellido, usuario, contra, tel, domicilio, idB, idP, idC, dinero, grupo, calificacion);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	

	/*BUSCA SI EL PROFESOR YA ESTA EN LA BASE DE DATOS MEDIANTE EL USUARIO*/
	public static Profesor buscarProfesor(Connection con, String usuario) {
		String sql = String.format("SELECT * FROM Profesor WHERE usuario = '%s'", usuario);
		Profesor a = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String usu = rs.getString("usuario");
				String contra = rs.getString("contraseña");
				int tel = rs.getInt("telefono");
				String domicilio = rs.getString("domicilio");
				int grupo = rs.getInt("grupo");
				a = new Profesor(nombre, apellido, usu, contra, tel, domicilio, grupo);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	/*ELIMINA A UNA PERSOAN DE LA BASE DE DATOS*/

	/*ELIMINA A UNA PERSONA DE LA BASE DE DATOS*/

	
	public static void eliminarAlumno(Connection con, String usuario) {
		String sql = String.format("DELETE FROM Alumno WHERE usuario = '%s'", usuario);
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*MODIFICAR UN ALUMNO*/
	/*
	public static void modificarAlumno(Connection con, String nuevoNombre, nuevoApellido, nuevoContra, String usuario) {
	    String sql = String.format("UPDATE ALUMNO SET nombre = ?, apellido = ?, contraseña = ?, telefono = ?, domicilio = ?, idBaile = ?, idProfesorAlumno = ?, idClase = ?, dinero = ?, grupo = ?, calificacion = ? WHERE usuario = ?");
	    try (PreparedStatement pst = con.prepareStatement(sql)) {
	        pst.setString(1, nuevoValor);
	        pst.setString(2, usuario);
	        pst.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}*/
	
	/*OBTENER EL USUARIO*/
	
	public static List<Alumno> obtenerAlumnos(Connection con) {
	    List<Alumno> listaAlumnos = new ArrayList<>();
	    String sql = "SELECT * FROM Alumno";
	    try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
	        while (rs.next()) {
	            // Extraer los valores del ResultSet y crear un objeto Alumno
	            String nombre = rs.getString("nombre");
	            String apellido = rs.getString("apellido");
	            String usu = rs.getString("usuario");
	            String contra = rs.getString("contraseña");
	            int tel = rs.getInt("telefono");
	            String domicilio = rs.getString("domicilio");
	            int idB = rs.getInt("idBaile");
	            int idP = rs.getInt("idProfesorAlumno");
	            int idC = rs.getInt("idClase");
	            double dinero = rs.getDouble("dinero");
	            int grupo = rs.getInt("grupo");
	            double calificacion = rs.getDouble("calificacion");

	            Alumno alumno = new Alumno(nombre, apellido, usu, contra, tel, domicilio, idB, idP, idC, dinero, grupo, calificacion);
	            listaAlumnos.add(alumno);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return listaAlumnos;
	}
	
	/*ELIMINAR PROFESOR*/
	
	public static void eliminarProfesor(Connection con, String usuario) {
		String sql = String.format("DELETE FROM Profesor WHERE usuario = '%s'", usuario);
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*OBTENER TODOS LOS PROFESOR*/
	
	public static List<Profesor> listaProfesores(Connection con){
		List<Profesor> p = new ArrayList<>();
		String sql = "SELECT * FROM PROFESOR";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String usu = rs.getString("usuario");
				String contra = rs.getString("contraseña");
				int tel = rs.getInt("telefono");
				String domicilio = rs.getString("domicilio");
				int grupo = rs.getInt("grupo");
				Profesor a = new Profesor(nombre, apellido, usu, contra, tel, domicilio, grupo);
				p.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	/*MODIFICAR PROFESOR*/
	
	public static void modificarProfesor(Connection con, String nombre, String apellido, String contraseña, int tel, String domicilio, int grupo, String usuario) {
	    String sql = "UPDATE Profesor SET nombre = ?, apellido = ?, contraseña = ?, domicilio = ?, telefono = ?, grupo = ? WHERE usuario = ?";
	    
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        pstmt.setString(1, nombre);
	        pstmt.setString(2, apellido);
	        pstmt.setString(3, contraseña);
	        pstmt.setString(4, domicilio);
	        pstmt.setInt(5, tel);
	        pstmt.setInt(6, grupo);
	        pstmt.setString(7, usuario);

	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	/*MODIFICAR UN ALUMNO*/
	
	public static void modificarAlumno(Connection con, String nombre, String apellidos, String contrasenia, int telefono,
	        String domicilio, int baileAsignado, int profesorAsignado, int claseAsignada, double dinero,
	        int grupo, double calificacion, String usuario) {
	    String sql = "UPDATE Alumno SET nombre = ?, apellido = ?, contraseña = ?, telefono = ?, domicilio = ?, " +
	            "idBaile = ?, idProfesorAlumno = ?, idClase = ?, dinero = ?, grupo = ?, calificacion = ? " +
	            "WHERE usuario = ?";
	    
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        pstmt.setString(1, nombre);
	        pstmt.setString(2, apellidos);
	        pstmt.setString(3, contrasenia);
	        pstmt.setInt(4, telefono);
	        pstmt.setString(5, domicilio);
	        pstmt.setInt(6, baileAsignado);
	        pstmt.setInt(7, profesorAsignado);
	        pstmt.setInt(8, claseAsignada);
	        pstmt.setDouble(9, dinero);
	        pstmt.setInt(10, grupo);
	        pstmt.setDouble(11, calificacion);
	        pstmt.setString(12, usuario);

	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	/*OBTENER UN ALUMNO*/
	
	public static Alumno obtenerAlumno(Connection con, String usuario) {
		Alumno a = null;
		String sql = String.format("SELECT * from Alumno WHERE usuario = '%s'", usuario);
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs != null) {
				String nombre = rs.getString("nombre");
	            String apellido = rs.getString("apellido");
	            String usu = rs.getString("usuario");
	            String contra = rs.getString("contraseña");
	            int tel = rs.getInt("telefono");
	            String domicilio = rs.getString("domicilio");
	            int idB = rs.getInt("idBaile");
	            int idP = rs.getInt("idProfesorAlumno");
	            int idC = rs.getInt("idClase");
	            double dinero = rs.getDouble("dinero");
	            int grupo = rs.getInt("grupo");
	            double calificacion = rs.getDouble("calificacion");

	            a = new Alumno(nombre, apellido, usu, contra, tel, domicilio, idB, idP, idC, dinero, grupo, calificacion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public static Profesor obtenerProfesor(Connection con, String usuario) {
		Profesor a = null;
		String sql = String.format("SELECT * from Profesor WHERE usuario = '%s'", usuario);
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs != null) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String usu = rs.getString("usuario");
				String contra = rs.getString("contraseña");
				int tel = rs.getInt("telefono");
				String domicilio = rs.getString("domicilio");
				int grupo = rs.getInt("grupo");
				a = new Profesor(nombre, apellido, usu, contra, tel, domicilio, grupo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	/*OBTENER LOS PROFESOR SEGUN SU id*/
	
	
	public static Profesor obtenerProfesorId(Connection con,int id) {
		String sql = String.format("SELECT * FROM Profesor WHERE id = '%d'", id);
		Profesor a = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs != null) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String usu = rs.getString("usuario");
				String contra = rs.getString("contraseña");
				int tel = rs.getInt("telefono");
				String domicilio = rs.getString("domicilio");
				int grupo = rs.getInt("grupo");
				a = new Profesor(nombre, apellido, usu, contra, tel, domicilio, grupo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}
	
	public static Baile obtenerBaileTipo(Connection con, String tipo) {
		Baile b = null;
		String sql = String.format("SELECT * FROM BAILE WHERE tipo = '%s'", tipo);
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs != null) {
				// 		String sq3 = "CREATE TABLE IF NOT EXISTS Baile(id Integer, idProfesorBaile Integer, descripcion String, tipo String, precio double, horas Integer)";
				int id = rs.getInt("id");
				int idProfe = rs.getInt("idProfesorBaile");
				String descripcion = rs.getString("descripcion");
				String tipoBaile = rs.getString("tipo");
				double precio = rs.getDouble("precio");
				int horas = rs.getInt("horas");
				b = new Baile(id, idProfe, descripcion, tipoBaile, precio, horas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}	
	
	
	public static List<Baile> obtenerTodosBailes(Connection con) {
		List<Baile> listaBaile = new ArrayList<>();
		String sql = "SELECT * FROM Baile";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				int id = rs.getInt("id");
				int idProfe = rs.getInt("idProfesorBaile");
				String descripcion = rs.getString("descripcion");
				String tipoBaile = rs.getString("tipo");
				double precio = rs.getDouble("precio");
				int horas = rs.getInt("horas");
				Baile b = new Baile(id, idProfe, descripcion, tipoBaile, precio, horas);
				listaBaile.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaBaile;
	}
	
	
	
	
}
