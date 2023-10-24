package deustDance;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaEditarAlumno extends JFrame{
	protected Alumno alumno;
	protected JTextField textoContraseña;
	protected JTextField textoEmail;
	protected JTextField textoNombre;
	protected JTextField textoApellidos;
	protected JButton botonSalir;
	protected JButton botonGuardar;
	public VentanaEditarAlumno(Alumno alumno){
		JPanel panelEditar = new JPanel();
		
		panelEditar.setLayout(new GridLayout(5,2));
		
		textoContraseña= new JTextField(30);
		textoEmail = new JTextField(30);
		textoNombre = new JTextField(30);
		textoApellidos = new JTextField(30);
		
		panelEditar.add(new JLabel("Nombre: "));
		panelEditar.add(textoNombre);
		panelEditar.add(new JLabel("Apellidos: "));
		panelEditar.add(textoApellidos);
		panelEditar.add(new JLabel("Correo electrónico: "));
		panelEditar.add(textoEmail);
		panelEditar.add(new JLabel("Contraseña: "));
		panelEditar.add(textoContraseña);
		
		JPanel panelBotones = new JPanel();
		botonSalir = new JButton("Salir");
		botonGuardar = new JButton("Guardar datos");
		
		panelBotones.add(botonGuardar);
		panelBotones.add(botonSalir);
		
		this.add(panelEditar, BorderLayout.NORTH);
		this.add(panelBotones, BorderLayout.SOUTH);
		
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		botonGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				alumno.setEmail(textoEmail.getText());
				alumno.setContrasenia(textoContraseña.getText());
				
			}
		});
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Editar alumno");
		this.setSize(600, 400);
		this.setVisible(true);
	}
}
