package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaInformacion extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton boton;
	private JTextArea txtInfor;
	private JScrollPane scrollarea;
	
	public VentanaInformacion() {
		
		this.setTitle("LOGIN");
		this.setSize(400,600);
		this.setLayout(null);
		this.setBounds(500, 100, 900, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		JLabel txt = new JLabel("Informacion sobre los procedimientos");
		txt.setFont(new Font("Agency FB", Font.BOLD, 20));
		txt.setForeground(Color.BLACK);
		
		txtInfor = new JTextArea("Aqui esta la explicacion de todos los pasos a tener en cuenta para realizar cualquier inserccion, modificacion, eliminacion, ect..." + "\n"
		 + "Si quiere insertar a un alumno o a un profesor, tendra que añadir los datos correspondientes a dicho alumno o profesor y despues clicar el boton de insertar." + "\n"
			+ "Si usted quiere eliminar a un alumno o un profesor, tendra que pulsar primero el boton de eliminar correspondinete y despues introducir el usuario deseado a eliminar. Una vez hecho esto se eliminara al usuario, ya sea profesor o alumno." + "\n"
		 + "Si quiere modificar cualquier alumno o profesor, tendra primero que seleccionarlo de la lista, seleccione y despues pulse el boton seleccionar, y una vez cargados los datos de dicha persona, podra modificar sus datos sin modificar el usuario, al terminar pulse el boton modificar." + "\n"
			+ "Los botones con nombre ALUMNO o PROFESOR o BAILE o INFORMACION sirven para poder acceder a esa informacion." + "\n"
			+ "Formato de registro: " + "\n"
			+ "1. Nombre: La primera es mayuscula y luego todo minuscula" + "\n" 
			+ "2. Apellido: La primera en mayuscula y luego todo minuscula" + "\n"
			 + "3. Usuario: Puede ser o mayuscula o minuscula y luego numeros del 0 al 9 opcionales, minimo de 4 palabras" + "\n"
			+ "4. Contraseña: Puede ser o mayuscula o minuscula y luego numeros del 0 al 9 opcionales, minimo de 5 palabras" + "\n"
			 + "5. Telefono: que empiece por 6 o por 7 y que le acompañen otros 8 numeros mas." + "\n"
				+ "6. Domicilio: La primera mayuscula y que no sea mas largo de 15 palabras." + "\n"
				+ "7. Los numeros de como el profesor asignado van del 0 al 9 menos el dinero que puede ser hasta 10000000.");
		txtInfor.setEditable(false);
		scrollarea = new JScrollPane(txtInfor);
		
		boton = new JButton("Volver");
		
		scrollarea.setBounds(30, 70, 800, 200);
		add(scrollarea);
		
		
		
		boton.setBounds(350, 300, 100, 30);
		add(boton);
		
		txt.setBounds(80, 30, 250, 20);;
		add(txt);
		
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaInicial();
				dispose();
				
			}
		});
		
		
		this.setVisible(true);
		
	}

}
