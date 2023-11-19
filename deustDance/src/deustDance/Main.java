package deustDance;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import ventanas.VentanaInicioSesion;
import ventanas.VentanaSecretaria;


public class Main {

	public static void main(String[] args) {
		
		Logger logger = java.util.logging.Logger.getLogger("Logger");
		
		try {
			FileInputStream fis = new FileInputStream("conf/logger.properties");
			LogManager.getLogManager().readConfiguration(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Alumno a1 = new Alumno("Xabier", "Hernaez", "rebixa", "navaleno07",644544502, null, null, null, null, 150, 3, 7);
		Alumno a2 = new Alumno("Xabier", "Hernaez", "rr", "ddd",699577345, null, null, null,null, 300,4 ,5);
		
		Profesor p1 = new Profesor("a", "h", "ander", "aa", 638562098, null, null, 0, null, null);
		Profesor p2 = new Profesor("a", "h", "andrea", "bb", 630264985, null, null, 2, null, null);
		
		Secretaria s1 = new Secretaria("a", "h", "marta", "cc", 630845294, null);
		Secretaria s2 = new Secretaria("a", "h", "juan", "hh", 634821943, null);
		
		
		Academia.anyadirAlumno(a1);
		Academia.anyadirAlumno(a2);
		Academia.anyadirProfesor(p1);
		Academia.anyadirProfesor(p2);
		Academia.anyadirSecretario(s1);
		Academia.anyadirSecretario(s2);
		
		
		new VentanaSecretaria();	
		
	}

}
