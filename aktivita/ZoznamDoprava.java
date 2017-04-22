package aktivita;

import java.util.ArrayList;
import java.util.List;

public class ZoznamDoprava {
	private int pocetSpolocnosti=0;
	private DopravnaSpolocnost spolocnost;
	private List<DopravnaSpolocnost> spolocnosti = new ArrayList<>();

	public int getpocetSpolocnosti(){return pocetSpolocnosti;}
	
	public void pridajSpolocnost(String name,int cislo){
		spolocnosti.add(new DopravnaSpolocnost(name, cislo));
		pocetSpolocnosti++;
	}
	
	public void pridajProstriedok(String druh,String name, int miesta,int cena){
		spolocnost.pridajProstriedky(druh, name, miesta, cena);
	}
	
	public boolean vyhladajSpolocnost(String name){
		for(DopravnaSpolocnost z: spolocnosti){
			if(z.getMenoS().equals(name)){   spolocnost=z;  return true; }
		}
		return false;		
	}
	

	

	

}
