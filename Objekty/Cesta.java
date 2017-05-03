package Objekty;

import java.util.List;
import java.util.ArrayList;

import aktivita.Sport;


public class Cesta {
	private DopravneProstriedky prostriedok;
	private List<Ucastnici> pasazieri= new ArrayList<>();
	private boolean obsadene;
	private int freeMiesta;
	
	public Cesta(DopravneProstriedky p){
		this.prostriedok = p;
		freeMiesta= prostriedok.getPocetMiest();
	}
	public void sparuj(Sport sport,String typ){
		switch (typ) {
		case "Tam":
	
			for(Ucastnici u: sport.getUcastnici()){
				if(u.isStavCestaTam()==false && freeMiesta!=0){pasazieri.add(u);u.setCestaTam(this);freeMiesta--;}
			}
			break;
        case "Spiatocna":
        	for(Ucastnici u: sport.getUcastnici()){
        		if(u.isStavCestaNaspat()==false && freeMiesta!=0){pasazieri.add(u);u.setCestaNaspat(this);freeMiesta--;}
    		}
			break;

		default:
			break;		
	}
		
		if(freeMiesta==0)setObsadene(true);
	}
	public boolean isObsadene() {
		return obsadene;
	}
	public void setObsadene(boolean obsadene) {
		this.obsadene = obsadene;
	}
	public int getFreeMiesta(){
		return freeMiesta;
	}
	
}
