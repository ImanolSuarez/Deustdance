package deustDance;


import static org.junit.Assert.assertEquals;




import org.junit.Before;
import org.junit.Test;

public class BaileTest {
	
	private Baile b;
	
	
	@Before
	public void setUp() {
		b = new Baile(1, 1, "descripcion", "BAILE_MODERNO", 1, 1);
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
		assertEquals(Tipo.BAILE_MODERNO,b.getTipoBaile());
	}
	
	@Test
	public void setTipoBaile() {
		b.setTipoBaile("BAILE_MODERNO");
		assertEquals(Tipo.BAILE_MODERNO,b.getTipoBaile());
	}
	@Test
	public void getPrecio() {
		assertEquals(1, b.getPrecio(), 0);
	}
	@Test
	public void setPrecio() {
		b.setPrecio(1);
		assertEquals(1, b.getPrecio(), 0);
	}
	@Test
	public void getHorasDeClase() {
		assertEquals(1, b.getHorasDeClase());
	}
	@Test
	public void setHorasDeClase() {
		b.setHorasDeClase(1);
		assertEquals(1, b.getPrecio(), 0);
	}
	
	
	@Test
	public void BailetoString() {
		assertEquals("id: " + 1 + ", tipo de baile: "+ "BAILE_MODERNO" + "descripcion: " + "descripcion" + ", precio: " + 1.0 + "€"
				+ ", horas de clase: " + 1, b.toString());
	}
	

}
