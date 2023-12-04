package deustDance;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;



import org.junit.Before;
import org.junit.Test;

public class BaileTest {
	
	private Baile b;
	
	/*
	@Before
	public void setUp() {
		b = new Baile("descripcion", "", 500.00, 2);
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
	/*
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
	
	/*
	@Test
	public void BailetoString() {
		assertEquals("Tipo de baile: "+ null + "descripcion: " + "descripcion" + ", precio: " + 500.00 + "€"
				+ ", horas de clase: " + 2 + ", profesor asignado: " + null + ", lista de alumnos: "
				+ null + ", clase asignada=" + null, b.toString());
	}*/
	

}
