package gui;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


import faseB.Controlador;



public class Mover extends JInternalFrame {

	private static final long serialVersionUID = -6297916466298139562L;
	private Timer timer;
	private int ancho;
	private int alto;
	private JLabel lbSubmarino,lbBarca , lblVida, lblVidaContador, lblHP, lblHPContador, lblPuntos, lblPuntosContador, lblMensaje,lblMar; 
	private JLabel [] lbBomba;
	private int [] tiempoExplosion;
	private Controlador control;
	
	
	
	public Mover() {
		
		tamaño();
		lblMar = new JLabel();
		lblMar. setIcon(new ImageIcon("mar.jpg"));
		lblMar.setBounds(0,0,600,1000);
		this.getContentPane().add(lblMar);
		
		this.getContentPane().setLayout(null);
		this.getContentPane().addKeyListener(new ManejoKey());
		timer = new Timer(33, new AccionTimer());
		timer.start();
		
		this.control = new Controlador();
		
		lbSubmarino = new JLabel();
		lbSubmarino.setIcon(new ImageIcon("submarino.jpg"));
		lbSubmarino.setBounds((int)(control.SubmarinoToView().getPosicionX()),(int)(control.SubmarinoToView().getPosicionY()),100,100);
		
		this.lbBarca = new JLabel();
		lbBarca.setIcon(new ImageIcon("barco.jpg"));
		lbBarca.setBounds((int)(control.BarcotoView().getPosicionX()),(int)(control.BarcotoView().getPosicionY()), 100, 100);
		
		
		Font letra = new Font("Verdana", Font.BOLD, 12);
		this.lblVida = new JLabel("Vidas:");
		this.lblVida.setBounds(10, 5, 100, 15);
		this.lblVida.setHorizontalAlignment(JLabel.CENTER);
		lblVida.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblVida.setFont(letra);
		this.lblVidaContador = new JLabel("0");
		this.lblVidaContador.setBounds(110, 5, 100, 15);
		this.lblVidaContador.setHorizontalAlignment(JLabel.CENTER);
		lblVidaContador.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblVidaContador.setFont(letra);
		this.lblHP = new JLabel("HP:");
		this.lblHP.setBounds(210, 5, 90, 15);
		this.lblHP.setHorizontalAlignment(JLabel.CENTER);
		lblHP.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblHP.setFont(letra);
		this.lblHPContador = new JLabel("0");
		this.lblHPContador.setBounds(300, 5, 90, 15);
		this.lblHPContador.setHorizontalAlignment(JLabel.CENTER);
		lblHPContador.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblHPContador.setFont(letra);
		lblPuntos = new JLabel("Puntos : ");
		lblPuntos.setBounds(390, 5, 100, 15);
		lblPuntos.setHorizontalAlignment(JLabel.CENTER);
		lblPuntos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPuntos.setFont(letra);
		lblPuntosContador = new JLabel("0");
		lblPuntosContador.setBounds(490, 5, 100, 15);
		lblPuntosContador.setHorizontalAlignment(JLabel.CENTER);
		lblPuntosContador.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblPuntosContador.setFont(letra);
		
		
		this.getContentPane().add(lbSubmarino);
		this.getContentPane().add(lbBarca);
		lbBomba = new JLabel[10];
		tiempoExplosion= new int [10];
		for (int i = 0; i<10; i++)
		{
		tiempoExplosion[i]=0;
		lbBomba[i]= new JLabel();
		lbBomba[i].setIcon(new ImageIcon("bomba.jpg"));
		lbBomba[i].setBounds((int)(-100),(int)(-100), 100, 100);
		this.getContentPane().add(lbBomba[i]);
		}
		Font letraFin = new Font("Verdana", Font.BOLD, 60);
		this.lblMensaje = new JLabel("Fin del Juego");
		this.lblMensaje.setBounds(-100, -100, 100, 100);
		this.lblMensaje.setHorizontalAlignment(JLabel.CENTER);
		lblMensaje.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblMensaje.setFont(letraFin);
		this.getContentPane().add(lblMensaje);
		
		
		
		this.getContentPane().add(lblPuntos);
		this.getContentPane().add(lblPuntosContador);
		this.getContentPane().add(this.lblVida);
		this.getContentPane().add(this.lblVidaContador);
		this.getContentPane().add(this.lblHP);
		this.getContentPane().add(this.lblHPContador);

		this.setSize((int)(600 ),(int)( alto*.9));
		this.setVisible(true);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(false);
		this.setResizable(false);
		this.setLocation(4, 8);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().add(lblMar);
	
	}
	
	private void tamaño() {
	    Toolkit t = Toolkit.getDefaultToolkit();    
        Dimension dimensions = t.getScreenSize();
        ancho = dimensions.width;
        alto = dimensions.height;
	}
	
	class AccionTimer implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (control.continuarJuego()) {
			control.moverBarcoYBombas();
			lbBarca.setBounds((int)(control.BarcotoView().getPosicionX()),(int)(control.BarcotoView().getPosicionY()), 100, 100);
			lblPuntosContador.setText(control.SubmarinoToView().getCantPuntos()+"");
			lblHPContador.setText(control.SubmarinoToView().getHP()+"");
			lblVidaContador.setText(control.SubmarinoToView().getCantVidas()+"");
			for (int i = 0; i<10; i++) {
				int desplazar = 0;
				lbBomba[i].setBounds((int)(-100),(int)(-100), 100, 100);
				if (control.BombatoView()[i] != null) {
					if (control.BombatoView()[i].getExploto()) {
						tiempoExplosion[i]+=1;
						if (tiempoExplosion[i]<10)lbBomba[i].setIcon(new ImageIcon("exploto.jpg"));
						else desplazar = 1000;
					}
					else {
						lbBomba[i].setIcon(new ImageIcon("bomba.jpg"));
						tiempoExplosion[i] = 0;
					}
					lbBomba[i].setBounds((int)(control.BombatoView()[i].getPosicionX())+desplazar,(int)(control.BombatoView()[i].getPosicionY())+desplazar, 100,100);
					
				}
			}}
			else {
				lblMensaje.setBounds(10,100, 580, 300);
				timer.stop();
			}
		}		
	}
	
	

	class ManejoKey implements KeyListener{

		@Override
		public void keyPressed(KeyEvent key) {
			//JOptionPane.showMessageDialog(null, "key pressed " + key.getKeyCode());
			if(key.getKeyCode() == 37) { //izquierda
				control.moverSubmarino("izq");
			}
			if(key.getKeyCode() == 39) { //derecha
				control.moverSubmarino("der");
			}
			if(key.getKeyCode() == 38) { //arriba
				control.moverSubmarino("arr");
			}
			if(key.getKeyCode() == 40) { //abajo
				control.moverSubmarino("aba");
			}
			lbSubmarino.setBounds((int)(control.SubmarinoToView().getPosicionX()),(int)(control.SubmarinoToView().getPosicionY()),100,100);
		}

		@Override
		public void keyReleased(KeyEvent e) { }
		
		@Override
		public void keyTyped(KeyEvent e) { }
	}
}