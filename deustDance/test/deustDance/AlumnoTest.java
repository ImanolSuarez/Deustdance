package deustDance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlumnoTest {
	
	
	
	
	
	@Test
	public void AlumnoToString() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500, 2, 5.00f);
		assertEquals("Nombre del alumno: " + "Nombre-1" + ", apellidos: " + "Apellido-1" + ", baile asignado: " + null + ", profesor asignado: " + null
	            + ", clase asignada: " + null + ", dinero: " + 500.0 + ", grupo: " + 2 + ", calificacion: " + 5.0
	            + ", usuario: " + "usuario" + ", contraseña: " + "contraseña", a.toString());
	}
	@Test
	public void getGrupo() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500, 2, 5.00f);
		assertEquals(2, a.getGrupo());
	}
	@Test
	public void setGrupo() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500, 2, 5.00f);
		a.setGrupo(2);
		assertEquals(2, a.getGrupo());
	}
	@Test
	public void getBaileAsignado() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500, 2, 5.00f);
		assertEquals(null, a.getBaileAsignado());
	}
	@Test
	public void setBaileAsignado() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500, 2, 5.00f);
		a.setBaileAsignado(null);
		assertEquals(null, a.getBaileAsignado());
	}
	@Test
	public void getProfesorAsignado() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500, 2, 5.00f);
		assertEquals(null, a.getProfesorAsignado());
	}
	@Test
	public void setProfesorAsignado() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500, 2, 5.00f);
		a.setProfesorAsignado(null);;
		assertEquals(null, a.getProfesorAsignado());
	}
	@Test
	public void getDinero() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500.00f, 2, 5.00f);
		assertEquals(500.00, a.getDinero(), 0);
	}
	@Test
	public void setDinero() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500, 2, 5.00f);
		a.setDinero(500);
		assertEquals(500, a.getDinero(), 0);
	}
	@Test
	public void getClaseAsignada() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500, 2, 5.00f);
		assertEquals(null, a.getClaseAsignada());
	}
	@Test
	public void setClaseAsignada() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500, 2, 5.00f);
		a.setClaseAsignada(null);;
		assertEquals(null, a.getClaseAsignada());
	}
	@Test
	public void getClalificacion() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500, 2, 5.00f);
		assertEquals(5.00, a.getCalificacion(), 0);
	}
	@Test
	public void setCalificacion() {
		Alumno a = new Alumno("Nombre-1", "Apellido-1", "usuario", "contraseña", null, null, null, 500, 2, 5.00f);
		a.setCalificacion(5.00);
		assertEquals(5.00, a.getCalificacion(), 0);
	}
	
	
	
	

}
