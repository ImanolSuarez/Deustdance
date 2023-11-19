package deustDance;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class SecretariaTest {
	
	private Secretaria s;
	
	
	@Before
	public void setUp() {
		s = new Secretaria("Secretaria", "Apellido", "usuario", "contraseña");
	}
	
	
	@Test
	public void SecretariaToString() {
		assertEquals("Nombre de la secretaria: " + "Secretaria" + ", apellidos: " + "Apellido" + ", usuario: "
				+ "usuario" + ", contraseña " + "contraseña", s.toString());
	}

}
