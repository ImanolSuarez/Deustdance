package ventanas;

import java.awt.*;

import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.*;


public class VentanaAlumno extends JFrame{
	private static final long serialVersionUID = 1L;
	protected JButton botonEditar;
	protected JTextField textoNombre;
	protected JTextField textoApellidos;
	protected JTextField textoUsuario;
	protected JTextField textoContraseña;
	protected JTextField textoDomicilio;
	protected JTextField textoprofesorAsignado;
	protected JTextField textoclaseAsignada;
	protected JTextField textodinero;
	protected JTextField textogrupo;
	protected JTextField textocalificacion;
	protected JButton botonImprimirCalendar;
	protected JButton botonCargarFoto;
	protected VentanaSecretaria ventanaSecretaria;
	
	public VentanaAlumno() {
		
		JPanel panelInformacionPersonal = new JPanel();
		JPanel panelInformacionAcademica = new JPanel();
		JPanel panelImagen = new JPanel();
		
		panelInformacionPersonal.setLayout(new BorderLayout());
		panelInformacionAcademica.setLayout(new BorderLayout());
		
		Border bordeInformacionPersonal = BorderFactory.createTitledBorder("Información personal");
		panelInformacionPersonal.setBorder(bordeInformacionPersonal);
		
		Border bordeInformacionAcademica = BorderFactory.createTitledBorder("Información académica");
		panelInformacionAcademica.setBorder(bordeInformacionAcademica);
		
		panelInformacionPersonal.setLayout(new GridLayout(7,2));
		
		textoNombre = new JTextField(20);
		textoApellidos = new JTextField(20);
		textoUsuario = new JTextField(20);
		textoContraseña = new JTextField(20);
		textoDomicilio = new JTextField(20);
		textoprofesorAsignado = new JTextField(20);
		textoclaseAsignada = new JTextField(20);
		textodinero = new JTextField(20);
		textogrupo = new JTextField(20);
		textocalificacion = new JTextField(20);
		
		
		textoNombre.setEditable(false);
		textoApellidos.setEditable(false);
		textoUsuario.setEditable(false);
		textoContraseña.setEditable(false);
		textoDomicilio.setEditable(false);
		textoprofesorAsignado.setEditable(false);
		textoclaseAsignada.setEditable(false);
		textodinero.setEditable(false);
		textogrupo.setEditable(false);
		textocalificacion.setEditable(false);
		
		panelInformacionPersonal.add(new JLabel("Nombre: "));
		panelInformacionPersonal.add(textoNombre);
		panelInformacionPersonal.add(new JLabel("Apellidos: "));
		panelInformacionPersonal.add(textoApellidos);
		panelInformacionPersonal.add(new JLabel("Usuario: "));
		panelInformacionPersonal.add(textoUsuario);
		panelInformacionPersonal.add(new JLabel("Contraseña: "));
		panelInformacionPersonal.add(textoContraseña);
		panelInformacionPersonal.add(new JLabel("Domicilio: "));
		panelInformacionPersonal.add(textoDomicilio);
		panelInformacionPersonal.add(new JLabel("Profesor Asignado: "));
		panelInformacionPersonal.add(textoprofesorAsignado);
		panelInformacionPersonal.add(new JLabel("Clase Asignada: "));
		panelInformacionPersonal.add(textoclaseAsignada);
		panelInformacionPersonal.add(new JLabel("Dinero: "));
		panelInformacionPersonal.add(textodinero);
		panelInformacionPersonal.add(new JLabel("Grupo: "));
		panelInformacionPersonal.add(textogrupo);
		panelInformacionPersonal.add(new JLabel("Calificación: "));
		panelInformacionPersonal.add(textocalificacion);
		
		
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
	
		
		botonImprimirCalendar = new JButton("Imprimir horario");
		
		
		botonImprimirCalendar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		
		panelInformacionAcademica.add(new JLabel("Horario: "), BorderLayout.CENTER);
		JPanel panelBotonesAcademico = new JPanel();
		panelBotonesAcademico.add(botonImprimirCalendar);
		
		
		panelInformacionAcademica.add(panelBotonesAcademico, BorderLayout.SOUTH);
		
		panelImagen.add(panelInformacionPersonal, BorderLayout.WEST);
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