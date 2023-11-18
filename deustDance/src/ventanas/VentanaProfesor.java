package ventanas;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import deustDance.Alumno;


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
	protected JTextField textoDireccion;
	protected JTextField textoUsuario;
	protected JTextField textoContraseña;
	
	//Modelo para la tabla de la pestaña Lista de alumnos
	class ModeloTablaAlumnos extends AbstractTableModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[]cabecera= {"Grupo", "Nombre", "Apellidos", "Calificación"};
		List<Alumno> datos;
		public ModeloTablaAlumnos(List<Alumno> datos ) {
			this.datos = null; //Cambiar a datos cuando este la BD
			
		}

		@Override
		public String getColumnName(int column) {
			return cabecera[column];
		}

		

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
//			return datos.size(); FALTA HACER QUE COJA EL VALOR DE DATOS DESDE LA BD
			return 2;
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
//			Alumno a = datos.get(row);
//			switch (column) {
//			case 0: return a.getClaseAsignada().getNombre();
//			case 1: return a.getNombre();
//			case 2: return a.getApellidos();
//			case 3: return a.getCalificacion();
//			default: return null;
			return null;
			}
		}
		
		
	
	
	public VentanaProfesor() {
		
		pestañas = new JTabbedPane();
		
		//Pestaña Informacion Personal y calendario
		
		textoNombre = new JTextField(15);
		textoApellidos = new JTextField(15);
		textoDireccion = new JTextField(15);
		textoUsuario = new JTextField(15);
		textoContraseña = new JTextField(15);
		
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
		
		panelInformacionPersonal.setLayout(new GridLayout(10, 1));
		panelInformacionPersonal.add(new JLabel("Nombre: "));
		panelInformacionPersonal.add(textoNombre);
		panelInformacionPersonal.add(new JLabel("Apellidos: "));
		panelInformacionPersonal.add(textoApellidos);
		panelInformacionPersonal.add(new JLabel("direccion: "));
		panelInformacionPersonal.add(textoDireccion);
		panelInformacionPersonal.add(new JLabel("Usuario: "));
		panelInformacionPersonal.add(textoUsuario);
		panelInformacionPersonal.add(new JLabel("Contraseña: "));
		panelInformacionPersonal.add(textoContraseña);
		
		panelCalendario.add(new JLabel("Calendario: "));
		panelCalendario.add(botonImprimirCalendario, BorderLayout.SOUTH);
		panelInfoCalendario.add(panelInformacionPersonal, BorderLayout.WEST);
		panelInfoCalendario.add(panelCalendario, BorderLayout.WEST);
		
		pestañas.addTab("Informacion Personal/horarios", panelInfoCalendario);
		
		//pestaña Lista de alumnos
		//Datos de prueba		
		ModeloTablaAlumnos modelo = new ModeloTablaAlumnos(null); //Añadimos el modelo a la tabla
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
		new VentanaProfesor();
	}
}
