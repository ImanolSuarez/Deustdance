package deustDance;


import java.util.List;

public class Clase {
	
	private static int contador = 1;
	private int num;
	private String nombre;
	private int idProfesor;
	
	
	public Clase(String nombre, int idProfesor) {
		super();
		num = contador;
		contador++;
		this.num = num;
		this.nombre = nombre;
		this.idProfesor = idProfesor;
		
	}

	public Clase() {
		super();
		
	}
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	@Override
	public String toString() {
		return "Nombre de la clase: " + nombre + "-" + "id profesor: " + idProfesor;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
