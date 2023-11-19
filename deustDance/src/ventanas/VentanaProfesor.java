package ventanas;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import deustDance.Alumno;
import deustDance.Profesor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class VentanaProfesor extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTabbedPane pestañas;
	protected JButton botonImprimirCalendario;
	protected JTextField textoNombre;
	protected JTextField textoApellidos;
	protected JTextField textoUsuario;
	protected JTextField textoContraseña;
	protected JTextField textoTelefono;
	protected JTextField textoDomicilio;
	protected JTextField textoGrupo;
	
	//Modelo para la tabla de la pestaña Lista de alumnos
	class ModeloTablaAlumnos extends AbstractTableModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[]cabecera= {"Grupo", "Nombre", "Apellidos", "Calificación"};
		List<Alumno> datos;
		public ModeloTablaAlumnos(List<Alumno> datos ) {
			this.datos = datos; 
			
		}

		@Override
		public Class<?> getColumnClass(int column) {
			switch(column) {
				case 0:  
				case 1: return String.class;
				case 2: return String.class;
				case 3: return double.class;
				default: return null;
			}
		}

		@Override
		public void setValueAt(Object value, int row, int column) {
			// TODO Auto-generated method stub
			Alumno a = datos.get(row); 
			switch (column) {
			case 1:
				a.setNombre((String)value);
				break;
			case 2:
				a.setApellidos((String)value);
				break;
			case 3:
				a.setCalificacion((double)value);
				break;
			default: break;
			}
		}

		@Override
		public String getColumnName(int column) {
			return cabecera[column];
		}

		

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return datos.size(); 
			
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return cabecera.length;
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 4;
			//Los profesores solo podran editar las calificaciones
		}
		@Override
		public Object getValueAt(int row, int column) {
			//FALTA HACER QUE COJA EL VALOR DE DATOS DESDE LA BD
			Alumno a = datos.get(row);
			switch (column) {
		//	case 0: return a.getClaseAsignada().getNombre();
			case 1: return a.getNombre();
			case 2: return a.getApellidos();
			case 3: return a.getCalificacion();
			default: return null;
			}
			}
		
		}
	
		
		
	
	
	public VentanaProfesor(Profesor profesor) {
		
		pestañas = new JTabbedPane();
		
		//Pestaña Informacion Personal y calendario
		
		textoNombre = new JTextField(20);
		textoApellidos = new JTextField(20);
		textoUsuario = new JTextField(20);
		textoContraseña = new JTextField(20);
		textoTelefono = new JTextField(20);
		textoDomicilio = new JTextField(20);
		textoGrupo = new JTextField(20);
		
		textoNombre.setEditable(false);
		textoApellidos.setEditable(false);
		textoUsuario.setEditable(false);
		textoContraseña.setEditable(false);
		textoTelefono.setEditable(false);
		textoDomicilio.setEnabled(false);
		textoGrupo.setEditable(false);
		
		textoNombre.setText(profesor.getNombre());
		textoApellidos.setText(profesor.getApellidos());
		textoUsuario.setText(profesor.getUsuario());
		textoContraseña.setText(profesor.getContrasenia());
		textoTelefono.setText(String.valueOf(profesor.getTelefono()));
		textoDomicilio.setText(profesor.getDomicilio());
		textoGrupo.setText(String.valueOf(profesor.getGrupo()));
		
		botonImprimirCalendario= new JButton("Imprimir Calendario");
		botonImprimirCalendario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JPanel panelInformacionPersonal = new JPanel();
		JPanel panelCalendario = new JPanel();
		JPanel panelInfoCalendario = new JPanel();
		
		panelInformacionPersonal.setLayout(new GridLayout(8, 1));
		panelInformacionPersonal.add(new JLabel("Nombre: "));
		panelInformacionPersonal.add(textoNombre);
		panelInformacionPersonal.add(new JLabel("Apellidos: "));
		panelInformacionPersonal.add(textoApellidos);
		panelInformacionPersonal.add(new JLabel("Usuario: "));
		panelInformacionPersonal.add(textoUsuario);
		panelInformacionPersonal.add(new JLabel("Contraseña: "));
		panelInformacionPersonal.add(textoContraseña);
		panelInformacionPersonal.add(new JLabel("Teléfono: "));
		panelInformacionPersonal.add(textoTelefono);
		panelInformacionPersonal.add(new JLabel("Domicilio: "));
		panelInformacionPersonal.add(textoDomicilio);
		panelInformacionPersonal.add(new JLabel("Grupo: "));
		panelInformacionPersonal.add(textoGrupo);
		
		
		panelCalendario.add(new JLabel("Calendario: "));
		panelCalendario.add(botonImprimirCalendario, BorderLayout.SOUTH);
		panelInfoCalendario.add(panelInformacionPersonal, BorderLayout.WEST);
		panelInfoCalendario.add(panelCalendario, BorderLayout.WEST);
		
		pestañas.addTab("Informacion Personal/horarios", panelInfoCalendario);
		
		//pestaña Lista de alumnos
		//Datos de prueba	
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		listaAlumnos.add(new Alumno("Nombre1", "Apellido1", "usuario1", "contrasenia1", 123456789, "Dirección1",  null, null, null, 100.0, 1, 85.0));
		listaAlumnos.add(new Alumno ("Nombre2", "Apellido2", "usuario2", "contrasenia2", 987654321, "Dirección2",null, null, null, 150.0, 2, 90.0));
		listaAlumnos.add(new Alumno("Nombre3", "Apellido3", "usuario3", "contrasenia3", 111222333, "Dirección3", null, null, null, 200.0, 1, 78.0));
		listaAlumnos.add(new Alumno("Nombre4", "Apellido4", "usuario4", "contrasenia4", 444555666, "Dirección4", null, null, null, 120.0, 2, 95.0));
		listaAlumnos.add(new Alumno("Nombre5", "Apellido5", "usuario5", "contrasenia5", 555666777, "Dirección5", null, null, null, 80.0, 1, 75.0));
		ModeloTablaAlumnos modelo = new ModeloTablaAlumnos(listaAlumnos); //Añadimos el modelo a la tabla
		JTable JTableAlumnos = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(JTableAlumnos);
		JPanel panelTablaAlumnos = new JPanel();
		panelTablaAlumnos.add(scrollPane);
		
		pestañas.addTab("Lista de Alumnos", panelTablaAlumnos);
		
		
		this.add(pestañas);

		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP,altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		this.setTitle("VentanaProfesor");
		this.setVisible(true);
	}
	public static void main(String[] args) {
		//Ejemplos de prueba
		Profesor p1 = new Profesor("Juan", "Pérez", "juanperez", "contrasenia1", 123456789, "Dirección1", null, 1, null, null);
		new VentanaProfesor(p1);
	}
}
