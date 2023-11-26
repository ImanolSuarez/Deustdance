package deustDance;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PersonaTest {
	
	
	private Persona p;
	@Before
	public void setUp() {
		p = new Persona("Nombre1", "Apellidos1", "Usuario", "Contraseña", 67787765, "domicilio");
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Nombre1", p.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		p.setNombre("Nombre1");
		assertEquals("Nombre1", p.getNombre());
	}
	@Test
	public void testGetApellidos() {
		assertEquals("Apellidos1", p.getApellidos());
	}
	
	@Test
	public void testSetApellidos() {
		p.setApellidos("Apellidos1");
		assertEquals("Apellidos1", p.getApellidos());
		
	}
	
	@Test
	public void testGetUsuario() {
		assertEquals("Usuario", p.getUsuario());
		
	}
	
	@Test
	public void testSetUsuario() {
		p.setUsuario("Usuario");
		assertEquals("Usuario", p.getUsuario());
		
	}
	
	@Test
	public void testGetContrasenia() {
		assertEquals("Contraseña", p.getContrasenia());
	}
	@Test
	public void testSetContrasenia() {
		p.setContrasenia("Contraseña");
		assertEquals("Contraseña", p.getContrasenia());
	}
	@Test
	public void testgetTelefono() {
		assertEquals(67787765, p.getTelefono());
	}
	@Test
	public void testsetTelefono() {
		p.setTelefono(67787765);
		assertEquals(67787765, p.getTelefono());
	}
	@Test
	public void getDomicilio() {
		assertEquals("domicilio", p.getDomicilio());
	}
	@Test
	public void setDomicilio() {
		p.setDomicilio("domicilio");
		assertEquals("domicilio", p.getDomicilio());
	}
	@Test
	public void PersonaToString() {
		assertEquals("Persona [nombre=" + "Nombre1" + ", apellidos=" + "Apellidos1"  + ", usuario=" + "Usuario"
				+ ", contrasenia=" + "Contraseña" + ", telefono=" + 67787765 + ", domicilio=" + "domicilio" + "]", p.toString());
	}

}
