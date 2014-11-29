package net.gilgasso;
/**
 * 
 * @author gil
 *
 */
public class Bala extends Element {
	/**
	 * la velocitaty de la bala
	 */
    int velocitaty;
    /**
     *  la velocitatx de la bala
     */
    int velocitatx;
    
    /**
     * 
     * @param imatge la imatge de l'objecte
     * @param tipus el tipus de l'objecte
     * @param x la posicio x
     * @param y la posicio y
     * @param a la pantalla ( canvas )
     */
	public Bala(String imatge, String tipus, int x, int y, int a) {
		super(imatge, tipus, x, y, a);
		velocitaty=-20;
	}
    /**
     * passo la posicio y de la imatge de l'objecte
     */
	public int getY(){
    	int x = (int) this.getImatgeelement().getY()+ (int) this.getImatgeelement().getHeight();
    	return x;
    }
	/**
	 * mètode per passar una velocitat x
	 */
	public void setVelocitatx(int velocitatx) {
		this.velocitatx = velocitatx;
	}
    /**
     * mètode per moure la bala 
     * 
     */
	public void moure() {
		if(this.getY()>0){
		this.getImatgeelement().move(velocitatx,velocitaty);
    }

	}
	
}
