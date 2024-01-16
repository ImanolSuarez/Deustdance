package deustDance;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;


public class SecretariaTest {
	
	private Secretaria s;
	
	
	@Before
	public void setUp() {
		s = new Secretaria("Secretaria", "Apellido", "usuario", "contraseña", 677787765, "domicilio");
	}
	
	
	@Test
	public void testToString() {
		assertEquals("Nombre de la secretaria: " + "Secretaria" + ", apellidos: " + "Apellido" + ", usuario: "
				+ "usuario" + ", contraseña: " + "contraseña" +  ", telefono: " + 677787765 + ", domicilio: " + "domicilio", s.toString());
	}

}
