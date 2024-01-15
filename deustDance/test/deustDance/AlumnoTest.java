package deustDance;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class AlumnoTest {
	
	private Alumno a;
	@Before
	public void setUp() {
		a = new Alumno("Alumno", "Apellido", "Usuario", "Contraseña", 688823376, "Domicilio", 1, 1, 1, 1, 1, 1);
	}
	@Test
	public void getBaileAsignado() {
		assertEquals(1, a.getBaileAsignado());
	}
	@Test
	public void setBaileAsignado() {
		a.setBaileAsignado(1);
		assertEquals(1,a.getBaileAsignado());
	}
	@Test
	public void getProfesorAsignado() {
		assertEquals(1,a.getProfesorAsignado());
	}
	
	public void getClaseAsignada() {
		assertEquals(1,a.getClaseAsignada());
	}
	
	@Test
	public void getDinero() {
		assertEquals(1, a.getDinero(), 0);
	}
	@Test
	public void setDinero() {
		a.setDinero(1);
		assertEquals(1, a.getDinero(), 0);
	}
	@Test
	public void getGrupo() {
		assertEquals(1, a.getGrupo(),0);
	}
	public void setGrupo() {
		a.setGrupo(1);
		assertEquals(1, a.getGrupo(),0);
	}
	@Test
	public void getCalificacion() {
		assertEquals(1, a.getCalificacion(), 0);
	}
	@Test
	public void setCalificacion() {
		a.setCalificacion(1);
		assertEquals(1, a.getCalificacion(), 0);
	}
	@Test
	public void testToString() {
	    Alumno alumno = new Alumno();
	    alumno.setBaileAsignado(1);
	    alumno.setId_profesorAsignado(1);
	    alumno.setId_claseAsignada(1);
	    alumno.setDinero(1.0);
	    alumno.setGrupo(1);
	    alumno.setCalificacion(1.0);
	    alumno.setNombre("Nombre");
	    alumno.setApellidos("Apellido");
	    alumno.setUsuario("Usuario");
	    alumno.setContrasenia("Contraseña");
	    alumno.setTelefono(688823376);
	    alumno.setDomicilio("Domicilio");

	    String expectedToString = "Alumno baileAsignado=1, profesorAsignado=1, claseAsignada=1, dinero=1.0, grupo=1, calificacion=1.0, " +
	            "getNombre()=Nombre, getApellidos()=Apellido, getUsuario()=Usuario, getContrasenia()=Contraseña, " +
	            "getTelefono()=688823376, getDomicilio()=Domicilio";

	    assertEquals(expectedToString, alumno.toString());
	}
	
}
