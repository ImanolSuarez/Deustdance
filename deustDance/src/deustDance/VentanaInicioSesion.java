package deustDance;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame{
	
	
	private JTextField textUsuario;
	private JPasswordField textContrasenia;
	private JLabel textoBienvenida;
	private JLabel usuario;
	private JLabel contrasenia;
	private JButton botonInicioSesion;
	private JButton botonRegistro;
	
	public VentanaInicioSesion() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400,600);
		setTitle("Ventana inicio sesion");
		
		/*CEACION CON PANELES Y COMPONENTES*/
		
		JPanel panelNorte = new JPanel();
		JPanel panelCentro = new JPanel(new GridLayout(4,1));
		JPanel panelSur = new JPanel(new GridLayout(1,2));
		
		
		
		textoBienvenida = new JLabel("BIENVENIDO A DEUSTDANCE");
		
		usuario = new JLabel("Usuario");
		contrasenia = new JLabel("Contraseña");
		textUsuario = new JTextField();
		textContrasenia = new JPasswordField();
		
		botonInicioSesion = new JButton("Inicio sesion");
		botonRegistro = new JButton("Registro");
		
		
		
		/*EVENTOS*/
		
		botonInicioSesion.addActionListener((e)->{
			
		
		});
		
		
		
		botonRegistro.addActionListener((e)->{
			new VentanaRegistro();
			setVisible(false);
		});
		
		
		/*AÑADIR LOS COMPONENTES AL PANEL Y A LA VENTA*/
		
		panelNorte.add(textoBienvenida);
		
		panelCentro.add(usuario);
		panelCentro.add(textUsuario);
		panelCentro.add(contrasenia);
		panelCentro.add(textContrasenia);
		
		panelSur.add(botonInicioSesion);
		panelSur.add(botonRegistro);
		
		
		
		
		add(panelNorte, BorderLayout.NORTH);
		add(panelCentro, BorderLayout.CENTER);
		add(panelSur, BorderLayout.SOUTH);
		
		
		
		setVisible(true);
		
		
	}

}
