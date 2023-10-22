package deustDance;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private static final String nomFichero = "Alumnos.csv";
	
	
	public VentanaRegistro() {
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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
		
		SpinnerModel años = new SpinnerNumberModel(0, 0, 100, 1);
		spinnerEdad = new JSpinner(años);
		
		botonGuardar = new JButton("Guardar");
		botonSalir = new JButton("Salir");
		
		/*CARGA DE LAS COLLECIONES*/
		
		Academia.cargarAlumnosEnLista(nomFichero);
		
		
	
		
		
		/*EVENTOS*/
		
		botonGuardar.addActionListener((e)->{
			
			String nombre = textNombre.getText();
			String apellidos = textApellidos.getText();
			String dni = textDni.getText();
			String dir = textDir.getText();
			String codPos = textCodPos.getText();
			String tf = textTF.getText();
			String email = textEmail.getText();
			String contra = textContra.getText();
			String fNac = textfNac.getText();
			String sexo = (String) comboSexo.getSelectedItem();
			int edad = (int) (spinnerEdad.getValue());
			
			Alumno alumno = new Alumno(nombre, apellidos,edad, email, contra, dni, fNac, dir, codPos, tf, sexo);
			if(Academia.buscarAlumno(dni) != null) {
				JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese dni","ERROR",JOptionPane.ERROR_MESSAGE);
			}else {
				Academia.anyadirAlumno(alumno);
				JOptionPane.showMessageDialog(null, "BIENVENIDO A DEUSTDANCE.","BIENVENIDO",JOptionPane.INFORMATION_MESSAGE);
			}
			
			textNombre.setText("");
			textApellidos.setText("");
			textDni.setText("");
			textDir.setText("");
			textCodPos.setText("");
			textTF.setText("");
			textEmail.setText("");
			textContra.setText("");
			textfNac.setText("");
			spinnerEdad.setValue(0);
		});
		
		
		botonSalir.addActionListener((e)->{
			Academia.guardarAlumnosEnFichero(nomFichero);
			new VentanaInicioSesion();
			setVisible(false);
			
		});
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
