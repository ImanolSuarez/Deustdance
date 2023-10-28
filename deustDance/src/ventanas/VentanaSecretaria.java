package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class VentanaSecretaria extends JFrame {
	protected JTabbedPane pestañas;
	
	public VentanaSecretaria() {
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		// Pestaña Alumnos
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Contenido de la Pestaña 1"));
        tabbedPane.addTab("Alumnos", panel1);

        // Pestaña Profesores
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Contenido de la Pestaña 2"));
        tabbedPane.addTab("Profesores", panel2);

        // Pestaña Horario
        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Contenido de la Pestaña 3"));
        tabbedPane.addTab("Horario", panel3);

        this.add(tabbedPane);	
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Ventana del alumno");
		this.setSize(600, 400);
		this.setVisible(true);
	}
}
