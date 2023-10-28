package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaProfesor extends JFrame {
	protected JButton botonImprimirCalendario;
	protected JLabel LabelNombre;
	protected JTextField TextoNombre;
	protected JLabel LabelApellidos;
	protected JTextField TextoApellidos;
	protected JLabel usuario;
	

	
	public VentanaProfesor() {
		
		
		this.setSize(800, 800);
		this.setTitle("VentanaProfesor");
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new VentanaProfesor();
	}
}
