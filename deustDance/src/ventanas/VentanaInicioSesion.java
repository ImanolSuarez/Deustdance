package ventanas;

import java.awt.BorderLayout;

import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import deustDance.Academia;
import deustDance.Alumno;
import deustDance.Persona;
import deustDance.Profesor;
import deustDance.Secretaria;


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
	private Logger logger = Logger.getLogger(VentanaInicioSesion.class.getName());
	
	
	
	public VentanaInicioSesion() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP,altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
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
				
				String usu = textUsuario.getText();
				@SuppressWarnings("deprecation")
				String contra = textContrasenia.getText();
				
				logger.info("Mirando si todos los campos estan rellenados");
				if(usu.length() == 0) {
					JOptionPane.showMessageDialog(null, "RELLENA TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else if(contra.length() == 0) {
					JOptionPane.showMessageDialog(null, "RELLENA TODOS LOS CAMPOS", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					logger.info("Mirando si es un alumno, profesor o secretario");
					Alumno a = Academia.buscarAlumno(usu);
					if(a == null) {
						Profesor p = Academia.buscarProfesor(usu);
						if(p == null) {
							Secretaria s = Academia.buscarSecretario(usu);
							if(s == null) {
								JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO", "ERROR", JOptionPane.ERROR_MESSAGE);
								
							}else if(s.getContrasenia().equals(contra)){
								JOptionPane.showMessageDialog(null, "BIENVENIDO A DEUSTDANCE", "INICIO DE SESION", JOptionPane.INFORMATION_MESSAGE);
								new VentanaSecretaria();
								setVisible(false);
								logger.info("Abriendo la ventana secretario");
							}else {
								JOptionPane.showMessageDialog(null, "CONTRASEÑA ERRONEA", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}else if(p.getContrasenia().equals(contra)){
							JOptionPane.showMessageDialog(null, "BIENVENIDO A DEUSTDANCE", "INICIO DE SESION", JOptionPane.INFORMATION_MESSAGE);
							new VentanaProfesor(new Profesor("Pepito", "Grillo", "PepitoElGrillo", "1234", 683625194, "", null, 0, null, null));//Ejemplo de prueba
							setVisible(false);
							logger.info("Abriendo la ventana profesor");
						}else {
							JOptionPane.showMessageDialog(null, "CONTRASEÑA ERRONEA", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}else if(a.getContrasenia().equals(contra)){
						JOptionPane.showMessageDialog(null, "BIENVENIDO A DEUSTDANCE", "INICIO DE SESION", JOptionPane.INFORMATION_MESSAGE);
						new VentanaAlumno();
						setVisible(false);
						logger.info("Abriendo la ventana alumno");
					}else {
						JOptionPane.showMessageDialog(null, "CONTRASEÑA ERRONEA", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
				
				
				
				textUsuario.setText("");
				textContrasenia.setText("");
				
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
		
		logger.info("Añadiendo los componentes a la ventana");
		
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
