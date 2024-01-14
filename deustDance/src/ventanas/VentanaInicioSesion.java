package ventanas;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;
import deustDance.Academia;
import deustDance.Alumno;
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
	private ArrayList<String> listaImagenes;
	private JLabel labelFoto;
	private JLabel labelLogo;
	private JLabel condiciones;
	private JCheckBox checkCondiciones;
	private JProgressBar barraProgreso;
	private Timer time;
	private JLabel labelFoto2;
	
	
	
	public VentanaInicioSesion() {
		
		this.setTitle("LOGIN");
		this.setSize(400,600);
		this.setLayout(null);
		this.setBounds(500, 100, 500, 600);
		this.setResizable(false);
		/*CARGAMOS LA IMAGEN DEL FONDO*/
		String imagePath = "/imagenes/fondoLogin.jpg";
		this.setContentPane(new JLabel(new ImageIcon(getClass().getResource(imagePath))));
		
		
		/*CEACION CON PANELES Y COMPONENTES*/ 
		
		JLabel textoBienvenida = new JLabel("BIENVENIDO A DEUSTDANCE");
		
		textoBienvenida.setBounds(145, 0, 200, 130);
		textoBienvenida.setFont(new Font("Agency FB", Font.BOLD, 20));
		textoBienvenida.setForeground(Color.WHITE);
		add(textoBienvenida);
		
		labelFoto = new JLabel();
		labelFoto2 = new JLabel(new ImageIcon(getClass().getResource("/imagenes/imagenBaile.png")));
		ImageIcon imagenLogo = (new ImageIcon(getClass().getResource("/imagenes/imagenLogo.png")));
		setIconImage(imagenLogo.getImage());
		
		listaImagenes = new ArrayList<>();
		listaImagenes.add("/imagenes/imagenHilo1.png");
		listaImagenes.add("/imagenes/imagenHilo2.png");
		listaImagenes.add("/imagenes/imagenHilo3.jpg");
		listaImagenes.add("/imagenes/imagenHilo4.jpg");
		
		Thread hiloImagenes= new Thread(new Runnable() {
			@Override
			public void run() {
				
				for (int i=0;i<listaImagenes.size();i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					logger.info("Hilo. Cargando imagenes");
					cambiarImagen(listaImagenes.get(i));
					if (i==listaImagenes.size()-1) {
						i=0;
					}
				}	
			}		
		});
		
		hiloImagenes.setDaemon(true);
		hiloImagenes.start();
		
		barraProgreso = new JProgressBar();
		
		usuario = new JLabel("Usuario:");
		usuario.setForeground(Color.WHITE);
		
		textUsuario = new JTextField(20);
		
		contrasenia = new JLabel("Contraseña");
		contrasenia.setForeground(Color.WHITE);
		
		textContrasenia = new JPasswordField(20);
		
		botonValidar = new JButton("VALIDAR");
		
		condiciones = new JLabel("Aceptar terminos y condiciones");
		condiciones.setForeground(Color.WHITE);
		
		checkCondiciones = new JCheckBox();
		
		time = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkCondiciones.isSelected()) {
					int value = barraProgreso.getValue();
					if(value < 100) {
						barraProgreso.setValue(value + 10);
					}else {
						time.stop();
					}
				}
				
			}
		});
		
		checkCondiciones.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				 if (e.getStateChange() == ItemEvent.SELECTED) {
					 logger.info("Ha clicado el checkBox");
	                    barraProgreso.setVisible(true);
	                    barraProgreso.setValue(0);
	                    time.start();
	               } else {
	            	   logger.info("Todavia no ha clicado el checkBox");
	                    barraProgreso.setVisible(false);
	                    botonValidar.setEnabled(false);
	                    time.stop();
	                }
	            }
		});
		time.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (barraProgreso.getValue() >= 95) {
		        	logger.info("Barra progreso ha llegado a 100. Se habilita el boton");
		            System.out.println(barraProgreso.getValue());
		            botonValidar.setEnabled(true);
		            time.stop();
		            JOptionPane.showMessageDialog(null, "REGISTRO VALIDADO CORRECTAMENTE");
		        } else {
		        	logger.info("Todavia no ha llegado la barra de progreso a 100");
		            botonValidar.setEnabled(false);
		        }
		    }
		});
		barraProgreso.setStringPainted(true);
		barraProgreso.setVisible(false);
		botonValidar.setEnabled(false);
		
		
		logger.info("Cargando componenetes a la ventana");
		
		labelFoto.setBounds(235, 110, 220, 125);
		this.add(labelFoto);
		
		labelFoto2.setBounds(10, 110, 220, 125);
		this.add(labelFoto2);
		
		usuario.setBounds(160, 250, 150, 30);
		add(usuario);
		
		textUsuario.setBounds(160, 275, 150, 30);
		this.add(textUsuario);
		
		contrasenia.setBounds(160, 325, 150, 30);
		this.add(contrasenia);
			
		textContrasenia.setBounds(160, 350, 150, 30);
		this.add(textContrasenia);
		
		condiciones.setBounds(180, 390, 150, 30);
		this.add(condiciones);
		
		checkCondiciones.setBounds(160, 400, 18, 17);
		this.add(checkCondiciones);
		
		botonValidar.setBounds(160, 450, 150, 30);
		add(botonValidar);
		
		barraProgreso.setBounds(160, 420, 150, 20);
		add(barraProgreso);
		
		
		
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
							new VentanaProfesor(p);
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
	
		 
		setVisible(true);
		
		
	}
	public void cambiarImagen(String ruta) {
		ImageIcon iconoImagen= new ImageIcon(getClass().getResource(ruta));
		Image imagenEscalada= iconoImagen.getImage().getScaledInstance(240, 125, java.awt.Image.SCALE_SMOOTH);
		labelFoto.setIcon(new ImageIcon(imagenEscalada));
	}
	
	public static void main(String[] args) {
		new VentanaInicioSesion();
	}
	

}
