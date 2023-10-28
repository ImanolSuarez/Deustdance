package deustDance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class Academia {
	
	private static List<Baile> listaBailes = new ArrayList<Baile>();
	private static List<Alumno> listaAlumnos = new ArrayList<>();
	private static List<Profesor> listaProfesores = new ArrayList<>();
	private static List<Clase> listaClases = new ArrayList<>();
	
	
	/*METODOS DE LA CLASE ACADEMIA*/
	
	/*METODO PARA AÑADIR ALUMNOS*/
	
	public static void anyadirAlumno(Alumno a) {
		listaAlumnos.add(a);
		
	}
	
	
	/*METODO PARA VER SI UN ALUMNO SE HA REGISTRADO DOS VECES*/
	
	public static Alumno buscarAlumno(String dni) {
		
		boolean repetido = false;
		int pos = 0;
		Alumno b = null;
		
		if(!repetido && pos < listaAlumnos.size()) {
			b = listaAlumnos.get(pos);
			if(b.getDni().equals(dni)) {
				repetido = true;
			}
			pos++;
		}
		if(repetido) {
			return b;
		}else {
			return null;
		}
		
		
		
	}
	
	

}
