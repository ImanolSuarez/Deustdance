package deustDance;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class AlumnoTest {
	
	private Alumno a;
	@Before
	public void setUp() {
		a = new Alumno("Alumno", "Apellido", "usuario", "contraseña", 677877643, "domicilio", null,null,null,200, 2, 5.0);
	}
	@Test
	public void getBaileAsignado() {
		assertNull(a.getBaileAsignado());
	}
	@Test
	public void setBaileAsignado() {
		a.setBaileAsignado(null);
		assertNull(a.getBaileAsignado());
	}
	@Test
	public void getProfesorAsignado() {
		assertNull(a.getProfesorAsignado());
	}
	@Test
	public void setProfesorAsignado() {
		a.setProfesorAsignado(null);
		assertNull(a.getProfesorAsignado());
	}
	public void getClaseAsignada() {
		assertNull(a.getClaseAsignada());
	}
	public void setClaseAsignada() {
		a.setClaseAsignada(null);
		assertNull(a.getClaseAsignada());
	}
	@Test
	public void getDinero() {
		assertEquals(200, a.getDinero(), 0);
	}
	@Test
	public void setDinero() {
		a.setDinero(200);
		assertEquals(200, a.getDinero(), 0);
	}
	@Test
	public void getGrupo() {
		assertEquals(2, a.getGrupo(),0);
	}
	public void setGrupo() {
		a.setGrupo(2);
		assertEquals(2, a.getGrupo(),0);
	}
	@Test
	public void getCalificacion() {
		assertEquals(5.00, a.getCalificacion(), 0);
	}
	@Test
	public void setCalificacion() {
		a.setCalificacion(5.00);
		assertEquals(5.00, a.getCalificacion(), 0);
	}
	
	@Test
	public void testToString() {
		assertEquals("Alumno [baileAsignado=" + null + ", profesorAsignado=" + null + ", claseAsignada="
	            + null + ", dinero=" + 200.0 + ", grupo=" + 2 + ", calificacion=" + 5.00
	            + ", getNombre()=" + "Alumno" + ", getApellidos()=" + "Apellido" + ", getUsuario()="
	            + "usuario" + ", getContrasenia()=" + "contraseña" + ", getTelefono()=" + 677877643
	            + ", getDomicilio()=" + "domicilio" + "]", a.toString());
	}
}
