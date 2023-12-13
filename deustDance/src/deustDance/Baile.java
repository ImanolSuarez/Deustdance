package deustDance;

public class Baile {
	private static int contador = 1;
	private int idBaile;
	private int idProfesor;
	private String descripcion;
	private Tipo tipoBaile;
	private double precio;
	private int horasDeClase;
	
	
	public Baile(int idProfesor, String descripcion, Tipo tipoBaile, double precio, int horasDeClase) {
		super();
		this.idBaile = contador;
		contador++;
		this.idProfesor = idProfesor;
		this.descripcion = descripcion;
		this.tipoBaile = tipoBaile;
		this.precio = precio;
		this.horasDeClase = horasDeClase;
		
	}
	

	public Baile( int idProfesor, String descripcion, String tipoBaile, double precio, int horasDeClase) {
		super();
		this.idBaile = contador;
		contador++;
		this.idProfesor = idProfesor;
		this.descripcion = descripcion;
		setTipoBaile(tipoBaile);
		this.precio = precio;
		this.horasDeClase = horasDeClase;
	}


	public Baile() {
		super();
		
	}
	
	
	
	
	public int getIdProfesor() {
		return idProfesor;
	}


	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}


	public int getIdBaile() {
		return idBaile;
	}


	public void setIdBaile(int idBaile) {
		this.idBaile = idBaile;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Tipo getTipoBaile() {
		return tipoBaile;
	}
	
	public String getTipoBaileStr() {
		return tipoBaile.toString();
	}

	public void setTipoBaile(Tipo tipoBaile) {
		this.tipoBaile = tipoBaile;
	}
	
	public void setTipoBaile(String tipo) {
		this.tipoBaile = Tipo.valueOf(tipo);
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getHorasDeClase() {
		return horasDeClase;
	}

	public void setHorasDeClase(int horasDeClase) {
		this.horasDeClase = horasDeClase;
	}


	@Override
	public String toString() {
		return "id: " + idBaile + ", tipo de baile: "+ tipoBaile + "descripcion: " + descripcion + ", precio: " + precio + "€"
				+ ", horas de clase: " + horasDeClase ;
	}

	
	
	
	
	
	

}
