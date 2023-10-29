package ventanas;

import java.awt.BorderLayout;
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

public class VentanaSecretaria extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTabbedPane pestañas;
	protected JTextField txtNombre;
	protected JSpinner spinnerGrupo;
	protected JTextField txtDomicilio;
	protected JTextField txtUsuario;
	protected JTextField txtContrasenya;
	protected JTextField txtTelefono;
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
		txtNombre = new JTextField();
		spinnerGrupo = new JSpinner();
		txtDomicilio = new JTextField();
		txtUsuario = new JTextField();
		txtContrasenya = new JTextField();
		txtTelefono = new JTextField();
		botonAnyadir = new JButton("Añadir alumno");
		botonModificar = new JButton("Modificar alumno");
		botonEliminar = new JButton("Eliminar alumno");
		
		JPanel panelTexto = new JPanel();
		panelTexto.setLayout(new GridLayout(6,2));
        
		panelTexto.add(new JLabel("Nombre y Apellidos: "));
		panelTexto.add(txtNombre);
		panelTexto.add(new JLabel("Grupo: "));
		panelTexto.add(spinnerGrupo);
		panelTexto.add(new JLabel("Domicilio: "));
		panelTexto.add(txtDomicilio);
		panelTexto.add(new JLabel("Usuario: "));
		panelTexto.add(txtUsuario);
		panelTexto.add(new JLabel("Contraseña: "));
		panelTexto.add(txtContrasenya);
		
		botonAnyadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreyapellidos = txtNombre.getText();
				int grupo = (int) spinnerGrupo.getValue();
				String domicilio = txtDomicilio.getText(); 
				String usuario = txtUsuario.getText();
				String contrasenya = txtContrasenya.getText();
				String telefono = txtTelefono.getText();
				// Alumno nuevo = new Alumno(nombreyapellidos,grupo,domicilio,usuario,contrasenya,telefono);
				// Falta guardar los datos en la base de datos
				txtNombre.setText("");
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
				// Profesor nuevo = new Profesor(nombreyapellidos,grupo,domicilio,usuario,contrasenya,telefono);
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
		this.setSize(600, 400);
		this.setVisible(true);
	}
}
