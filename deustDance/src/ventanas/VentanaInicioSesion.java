package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import deustDance.Academia;

public class VentanaInicioSesion extends JFrame{
	
	
	private JTextField textUsuario;
	private JPasswordField textContrasenia;
	private JLabel usuario;
	private JLabel contrasenia;
	private JButton botonValidar;
	
	
	
	public VentanaInicioSesion() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400,600);
		setTitle("Ventana inicio sesion");
		
		/*CEACION CON PANELES Y COMPONENTES*/
		
		JPanel panelNorte = new JPanel();
		JPanel panelCentro = new JPanel(new GridLayout(4,1));
		JPanel panelSur = new JPanel();
		
		JLabel textoBienvenida = new JLabel("BIENVENIDO A DEUSTDANCE");
		
		textUsuario = new JTextField();
		textContrasenia = new JPasswordField();
		
		usuario = new JLabel("Usuario: ");
		contrasenia = new JLabel("Contraseña");
		
		botonValidar = new JButton("Validar");
		
		
		/*EVENTOS*/
		
		/*
		botonValidar.addActionListener((e)->{
			
			String usuario = textUsuario.getText();
			String con = textContrasenia.getText();
			Alumno a = Academia.buscarAlumno(usuario);
			if(a == null) {
				JOptionPane.showMessageDialog(null, "ERROR. VOLVER A INTENTAR","ERROR",JOptionPane.ERROR_MESSAGE);
			}else {
				if(a.getContrasenia().equals(con)) {
					JOptionPane.showMessageDialog(null, "BIENVENIDO A DEUSTDANCE", "BIENVENIDO", JOptionPane.INFORMATION_MESSAGE);
					new VentanaPrincipal();
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "ERROR. CONTRASEÑA INCORRECTA", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		
		});
		
		*/
		
		
		
		
		/*AÑADIR LOS COMPONENTES AL PANEL Y A LA VENTA*/
		
		panelNorte.add(textoBienvenida);
		panelCentro.add(usuario);
		panelCentro.add(textUsuario);
		panelCentro.add(contrasenia);
		panelCentro.add(textContrasenia);
		panelSur.add(botonValidar);
		
		add(panelNorte, BorderLayout.NORTH);
		add(panelCentro, BorderLayout.CENTER);
		add(panelSur, BorderLayout.SOUTH);
		
		setVisible(true);
		
		
	}

}
