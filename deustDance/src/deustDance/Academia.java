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
	
	/*METODO CARGAR ALUMNOS*/
	
	public static void cargarAlumnosEnLista(String nomFichero) {
		
		try {
			Scanner sc = new Scanner(new FileReader(nomFichero));
			String linea;
			while(sc.hasNext()) {
				linea = sc.nextLine();
				String[] datos = linea.split(";");
				String nombre = datos[0];
				String apellidos = datos[1];
				int edad  = Integer.parseInt(datos[2]);
				String email = datos[3];
				String con = datos[4];
				String dni = datos[5];
				String fNac = datos[6];
				String direccion = datos[7];
				String codPostal =datos[8];
				String telefono =datos[9];
				String sexo = datos[10];
				
				Alumno a = new Alumno(nombre, apellidos,edad, email, con, dni, fNac, direccion, codPostal, telefono, sexo);
				listaAlumnos.add(a);
				
			}
		} catch (FileNotFoundException e) {
			
		}
		
	}
	
	
	/*METODO GUARDAR ALUMNO*/
	
	public static void guardarAlumnosEnFichero(String nomFicher){
		
		try {
			PrintWriter pw = new PrintWriter(nomFicher);
			for(Alumno a : listaAlumnos) {
				pw.println(a.getNombre()+";"+a.getApellidos()+";"+a.getEdad()+";"+a.getDni()+";"+a.getfNac()+";"+a.getDireccion()+a.getCodPostal()+a.getTelefono()+";"+a.getSexo());
				
			}
			pw.flush();
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*METODO GUARDAR PROFESORES*/
	
	public static void guardarProfesorEnFichero(String nomFichero) {
		
		try {
			PrintWriter pw = new PrintWriter(nomFichero);
			for(Profesor p : listaProfesores) {
				pw.println(p.getNombre()+";"+p.getApellidos()+";"+p.getEdad()+";"+p.getDni()+";"+p.getfNac()+p.getDireccion()+";"+p.getCodPostal()+";"+p.getTelefono());
			}
			pw.flush();
			pw.close();
			
		} catch (FileNotFoundException e) {
			
		}
	
	}

}
