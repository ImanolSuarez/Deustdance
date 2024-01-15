package deustDance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AcademiaTest {
	
	private Connection con;
	
	@Before
	public void setUp() {
		con = BaseDatos.initBD("DeustDance.db");
	}
	@After
	public void closeUp() {
		BaseDatos.closeBD(con);
	}

	 @Test
	 public void testCargarAlumnoDesdeBD() {
	       Academia.cargarAlumnoDesdeBD(con);
	       assertFalse(Academia.getListaAlumnos().isEmpty());
	  }
	 
	 @Test
	    public void testCargarProfesoresDesdeBD() {
	        Academia.cargarProfesoresDesdeBD(con);
	        assertFalse(Academia.getListaProfesores().isEmpty());
	    }
	 
	 @Test
	    public void testCargarSecretariaDesdeBD() {
	        Academia.cargarSecretariaDesdeBD(con);
	        assertFalse(Academia.getListaSecretaria().isEmpty());
	    }
	 
	 @Test
	    public void testBorrarTodosLosProfesores() {
	        Academia.borrarTodosLosProfesores();
	        assertTrue(Academia.getListaProfesores().isEmpty());
	    }
	 @Test
	    public void testAnyadirProfesor() {
	        Profesor profesor = new Profesor("Profesor", "Apellido", "usuario", "contraseña", 688823376, "domicilio", null, 0, null, null);
	        Academia.anyadirProfesor(profesor);
	        assertTrue(Academia.getListaProfesores().contains(profesor));
	    }
	 
	 @Test
	    public void testAnyadirSecretario() {
	        Secretaria secretario = new Secretaria("Secretaria", "Apellido", "usuairo", "contraseña", 688823376, "domicilio");
	        Academia.anyadirSecretario(secretario);
	        assertTrue(Academia.getListaSecretaria().contains(secretario));
	    }
	 @Test
	 public void testAnyadirAlumno() {
	      	Alumno alumnoPrueba = new Alumno("Xabier", "Apellido", "usuario", "contraseña", 688823376, "domicilio", 1, 1, 1, 1, 1, 1);
	        Academia.anyadirAlumno(alumnoPrueba);
	        assertTrue(Academia.getListaAlumnos().contains(alumnoPrueba));
	  }
	 @Test
	 public void testBorrarTodosLosAlumnos() {
	      Academia.borrarTodosLosAlumnos();
	      assertTrue(Academia.getListaAlumnos().isEmpty());
	 }
	 @Test
	  public void testCargarMapa() {
		 	Map<Integer, List<Alumno>> mapa = Academia.cargarMapa();
		 	assertNotNull(mapa);
	  }
	 @Test
	  public void testcargarMapaTipoAlumno() {
		 	Map<Integer, List<Alumno>> mapa = Academia.cargarMapaTipoAlumno();
		 	assertNotNull(mapa);
	  }
	 /*
	 @Test
	  public void testcargarMapaTipoProfesor() {
		 	Map<Integer, List<Profesor>> mapa = Academia.cargarMapaTipoProfesor();
		 	assertNotNull(mapa);
	  }*/
	 @Test
	    public void testcontieneAlumno() {
	       List<Alumno> listaAlumno = Academia.getListaAlumnos();
	       Alumno a = new Alumno("Xabier", null, "usuario", null, 0, null, 0, 0, 0, 0, 0, 0);
	       Alumno b = new Alumno(null, null, "u", null, 0, null, 0, 0, 0, 0, 0, 0);
	       listaAlumno.add(a);
	       assertTrue(Academia.contieneAlumno(a));
	       assertFalse(Academia.contieneAlumno(b));
	 }
	 
	 @Test
	    public void testcontieneAProfesor() {
	       List<Profesor> listaProfesor = Academia.getListaProfesores();
	       Profesor a = new Profesor(null, null, "usuario", null, 0, null, null, 0, null, null);
	       Profesor b = new Profesor(null, null, "u", null, 0, null, null, 0, null, null);
	       listaProfesor.add(a);
	       assertTrue(Academia.contieneProfesor(a));
	       assertFalse(Academia.contieneProfesor(b));
	 }
	 @Test 
	 public void testbuscarAlumno() {
		 List<Alumno> listaAlumno = Academia.getListaAlumnos();
	       Alumno a = new Alumno("Xabier", null, "usuario", null, 0, null, 0, 0, 0, 0, 0, 0);
	       listaAlumno.add(a);
	       assertTrue(Academia.buscarAlumno("usuario") != null);
	       assertNull(Academia.buscarAlumno("u"));
	       
	 }
	 @Test
	 public void testbuscarProfesor() {
		 List<Profesor> listaProfesor = Academia.getListaProfesores();
	       Profesor a = new Profesor(null, null, "usuario", null, 0, null, null, 0, null, null);
	       listaProfesor.add(a);
	       assertTrue(Academia.buscarProfesor("usuario") != null);
	       assertNull(Academia.buscarProfesor("u"));
	 }
	 
	 @Test
	 public void testbuscarSecretaria() {
		 List<Secretaria> listaSecretaria = Academia.getListaSecretaria();
		 Secretaria s = new Secretaria(null, null, "usuario", null, 0, null);
		 listaSecretaria.add(s);
		 assertNotNull(Academia.buscarSecretario("usuario"));
		 assertNull(Academia.buscarSecretario("u"));
	 }
	
}
