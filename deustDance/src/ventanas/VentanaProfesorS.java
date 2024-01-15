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
import deustDance.BaseDatos;
import deustDance.Profesor;

public class VentanaProfesorS extends JFrame{
	
	Connection con = BaseDatos.initBD("DeustDance.db");
	
	private JLabel labelNombre;
	private JLabel labelApellidos;
	private JLabel labelUsuario;
	private JLabel labelContrasenia;
	private JLabel labelGrupo;
	private JLabel labelDomicilio;
	private JLabel labelTelefono;
	
	protected JTextField txtNombreP;
	protected JTextField textApellidoP;
	protected JSpinner spinnerGrupoP;
	protected JTextField txtDomicilioP;
	protected JTextField txtUsuarioP;
	protected JTextField txtContrasenyaP;
	protected JTextField txtTelefonoP;
	
	private JButton botonAnyadir;
	private JButton botonBorrar;
	private JButton botonSeleccionar;
	private JButton botonModificar;
	private JButton botonSalir;
	private JButton botonA;
	private JButton botonH;
	private Logger logger = Logger.getLogger(VentanaProfesorS.class.getName());
	
	protected DefaultListModel<String> modeloListaP;
	protected JList<String> listaProfesor;
	protected JScrollPane scrollListaP;
	
	public VentanaProfesorS() {
		
		this.setTitle("Ventana profesor secretaria");
		this.setSize(400,600);
		this.setLayout(null);
		this.setBounds(500, 100, 850, 400);
		this.setResizable(false);
		
		/*CARGAMOS LA IMAGEN DEL FONDO*/
		//String imagePath = "/imagenes/fondoLogin.jpg";
		//this.setContentPane(new JLabel(new ImageIcon(getClass().getResource(imagePath))));
		
		JLabel labelTexto = new JLabel("Listado de profesores: ");
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
		
		txtNombreP = new JTextField(20);
		textApellidoP = new JTextField(20);
		txtUsuarioP = new JTextField(20);
		txtContrasenyaP = new JTextField(20);
		txtDomicilioP = new JTextField(20);
		txtTelefonoP = new JTextField(20);
		spinnerGrupoP = new JSpinner();
		
		botonAnyadir = new JButton("Añadir");
		botonBorrar = new JButton("Borrar");
		botonModificar = new JButton("Modificar");
		botonSeleccionar = new JButton("Seleccionar");
		botonH = new JButton("Horario");
		botonA = new JButton("Alumnos");
		botonSalir = new JButton("Salir");
		
		logger.info("cargando los componentes a la ventana");
		
		labelNombre.setBounds(60, 10, 100, 130);
		add(labelNombre);
		
		txtNombreP.setBounds(60, 90, 140, 30);
		add(txtNombreP);
		
		labelApellidos.setBounds(60, 80, 100, 130);
		add(labelApellidos);
		
		textApellidoP.setBounds(60, 160, 140, 30);
		add(textApellidoP);
		
		labelUsuario.setBounds(60, 190, 140, 30);
		add(labelUsuario);
		
		txtUsuarioP.setBounds(60, 220, 140, 30);
		add(txtUsuarioP);
		
		labelContrasenia.setBounds(60, 250, 140, 30);
		add(labelContrasenia);
		
		txtContrasenyaP .setBounds(60, 280, 140, 30);
		add(txtContrasenyaP);
		
		labelDomicilio.setBounds(320,60, 140, 30);
		add(labelDomicilio);
		
		txtDomicilioP.setBounds(320,90, 140, 30);
		add(txtDomicilioP);
		
		labelTelefono.setBounds(320,130, 140, 30);
		add(labelTelefono);
		
		txtTelefonoP.setBounds(320,160, 140, 30);
		add(txtTelefonoP);
		
		labelGrupo.setBounds(320,190, 140, 30);
		add(labelGrupo);
		
		spinnerGrupoP.setBounds(320,220, 50, 30);
		add(spinnerGrupoP);
		
		botonAnyadir.setBounds(320,330, 100, 30);
		add(botonAnyadir);
		
		botonModificar.setBounds(540,330, 100, 30);
		add(botonModificar);
		
		botonBorrar.setBounds(215,330, 100, 30);
		add(botonBorrar);
		
		botonA.setBounds(110,330, 100, 30);
		add(botonA);
		
		botonSalir.setBounds(7,330, 100, 30);
		add(botonSalir);
		
		botonH.setBounds(430,330, 100, 30);
		add(botonH);
		
		botonSeleccionar.setBounds(650,330, 150, 30);
		add(botonSeleccionar);
		
		labelTexto.setBounds(550, -20, 200,200);
		add(labelTexto);
		
		/*CREACION DE LA JLIST*/
		
		modeloListaP = new DefaultListModel<>();
		listaProfesor = new JList<>(modeloListaP);
		scrollListaP = new JScrollPane(listaProfesor);
		scrollListaP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollListaP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		cargarJListProfesor();
		scrollListaP.setBounds(550, 100, 200,200);
		add(scrollListaP);
		
		/*EVENTOS DE BOTON*/
		
		botonAnyadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombreP.getText();
				String apellido = textApellidoP.getText();
				String grupo = spinnerGrupoP.getValue().toString();
				String domicilio = txtDomicilioP.getText(); 
				String usuario = txtUsuarioP.getText();
				String contra = txtContrasenyaP.getText();
				String tf = txtTelefonoP.getText();
				 if (!nombre.isEmpty()  &&   !apellido.isEmpty() && !grupo.isEmpty() && !domicilio.isEmpty() && !usuario.isEmpty() && !contra.isEmpty() && !tf.isEmpty()) {
			            try {
			            	int gru = Integer.parseInt(grupo);
			            	int telefo = Integer.parseInt(tf);
			            	if(nombreCorrecto(nombre) && apellidoCorrecto(apellido) && usuarioCorrecto(usuario) && contraCorrecto(contra) && tfCorrecto(tf) && domicilioCorrecto(domicilio) && grupoCorrecto(grupo)) {
			            		Profesor p = new Profesor(nombre, apellido, usuario, contra, telefo, domicilio, gru);
			            		if(BaseDatos.buscarProfesor(con, usuario) == null) {
			            			Academia.anyadirProfesor(p);
			            			JOptionPane.showMessageDialog(null, "Porfesor añadido correctamente");
			            			logger.info("añadiendo un profesor");
			            		}else {
			            			JOptionPane.showMessageDialog(null, "El profesor no se pudo añadir");
			            			logger.info("no se pudo añadir");
			            		}
			
			            	}else{
			            		logger.info("formato erroneo");
			            		JOptionPane.showMessageDialog(null, "Formato incorrecto");
			            	}
			            }catch (NumberFormatException e1) {
			            	logger.info("error al intentar convertir un string a int");
			            	JOptionPane.showMessageDialog(null, "ERROR NUMERICO");
						}
			        } else {
			        	logger.info("error, algun campo vacio");
			            JOptionPane.showMessageDialog(null, "ERROR. PORFAVOR REVISE TODOS LOS CAMPOS");
			        }
				 	txtNombreP.setText("");
				 	textApellidoP.setText("");
					spinnerGrupoP.setValue(0);
					txtDomicilioP.setText("");
					txtUsuarioP.setText("");
					txtContrasenyaP.setText("");
					txtTelefonoP.setText("");
				 
			}
		});
		
		botonSeleccionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int pos = listaProfesor.getSelectedIndex();
				if(pos == -1) {
					JOptionPane.showMessageDialog(null, "Primero debes seleccionar un alumno");
					logger.info("no se ha seleccionado ningun alumno");
				}else {
					logger.info("se ha seleccionado un alumno");
					String[] profesor = modeloListaP.getElementAt(pos).split(",");
					String usuario = profesor[profesor.length-1].trim();
					Profesor a = BaseDatos.obtenerProfesor(con, usuario);
					txtNombreP.setText(a.getNombre());
					textApellidoP.setText(a.getApellidos());
					txtUsuarioP.setText(a.getUsuario());
					txtContrasenyaP.setText(a.getContrasenia());
					txtTelefonoP.setText(String.valueOf(a.getTelefono()));
					txtDomicilioP.setText(a.getDomicilio());
					spinnerGrupoP.setValue(a.getGrupo());
					JOptionPane.showMessageDialog(null, "Profesor seleccionado con exito. Cambie los campos necesarios");
				}
				
			}
		});
		
		botonModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombreP.getText();
				String apellido = textApellidoP.getText();
				String contra = txtContrasenyaP.getText();
				String domicilio = txtDomicilioP.getText();
				String tel = txtTelefonoP.getText();
				String usuario = txtUsuarioP.getText();
				String grupo = spinnerGrupoP.getValue().toString();
				if (!nombre.isEmpty()  &&  !apellido.isEmpty() && !grupo.isEmpty() && !domicilio.isEmpty() && !contra.isEmpty() && !tel.isEmpty()) {
					if(nombreCorrecto(nombre) && apellidoCorrecto(apellido) && usuarioCorrecto(usuario) && contraCorrecto(contra) && tfCorrecto(tel) && domicilioCorrecto(domicilio) && grupoCorrecto(grupo)) {
					int g = Integer.parseInt(grupo);
					int t = Integer.parseInt(tel);
					if(BaseDatos.buscarProfesor(con, usuario) != null) {
						BaseDatos.modificarProfesor(con, nombre, apellido, contra, t, domicilio, g, usuario);
						logger.info("se ha modificado un alumno");
						List<Profesor> listaProfesores = BaseDatos.listaProfesores(con);
						Academia.borrarTodosLosProfesores();
						JOptionPane.showMessageDialog(null, "Profesor modificado con exito");
						for (Profesor a : listaProfesores) {
						    if (!Academia.contieneProfesor(a)) {
						        Academia.anyadirProfesor(a);;
						        System.out.println(a);
						    }
						}
					}else {
						JOptionPane.showMessageDialog(null, "NO SE HA PODIDO ENCONTRAR AL PROFESOR");
						logger.info("no se ha encontrado al profesor");
					}
					}else {
						JOptionPane.showMessageDialog(null, "Formato incorrecto");
						logger.info("el formato es erroneo");
					}
				}else {
					JOptionPane.showMessageDialog(null, "REVISE LOS CAMPOS. ALGUN CAMPO NULO");
					logger.info("algun campo nulo");
				}
				
				
			}
		});
		

		botonBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = JOptionPane.showInputDialog(null,"Introduce el usuario a eliminar: ");
				try {
						if(BaseDatos.buscarProfesor(con, usuario) != null) {
							BaseDatos.eliminarProfesor(con, usuario);
							List<Profesor> listaProfesores = BaseDatos.listaProfesores(con);
							Academia.borrarTodosLosProfesores();
							for (Profesor a : listaProfesores) {
							    if (!Academia.contieneProfesor(a)) {
							        Academia.anyadirProfesor(a);;
							        System.out.println(a);
							    }
							}
							JOptionPane.showMessageDialog(null, "PROFESOR BORRADO CON EXITO");
							logger.info("se ha borrado el profesor");
						}else {
							JOptionPane.showMessageDialog(null, "EL PROFESOR NO SE PUDO BORRAR");
							logger.info("no se puedo borrar al profesor");
						}
						
					} catch (NumberFormatException e3) {
						e3.printStackTrace();
					}
				}
		});
		
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("cargando la ventana inicial");
				new VentanaInicial();
				dispose();
				
			}
		});
		
		botonH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("cargando la ventana Horario");
				new VentanaTablaInfoS();
				dispose();
				
			}
		});
		
		botonA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("cargando la ventan alumno");
				new VentanaAlumnoS();
				dispose();
				
			}
		});
	
				
		
		
		setVisible(true);
	}
	
	public void cargarJListProfesor() {
		for(Profesor p : BaseDatos.listaProfesores(con)) {
			logger.info("cargando la JList");
			modeloListaP.addElement(p.getNombre()+""+p.getApellidos()+", "+p.getUsuario());
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
	
	public static void main(String[] args) {
		new VentanaProfesorS();
	}

}
