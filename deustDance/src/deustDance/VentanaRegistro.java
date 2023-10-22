package deustDance;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class VentanaRegistro extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel texto, labelNombre, labelSexo, labelApellidos, labelDni, labelEdad, labelfNac, labelDir, labelCodPos, labelTF, labelEmail, labelContra;
	private JTextField textNombre, textApellidos, textDni, textDir, textCodPos, textTF, textEmail, textContra, textfNac;
	private JButton botonGuardar, botonSalir;
	private JComboBox<String> comboSexo;
	private JSpinner spinnerEdad;
	
	
	public VentanaRegistro() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 500);
		setTitle("Ventana registro");
		
		/*CREACION DE PANELES*/
		
		JPanel panelNorte = new JPanel();
		JPanel panelCentro = new JPanel(new GridLayout(6,4));
		JPanel panelSur = new JPanel(new GridLayout(1, 2));
		
		/*COMPONENTES*/
		
		texto = new JLabel("REALIZE EL REGISTRO PARA EL INICIO DE SESION");
		
		labelNombre = new JLabel("Nombre:");
		labelSexo = new JLabel("Sexo: ");
		labelApellidos = new JLabel("Apellidos: ");
		labelDni = new JLabel("Dni: ");
		labelEdad = new JLabel("Edad: ");
		labelfNac = new JLabel("Fecha de nacimiento: ");
		labelDir = new JLabel("Direccion: ");
		labelCodPos = new JLabel("Codigo postal: ");
		labelTF = new JLabel("Telefono: ");
		labelEmail = new JLabel("Email: ");
		labelContra = new JLabel("Contraseña: ");
		
		textNombre = new JTextField();
		textApellidos = new JTextField();
		textDni = new JTextField();
		textDir = new JTextField();
		textCodPos = new JTextField();
		textTF = new JTextField();
		textEmail = new JTextField();
		textContra = new JTextField();
		textfNac = new JTextField();
	
		comboSexo = new JComboBox<>();
		comboSexo.addItem("MASCULINO");
		comboSexo.addItem("FEMENINO");
		comboSexo.addItem("OTROS");
		
		SpinnerModel años = new SpinnerNumberModel(0, 0, 10, 1);
		spinnerEdad = new JSpinner(años);
		
		botonGuardar = new JButton("Guardar");
		botonSalir = new JButton("Salir");
		
		
		
		/*AÑADIR COMPONENTES AL PANEL*/
		
		panelNorte.add(texto);
		
		panelCentro.add(labelNombre);
		panelCentro.add(textNombre);
		panelCentro.add(labelSexo);
		panelCentro.add(comboSexo);
		panelCentro.add(labelApellidos);
		panelCentro.add(textApellidos);
		panelCentro.add(labelDni);
		panelCentro.add(textDni);
		panelCentro.add(labelEdad);
		panelCentro.add(spinnerEdad);
		panelCentro.add(labelfNac);
		panelCentro.add(textfNac);
		panelCentro.add(labelDir);
		panelCentro.add(textDir);
		panelCentro.add(labelCodPos);
		panelCentro.add(textCodPos);
		panelCentro.add(labelTF);
		panelCentro.add(textTF);
		panelCentro.add(labelEmail);
		panelCentro.add(textEmail);
		panelCentro.add(labelContra);
		panelCentro.add(textContra);
		
		panelSur.add(botonGuardar);
		panelSur.add(botonSalir);
		
		
		/*AÑADIR PANELES A LA VENTANA*/
		
		add(panelNorte, BorderLayout.NORTH);
		add(panelCentro, BorderLayout.CENTER);
		add(panelSur,BorderLayout.SOUTH);
		
		
		
		
		
		setVisible(true);
	}

	





}
