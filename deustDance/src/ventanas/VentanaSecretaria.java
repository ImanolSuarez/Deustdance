package ventanas;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import deustDance.Academia;
import deustDance.Alumno;
import deustDance.BaseDatos;
import deustDance.Main;
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
	protected JButton botonTerminarRegistro;
	
	
	protected JTextField txtNombreP;
	protected JSpinner spinnerGrupoP;
	protected JTextField txtDomicilioP;
	protected JTextField txtUsuarioP;
	protected JTextField txtContrasenyaP;
	protected JTextField txtTelefonoP;
	protected JButton botonAnyadirP;
	protected JButton botonModificarP;
	protected JButton botonEliminarP;
	
	Connection con = BaseDatos.initBD("DeustDance.db");
	
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
		botonTerminarRegistro = new JButton("Terminar registro");
		
		
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
				String baileAsignado = txtBaileAsignado.getText();
				String profesorAsignado = txtProfesorAsignado.getText();
				String claseAsignada = txtClaseAsignada.getText();
				String dinero =  spinnerDinero.getValue().toString();
				String grupo =  spinnerGrupo.getValue().toString();
				String calificacion =  spinnerCalificacion.getValue().toString();
				
				if(!nombre.isEmpty() &&!apellidos.isEmpty() &&!usuario.isEmpty() &&!contrasenia.isEmpty() &&!domicilio.isEmpty() &&!baileAsignado.isEmpty() &&!profesorAsignado.isEmpty()&&!claseAsignada.isEmpty() && !telefono.isEmpty()) {
					try {
						int tel = Integer.parseInt(telefono);
						int baile = Integer.parseInt(baileAsignado);
						int profesor = Integer.parseInt(profesorAsignado);
						int clase = Integer.parseInt(claseAsignada);
						double din 	= Double.parseDouble(dinero);
						int grup = Integer.parseInt(grupo);
						double califi = Double.parseDouble(calificacion);
						if(nombreCorrecto(nombre) && apellidoCorrecto(apellidos) && usuarioCorrecto(usuario) && contraCorrecto(contrasenia) && tfCorrecto(telefono) && domicilioCorrecto(domicilio)
								&& baileCorrecto(baileAsignado) && profeCorrecto(profesorAsignado) && claseCorrecto(claseAsignada)) {
								Alumno a = new Alumno(nombre, apellidos, usuario, contrasenia, tel, domicilio, baile, profesor, clase, din, grup, califi);
								if(BaseDatos.buscarAlumno(con, usuario) == null) {
									Academia.anyadirAlumno(a);
									JOptionPane.showMessageDialog(null, "REGISTRO REALIZADO CORRECTAMENTE");
								}else {
									JOptionPane.showMessageDialog(null, "USUARIO YA EXISTENTE");
								}
								
						}else {
							JOptionPane.showMessageDialog(null, "ERROR EN EL FORMATO");
						}
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "ERROR NUMERICO");
					}
				}else {
					JOptionPane.showMessageDialog(null, "REGISTRO INCORRECTO");
				}
				// El profesor debería ser seleccionado de una lista desplegable, asi como la clase, el grupo y el baile 
				// Falta guardar los datos en la base de datos
				
				txtNombre.setText("");
				txtApellidos.setText("");
				txtUsuario.setText("");
				txtContrasenya.setText("");
				txtTelefono.setText("");
				txtDomicilio.setText("");
				txtBaileAsignado.setText("");
				txtProfesorAsignado.setText("");
				txtClaseAsignada.setText("");
				spinnerDinero.setValue(0);
				spinnerGrupo.setValue(0);
				spinnerCalificacion.setValue(0);
				
			}
		});
		
		botonTerminarRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Academia.guardarDatosAlumno("resources/alumnos.csv");
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				
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
				String usuario = txtUsuario.getText();
				BaseDatos.eliminarAlumno(con, usuario);
				if(BaseDatos.buscarAlumno(con, usuario) == null) {
					JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO");
				}else {
					JOptionPane.showMessageDialog(null, "EL USUARIO NO SE PUDO ELIMINAR, REVISE LOS DATOS");
				}
				
			}
		});
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1,4));
		panelBotones.add(botonAnyadir);
		panelBotones.add(botonModificar);
		panelBotones.add(botonEliminar);
		panelBotones.add(botonTerminarRegistro);
		
		
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
				String grupo = spinnerGrupoP.getValue().toString();
				String domicilio = txtDomicilioP.getText(); 
				String usuario = txtUsuarioP.getText();
				String contra = txtContrasenyaP.getText();
				String tf = txtTelefonoP.getText();
				
				if(!nombreyapellidos.isEmpty() && !domicilio.isEmpty() && !usuario.isEmpty() && !contra.isEmpty() && !tf.isEmpty() ) {
					try {
						int grup = Integer.parseInt(grupo);
						int telefono = Integer.parseInt(tf);
						if(nombreCorrecto(nombreyapellidos) && domicilioCorrecto(domicilio) && usuarioCorrecto(usuario) && contraCorrecto(contra) && tfCorrecto(tf)) {
							JOptionPane.showMessageDialog(null, "REGISTRO REALIZADO CORRECTAMENTE");
						}else {
							JOptionPane.showMessageDialog(null, "ERROR EN EL FORMATO");
						}
					}catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "ERROR NUMERICO");
					}
				}
				
				/*
				nuevo.setNombre(nombreyapellidos);
				nuevo.setGrupo(grupo);
				nuevo.setDomicilio(domicilio);
				nuevo.setUsuario(usuario);
				nuevo.setContrasenia(contrasenya);
				nuevo.setTelefono(grupo);
				*/
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
	private boolean nombreCorrecto(String nombre) {
		String patron = "[A-Z][a-z]{2,7}";
		return Pattern.matches(patron, nombre);
	}
	private boolean apellidoCorrecto(String apellido) {
		String patron = "[A-Z][a-z]{3,10}";
		return Pattern.matches(patron, apellido);
	}
	private boolean usuarioCorrecto(String usuario) {
		String patron = "[A-Za-z]{4,}[0-9]*";
		return Pattern.matches(patron, usuario);
	}
	private boolean contraCorrecto(String contra) {
		String patron = "[A-Za-z]{5,}[0-9]*";
		return Pattern.matches(patron, contra);
	}
	private boolean tfCorrecto(String tf) {
		String patron = "[6][0-9]{8,9}";
		return Pattern.matches(patron, tf);
	}
	private boolean domicilioCorrecto(String domicilio) {
		String patron = "[A-Z][a-z]{3,15}";
		return Pattern.matches(patron, domicilio);
	}
	private boolean baileCorrecto(String baileAsig) {
		try {
			int num = Integer.parseInt(baileAsig);
			return num >=1 && num <= 9;
		}catch (NumberFormatException | NullPointerException e) {
			return false;
		}
	}
	private boolean profeCorrecto(String profeAsig) {
		try {
			int num = Integer.parseInt(profeAsig);
			return num >=1 && num <= 9;
		}catch (NumberFormatException | NullPointerException e) {
			return false;
		}
	}
	private boolean claseCorrecto(String claseAsig) {
		try {
			int num = Integer.parseInt(claseAsig);
			return num >=1 && num <= 9;
		}catch (NumberFormatException | NullPointerException e) {
			return false;
		}
	}
	private boolean nombreyApellidoP(String texto) {
		String formato = "[A-Z][a-z]}{2,7}/s[A-Z][a-z]{3,10}";
		return Pattern.matches(texto, formato);
	}
}
