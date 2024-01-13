package ventanas;

import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.*;

import deustDance.Alumno;


public class VentanaAlumno extends JFrame{
	private static final long serialVersionUID = 1L;
	
	// COMPONENETES DE LA VENTANA ALUMNO QUE HA INICIADO SESION
	public static Alumno alumno;
	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
	
	// PANEL PRINCIPAL
	protected static JPanel panelC;
	
	// TABLA
	protected static Tablas tabla;
	
	
	// DATOS 
	protected static JLabel labelFoto;
	protected static JPanel panelDatos;
	protected static JLabel botonEditar;
	protected static JLabel labelNombre;
	protected static JLabel labelApellido;
	protected static JLabel labelUsuario;
	protected static JLabel labelContraseña;
	protected static JLabel labelDomicilio;
	protected static JLabel labelProfesorAsignado;
	protected static JLabel labelClaseAsignada;
	protected static JLabel labelDinero;
	protected static JLabel labelGrupo;
	protected static JLabel labelCalificacion;
	
	//protected static JTextField textoNombre;
	//protected static JTextField textoApellidos;
	//protected static JTextField textoUsuario;
	//protected static JTextField textoContraseña;
	//protected static JTextField textoDomicilio;
	//protected static JTextField textoprofesorAsignado;
	//protected static JTextField textoclaseAsignada;
	//protected static JTextField textodinero;
	//protected static JTextField textogrupo;
	//protected static JTextField textocalificacion;
	//protected static JButton botonImprimirCalendar;
	protected static JButton botonCargarFoto;
	protected static VentanaSecretaria ventanaSecretaria;
	
	// PANELES
	protected static JPanel panelInformacionPersonal;
	protected static JPanel panelInformacionAcademica;
	
	public VentanaAlumno() {
		//AQUI CARGAR BASE DE DATOS Y LOGGER
		//PANELES
		panelC = new JPanel();
		panelC.setOpaque(false);
		panelInformacionPersonal = new JPanel();
		panelInformacionAcademica = new JPanel();
		
		// TABLAS
		tabla = new Tablas();
		
		panelInformacionPersonal.setLayout(new GridBagLayout());
		panelInformacionAcademica.setLayout(new BorderLayout());
		
		Border bordeInformacionPersonal = BorderFactory.createTitledBorder("Información personal");
		panelInformacionPersonal.setBorder(bordeInformacionPersonal);
		
		Border bordeInformacionAcademica = BorderFactory.createTitledBorder("Información académica");
		panelInformacionAcademica.setBorder(bordeInformacionAcademica);
		
		panelInformacionPersonal.setLayout(new GridLayout(7,2));
		
		// ELEMENTOS DE DATOS
		labelNombre = new JLabel("Nombre:		" + alumno.getNombre());
		labelApellido = new JLabel("Apellido:		" + alumno.getApellidos());
		labelUsuario = new JLabel("Usuario:		" + alumno.getUsuario());
		labelContraseña = new JLabel("Contraseña:		" + alumno.getContrasenia());
		labelDomicilio = new JLabel("Domicilio:		" + alumno.getDomicilio());
		labelProfesorAsignado = new JLabel("Profesor asignado		" + alumno.getProfesorAsignado());
		labelClaseAsignada = new JLabel("Clase asignada		" + alumno.getClaseAsignada());
		labelDinero = new JLabel("Dinero		" +  alumno.getDinero());
		labelGrupo = new JLabel("Grupo:		" +  alumno.getGrupo());
		labelCalificacion = new JLabel("Calificación:		" + alumno.getCalificacion());
		botonCargarFoto = new JButton("Cargar foto");
		//textoNombre = new JTextField(20);
		//textoApellidos = new JTextField(20);
		//textoUsuario = new JTextField(20);
		//textoContraseña = new JTextField(20);
		//textoDomicilio = new JTextField(20);
		//textoprofesorAsignado = new JTextField(20);
		//textoclaseAsignada = new JTextField(20);
		//textodinero = new JTextField(20);
		//textogrupo = new JTextField(20);
		//textocalificacion = new JTextField(20);
		//labelFoto = new JLabel();
		
		
		//textoNombre.setEditable(false);
		//textoApellidos.setEditable(false);
		//textoUsuario.setEditable(false);
		//textoContraseña.setEditable(false);
		//textoDomicilio.setEditable(false);
		//textoprofesorAsignado.setEditable(false);
		//textoclaseAsignada.setEditable(false);
		//textodinero.setEditable(false);
		//textogrupo.setEditable(false);
		//textocalificacion.setEditable(false);
		
		panelInformacionPersonal.add(labelNombre);
		
		panelInformacionPersonal.add(labelApellido);
		
		panelInformacionPersonal.add(labelUsuario);
		
		panelInformacionPersonal.add(labelContraseña);
		
		panelInformacionPersonal.add(labelDomicilio);
		
		panelInformacionPersonal.add(labelProfesorAsignado);
		
		panelInformacionPersonal.add(labelClaseAsignada);
		
		panelInformacionPersonal.add(labelDinero);
		
		panelInformacionPersonal.add(labelGrupo);
		
		panelInformacionPersonal.add(labelCalificacion);
		
		
		
		//JFILECHOOSER PARA QUE EL ALUMNO ELIJA LA FOTO
		
		JLabel etiquetaFoto = new JLabel();
		panelInformacionPersonal.add(etiquetaFoto);
				
		botonCargarFoto = new JButton("Cargar foto");
				
		botonCargarFoto.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int seleccionado = fileChooser.showOpenDialog(null);
						
				if (seleccionado == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					String rutaImagen = file.getAbsolutePath();
							
					ImageIcon imagenIcono = new ImageIcon(rutaImagen);
				    Image imagen = imagenIcono.getImage().getScaledInstance(etiquetaFoto.getWidth(), etiquetaFoto.getHeight(), Image.SCALE_SMOOTH);
				    ImageIcon imagenEscalada = new ImageIcon(imagen);
				            
				    etiquetaFoto.setIcon(imagenEscalada);
							
				}
			}
		});
		
		JLabel labelFoto = new JLabel();
		labelFoto.setIcon(new ImageIcon(getClass().getResource("")));
		
		JPanel panelBotonPersonal = new JPanel();
		panelInformacionPersonal.add(panelBotonPersonal, BorderLayout.SOUTH);
		panelBotonPersonal.add(botonCargarFoto);
	
		//////////////////////////////
		
		
		
		panelInformacionAcademica.add(new JLabel("Horario: "), BorderLayout.CENTER);
		JPanel panelBotonesAcademico = new JPanel();
		
		
		
		panelInformacionAcademica.add(panelBotonesAcademico, BorderLayout.SOUTH);
		
		this.add(panelInformacionPersonal, BorderLayout.WEST);
		this.add(panelInformacionAcademica, BorderLayout.EAST);
		
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Ventana del alumno");
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP,altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaAlumno();
	}
	
}