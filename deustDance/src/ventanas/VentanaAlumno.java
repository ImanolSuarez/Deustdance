package ventanas;

import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.*;

import deustDance.Alumno;
import deustDance.BaseDatos;


public class VentanaAlumno extends JFrame{
	private static final long serialVersionUID = 1L;
	
	// COMPONENETES DE LA VENTANA ALUMNO QUE HA INICIADO SESION
	public static Alumno alumno;
	
	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
	
	ImagenPanel panel = new ImagenPanel ( new ImageIcon("/imagenes/fondoAlumno.jpg").getImage());
	
	
	// PANEL PRINCIPAL
	protected static JPanel panelC;
	
	// TABLA
	protected static Tablas tabla;
	
	// MENU
	protected static JMenuBar menuAlumno;
	protected static JMenu horario;
	protected static JMenu calificaciones;
	
	protected static JMenuItem cerrarSesion;
	protected static JMenuItem consultarHorario;
	protected static JMenuItem consultarCalificaciones;
	
	// DATOS PERSONALES
	protected static JLabel labelFoto;
	protected static JPanel panelDatos;
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
	protected static JPanel panelCampos;
	protected static JButton botonCargarFoto;
	
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
		panelCampos = new JPanel();
		panelCampos.setOpaque(false);
		
	
		panel.add(menuAlumno, BorderLayout.NORTH);
		panel.add(panelC, BorderLayout.CENTER);
		
		ImageIcon icono = new ImageIcon("/imagenes/icono1.png");
		this.setIconImage(icono.getImage());
		
		// ELEMENTOS DE NOTAS
		
		// ELEMENTOS DE HORARIO
		tablaHorario = tabla.tablaHorarioAlumno();
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
		
		
		// LISTENERS DEL MENU
		consultarHorario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tablaHorario = tabla.tablaHorarioAlumno();
				panelC.removeAll();
				panelC.revalidate();
				panelC.repaint();
				panelC.setLayout(new GridBagLayout());
				GridBagConstraints posicionTablaHorario = nuevaPosicion(0,0,1,1,100,100,150,100);
				posicionTablaHorario.weightx = 0.5;
				posicionTablaHorario.weighty = 0.2;
				
				for (int i = 0 ; i < tablaHorario.getRowCount(); i++) {
					if(Arrays.asList(1,3,5).contains(i)) {
						tablaHorario.setRowHeight(i,20);
					}else {
						tablaHorario.setRowHeight(i,81);
					}
				}
				tablaHorario.getTableHeader().setPreferredSize(new Dimension(tablaHorario.getWidth(),40));
				tablaHorario.getTableHeader().setBackground(new Color(146,180,255));
				panelC.add(new JScrollPane(tablaHorario), posicionTablaHorario);
				tablaHorario.revalidate();
				panelC.revalidate();
				panelC.repaint();
			}

			public static GridBagConstraints nuevaPosicion(int fila, int columna, int numFilas, int numColumnas, int top, int left, int bottom, int right) {
				GridBagConstraints constraint = new GridBagConstraints();
				constraint.gridx = columna;
				constraint.gridy = fila;
				constraint.gridwidth = numColumnas;
				constraint.gridheight = numFilas;
				constraint.insets = new Insets(top,left,bottom,right);
				constraint.fill = GridBagConstraints.BOTH;
				return constraint;
			}
		});
		// WINDOW LISTENER
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosed(WindowEvent e) {
				BaseDatos.closeBD(null);
				
			}
		
		});
		
		this.getContentPane().add(panel);
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				BaseDatos.initBD("BaseDeDatosAcademia");
				BaseDatos.bd.logger();
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