package deustDance;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.LogManager;
import java.util.logging.Logger;


import ventanas.VentanaInicioSesion;


public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Logger logger = java.util.logging.Logger.getLogger("Logger");
		
		try {
			FileInputStream fis = new FileInputStream("conf/logger.properties");
			LogManager.getLogManager().readConfiguration(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (SecurityException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Connection con = BaseDatos.initBD("DeustDance.db");
		BaseDatos.crearTabla(con);
		Academia.cargarDatosAlumno(con, "resources/alumnos.csv");	
		Academia.cargarDatosProfesor(con, "resources/profesores.csv");
		Academia.cargarDatosSecretaria(con, "resources/secretarias.csv");
		Academia.cargarDatosBaile(con, "resources/baile.csv");
		Academia.cargarDatosClase(con, "resources/clase.csv");
		Academia.cargarAlumnoDesdeBD(con);
		Academia.cargarProfesoresDesdeBD(con);
		Academia.cargarSecretariaDesdeBD(con);
		BaseDatos.insertarAlumnoProfesorBD(con);
		BaseDatos.insertarBaileProfesor(con);
		BaseDatos.insertarClaseProfesor(con);
		Academia.cargarMapa();
		BaseDatos.closeBD(con);
		
		
		
		@SuppressWarnings("unused")
		VentanaInicioSesion v = new VentanaInicioSesion();
		
			
		
	}

}
