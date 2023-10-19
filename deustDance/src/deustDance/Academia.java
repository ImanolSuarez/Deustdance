package deustDance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JList;

public class Academia {
	
	private static List<Baile> listaBailes = new ArrayList<Baile>();
	private static List<Alumno> listaAlumnos = new ArrayList<>();
	private static List<Profesor> listaProfesores = new ArrayList<>();
	private static List<Clase> listaClases = new ArrayList<>();
	
	
	
	
	
	
	
	
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
				String dni = datos[3];
				String fNac = datos[4];
				String direccion = datos[5];
				String codPostal =datos[6];
				String telefono =datos[7];
				
				//Alumno a = new Alumno(nombre, apellidos, edad, dni, fNac, direccion, codPostal, telefono);
				//listaPersonas.add(a);
				
			}
		} catch (FileNotFoundException e) {
			
		}
		
	}
	
	public static void guardarAlumnosEnFichero(String nomFicher){
		
		try {
			PrintWriter pw = new PrintWriter(nomFicher);
			for(Alumno a : listaAlumnos) {
				pw.println(a.getNombre()+";"+a.getApellidos()+";"+a.getEdad()+";"+a.getDni()+";"+a.getfNac()+";"+a.getDireccion()+a.getCodPostal()+a.getTelefono());
				
			}
			pw.flush();
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
