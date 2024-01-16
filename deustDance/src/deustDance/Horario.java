package deustDance;

public class Horario {
	Grupo grupo;
	Clase clase;
	Dias dia;
	int hora;
	
	public Horario(Grupo grupo, Clase clase, Dias dia, int hora) {
		super();
		this.grupo = grupo;
		this.clase = clase;
		this.dia = dia;
		this.hora = hora;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Dias getDia() {
		return dia;
	}

	public void setDia(Dias dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Horario [clase=" + clase + ", grupo=" + grupo + ", dia=" + dia + ", hora=" + hora + "]";
	}
	
	
}
