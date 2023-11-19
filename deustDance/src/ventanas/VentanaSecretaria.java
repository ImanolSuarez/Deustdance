package ventanas;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import deustDance.Alumno;
import deustDance.Profesor;


public class VentanaSecretaria extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTabbedPane pestañas;
	protected JTextField txtNombre;
	protected JTextField txtApellidos;	
	protected JTextField txtUsuario;
	protected JTextField txtContrasenya;
	protected JTextField txtTelefono;
	protected JTextField txtDomicilio;
	protected JTextField txtBaileAsignado;
	protected JTextField txtProfesorAsignado;
	protected JTextField txtClaseAsignada;
	protected JSpinner spinnerDinero;
	protected JSpinner spinnerGrupo;
	protected JSpinner spinnerCalificacion;	
	
	protected JButton botonAnyadir;
	protected JButton botonModificar;
	protected JButton botonEliminar;
	
	
	protected JTextField txtNombreP;
	protected JSpinner spinnerGrupoP;
	protected JTextField txtDomicilioP;
	protected JTextField txtUsuarioP;
	protected JTextField txtContrasenyaP;
	protected JTextField txtTelefonoP;
	protected JButton botonAnyadirP;
	protected JButton botonModificarP;
	protected JButton botonEliminarP;
	
	public VentanaSecretaria() {
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		// Pestaña Alumnos
		txtNombre = new JTextField(20);
		txtApellidos = new JTextField(20);
		txtUsuario = new JTextField(20);
		txtContrasenya = new JTextField(20);
		txtTelefono = new JTextField(20);
		txtDomicilio = new JTextField(20);
		txtBaileAsignado = new JTextField(20);
		txtProfesorAsignado = new JTextField(20);
		txtClaseAsignada = new JTextField(20);
		
		spinnerDinero = new JSpinner();
		spinnerGrupo = new JSpinner();
		spinnerCalificacion = new JSpinner();

		
		botonAnyadir = new JButton("Añadir alumno");
		botonModificar = new JButton("Modificar alumno");
		botonEliminar = new JButton("Eliminar alumno");
		
		
		JPanel panelTexto = new JPanel();
		panelTexto.setLayout(new GridLayout(12,2));
        

		panelTexto.add(new JLabel("Nombre: "));
		panelTexto.add(txtNombre);
		panelTexto.add(new JLabel("Apellidos: "));
		panelTexto.add(txtApellidos);
		panelTexto.add(new JLabel("Usuario: "));
		panelTexto.add(txtUsuario);
		panelTexto.add(new JLabel("Contraseña: "));
		panelTexto.add(txtContrasenya);
		panelTexto.add(new JLabel("Teléfono: "));
		panelTexto.add(txtTelefono);
		panelTexto.add(new JLabel("Domicilio: "));
		panelTexto.add(txtDomicilio);
		panelTexto.add(new JLabel("Baile Asignado: "));
		panelTexto.add(txtBaileAsignado);
		panelTexto.add(new JLabel("Profesor Asignado: "));
		panelTexto.add(txtProfesorAsignado);
		panelTexto.add(new JLabel("Clase Asignada: "));
		panelTexto.add(txtClaseAsignada);
		panelTexto.add(new JLabel("Dinero: "));
		panelTexto.add(spinnerDinero);
		panelTexto.add(new JLabel("Grupo: "));
		panelTexto.add(spinnerGrupo);
		panelTexto.add(new JLabel("Calificación: "));
		panelTexto.add(spinnerCalificacion);

		
		botonAnyadir.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String apellidos = txtApellidos.getText();
				String usuario = txtUsuario.getText();
				String contrasenia = txtContrasenya.getText();
				String telefono = txtTelefono.getText();
				String domicilio = txtDomicilio.getText();
				// Falta el baileasignado
				//String profesorAsignado = txtProfesorAsignado.getText();
				//String claseAsignada = txtClaseAsignada.getText();
				double dinero = (double) spinnerDinero.getValue();
				int grupo = (int) spinnerGrupo.getValue();
				double calificacion = (double) spinnerCalificacion.getValue();
				
				Alumno nuevo = new Alumno();
				nuevo.setNombre(nombre);
				nuevo.setApellidos(apellidos);
				nuevo.setUsuario(usuario);
				nuevo.setContrasenia(contrasenia);
				nuevo.setTelefono(Integer.parseInt(telefono));
				nuevo.setDomicilio(domicilio);
				nuevo.setDinero(dinero);
				nuevo.setGrupo(grupo);
				nuevo.setCalificacion(calificacion);
				
				// El profesor debería ser seleccionado de una lista desplegable, asi como la clase, el grupo y el baile 
				// Falta guardar los datos en la base de datos
				spinnerGrupo.setValue(0);
				txtDomicilio.setText("");
				txtUsuario.setText("");
				txtContrasenya.setText("");
				txtTelefono.setText("");
			}
		});
		
		botonModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
				
			}
		});
		
		botonEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
				
			}
		});
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1,3));
		panelBotones.add(botonAnyadir);
		panelBotones.add(botonModificar);
		panelBotones.add(botonEliminar);
		
		
		JPanel panelDatos = new JPanel();
		panelDatos.setLayout(new GridLayout(2,1));
		panelDatos.add(panelTexto);
		panelDatos.add(panelBotones);
		
		JPanel panelListado = new JPanel();
		panelListado.add(new JLabel("Listado de Alumnos:"), BorderLayout.NORTH);
		
		JPanel panelAlumnos = new JPanel();
        panelAlumnos.add(panelDatos, BorderLayout.EAST);
        panelAlumnos.add(panelListado, BorderLayout.WEST);
        tabbedPane.addTab("Alumnos", panelAlumnos);

        // Pestaña Profesores
        txtNombreP = new JTextField();
		spinnerGrupoP = new JSpinner();
		txtDomicilioP = new JTextField();
		txtUsuarioP = new JTextField();
		txtContrasenyaP = new JTextField();
		txtTelefonoP = new JTextField();
		botonAnyadirP = new JButton("Añadir profesor");
		botonModificarP = new JButton("Modificar profesor");
		botonEliminarP = new JButton("Eliminar profesor");
		
		JPanel panelTextoP = new JPanel();
		panelTextoP.setLayout(new GridLayout(6,2));
        
		panelTextoP.add(new JLabel("Nombre y Apellidos: "));
		panelTextoP.add(txtNombreP);
		panelTextoP.add(new JLabel("Grupo: "));
		panelTextoP.add(spinnerGrupoP);
		panelTextoP.add(new JLabel("Domicilio: "));
		panelTextoP.add(txtDomicilioP);
		panelTextoP.add(new JLabel("Usuario: "));
		panelTextoP.add(txtUsuarioP);
		panelTextoP.add(new JLabel("Contraseña: "));
		panelTextoP.add(txtContrasenyaP);
		
		botonAnyadirP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreyapellidos = txtNombreP.getText();
				int grupo = (int) spinnerGrupoP.getValue();
				String domicilio = txtDomicilioP.getText(); 
				String usuario = txtUsuarioP.getText();
				String contrasenya = txtContrasenyaP.getText();
				String telefono = txtTelefonoP.getText();
				Profesor nuevo = new Profesor();
				nuevo.setNombre(nombreyapellidos);
				nuevo.setGrupo(grupo);
				nuevo.setDomicilio(domicilio);
				nuevo.setUsuario(usuario);
				nuevo.setContrasenia(contrasenya);
				nuevo.setTelefono(grupo);
				
				// Falta guardar los datos en la base de datos
				txtNombreP.setText("");
				spinnerGrupoP.setValue(0);
				txtDomicilioP.setText("");
				txtUsuarioP.setText("");
				txtContrasenyaP.setText("");
				txtTelefonoP.setText("");
			}
		});
		
		botonModificarP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
				
			}
		});
		
		botonEliminarP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
				
			}
		});
		
		JPanel panelBotonesP = new JPanel();
		panelBotonesP.setLayout(new GridLayout(1,3));
		panelBotonesP.add(botonAnyadirP);
		panelBotonesP.add(botonModificarP);
		panelBotonesP.add(botonEliminarP);
		
		
		JPanel panelDatosP = new JPanel();
		panelDatosP.setLayout(new GridLayout(2,1));
		panelDatosP.add(panelTextoP);
		panelDatosP.add(panelBotonesP);
		
		JPanel panelListadoP = new JPanel();
		panelListadoP.add(new JLabel("Listado de Profesores:"), BorderLayout.NORTH);
		
		JPanel panelProfesores = new JPanel();
		panelProfesores.add(panelDatosP, BorderLayout.EAST);
		panelProfesores.add(panelListadoP, BorderLayout.WEST);
        tabbedPane.addTab("Profesores", panelProfesores);

        // Pestaña Horario
        JPanel panelHorario = new JPanel();
        panelHorario.add(new JLabel("Contenido de la Pestaña 3"));
        tabbedPane.addTab("Horario", panelHorario);

        this.add(tabbedPane);	
		
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
		new VentanaSecretaria();
	}
}
