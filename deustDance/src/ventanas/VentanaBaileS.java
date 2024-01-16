package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import deustDance.Academia;
import deustDance.Alumno;
import deustDance.Baile;
import deustDance.BaseDatos;
import deustDance.Profesor;
import deustDance.Tipo;

public class VentanaBaileS extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Connection con = BaseDatos.initBD("DeustDance.db");
	
	private JComboBox<Tipo> comboBaile;
	
	
	private ModeloTabla modeloTabla;
	private JTable tabla;
	private JScrollPane scrollTabla;
	
	private JTextArea textoArea;
	
	private JButton botonSalir;
	
	private JButton botonI;
	
	private Logger logger = Logger.getLogger(VentanaProfesorS.class.getName());
	
	public VentanaBaileS() {
		
		this.setTitle("Ventana horario secretaria");
		this.setSize(400,600);
		this.setBounds(00, 100, 1500, 400);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		ImageIcon imagenLogo = (new ImageIcon(getClass().getResource("/imagenes/imagenLogo.png")));
		setIconImage(imagenLogo.getImage());
		
		JLabel labelTexto1 = new JLabel("Listado de alumnos de ese baile: ");
		labelTexto1.setFont(new Font("Agency FB", Font.BOLD, 20));
		labelTexto1.setForeground(Color.BLACK);
		
		JLabel labelTexto2 = new JLabel("Listado del profesores de ese baile: ");
		labelTexto2.setFont(new Font("Agency FB", Font.BOLD, 20));
		labelTexto2.setForeground(Color.BLACK);
		
		logger.info("cargando los componentes a la ventana");
		
		/*CREACION DE LA JTABLE ALUMNO*/
		
		modeloTabla = new ModeloTabla(null);
		tabla = new JTable(modeloTabla);
		scrollTabla = new JScrollPane(tabla);
		scrollTabla.setBounds(175, 45, 600, 250);
		add(scrollTabla);
		
		/*CREACION DE LA JTextArea PROFESOR*/
		
		textoArea = new JTextArea();
		textoArea.setBounds(900, 60, 300,100);
		add(textoArea);
		
		/*CREACION DEL JComboBox*/
		
		comboBaile = new JComboBox<Tipo>(Tipo.values());
		comboBaile.setBounds(10, 100, 150,40);
		add(comboBaile);
		
		botonSalir = new JButton("Salir");
		botonI = new JButton(new ImageIcon(getClass().getResource("/imagenes/imagenInfo.jpg")));
		
		labelTexto1.setBounds(200,-25,250,100);
		add(labelTexto1);
		
		labelTexto2.setBounds(900,-25,250,100);
		add(labelTexto2);
		
		botonSalir.setBounds(30,200,100,30);
		add(botonSalir);
		
		botonI.setBounds(1350, 15, 20, 20);
		add(botonI);
		
		/*EVENTOS*/
		
		
		
		comboBaile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("ha seleccionado un elemento del combo");
				textoArea.setText("");
				tabla.setModel(new ModeloTabla(null));
				Tipo tipo = (Tipo)comboBaile.getSelectedItem();
				String tipoSeleccionado = tipo.toString();
				Baile b = BaseDatos.obtenerBaileTipo(con, tipoSeleccionado);
				if(b != null) {
					List<Alumno> listaAlumnos = Academia.cargarMapaTipoAlumno().get(b.getIdBaile());
					if(listaAlumnos != null ) {
						tabla.setModel(new ModeloTabla(listaAlumnos));
					}else {
						System.out.println("no se ha podido cargar");
					}
					
					int id = Academia.cargarMapaTipoProfesor().get(b.getIdBaile());
					Profesor p = BaseDatos.obtenerProfesorId(con, id);
					String texto = p.getNombre() + " " + p.getApellidos() + "\n";
					textoArea.append(texto);
					
			}
				
			}
		});
		
		botonSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("ha pulsado el boton salir");
				new VentanaTablaInfoS();
				dispose();
				
			}
		});
		
		botonI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("ha pulsado el boton de informacion");
				new VentanaInformacion();
				dispose();
				
			}
		});
		
		setVisible(true);
		
	}
	
	
	class ModeloTabla extends DefaultTableModel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private List<Alumno> listaAlumno;
		private List<String> titulos = Arrays.asList("NOMBRE","APELLIDO","USUARIO","CONTRASEÑA","DOMICILIO","TELEFONO");
		
		public ModeloTabla(List<Alumno> lA) {
			listaAlumno = lA;
		}
		
		
		@Override
		public int getColumnCount() {
			return titulos.size();
		}
		
		@Override
		public String getColumnName(int column) {
			return titulos.get(column);
		}
		
		@Override
		public int getRowCount() {
			if(listaAlumno == null)
				return 0;
			return listaAlumno.size();
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
		@Override
		public Object getValueAt(int row, int column) {
			Alumno p = listaAlumno.get(row);
			switch(column) {
				case 0: return p.getNombre();
				case 1: return p.getApellidos();
				case 2: return p.getUsuario();
				case 3: return p.getContrasenia();
				case 4: return p.getDomicilio();
				case 5: return p.getTelefono();
				default: return null;
			}
		}
	}	
}


