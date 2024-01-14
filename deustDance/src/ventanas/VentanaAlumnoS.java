package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import deustDance.Academia;
import deustDance.Alumno;
import deustDance.BaseDatos;

public class VentanaAlumnoS extends JFrame{
	
	Connection con = BaseDatos.initBD("DeustDance.db");
	
	private JLabel labelNombre;
	private JLabel labelApellidos;
	private JLabel labelUsuario;
	private JLabel labelContrasenia;
	private JLabel labelGrupo;
	private JLabel labelDomicilio;
	private JLabel labelTelefono;
	private JLabel labelBaileAsig;
	private JLabel labelProfeAsig;
	private JLabel labelClaseAsig;
	private JLabel labelDinero;
	private JLabel labelCalificacion;
	
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
	
	private JButton botonAnyadir;
	private JButton botonBorrar;
	private JButton botonSeleccionar;
	private JButton botonModificar;
	private JButton botonSalir;
	private JButton botonP;
	private JButton botonH;
	
	private Logger logger = Logger.getLogger(VentanaAlumnoS.class.getName());
	
	protected DefaultListModel<String> modeloListaA;
	protected JList<String> listaAlumno;
	protected JScrollPane scrollLista;
	
	public VentanaAlumnoS() {
		
		this.setTitle("Ventana alumno secretaria");
		this.setSize(400,600);
		this.setLayout(null);
		this.setBounds(500, 100, 1000, 500);
		this.setResizable(false);
		
		JLabel labelT = new JLabel("REGISTRO DE DATOS DEL ALUMNO");
		labelT.setFont(new Font("Agency FB", Font.ROMAN_BASELINE, 20));
		labelT.setForeground(Color.BLACK);
		
		JLabel labelTexto = new JLabel("Listado de alumnos");
		labelTexto.setFont(new Font("Agency FB", Font.BOLD, 20));
		labelTexto.setForeground(Color.BLACK);
			
		labelNombre = new JLabel("Nombre: ");
		labelNombre.setForeground(Color.BLACK);
		
		labelApellidos = new JLabel("Apellido: ");
		labelApellidos.setForeground(Color.BLACK);
		
		labelUsuario = new JLabel("Usuario: ");
		labelUsuario.setForeground(Color.BLACK);
		
		labelContrasenia = new JLabel("Contraseña: ");
		labelContrasenia.setForeground(Color.BLACK);
		
		labelDomicilio = new JLabel("Domicilio: ");
		labelDomicilio.setForeground(Color.BLACK);
		
		labelTelefono = new JLabel("Telefono: ");
		labelTelefono.setForeground(Color.BLACK);
		
		labelGrupo = new JLabel("Grupo: ");
		labelGrupo.setForeground(Color.BLACK);
		
		labelBaileAsig = new JLabel("Baile asignado: ");
		labelBaileAsig.setForeground(Color.BLACK);
		
		labelProfeAsig = new JLabel("Profesor asignado: ");
		labelProfeAsig.setForeground(Color.BLACK);
		
		labelClaseAsig = new JLabel("Clase asignado: ");
		labelClaseAsig.setForeground(Color.BLACK);
		
		labelDinero = new JLabel("Dinero: ");
		labelDinero.setForeground(Color.BLACK);
		
		labelCalificacion = new JLabel("Calificacion: ");
		labelCalificacion.setForeground(Color.BLACK);
		
		
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
		
		botonAnyadir = new JButton("Añadir");
		botonBorrar = new JButton("Borrar");
		botonModificar = new JButton("Modificar");
		botonSeleccionar = new JButton("Seleccionar");
		botonH = new JButton("Horario");
		botonP = new JButton("Alumnos");
		botonSalir = new JButton("Salir");
		
		
		/*CREACION DE LA JList*/
		
		modeloListaA = new DefaultListModel<>();
		listaAlumno = new JList<>(modeloListaA);
		scrollLista = new JScrollPane(listaAlumno);
		scrollLista.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		cargarJListAlumnos();
		scrollLista.setBounds(720, 120, 200, 200);
		add(scrollLista);
		
		logger.info("añadiendo los componentes a la ventana");
		
		labelNombre.setBounds(60, 10, 100, 130);
		add(labelNombre);
		
		txtNombre.setBounds(60, 90, 140, 30);
		add(txtNombre);
		
		labelApellidos.setBounds(60, 80, 100, 130);
		add(labelApellidos);
		
		txtApellidos.setBounds(60, 160, 140, 30);
		add(txtApellidos);
		
		labelUsuario.setBounds(60, 190, 140, 30);
		add(labelUsuario);
		
		txtUsuario.setBounds(60, 220, 140, 30);
		add(txtUsuario);
		
		labelContrasenia.setBounds(60, 250, 140, 30);
		add(labelContrasenia);
		
		txtContrasenya.setBounds(60, 280, 140, 30);
		add(txtContrasenya);
		
		labelDomicilio.setBounds(320,60, 140, 30);
		add(labelDomicilio);
		
		txtDomicilio.setBounds(320,90, 140, 30);
		add(txtDomicilio);
		
		labelTelefono.setBounds(320,130, 140, 30);
		add(labelTelefono);
		
		txtTelefono.setBounds(320,160, 140, 30);
		add(txtTelefono);
		
		labelGrupo.setBounds(320,190, 140, 30);
		add(labelGrupo);
		
		spinnerGrupo.setBounds(320,220, 50, 30);
		add(spinnerGrupo);
		
		labelBaileAsig.setBounds(320,260, 140, 30);
		add(labelBaileAsig);
		
		txtBaileAsignado.setBounds(320,290, 140, 30);
		add(txtBaileAsignado);
		
		labelProfeAsig.setBounds(550, 60, 140, 30);
		add(labelProfeAsig);
		
		txtProfesorAsignado.setBounds(550, 90, 140, 30);
		add(txtProfesorAsignado);
		
		labelClaseAsig.setBounds(60, 310, 140, 30);
		add(labelClaseAsig);
		
		txtClaseAsignada.setBounds(60,340,140,30);
		add(txtClaseAsignada);
		
		labelDinero.setBounds(320,320, 140, 30);
		add(labelDinero);
		
		spinnerDinero.setBounds(320,350, 50, 30);
		add(spinnerDinero);
		
		labelCalificacion.setBounds(550, 120, 140, 30);
		add(labelCalificacion);
		
		spinnerCalificacion.setBounds(550, 150, 50, 30);
		add(spinnerCalificacion);
		
		botonAnyadir.setBounds(350,400, 100, 30);
		add(botonAnyadir);
		
		botonModificar.setBounds(570, 400, 100, 30);
		add(botonModificar);
		
		botonSeleccionar.setBounds(680, 400, 130, 30);
		add(botonSeleccionar);
		
		botonBorrar.setBounds(240,400, 100, 30);
		add(botonBorrar);
		
		botonP.setBounds(130,400, 100, 30);
		add(botonP);
		
		botonSalir.setBounds(20,400, 100, 30);
		add(botonSalir);
		
		botonH.setBounds(460,400, 100, 30);
		add(botonH);
		
		labelTexto.setBounds(750, 20, 130, 150);
		add(labelTexto);
		
		labelT.setBounds(500, -60, 200, 200);
		add(labelT);
		
		
		/*EVENTOS DE LOS BOTONES*/
		
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
									logger.info("alumno añadido");
									JOptionPane.showMessageDialog(null, "REGISTRO REALIZADO CORRECTAMENTE");
								}else {
									logger.info("alumno no se puedo añadir");
									JOptionPane.showMessageDialog(null, "USUARIO YA EXISTENTE");
								}
								
						}else {
							logger.info("formato erroneo");
							JOptionPane.showMessageDialog(null, "ERROR EN EL FORMATO");
						}
					}catch (Exception ex) {
						logger.info("error en la conversion");
						JOptionPane.showMessageDialog(null, "ERROR NUMERICO");
					}
				}else {
					logger.info("algun campo vacio");
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
		
		botonSeleccionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int pos = listaAlumno.getSelectedIndex();
				if(pos == -1) {
					JOptionPane.showMessageDialog(null, "Porfavor selecciona un alumno");
				}else {
					logger.info("se ha seleccionado un alumno en la JList");
					String[] alumno = modeloListaA.getElementAt(pos).split(",");
					String usuario = alumno[alumno.length-1].trim();
					Alumno a = BaseDatos.obtenerAlumno(con, usuario);
					txtNombre.setText(a.getNombre());
					txtApellidos.setText(a.getApellidos());
					txtUsuario.setText(a.getUsuario());
					txtContrasenya.setText(a.getContrasenia());
					txtTelefono.setText(String.valueOf(a.getTelefono()));
					txtDomicilio.setText(a.getDomicilio());
					txtBaileAsignado.setText(String.valueOf(a.getBaileAsignado()));
					txtProfesorAsignado.setText(String.valueOf(a.getProfesorAsignado()));
					txtClaseAsignada.setText(String.valueOf(a.getClaseAsignada()));
					spinnerDinero.setValue(a.getDinero());
					spinnerCalificacion.setValue(a.getCalificacion());
					spinnerGrupo.setValue(a.getGrupo());
					JOptionPane.showMessageDialog(null, "Profesor seleccionado con exito. Cambie los campos necesarios");
				}
				
			}
		});
		
		botonModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String apellidos = txtApellidos.getText();
				String contrasenia = txtContrasenya.getText();
				String usuario = txtUsuario.getText();
				String telefono = txtTelefono.getText();
				String domicilio = txtDomicilio.getText();
				String baileAsignado = txtBaileAsignado.getText();
				String profesorAsignado = txtProfesorAsignado.getText();
				String claseAsignada = txtClaseAsignada.getText();
				String dinero =  spinnerDinero.getValue().toString();
				String grupo =  spinnerGrupo.getValue().toString();
				String calificacion =  spinnerCalificacion.getValue().toString();
				if(!nombre.isEmpty() &&!apellidos.isEmpty()  &&!contrasenia.isEmpty() &&!domicilio.isEmpty() &&!baileAsignado.isEmpty() &&!profesorAsignado.isEmpty()&&!claseAsignada.isEmpty() && !telefono.isEmpty()) {
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
							if(BaseDatos.buscarAlumno(con, usuario) != null) {
								BaseDatos.modificarAlumno(con, nombre, apellidos, contrasenia, tel, domicilio, baile, profesor, clase, din, grup, califi, usuario);
								JOptionPane.showMessageDialog(null, "USUARIO MODIFICADO CON EXITO");
								logger.info("el usuario a sido modificado con exito");
								List<Alumno> listaAlumnos = BaseDatos.obtenerAlumnos(con);
								Academia.borrarTodosLosAlumnos();
								for(Alumno a : listaAlumnos) {
									if(!Academia.contieneAlumno(a)) {
										Academia.anyadirAlumno(a);
									}
								}
							
							}else {
								logger.info("error al intentar convertir un string a numero");
							JOptionPane.showMessageDialog(null, "Error al intentar eliminar el usuario");
							}
						}else {
							logger.info("formato erroneo en algun campo");
							JOptionPane.showMessageDialog(null, "Formato incorrecto");
						}
					}catch (NumberFormatException e3) {
						
					}
				}else {
					logger.info("algun campo vacio");
					JOptionPane.showMessageDialog(null, "ERROR. INTRODUZCA TODOS LOS DATOS");
				}
			}
		});
		
		botonBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = JOptionPane.showInputDialog("Introduce el usuario del alumno: ");
				try {
					if(BaseDatos.buscarAlumno(con, usuario) != null) {
						BaseDatos.eliminarAlumno(con, usuario);
						logger.info("Eliminando a un alumno");
						List<Alumno> listaAlumnos = BaseDatos.obtenerAlumnos(con);
						Academia.borrarTodosLosAlumnos();
						for (Alumno a : listaAlumnos) {
						    if (!Academia.contieneAlumno(a)) {
						        Academia.anyadirAlumno(a);
						  
						    }
						}
					}else {
						logger.info("no se ha introducido ningun usuario");
						JOptionPane.showMessageDialog(null, "Error al intentar eliminar el usuario");
					}
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
						
				}
			}
		});
		
		botonP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("abriendo la ventana profesores");
				new VentanaProfesorS();
				dispose();
				
			}
		});
		
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("abriendo la ventana inicial");
				new VentanaInicial();
				dispose();
				
			}
		});
		
		botonH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("abriendo la ventana horario");
				new VentanaHorarioS();
				dispose();
				
			}
		});
		
		
		setVisible(true);
	}
	
	public void cargarJListAlumnos() {
		for(Alumno a : BaseDatos.obtenerAlumnos(con)) {
			logger.info("cargando el modelo de la JList");
			modeloListaA.addElement(a.getNombre()+" "+a.getApellidos()+", "+a.getUsuario());
		}
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
	private boolean grupoCorrecto(String grupo) {
		try {
			int num = Integer.parseInt(grupo);
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

}
