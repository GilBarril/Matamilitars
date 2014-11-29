package net.gilgasso;
import net.gilgasso.Principal;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;
/**
 * 
 * @author gil
 *
 */
public class Soldat extends Element {
	/**
	 * boolea que mira si el soldat ha estat contat a l'invasió
	 */
	boolean soldatcontat=false;
	/**
	 * boolea que mira si el soldat te paracaigudes
	 */
	boolean teparacaigudes=true;
	/**
	 * pantalla
	 */
	Principal Pantalla;
	/**
	 * imatge del paracaigudes
	 */
	GImage paraca = new GImage("paraca.png");
	/**
	 * velocitat y del soldat
	 */
    int velocitaty=2;
    /**
     * boolean que mira si el soldat ha arribat al desti
     */
    boolean desti=false;
    /**
     * 
     * @param imatge de  l'element
     * @param tipus de  l'element
     * @param x posicio x
     * @param y posicio y
     * @param a pantalla
     */
	public Soldat(String imatge, String tipus, int x, int y,int a) {
		super(imatge, tipus, x, y,a);
	    paraca.setLocation(this.getImatgeelement().getX(),this.getImatgeelement().getY()-this.getParaca().getHeight());
	}
	
	/**
	 * retorna la posicio y
	 */
	public int getY(){
    	int y = (int) this.getImatgeelement().getY()+ (int) this.getImatgeelement().getHeight();
    	return y;
    }
	/**
	 * mètode moure per al soldat
	 */
	public void moure() {
		
		if(this.getY()+this.getImatgeelement().getHeight()<this.alcadadepantalla){
		    this.getImatgeelement().move(0,velocitaty);
		    this.getParaca().move(0,velocitaty);
		    
		}
		else{
			
			if(this.isTeparacaigudes()){
				
				this.getImatgeelement().setImage("soldat-peu.png");
			}
			else{
				this.getImatgeelement().setImage("soldat-ferit.png");
				
			}
			
			
			this.setDesti(true);
			
		}
		
	}
	/**
	 * 
	 * @param soldatcontat passes el valor del boolean
	 */
	public void setSoldatcontat(boolean soldatcontat) {
		this.soldatcontat = soldatcontat;
	}
	/**
	 * 
	 * @return el paracaigudes (imatge)
	 */
	public GImage getParaca() {
		return paraca;
	}
	/**
	 * 
	 * @return retorna el valor del boolean teparacaigudes
	 */
	public boolean isTeparacaigudes() {
		return teparacaigudes;
	}
	/**
	 * 
	 * @param teparacaigudes li passes el valor del boolean 
	 */
	public void setTeparacaigudes(boolean teparacaigudes) {
		this.teparacaigudes = teparacaigudes;
	}
	/**
	 * 
	 * @param velocitaty li passes la velocitat y al soldat
	 */
	public void setVelocitaty(int velocitaty) {
		this.velocitaty = velocitaty;
	}
	/**
	 * 
	 * @return retorna el desti del soldat
	 */
	public boolean isDesti() {
		return desti;
	}
	/**
	 * 
	 * @param desti li passes el valor al boolean desti del soldat
	 */
	public void setDesti(boolean desti) {
		this.desti = desti;
	}
	/**
	 * 
	 * @return retorna el valor del boolean soldatcontat
	 */
	public boolean isSoldatcontat() {
		return soldatcontat;
	}
   
	 


	
	
	
	
	
}
