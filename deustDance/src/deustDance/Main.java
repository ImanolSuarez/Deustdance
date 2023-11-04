package deustDance;



import ventanas.VentanaInicioSesion;


public class Main {

	public static void main(String[] args) {
		
		Alumno a1 = new Alumno("Xabier", "Hernaez", "rebixa", "navaleno07");
		Alumno a2 = new Alumno("Xabier", "Hernaez", "rr", "ddd");
		
		Profesor p1 = new Profesor("a", "h", "ander", "aa");
		Profesor p2 = new Profesor("a", "h", "andrea", "bb");
		
		Secretaria s1 = new Secretaria("a", "h", "marta", "cc");
		Secretaria s2 = new Secretaria("a", "h", "juan", "hh");
		
		
		Academia.anyadirAlumno(a1);
		Academia.anyadirAlumno(a2);
		Academia.anyadirProfesor(p1);
		Academia.anyadirProfesor(p2);
		Academia.anyadirSecretario(s1);
		Academia.anyadirSecretario(s2);
		
		
		new VentanaInicioSesion();
		
		
		
	}

}
