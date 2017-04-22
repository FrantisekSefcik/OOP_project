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
	
	
	public DopravnaSpolocnost(String name,int cislo){
		this.setMenoS(name);this.cisloUctu = cislo;
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
	

}
