package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class VentanaSecretaria extends JFrame {
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
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1,3));
		panelBotones.add(botonAnyadir);
		panelBotones.add(botonModificar);
		panelBotones.add(botonEliminar);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setLayout(new GridLayout(2,1));
		panelDatos.add(panelTexto);
		panelDatos.add(panelBotones);
		
		JPanel panelAlumnos = new JPanel();
        panelAlumnos.add(panelDatos, BorderLayout.EAST);
        tabbedPane.addTab("Alumnos", panelAlumnos);

        // Pestaña Profesores
        JPanel panelProfesores = new JPanel();
        panelProfesores.add(new JLabel("Contenido de la Pestaña 2"));
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
