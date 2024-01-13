package ventanas;

import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Tablas {
	protected static JTable tabla;
	SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
	
	public Tablas(){
		
	}
	public JTable tablaAlumno() {
		
		// MODELO ALUMNO
		DefaultTableModel modeloAlumno = new DefaultTableModel(new Object[] {"Nombre","Apellidos","Usuario","Contraseña","Domicilio","Profesor Asignado","Clase Asignada","Dinero","Grupo","Calificación"}, 0) {
			protected static final long serialVersionUID = 1L;
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		// CREACION DE LA TABLA
		tabla = new JTable(modeloAlumno);
		
		//Renderer
		tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			
			protected static final long serialVersionUID = 1L;
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				((JLabel) c).setHorizontalAlignment(JLabel.CENTER);
				if (column == 0) {
					c.setBackground(new Color(46, 192, 224));
				} else {
					c.setBackground(new Color(42, 239, 216));
				}
				return c;
			}
		});
		
		tabla.setModel(modeloAlumno);
		
		tabla.getTableHeader().setReorderingAllowed(false);
		
		tabla.setRowHeight(25);
		tabla.getTableHeader().setPreferredSize(new Dimension(tabla.getWidth(),30));
		return tabla;
	}
}
