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
	
	
	/*METODO PARA VER SI ES UN ALUMNO ESTA REGISTRADO Y PUEDE INICIAR SESION*/
	
	public static Alumno buscarAlumno(String usuario) {
		int pos = 0;
		boolean enc = false;
		Alumno a = null;
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
	
	
	
	
	

}
