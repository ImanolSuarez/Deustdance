package deustDance;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class VentanaAlumno extends JFrame{
	protected JButton botonEditar;
	protected JTextField textoNombre;
	protected JTextField textoApellidos;
	protected JTextField textoEmail;
	protected JTextField textoContraseña;
	protected JComboBox<Clase> comboClases;
	protected JButton botonDatosClase;
	protected JButton botonMostrarCalendar;
	protected JButton botonImprimirCalendar;
	
	public VentanaAlumno() {
		JPanel panelInformacionPersonal = new JPanel();
		JPanel panelInformacionAcademica = new JPanel();
		
		panelInformacionPersonal.setLayout(new BorderLayout());
		panelInformacionAcademica.setLayout(new BorderLayout());
		
		Border bordeInformacionPersonal = BorderFactory.createTitledBorder("Información personal");
		panelInformacionPersonal.setBorder(bordeInformacionPersonal);
		
		Border bordeInformacionAcademica = BorderFactory.createTitledBorder("Información académica");
		panelInformacionAcademica.setBorder(bordeInformacionAcademica);
		
		textoNombre = new JTextField(20);
		textoApellidos = new JTextField(20);
		textoEmail = new JTextField(20);
		textoContraseña = new JTextField(20);
		
		panelInformacionPersonal.add(new JLabel("Nombre: "));
		panelInformacionPersonal.add(textoNombre);
		panelInformacionPersonal.add(new JLabel("Apellidos: "));
		panelInformacionPersonal.add(textoApellidos);
		panelInformacionPersonal.add(new JLabel("Correo electronico: "));
		panelInformacionPersonal.add(textoEmail);
		panelInformacionPersonal.add(new JLabel("Contraseña: "));
		panelInformacionPersonal.add(textoContraseña);
		
		botonEditar = new JButton("Editar datos");
		
		JPanel panelBotonPersonal = new JPanel();
		panelInformacionPersonal.add(panelBotonPersonal, BorderLayout.SOUTH);
		panelBotonPersonal.add(botonEditar);
		
		botonEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		comboClases = new JComboBox<Clase>();
		
		
		botonDatosClase = new JButton("Mostrar datos clase seleccionada");
		botonMostrarCalendar = new JButton("Mostrar calendario");
		botonImprimirCalendar = new JButton("Imprimir calendario");
		
		botonDatosClase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		botonMostrarCalendar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		botonImprimirCalendar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		panelInformacionAcademica.add(new JLabel("Calendario clases: "), BorderLayout.CENTER);
		JPanel panelBotonesAcademico = new JPanel();
		panelBotonesAcademico.add(botonDatosClase);
		panelBotonesAcademico.add(botonMostrarCalendar);
		panelBotonesAcademico.add(botonImprimirCalendar);
		
		
		panelInformacionAcademica.add(comboClases, BorderLayout.NORTH);
		panelInformacionAcademica.add(panelBotonesAcademico, BorderLayout.SOUTH);
		
		
		this.add(panelInformacionPersonal, BorderLayout.WEST);
		this.add(panelInformacionAcademica, BorderLayout.EAST);
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Ventana del alumno");
		this.setSize(1000, 800);
		this.setVisible(true);
	}
}