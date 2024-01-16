package deustDance;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class ClaseTest {
	
	private Clase c;
	
	@Before
	public void setUp() {
		c = new Clase("Clase", 1);
	}
	@Test
	public void getNombre() {
		assertEquals("Clase", c.getNombre());
	}
	@Test
	public void setNombre() {
		c.setNombre("Clase");
		assertEquals("Clase", c.getNombre());
	}
	@Test
	public void getListaProfesores() {
		assertEquals(1, c.getIdProfesor());
	}
	@Test
	public void ClaseToString() {
		assertEquals("Nombre de la clase: " + "Clase" + "-" + "id profesor: " + 1, c.toString());
	}
	
}
