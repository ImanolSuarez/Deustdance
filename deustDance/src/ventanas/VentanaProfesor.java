package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class VentanaProfesor extends JFrame {
	protected JTabbedPane pestañas;
	protected JButton botonImprimirCalendario;
	protected JTextField textoNombre;
	protected JTextField textoApellidos;
	protected JTextField textoDireccion;
	protected JTextField textoUsuario;
	protected JTextField textoContraseña;

	public VentanaProfesor() {
		pestañas = new JTabbedPane();
		textoNombre = new JTextField(15);
		textoApellidos = new JTextField(15);
		textoDireccion = new JTextField(15);
		textoUsuario = new JTextField(15);
		textoContraseña = new JTextField(15);
		
		botonImprimirCalendario= new JButton("Imprimir Calendario");
		
		JPanel panelInformacionPersonal = new JPanel();
		JPanel panelCalendario = new JPanel();
		JPanel panelInfoCalendario = new JPanel();
		
		panelInformacionPersonal.setLayout(new GridLayout(10, 1));
		panelInformacionPersonal.add(new JLabel("Nombre: "));
		panelInformacionPersonal.add(textoNombre);
		panelInformacionPersonal.add(new JLabel("Apellidos: "));
		panelInformacionPersonal.add(textoApellidos);
		panelInformacionPersonal.add(new JLabel("direccion: "));
		panelInformacionPersonal.add(textoDireccion);
		panelInformacionPersonal.add(new JLabel("Usuario: "));
		panelInformacionPersonal.add(textoUsuario);
		panelInformacionPersonal.add(new JLabel("Contraseña: "));
		panelInformacionPersonal.add(textoContraseña);
		
		panelCalendario.add(new JLabel("Calendario: "));
		panelCalendario.add(botonImprimirCalendario, BorderLayout.SOUTH);
		panelInfoCalendario.add(panelInformacionPersonal, BorderLayout.WEST);
		panelInfoCalendario.add(panelCalendario, BorderLayout.WEST);
		pestañas.addTab("Informacion Personal/horarios", panelInfoCalendario);
		this.add(pestañas);

		this.setSize(600, 400);
		this.setTitle("VentanaProfesor");
		this.setVisible(true);
	}
}
