package ventanas;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import deustDance.Academia;
import deustDance.Dias;
import deustDance.Horario;


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
	
	public JTable tablaHorarioAlumno() {
		
		// MODELO CURSO
		DefaultTableModel modeloCursosAlumno = new DefaultTableModel(new Object[] {"Hora","Lunes","Martes","Miercoles","Jueves","Viernes"},0) {
			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for (int hora = 5; hora < 9 ; hora = hora + 2) {
			Object[] linea = new Object[6];
			linea[0] = hora + ":00  -  " + hora + ":50";
			int columna = 1;
			for(Dias dia : Dias.values()) {
				for(Horario horario : Academia.getListaHorarios()) {
					if(VentanaAlumno.alumno.getMapaGrupos().containsKey(horario.getGrupo().getCodigo()) && horario.getDia().toString().equals(dia.toString()) && horario.getHora() == hora) {
						linea[columna] = horario.getGrupo();
					}
				}
				columna++;
			}
			modeloCursosAlumno.addRow(linea);
			modeloCursosAlumno.addRow(new Object[] {});
			linea[0] = (hora + 1) + ":00  -  " + (hora + 1) + ":50";
			modeloCursosAlumno.addColumn(linea);
			modeloCursosAlumno.addColumn(new Object[] {});
		}
		modeloCursosAlumno.removeRow(modeloCursosAlumno.getRowCount() - 1);
		
		tabla = new JTable(modeloCursosAlumno);
		
		tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				setHorizontalAlignment(SwingConstants.CENTER);
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				((JLabel) c).setHorizontalAlignment(JLabel.CENTER);
				
				return c;
				
			}
		});
		tabla.setModel(modeloCursosAlumno);
		tabla.getTableHeader().setReorderingAllowed(false);
		return tabla;
	}
}
