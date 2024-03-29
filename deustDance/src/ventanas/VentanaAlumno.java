package ventanas;

import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.border.*;

import deustDance.Alumno;
import deustDance.BaseDatos;


public class VentanaAlumno extends JFrame{
	private static final long serialVersionUID = 1L;
	
	Connection con = BaseDatos.initBD("DeustDance.db");
	// COMPONENETES DE LA VENTANA ALUMNO QUE HA INICIADO SESION
	public static Alumno alumno;
	
	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
	
	
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
	
	protected JTextField textoNombre;
	protected JTextField textoApellido;
	protected JTextField textoUsuario;
	protected JTextField textoContraseña;
	protected JTextField textoDomicilio;
	protected JTextField textoProfesorAsignado;
	protected JTextField textoClaseAsignada;
	protected JTextField textoDinero;
	protected JTextField textoGrupo;
	protected JTextField textoCalificacion;

	
	protected Alumno a;
	

	
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
		
		/*A*/
		String usuario = VentanaInicioSesion.textUsuario.toString();

		a = BaseDatos.obtenerAlumno(con, usuario);
		

		Alumno a = BaseDatos.obtenerAlumno(con, usuario);

		
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
		
		labelNombre = new JLabel("Nombre: ");
		labelApellido = new JLabel("Apellido: ");
		labelUsuario = new JLabel("Usuario: ");
		labelContraseña = new JLabel("Contraseña: ");
		labelDomicilio = new JLabel("Domicilio: ");
		labelProfesorAsignado = new JLabel("Profesor asignado: ");
		labelClaseAsignada = new JLabel("Clase asignada: ");
		labelDinero = new JLabel("Dinero: ");
		labelGrupo = new JLabel("Grupo: ");
		labelCalificacion = new JLabel("Calificación: ");
		botonCargarFoto = new JButton("Cargar foto");
		
		textoNombre = new JTextField(20);
		textoNombre.setText(a.getNombre());
		textoApellido = new JTextField(20);
		textoUsuario = new JTextField(20);
		textoContraseña = new JTextField(20);
		textoDomicilio = new JTextField(20);
		textoProfesorAsignado = new JTextField(20);
		textoClaseAsignada = new JTextField(20);
		textoDinero = new JTextField(20);
		textoGrupo = new JTextField(20);
		textoCalificacion = new JTextField(20);
		
		labelNombre.setBounds(20, 10, 50, 50);
		add(labelNombre);
		
		textoNombre.setBounds(20, 10, 50, 50);
		add(textoNombre);
		textoNombre.setEditable(false);
		
		labelApellido.setBounds(20, 10, 50, 50);
		add(labelApellido);
		
		textoApellido.setBounds(20, 10, 50, 50);
		add(textoApellido);
		textoApellido.setEditable(false);
		
		labelUsuario.setBounds(20, 10, 50, 50);
		add(labelUsuario);
		
		textoUsuario.setBounds(20, 10, 50, 50);
		add(textoUsuario);
		textoUsuario.setEditable(false);
		
		labelContraseña.setBounds(20, 10, 50, 50);
		add(labelContraseña);
		
		textoContraseña.setBounds(20, 10, 50, 50);
		add(textoContraseña);
		textoContraseña.setEditable(false);
		
		labelDomicilio.setBounds(20, 10, 50, 50);
		add(labelDomicilio);
		
		textoDomicilio.setBounds(20, 10, 50, 50);
		add(textoDomicilio);
		textoDomicilio.setEditable(false);
		
		labelProfesorAsignado.setBounds(20, 10, 50, 50);
		add(labelProfesorAsignado);
		
		textoProfesorAsignado.setBounds(20, 10, 50, 50);
		add(textoProfesorAsignado);
		textoProfesorAsignado.setEditable(false);
		
		labelClaseAsignada.setBounds(20, 10, 50, 50);
		add(labelClaseAsignada);
		
		textoClaseAsignada.setBounds(20, 10, 50, 50);
		add(textoClaseAsignada);
		textoClaseAsignada.setEditable(false);
		
		labelDinero.setBounds(20, 10, 50, 50);
		add(labelDinero);
		
		textoDinero.setBounds(20, 10, 50, 50);
		add(textoDinero);
		textoDinero.setEditable(false);
		
		labelGrupo.setBounds(20, 10, 50, 50);
		add(labelGrupo);
		
		textoGrupo.setBounds(20, 10, 50, 50);
		add(textoGrupo);
		textoGrupo.setEditable(false);
		
		labelCalificacion.setBounds(20, 10, 50, 50);
		add(labelCalificacion);
		
		textoCalificacion.setBounds(20, 10, 50, 50);
		add(textoCalificacion);
		textoCalificacion.setEditable(false);
		
		panelInformacionPersonal.add(labelNombre);
		panelInformacionPersonal.add(labelApellido);
		panelInformacionPersonal.add(labelUsuario);
		panelInformacionPersonal.add(labelContraseña);
		panelInformacionPersonal.add(labelDomicilio);
		panelInformacionPersonal.add(labelProfesorAsignado);
		panelInformacionPersonal.add(labelClaseAsignada);
		panelInformacionPersonal.add(labelDinero);
		
		// ELEMENTOS DE CURSOS
		panelCampos = new JPanel();
		panelCampos.setOpaque(false);
		
	
		panelC.add(menuAlumno, BorderLayout.NORTH);
		
		
		ImageIcon icono = new ImageIcon("/imagenes/icono1.png");
		this.setIconImage(icono.getImage());
		
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
		
		this.getContentPane().add(panelC);
		
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