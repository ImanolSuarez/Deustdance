package deustDance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BaseDatosTest {

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
	public void testinsertarAlumnoBD() {
		Alumno a = new Alumno(null, null, "usuario", null, 0, null, 0, 0, 0, 0, 0, 0);
		List<Alumno> listaA = BaseDatos.obtenerAlumnos(con);	
		BaseDatos.insertarAlumnoBD(con, a);
		List<Alumno> listaB = BaseDatos.obtenerAlumnos(con);
		assertTrue(listaA.size() != listaB.size());
		BaseDatos.eliminarAlumno(con, "usuario");
	}
	@Test
	public void testModificarAlumno() {
		Alumno a = new Alumno("", null, "usuario", null, 0, null, 0, 0, 0, 0, 0, 0);
		BaseDatos.insertarAlumnoBD(con, a);
		assertEquals("",BaseDatos.obtenerAlumno(con, "usuario").getNombre());
		BaseDatos.modificarAlumno(con, "xabier", null, null, 0, null, 0, 0, 0, 0, 0, 0, "usuario");
		assertEquals("xabier",BaseDatos.obtenerAlumno(con, "usuario").getNombre());
		BaseDatos.eliminarAlumno(con, "usuario");
	}
	@Test
	public void testEliminarAlumno() {
		Alumno a = new Alumno(null, null, "usuario", null, 0, null, 0, 0, 0, 0, 0, 0);
		BaseDatos.insertarAlumnoBD(con, a);
		List<Alumno> lista = BaseDatos.obtenerAlumnos(con);
		BaseDatos.eliminarAlumno(con, "usuario");
		List<Alumno> listaA = BaseDatos.obtenerAlumnos(con);
		assertTrue(lista.size() != listaA.size());
	}
	@Test
	public void testinsertarProfesor() {
		Profesor p = new Profesor(null, null, "usuario", null, 0, null, null, 0, null, null);
		List<Profesor> listaP = BaseDatos.listaProfesores(con);
		BaseDatos.insertarProfesorBD(con, p);
		List<Profesor> listaA = BaseDatos.listaProfesores(con);
		assertTrue(listaP.size() != listaA.size());
		BaseDatos.eliminarProfesor(con, "usuario");
				
	}
	@Test 
	public void testmodificarProfesor() {
		Profesor p = new Profesor("", null, "usuario", null, 0, null, 0);
		BaseDatos.insertarProfesorBD(con, p);
		assertEquals("",BaseDatos.obtenerProfesor(con, "usuario").getNombre());
		BaseDatos.modificarProfesor(con, "xabier", null, null, 0, null, 0, "usuario");
		assertEquals("xabier",BaseDatos.obtenerProfesor(con, "usuario").getNombre());
		BaseDatos.eliminarProfesor(con, "usuario");
	}
	@Test
	public void testborrarProfesor() {
		Profesor p = new Profesor("", null, "usuario", null, 0, null, 0);
		BaseDatos.insertarProfesorBD(con, p);
		BaseDatos.eliminarProfesor(con, "usuario");
		assertNotEquals("xabier",BaseDatos.obtenerProfesor(con, "usuario").getNombre());
		
	}
	@Test
	public void testinsertarSecretaria() {
		Secretaria s = new Secretaria(null, null, "usuario", null, 0, null);
		List<Secretaria> listaS = BaseDatos.obtenerSecretarios(con);
		BaseDatos.insertarSecretariaBD(con, s);
		List<Secretaria> listA = BaseDatos.obtenerSecretarios(con);
		assertTrue(listaS.size() != listA.size());
	}
	
	
}
