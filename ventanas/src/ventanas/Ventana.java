package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Ventana implements ActionListener{
	JFrame ventana;
	JMenu opcion1, opcion2, sOpcion1, sOpcion2, sOpcion3, sOpcion4;
	JMenuItem sub1, sub2;
	JMenuBar menuBar;
	JPanel panelA, panelB;
	JLabel saludo, otroSaludo;
	JButton boton;
	
	public void crearMenu(){
		menuBar = new JMenuBar();
		opcion1 = new JMenu("1");
		opcion2 = new JMenu("2");
	
		sOpcion1 = new JMenu("A");
		sOpcion2 = new JMenu("B");
		sOpcion3 = new JMenu("C");
		sOpcion4 = new JMenu("D");
		
		sub1 = new JMenuItem("X");
		sub2 = new JMenuItem("Y");
		
		menuBar.add(opcion1);
		menuBar.add(opcion2);
		
		opcion1.add(sOpcion1);
		opcion1.add(sOpcion2);
		
		opcion2.add(sOpcion3);
		opcion2.add(sOpcion4);
		
		sOpcion2.add(sub1);
		sOpcion2.add(sub2);
		
		sOpcion1.addActionListener(this);
		sOpcion2.addActionListener(this);
		sOpcion3.addActionListener(this);
		sOpcion4.addActionListener(this);
		
		sub1.addActionListener(this);
		sub2.addActionListener(this);
	}
	
	public void crearPanelA() {
		panelA = new JPanel();
		saludo = new JLabel("Bienvenidos");
		otroSaludo = new JLabel("BIENVENIDOOOS");
		panelA.setLayout(new BoxLayout(panelA, BoxLayout.X_AXIS));
		panelA.add(saludo);
	}
	
	public void crearPanelB() {
		panelB = new JPanel();
		boton = new JButton();
		boton.setText("Entrar");
		panelB.setLayout(new BoxLayout(panelB, BoxLayout.X_AXIS));
		panelB.add(boton);
	}
	
	public void crearVentana() {
		ventana = new JFrame();
		ventana.setTitle("Menú");
		ventana.setSize(400, 400);
		ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS));
		ventana.setVisible(true);
		ventana.setJMenuBar(menuBar);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public Ventana() {
		this.crearPanelA();
		this.crearPanelB();
		this.crearMenu();
		this.crearVentana();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sub1) {
			ventana.setSize(500,500);
		}
	}
}
