package net.gilgasso;
import acm.program.*;
import acm.graphics.*;

/**
 * 
 * @author gil
 *
 */
public class Cano {
	/**
	 * objecte bala que dispararà el cano
	 */
    Bala bala;
    /**
     * la direccio de la bala en les x
     */
    int direccioxbala=0;
    /**
     * la imatge del cano
     */
    GImage imatgeelement;
    /**
     * l'alçada de la pantalla
     */
    int alcadapantalla;
    /**
     * 
     * @param imatge la imatge del cano
     * @param x la posicio en les x
     * @param y la posicio en les y
     * @param a la pantalla
     */
	public Cano(String imatge, int x, int y, int a) {
		imatgeelement =new GImage (imatge,x,y);
		alcadapantalla = a;
	}

	/**
	 * mètode per disparar bales del cano
	 * 
	 * @return retorna un objecte bala
	 */
	public  Bala disparabala(){
    	 int altura = (int) this.getImatgeelement().getHeight();
    	 int amplada = (int) this.getImatgeelement().getWidth()/2;
    	
    	bala = new Bala ("bales.png","soldat",this.getX()+amplada,this.getY()-altura,this.getAlcadapantalla());
    	bala.setVelocitatx(this.getDireccioxbala());
    
    	return bala;
    }
    /**
     * 	
     * @return la posicio y
     */
	public int getY(){
    	int y = (int) this.getImatgeelement().getY()+ (int) this.getImatgeelement().getHeight();
    	return y;
    }
	/**
	 * 
	 * @return la posicio x
	 */
	public int getX(){
    	int x = (int) this.getImatgeelement().getX();
    	return x;
    }

    /**
     * 
     * @return la direccio x de la bala
     */
	public int getDireccioxbala() {
		return direccioxbala;
	}

    /**
     * 
     * @param pases la direccio x a la bala
     */
	public void setDireccioxbala(int bala) {
		this.direccioxbala = direccioxbala + bala;
	}

    /**
     * 
     * @return retorna la imatge de l'element
     */
	public GImage getImatgeelement() {
		return imatgeelement;
	}

    /**
     * 
     * @return l'alçada de la pantalla
     */
	public int getAlcadapantalla() {
		return alcadapantalla;
	}

   
}
