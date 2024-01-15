package ventanas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import deustDance.Academia;
import deustDance.Alumno;
import deustDance.BaseDatos;
import deustDance.Profesor;


public class VentanaTablaInfoS extends JFrame{
	
	Connection con = BaseDatos.initBD("DeustDance.db");
	
	private DefaultTreeModel modeloArbol;
	private JTree arbol;
	
	private ModeloTabla modeloTabla;
	private JTable tabla;
	private JScrollPane scrollTabla;
	
	private JLabel labelBusqueda;
	private JTextField txtBusqueda;
	
	private JButton botonSalir;
	private JButton botonA;
	private JButton botonP;
	private JButton botonBaile;
	
	private int fila, columna;
	
	private JButton botonI;
	
	private Logger logger = Logger.getLogger(VentanaProfesorS.class.getName());
	
	public VentanaTablaInfoS() {
		
		this.setTitle("Ventana horario secretaria");
		this.setSize(400,600);
		this.setLayout(null);
		this.setBounds(300, 90, 900, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		ImageIcon imagenLogo = (new ImageIcon(getClass().getResource("/imagenes/imagenLogo.png")));
		setIconImage(imagenLogo.getImage());
		
		labelBusqueda = new JLabel("Introduzca el nombre de la persona: ");
		txtBusqueda = new JTextField(20);
		
		botonSalir = new JButton("Salir");
		botonA = new JButton("Alumno");
		botonP = new JButton("Profesor");
		botonBaile = new JButton("Baile");
		botonI = new JButton(new ImageIcon(getClass().getResource("/imagenes/imagenInfo.jpg")));
		
		fila = -1;
		columna = -1;
		
		/*CREACION DE LA JTree*/
		
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("PROFESORES");
		modeloArbol = new DefaultTreeModel(raiz);
		arbol = new JTree(modeloArbol);
		cargarArbol();
		
		/*CREACION DE LA JTable*/
		
		modeloTabla = new ModeloTabla(null);
		tabla = new JTable(modeloTabla);
		scrollTabla = new JScrollPane(tabla);
		/*AÑADIENDO LOS COMPONENTES A LA VENTANA*/
		
		logger.info("cargando los componentes a la ventana");
		
		arbol.setBounds(30, 40, 200, 130);
		add(arbol);
		
		scrollTabla.setBounds(250, 45, 600, 300);
		add(scrollTabla);
		
		labelBusqueda.setBounds(300, -30, 300, 100);
		add(labelBusqueda);
		
		txtBusqueda.setBounds(520, 10, 150, 30);
		add(txtBusqueda);
		
		botonSalir.setBounds(120, 360, 150, 30);
		add(botonSalir);
		
		botonA.setBounds(280, 360, 150, 30);
		add(botonA);
		
		botonP.setBounds(440, 360, 150, 30);
		add(botonP);
		
		botonBaile.setBounds(600, 360, 150, 30);
		add(botonBaile);
		
		botonI.setBounds(800, 15, 20, 20);
		add(botonI);
		
		/*EVENTOS*/
		
		arbol.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				TreePath tp = e.getPath();
				try {
					logger.info("se selecciono un elemento en el combo");
					String[] cadena = tp.getLastPathComponent().toString().split(",");
					int id = Integer.parseInt(cadena[cadena.length-1].trim());
					List<Alumno> l = Academia.cargarMapa().get(id);
					if(l != null && !l.isEmpty()) {
						logger.info("se carga la lista de alumnos");
						tabla.setModel(new ModeloTabla(l));
					}else {
						
					}
				}catch (NumberFormatException e2) {
					
				}
				
			}
		});
		
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("ha pulsado el boton salir");
				new VentanaInicial();
				dispose();
				
			}
		});
		
		botonA.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("ha pulsado el oton de Alumno");
				new VentanaAlumnoS();
				dispose();
				
			}
		});
		
		botonP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("ha pulsado el boton de Profesor");
				new VentanaProfesorS();
				dispose();
				
			}
		});
		
		botonBaile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("ha pulsado el boton de baile");
				new VentanaBaileS();
				dispose();
				
			}
		});
		
		/*RENDER DE LA TABLA*/
		
		tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if(row==fila && column==columna) {
					c.setBackground(Color.GREEN);
				}else {
					c.setBackground(table.getBackground());
				}
				return c;
			
			}
		});
		
		tabla.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				Point p = e.getPoint();
				fila = tabla.rowAtPoint(p);
				columna = tabla.columnAtPoint(p);
				tabla.repaint();
				
			}
		});
		
		tabla.addMouseListener(new MouseAdapter() {
			
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				fila = -1;
				columna = -1;
				tabla.repaint();
				
			}
		});
		
		/*OTRO RENDER*/		
		
		txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		});
		
		botonI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.info("ha pulsado el boton de info");
				new VentanaInformacion();
				dispose();
				
			}
		});
		
		setVisible(true);
	}
	
	private void cargarArbol() {
		int pos = 0;
		for(int id : Academia.cargarMapa().keySet()) {
			DefaultMutableTreeNode n = new DefaultMutableTreeNode(id);
			modeloArbol.insertNodeInto(n, (DefaultMutableTreeNode) modeloArbol.getRoot(), pos);
			pos++;
		}
	}
	
	
		class ModeloTabla extends DefaultTableModel{
			
			private List<Alumno> listaAlumno = new ArrayList<>();
			private List<String> titulos = Arrays.asList("NOMBRE","APELLIDO","USUARIO","CONTRASEÑA","DOMICILIO","TELEFONO","CALIFICACION");
			
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
					case 6: return p.getCalificacion();
					default: return null;
				}
			}
		}
		
			
		}
	
