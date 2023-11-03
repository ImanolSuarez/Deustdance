package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import deustDance.Academia;
import deustDance.Persona;


public class VentanaInicioSesion extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textUsuario;
	private JPasswordField textContrasenia;
	private JLabel usuario;
	private JLabel contrasenia;
	private JButton botonValidar;
	
	
	
	public VentanaInicioSesion() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600,400);
		setTitle("Ventana inicio sesion");
		
		/*CEACION CON PANELES Y COMPONENTES*/
		
		JPanel panelNorte = new JPanel();
		JPanel panelCentro = new JPanel();
		JPanel panelSur = new JPanel();
		JPanel panelText = new JPanel(new GridLayout(4,1));
		JPanel panelImagen = new JPanel();
		
		JLabel labelFoto = new JLabel();
		JLabel textoBienvenida = new JLabel("BIENVENIDO A DEUSTDANCE");
		
		labelFoto.setIcon(new ImageIcon(getClass().getResource("/imagenes/imagenBaile.png")));
		
		textUsuario = new JTextField(20);
		textContrasenia = new JPasswordField(20);
		
		usuario = new JLabel("Usuario: ");
		contrasenia = new JLabel("Contraseña");
		
		botonValidar = new JButton("Validar");
		
		
		/*EVENTOS*/
		
		
		botonValidar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		
		
		
		
		
		
		/*AÑADIR LOS COMPONENTES AL PANEL Y A LA VENTA*/
		
		panelNorte.add(textoBienvenida);
		
		panelText.add(usuario);
		panelText.add(textUsuario);
		panelText.add(contrasenia);
		panelText.add(textContrasenia);
		
		panelCentro.add(panelText);
		
		panelImagen.add(labelFoto);
		
		panelSur.add(botonValidar);
		
		add(panelNorte, BorderLayout.NORTH);
		add(panelCentro, BorderLayout.CENTER);
		add(panelSur, BorderLayout.SOUTH);
		add(panelImagen, BorderLayout.EAST);
		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new VentanaInicioSesion();
	}

}
