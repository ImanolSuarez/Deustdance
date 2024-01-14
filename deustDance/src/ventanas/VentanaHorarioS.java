package ventanas;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import deustDance.Academia;
import deustDance.Alumno;
import deustDance.BaseDatos;


public class VentanaHorarioS extends JFrame{
	
	Connection con = BaseDatos.initBD("DeustDance.db");
	
	private DefaultTreeModel modeloArbol;
	private JTree arbol;
	
	private ModeloTabla modeloTabla;
	private JTable tabla;
	private JScrollPane scrollTabla;
	
	private JLabel labelBusqueda;
	private JTextField txtBusqueda;
	
	public VentanaHorarioS() {
		
		this.setTitle("Ventana horario secretaria");
		this.setSize(400,600);
		this.setLayout(null);
		this.setBounds(500, 100, 900, 800);
		this.setResizable(false);
		
		labelBusqueda = new JLabel("Introduzca el nombre de la persona: ");
		txtBusqueda = new JTextField(20);
		
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
		
		arbol.setBounds(30, 40, 200, 130);
		add(arbol);
		
		scrollTabla.setBounds(250, 45, 600, 650);
		add(scrollTabla);
		
		labelBusqueda.setBounds(300, -30, 300, 100);
		add(labelBusqueda);
		
		txtBusqueda.setBounds(520, 10, 150, 30);
		add(txtBusqueda);
		
		
		/*EVENTOS*/
		
		arbol.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				TreePath tp = e.getPath();
				try {
					int id =Integer.parseInt(tp.getLastPathComponent().toString());
					List<Alumno> l = Academia.cargarMapa().get(id);
					if(l != null && !l.isEmpty()) {
						tabla.setModel(new ModeloTabla(l));
					}else {
						System.out.println("a");
					}
				}catch (NumberFormatException e2) {
					System.out.println("No se ha podido converir a numero");
				}
				
				}
			});
		
		txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		setVisible(true);
	}
	
	private void cargarArbol() {
		int pos = 0;
		for(int id : Academia.cargarMapa().keySet()) {
			//Profesor p = BaseDatos.obtenerProfesorId(con, id);
			DefaultMutableTreeNode n = new DefaultMutableTreeNode(id);
			modeloArbol.insertNodeInto(n, (DefaultMutableTreeNode) modeloArbol.getRoot(), pos);
			pos++;
		}
	}
	
	
	public static void main(String[] args) {
		new VentanaHorarioS();
	}
	
		class ModeloTabla extends DefaultTableModel{
			
			private List<Alumno> listaAlumno;
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
