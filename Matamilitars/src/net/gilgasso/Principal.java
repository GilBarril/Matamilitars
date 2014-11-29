package net.gilgasso;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
/**
 * 
 * @author gil
 *
 */
public class Principal extends GraphicsProgram {

public void init(){
	setSize(800,600);
	pause(400);
	addKeyListeners(this);
}
/**
 * objecte cano
 */
Cano cano;
/**
 * imatge de fons
 */
GImage fons = new GImage("fons.png");
/**
 * imatge de gameover
 */
GImage gameover = new GImage("gameover.png",100,100);
/**
 * array de bales de cano
 */
ArrayList<Bala> balescano = new ArrayList<Bala>();
public void run(){
	add(fons);
	GLabel marcador=null;
	Helicopter helicopter;
	ArrayList<Element> elementsescenari = new ArrayList<Element>();
	Escenari Normandia = new Escenari(elementsescenari,balescano,this);
	cano = new Cano("cano.png",this.getWidth()/2-35,this.getHeight()-170,this.getHeight());
	add(cano.imatgeelement);
	while(!Normandia.comprobarinvasio()){
		int surthelicopter = (int) (Math.random()*60)+1;
		if(surthelicopter == 6){
			Helicopter helic;
			     
			helic = new Helicopter("carbassa.png","hlicopter",this.getWidth(),80,this.getHeight());
			
			helic.setVelocitatx(-1);
			elementsescenari.add(helic);
			add(helic.imatgeelement);
		}
		if(surthelicopter == 5){
			Helicopter helic = null;
			
			
		    helic = new Helicopter("carbassa.png","hlicopter",-109,0,this.getHeight());	
			
			helic.setVelocitatx(1);
			System.out.println("heli");
			elementsescenari.add(helic);
			add(helic.imatgeelement);
		}
		String dadesmarcador = Normandia.contadorinvasio();
		marcador = new GLabel(dadesmarcador,650,100);
		marcador.setColor(Color.WHITE);
		marcador.setFont(new Font("Serif", Font.BOLD,18));
		
		add(marcador);
		Normandia.movimentelementspantalla();
		Normandia.movimentbales();
		Normandia.comprobarbaixes();
		pause(50);
		Normandia.tirarparacaigudistes();
		remove(marcador);
		
		}
	String dadesmarcador = Normandia.contadorinvasio();
	marcador = new GLabel(dadesmarcador,650,100);
	marcador.setColor(Color.WHITE);
	marcador.setFont(new Font("Serif", Font.BOLD,18));
	add(marcador);
	add(gameover);
	System.out.println("gameover");
	
}

public void keyPressed (KeyEvent arg0) {
	switch(arg0.getKeyCode()){
	case KeyEvent.VK_LEFT:
		
		cano.setDireccioxbala(-5);
		break;
	case KeyEvent.VK_RIGHT:
		
		cano.setDireccioxbala(+5);
		break;
	case KeyEvent.VK_SPACE:
		Bala bala=cano.disparabala();
		balescano.add(bala);
		add(bala.imatgeelement);
		break;	
	}
}


}




