package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import deustDance.Academia;
import deustDance.Main;

public class VentanaInicial extends JFrame{
	
	
	private JButton botonAlumno;
	private JButton botonProfesor;
	private JButton botonHorario;
	private JButton botonSalir;
	private Logger logger = Logger.getLogger(VentanaInicioSesion.class.getName());
	
	public VentanaInicial() {
		
		this.setTitle("Ventana Inicial Secretaria");
		this.setSize(400,600);
		this.setLayout(null);
		this.setBounds(500, 100, 500, 400);
		this.setResizable(false);
		
		/*CARGAMOS LA IMAGEN DEL FONDO*/
		String imagePath = "/imagenes/fondoLogin.jpg";
		this.setContentPane(new JLabel(new ImageIcon(getClass().getResource(imagePath))));
		
		
		/*CEACION CON PANELES Y COMPONENTES*/ 
		
		JLabel textoBienvenida = new JLabel("BIENVENIDO A DEUSTDANCE");
		
		textoBienvenida.setBounds(145, 0, 200, 130);
		textoBienvenida.setFont(new Font("Agency FB", Font.BOLD, 20));
		textoBienvenida.setForeground(Color.WHITE);
		add(textoBienvenida);
		
		botonAlumno = new JButton("Boton alumno");
		botonProfesor = new JButton("Boton profesor");
		botonHorario = new JButton("Boton horario");
		botonSalir = new JButton("Salir");
		
		logger.info("Cargando componentes de la ventana");
		
		botonAlumno.setBounds(160, 325, 150, 30);
		add(botonAlumno);
		
		botonProfesor.setBounds(160, 200, 150, 30);
		add(botonProfesor);
		
		botonHorario.setBounds(160, 260, 150, 30);
		add(botonHorario);
		
		botonSalir.setBounds(160,150,150,30);
		add(botonSalir);
		
		
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("guardando datos");
				Academia.guardarDatosAlumno("resources/alumnos.csv");
				Academia.guardarDatosProfesor("resources/profesores.csv");
				dispose();
				
			}
		});
		
		botonProfesor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("abriendo la ventana profesor");
				new VentanaProfesorS();
				dispose();
				
			}
		});
		
		botonHorario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("abriendo la ventana horario");
				new VentanaHorarioS();
				dispose();
				
			}
		});
		
		botonAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("abriendo la ventana del alumno");
				new VentanaAlumnoS();
				dispose();
				
			}
		});
		
		
		
		setVisible(true);
		
		
		
	}

}
