package net.gilgasso;
/**
 * 
 * @author gil
 *
 */
public class Helicopter extends Element{
   /**
    * objecte soldat per al paracaigudista
    */
    Soldat soldi;
    /**
     * la procedencia de l'helicopter (carbassa)
     */
    int procedencia;
    /**
     * numero de soldats que pot fer un helicopter per passada
     */
    int soldats=1;
    /**
     * 
     * @param imatge de l'element
     * @param tipus de l'element
     * @param x posicio x
     * @param y posicio y
     * @param a alçadapantalla
     */
	public Helicopter(String imatge, String tipus, int x, int y,int a) {
		super(imatge, tipus, x, y, a);
		procedencia=0;
		velocitatx=6;
	}

	/**
	 * 
	 * @return retorna la procedència de l'helicopter
	 */
	public int getProcedencia() {
		return procedencia;
	}

    /**
     * 
     * @param procedencia li passes la procedència a l'helicopter
     */
	public void setProcedencia(int procedencia) {
		this.procedencia = procedencia;
	}

    /**
     * mètode per moure l'helicopter
     */
	public void moure() {			
		    
			this.getImatgeelement().move(velocitatx,0);
	}
	
	
  
   /**
    * 
    * @return retorna un paracaigudista si pot sinó retorna null
    */
	public Soldat deixasoldat(){

		if (this.soldats > 0) {
    		int paracaigudes = (int) (Math.random()*60)+1;
        	if(paracaigudes == 2){
        	soldi = new Soldat ("soldat.png","soldat",this.getX(),this.getY(),this.alcadadepantalla);
        	this.soldats--;
        	return soldi;
        	}
        	
		}
        	return null;
        }
    
}
