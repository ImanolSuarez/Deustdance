package deustDance;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame{
	
	
	private JTextField textDni;
	private JPasswordField textContrasenia;
	private JLabel textoBienvenida;
	private JLabel dni;
	private JLabel contrasenia;
	private JButton botonInicioSesion;
	private JButton botonRegistro;
	private static final String nomFicheroAlumnos = "Alumnos.csv";
	
	public VentanaInicioSesion() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400,600);
		setTitle("Ventana inicio sesion");
		
		/*CEACION CON PANELES Y COMPONENTES*/
		
		JPanel panelNorte = new JPanel();
		JPanel panelCentro = new JPanel(new GridLayout(4,1));
		JPanel panelSur = new JPanel(new GridLayout(1,2));
		
		
		
		textoBienvenida = new JLabel("BIENVENIDO A DEUSTDANCE");
		
		dni = new JLabel("Dni: ");
		contrasenia = new JLabel("Contraseña");
		textDni = new JTextField(5);
		textContrasenia = new JPasswordField(5);
		
		botonInicioSesion = new JButton("Inicio sesion");
		botonRegistro = new JButton("Registro");
		
		
		
		/*EVENTOS*/
		
		botonInicioSesion.addActionListener((e)->{
			
			String dni = textDni.getText();
			String con = textContrasenia.getText();
			Alumno a = Academia.buscarAlumno(dni);
			if(a == null) {
				JOptionPane.showMessageDialog(null, "Para poder iniciar sesión tienes que estar registrado","ERROR",JOptionPane.ERROR_MESSAGE);
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
		
		
		
		botonRegistro.addActionListener((e)->{
			
			
		});
		
		
		/*AÑADIR LOS COMPONENTES AL PANEL Y A LA VENTA*/
		
		panelNorte.add(textoBienvenida);
		
		panelCentro.add(dni);
		panelCentro.add(textDni);
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
