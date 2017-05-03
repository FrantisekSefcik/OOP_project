package aktivita;

import java.util.ArrayList;
import java.util.List;

import Objekty.Autobus;
import Objekty.DopravneProstriedky;
import Objekty.Lietadlo;
import Objekty.Auto;
public class DopravnaSpolocnost {
	
	private String menoS;
	private int cisloUctu;
	private List<DopravneProstriedky> prostriedky = new ArrayList<>();
	
	public boolean vyhladajProstriedok(String name){
		for(DopravneProstriedky p : prostriedky){
			if(p.getMenoProstriedku().equals(name)){return true;}
		}
		return false;
	}
	public void sparuj(Sport sport,String name,String druh){
		for(DopravneProstriedky p : prostriedky){
			if(p.getMenoProstriedku().equals(name)){p.sparuj(sport, druh);}
		}
	}
	public DopravnaSpolocnost(String name,int cislo){
		this.setMenoS(name); this.cisloUctu = cislo;
	}
	
	public List<DopravneProstriedky> getProstriedky() {
		return prostriedky;
	}
	public void setProstriedky(List<DopravneProstriedky> prostriedky) {
		this.prostriedky = prostriedky;
	}	
	public void pridajProstriedky(String druh,String name, int miesta,int cena) {
		if(druh.equals("Lietadlo")){ prostriedky.add(new Lietadlo(name, miesta, cena));}else if (druh.equals("Auto"))
		{	prostriedky.add(new Auto(name, miesta, cena));
		}else if(druh.equals("Autobus")){ prostriedky.add(new Autobus(name, miesta, cena));}
	}

	public String getMenoS() {
		return menoS;
	}

	public void setMenoS(String menoS) {
		this.menoS = menoS;
	}
	public String spravaSpolocnosti(){
		String sprava = menoS+"\n";
		int i=0;
		for(DopravneProstriedky j: prostriedky){
			sprava+= j.spravaProstriedok();
			i+=j.getPocetMiest();
			
		}
		
		return sprava+ "pocet miest celkovo : "+ Integer.toString(i)+"\n";
	}
	public String spravaParovanie(){
		String sprava = "";
		int i=0;
		for(DopravneProstriedky j: prostriedky){
			sprava+= j.spravaParovanie();
						
		}
		
		return sprava;
	}
	public int pocetProstriedkov(){
		int i=0;
		for(DopravneProstriedky j: prostriedky){
			i++;
		}
		return i;
	}

}
