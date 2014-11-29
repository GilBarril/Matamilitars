package net.gilgasso;
import java.util.ArrayList;

import acm.graphics.GLabel;
/**
 * 
 * @author gil
 *
 */
public class Escenari {
    /**
     *  conta els zombies que entren
     */
	int containvasio=0;
	/**
	 * Helicopters que he canviat la imatge i son carbasses
	 */
	Helicopter heli;
	/**
	 * Array d'invasors per saber quan t'han envaït
	 */
	ArrayList<Soldat> invasors = new ArrayList<Soldat>();
	/**
	 * Array per esborrar elements
	 */
	ArrayList<Element> elementsborrar = new ArrayList<Element>();
	/**
	 * Array dels elements de la pantalla
	 */
	ArrayList<Element> elementspantalla;
	/**
	 * Array de bales
	 */
	ArrayList<Bala> bales = new ArrayList<Bala>();
	/**
	 * Array de paracaigudistes
	 */
	ArrayList<Soldat> paracaigudistes = new ArrayList<Soldat>();
	/**
	 * passo la pantalla per poder agafar els seus valors
	 */
	Principal pantallaEscenari;
	/**
	 * boolean per mirar si s'ha acabat el joc
	 */
	boolean acabat=false;
	/**
	 * 
	 * @param ele array d'elements
	 * @param bal aray de bales
	 * @param pantalla la pantalla
	 */
	Escenari(ArrayList<Element> ele,ArrayList<Bala> bal,Principal pantalla){
		elementspantalla = ele;
		pantallaEscenari = pantalla;
		bales=bal;
	}
	/**
	 * metode per moure els elements de la pantalla
	 */
public void movimentelementspantalla(){
    
		
	ArrayList<Element> elementsborrar = new ArrayList<Element>();
    for(Element o: elementspantalla){
    	
    	o.moure();
    	
    	
	    	 if(o.imatgeelement.getX()<=0-o.getImatgeelement().getWidth() || o.getImatgeelement().getX()>pantallaEscenari.getWidth()){
	    	  
	    	  elementsborrar.add(o);
	    	  pantallaEscenari.remove(o.getImatgeelement());
	    	  
	    	}
   }
    
  
    for(Element borraHeli : elementsborrar){    	
    	elementspantalla.remove(borraHeli);
    }
    
}	
/**
 * moviment de les bales de la pantalla
 */
public void movimentbales(){
	for(Bala b : bales){
		b.moure();
    }
}
/**
 * mètode per tirar paracaigudistes
 */
public void tirarparacaigudistes(){
    	for(Element o: elementspantalla){
			    if(o.getX()>10 && o.getX()+o.getImatgeelement().getWidth()<pantallaEscenari.getWidth()-20 && o instanceof Helicopter){
			    	Soldat soldat = ((Helicopter)o).deixasoldat();
					if(soldat!=null){
					   pantallaEscenari.add(soldat.getImatgeelement());
					   pantallaEscenari.add(soldat.getParaca());
					   paracaigudistes.add(soldat);
					
				}
			   }  
			 }
    	for(Soldat p : paracaigudistes){
    	    elementspantalla.add(p);	
    	 }
    	paracaigudistes.clear();
    	}
/**
 * mètode per comprobar les baixes
 */
public void comprobarbaixes(){
	if(!bales.isEmpty()){
		for(Bala b : bales){
			for(Element s : elementspantalla){
				if(s instanceof Soldat){
				if(b.imatgeelement.getBounds().intersects(s.getImatgeelement().getBounds())){
					pantallaEscenari.remove(b.getImatgeelement());
					pantallaEscenari.remove(s.getImatgeelement());
					pantallaEscenari.remove(((Soldat) s).getParaca());
					elementsborrar.add(b);
					elementsborrar.add(s);
					
				}
				if(b.imatgeelement.getBounds().intersects(((Soldat)s).getParaca().getBounds())){
					pantallaEscenari.remove(b.getImatgeelement());
					pantallaEscenari.remove(((Soldat)s).getParaca());
					elementsborrar.add(b);
					((Soldat)s).setTeparacaigudes(false);
					if(((Soldat)s).isTeparacaigudes()==false){
					   ((Soldat) s).setVelocitaty(20);
					}
				}
				}
			}
			
		}
	if(!elementsborrar.isEmpty()){
		 for(Element borrar : elementsborrar){
			if(borrar instanceof Bala){
			 bales.remove(borrar);
			}
			else{
		     elementspantalla.remove(borrar);
			}
		}
	  }
    }
}

/**
 * mètode per comprovar l'invasió
 * @return torna el boolean de si s'ha acabat el joc
 */
	public boolean comprobarinvasio(){
		for(Element e : elementspantalla){
			if(e instanceof Soldat && ((Soldat)e).isDesti() && !((Soldat)e).isSoldatcontat() && ((Soldat)e).isTeparacaigudes()){
				((Soldat)e).setSoldatcontat(true);
				
				invasors.add(((Soldat)e));				
			}
			
			
		}
		containvasio = invasors.size();
		if(containvasio==10){
			acabat=true;
		}
		return acabat;
	}
	
	/**
	 * mètode per crear el marcador
	 * @return marcador
	 */
	public String contadorinvasio(){
		
		String marcador="Invasors: " + invasors.size();	
		
		
	return marcador;
	}
	
	
	
	
}
