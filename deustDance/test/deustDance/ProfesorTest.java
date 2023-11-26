package deustDance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;



import org.junit.Before;
import org.junit.Test;

public class ProfesorTest {
	
	private Profesor p;
	
	@Before
	public void setUp() {
		p = new Profesor("Profesor", "Apellido", "usuario", "contraseña",677787767,"domicilio", null, 2, null, null);
	}
	
	@Test
	public void getGrupo() {
		assertEquals(2, p.getGrupo());
	}
	@Test
	public void setGrupo() {
		p.setGrupo(2);
		assertEquals(2, p.getGrupo());
	}
	@Test
	public void getListaAlumnos() {
		assertNull(p.getListaAlumnos());
	}
	@Test
	public void setListaAlumnos() {
		p.setListaAlumnos(null);
		assertNull(p.getListaAlumnos());
	}
	@Test
	public void getListaBailes() {
		assertNull(p.getListaBailes());
	}
	@Test
	public void setListaBailes() {
		p.setListaBailes(null);
		assertNull(p.getListaBailes());
	}
	@Test
	public void getListaClases() {
		assertNull(p.getListaClases());
	}
	@Test
	public void setListaClases() {
		p.setListaClases(null);
		assertNull(p.getListaClases());
	}
	
	@Test
	public void ProfesorToString() {
		//		p = new Profesor("Profesor", "Apellido", "usuario", "contraseña",677787767,"domicilio", null, 2, null, null);

		assertEquals("Profesor [listaAlumnos=" + null + ", grupo=" + 2 + ", listaBailes=" + null
				+ ", listaClases=" + null + ", getNombre()=" + "Profesor" + ", getApellidos()=" + "Apellido"
				+ ", getUsuario()=" + "usuario" + ", getContrasenia()=" + "contraseña" + ", getTelefono()="
				+ 677787767 + ", getDomicilio()=" + "domicilio"+ "]", p.toString());
	}
}
