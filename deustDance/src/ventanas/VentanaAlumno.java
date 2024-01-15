package ventanas;

import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.*;

import deustDance.Alumno;
import deustDance.BaseDatos;


public class VentanaAlumno extends JFrame{
	private static final long serialVersionUID = 1L;
	
	// COMPONENETES DE LA VENTANA ALUMNO QUE HA INICIADO SESION
	public static Alumno alumno;
	
	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
	
	// PANEL PRINCIPAL
	protected static JPanel panelC;
	
	// TABLA
	protected static Tablas tabla;
	
	// MENU
	protected static JMenuBar menuAlumno;
	protected static JMenu calificaciones;
	protected static JMenu horario;
	
	protected static JMenuItem cerrarSesion;
	protected static JMenuItem consultarCalificaciones;
	protected static JMenuItem consultarHorario;
	
	// DATOS PERSONALES
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
	
	// ELEMENTOS CURSOS
	protected static JPanel panelTablaCursos;
	protected static JPanel panelCampos;
	protected static JLabel añadir;
	protected static JLabel eliminar;
	protected static JLabel buscar;
	protected static JTextField textoBuscar;
	protected static JButton botonCargarFoto;
	
	// ELEMENTOS NOTAS
	protected static JTable tablaNotas;
	protected static JLabel botonExpediente;
	
	// ELEMENTOS HORARIO
	protected static JTable tablaHorario;
	
	// PANELES
	protected static JPanel panelInformacionPersonal;
	protected static JPanel panelInformacionAcademica;
	
	public VentanaAlumno() {
		//AQUI CARGAR BASE DE DATOS Y LOGGER
		
		BaseDatos.bd.logger();
		//PANELES
		panelC = new JPanel();
		panelC.setOpaque(false);
		panelInformacionPersonal = new JPanel();
		panelInformacionAcademica = new JPanel();
		
		// TABLAS
		tabla = new Tablas();
		
		
		// MENU
		menuAlumno = new JMenuBar();
		menuAlumno.setMargin(null);
		menuAlumno.setBackground(null);
		
		calificaciones = new JMenu("Calificaciones");
		consultarCalificaciones = new JMenuItem("Consultar");
		calificaciones.add(consultarCalificaciones);
		
		horario = new JMenu("Horario");
		consultarHorario = new JMenuItem("Consultar");
		horario.add(consultarHorario);
		
		menuAlumno.add(calificaciones);
		menuAlumno.add(horario);
		
		//ELEMENTOS DATOS PERSONALES
		panelInformacionPersonal.setLayout(new GridBagLayout());
		panelInformacionAcademica.setLayout(new BorderLayout());
		
		Border bordeInformacionPersonal = BorderFactory.createTitledBorder("Información personal");
		panelInformacionPersonal.setBorder(bordeInformacionPersonal);
		
		Border bordeInformacionAcademica = BorderFactory.createTitledBorder("Información académica");
		panelInformacionAcademica.setBorder(bordeInformacionAcademica);
		
		panelInformacionPersonal.setLayout(new GridLayout(7,2));
		
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
		
		// ELEMENTOS DE CURSOS
		panelTablaCursos = new JPanel();
		panelTablaCursos.setOpaque(false);
		panelCampos = new JPanel();
		panelCampos.setOpaque(false);
		
		añadir = new JLabel();
		ImageIcon icono1 = new ImageIcon("/imagenes/añadir.jpg");
		Image imagen1 = icono1.getImage();
		Image imagenFinal1 = imagen1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		añadir.setIcon(new ImageIcon(imagenFinal1));
		
		eliminar = new JLabel();
		ImageIcon icono2 = new ImageIcon("/imagenes/eliminar.png");
		Image imagen2 = icono2.getImage();
		Image imagenFinal2 = imagen2.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		eliminar.setIcon(new ImageIcon(imagenFinal2));
		
		buscar = new JLabel();
		ImageIcon icono3 = new ImageIcon("/imagenes/lupa.jpeg");
		Image imagen3 = icono3.getImage();
		Image imagenFinal3 = imagen3.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		buscar.setIcon(new ImageIcon(imagenFinal3));
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