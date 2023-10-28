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
	private JLabel dni;
	private JLabel contrasenia;
	private JButton botonValidar;
	
	
	
	public VentanaInicioSesion() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400,600);
		setTitle("Ventana inicio sesion");
		
		/*CEACION CON PANELES Y COMPONENTES*/
		
		JPanel panelNorte = new JPanel();
		
		JLabel textoBienvenida = new JLabel("BIENVENIDO A DEUSTDANCE");
		
		
		/*EVENTOS*/
		
		/*
		botonValidar.addActionListener((e)->{
			
			String dni = textDni.getText();
			String con = textContrasenia.getText();
			Alumno a = Academia.buscarAlumno(dni);
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
		
		add(panelNorte, BorderLayout.NORTH);
		
		
		setVisible(true);
		
		
	}

}
