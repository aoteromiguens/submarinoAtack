package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 8615423218491304000L;

	private JMenu ventanas;
	private JMenuBar barraMenu;
	private JMenuItem  resolucion, movimiento;
	private JLabel lblRotulo;
	private JDesktopPane dp;
	
	
	private int ancho;
	private int alto;
	
	public Ventana() {
		tamaño();
		configurarMenu();
		configurarPantalla();
		eventos();
		
		this.setContentPane(dp);
		this.setSize(625,alto);
		this.setVisible(true);
		this.setLocation(0, 0);
		
	}
	
	private void configurarMenu() {
		barraMenu = new JMenuBar();
		ventanas = new JMenu("Opciones");
		resolucion = new JMenuItem("Ver Resolucion");
		movimiento = new JMenuItem("Jugar");
		ventanas.add(movimiento);
		ventanas.add(resolucion);
		barraMenu.add(ventanas);
		this.setJMenuBar(barraMenu);
	}
	
	private void configurarPantalla() {
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		
		
		
		Font letra = new Font("Verdana", Font.BOLD, 50);
		lblRotulo = new JLabel("Hola Jugador ");
		lblRotulo.setBounds(50, 50, 500, 500);
		lblRotulo.setHorizontalAlignment(JLabel.CENTER);
		lblRotulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblRotulo.setFont(letra);
		dp = new JDesktopPane();
		dp.add(lblRotulo);
	}
	
	private void tamaño() {
	    Toolkit t = Toolkit.getDefaultToolkit();    
        Dimension dimensions = t.getScreenSize();
        ancho = dimensions.width;
        alto = dimensions.height;
	}
	
	private void eventos() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		resolucion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "La resolucion es : " + ancho + " x " + alto);
			}
		});
		
		movimiento.addActionListener(new ManejoMovimiento());
		
	}


	class ManejoMovimiento implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Mover vm = new Mover();
			vm.setVisible(true);
			dp.add(vm);
			vm.setRequestFocusEnabled(true);
			movimiento.setEnabled(false);
			lblRotulo.setBounds(-100, -100, 100, 30);
		}
		
	}
}
