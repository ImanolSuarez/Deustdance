package deustDance;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BaileTest {
	
	private Baile b;
	
	
	@Before
	public void setUp() {
		b = new Baile("descripcion", null, 500.00f, 2, null, new ArrayList<>(), null );
	}
	@Test
	public void getDescripcion() {
		assertEquals("descripcion", b.getDescripcion());
	}
	@Test
	public void setDescripcion() {
		b.setDescripcion("descripcion");
		assertEquals("descripcion", b.getDescripcion());
	}
	@Test
	public void getTipoBaile() {
		assertNull(b.getTipoBaile());
	}
	@Test
	public void setTipoBaile() {
		b.setTipoBaile(null);
		assertNull(b.getTipoBaile());
	}
	@Test
	public void getPrecio() {
		assertEquals(500.00, b.getPrecio(), 0);
	}
	@Test
	public void setPrecio() {
		b.setPrecio(500.00);
		assertEquals(500.00, b.getPrecio(), 0);
	}
	@Test
	public void getHorasDeClase() {
		assertEquals(2, b.getHorasDeClase());
	}
	@Test
	public void setHorasDeClase() {
		b.setHorasDeClase(2);
		assertEquals(500.00, b.getPrecio(), 0);
	}
	@Test
	public void getProfesorAsignado() {
		assertNull(b.getProfesorAsignado());
	}
	@Test
	public void setProfesorAsignado() {
		b.setProfesorAsignado(null);
		assertNull(b.getProfesorAsignado());
	}
	/*
	@Test
	public void getListaAlumnos() {
		
	}
	@Test
	public void setListaAlumnos() {
		
	}
	 */
	@Test
	public void getClaseAsignada() {
		assertNull(b.getClaseAsignada());
	}
	@Test
	public void setClaseAsignada() {
		b.setClaseAsignada(null);
		assertNull(b.getClaseAsignada());
	}
	@Test
	public void BailetoString() {
		assertEquals("Tipo de baile: "+ null + "descripcion: " + "descripcion" + ", precio: " + 500.00 + "€"
				+ ", horas de clase: " + 2 + ", profesor asignado: " + null + ", lista de alumnos: "
				+ new ArrayList<>() + ", clase asignada=" + null, b.toString());
	}
	

}
