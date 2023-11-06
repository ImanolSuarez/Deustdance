package deustDance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonaTest {
	
	@Test
	public void testGetNombre() {
		Persona p1 = new Persona("Nombre1", "Apellidos1", "Usuario-Nombre1", "Contraseña-Nombre1");
		assertEquals("Nombre1", p1.getNombre());
	}
	
	@Test
	public void testGetApellidos() {
		Persona p2 = new Persona("Nombre2", "Apellidos2", "Usuario-Nombre2", "Contraseña-Nombre2");
		assertEquals("Apellidos2", p2.getApellidos());
		
	}
	@Test
	public void testGetUsuario() {
		Persona p3 = new Persona("Nombre3", "Apellidos3", "Usuario-Nombre3", "Contraseña-Nombre3");
		assertEquals("Usuario-Nombre3", p3.getUsuario());
		
	}
	@Test
	public void testGetContrasenia() {
		Persona p4 = new Persona("Nombre4", "Apellidos4", "Usuario-Nombre4", "Contraseña-Nombre4");
		assertEquals("Contraseña-Nombre4", p4.getContrasenia());
	}
}
