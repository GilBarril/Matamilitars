package net.gilgasso;
import acm.program.*;
import acm.graphics.*;

/**
 * 
 * @author gil
 *
 */
public abstract class Element{
	/**
	 * imatge de l'element
	 */
	GImage imatgeelement;
	/**
	 * velocitatx de l'element
	 */
	int velocitatx;
	/**
	 * tipus d'element
	 */
	public String tipuselement;
	/**
	 * alçada de la pantalla
	 */
	public static int alcadadepantalla;
	/**
	 * 
	 * @param imatge imatge de l'element
	 * @param tipus tipus de l'element
	 * @param x posicio x de l'element
	 * @param y posicio y de l'element
	 * @param a alçada de la pantalla
	 */
	public Element(String imatge,String tipus,int x,int y,int a){
		   
		  imatgeelement = new GImage(imatge,x,y);
		  tipuselement = tipus;
		  alcadadepantalla=a;
	   }
	
	
   /**
    * mètode per passar una imatge	
    * @param s nom  de la imatge
    * @param x posicio x de la imatge
    * @param y posicio y de la imatge
    */
   public void setImatgeelement(String s,double x,double y) {
		this.imatgeelement = new GImage(s,x,y);
	}
/**
 * 
 * @param x passes la posicio x
 * @param y passes la posicio y
 */
  	public void setPosicio(double x,double y) {
		this.imatgeelement.setLocation(x,y);
	}

	/**
	 * declara el mètode moure
	 */
	public abstract void moure();
	
	/**
	 * 
	 * @return retorna la velocitat x de l'element
	 */
	public int getVelocitatx() {
			return velocitatx;
		}

    /**
     * 
     * @param velo li passes la velocitat x a l'element
     */
    public void setVelocitatx(int velo) {
			this.velocitatx = velocitatx*velo;
		}
	/**
	 * 
	 * @return retorna la posicio x
	 */
   	public int getX(){
    	int x = (int) this.imatgeelement.getX();
    	return x;
    }
   	
   	/**
   	 * 
   	 * @return retorna la posicio y
   	 */
    public int getY(){
    	int y = (int) this.imatgeelement.getY()+ (int) this.imatgeelement.getHeight();
    	return y;
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
     * @return retorna el tipus de l'element
     */
	public String getTipuselement() {
		return tipuselement;
	}

   /**
    * 
    * @return retorna l'alçada de la pantalla
    */
	public static int getAlcadadepantalla() {
		return alcadadepantalla;
	}


}
