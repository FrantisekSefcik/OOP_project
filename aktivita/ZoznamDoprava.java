package aktivita;

import java.util.ArrayList;
import java.util.List;

import Objekty.DopravneProstriedky;

public class ZoznamDoprava {
	private int pocetSpolocnosti=0;
	private main main;
	private DopravnaSpolocnost spolocnost;
	private ZoznamSportov sporty;
	private List<DopravnaSpolocnost> spolocnosti = new ArrayList<>();
	private boolean cakam;
	
	public ZoznamDoprava(main main){
		this.main=main;
		sporty= main.getSporty();
	}

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
	public String spravaSpolocnosti(){
		String sprava = "Zoznam spolocnosti\n";
		for(DopravnaSpolocnost z: spolocnosti){
			sprava+= z.spravaSpolocnosti();
		}
		return sprava;
	}
	public void sparuj(String name,String sport,String druh){
		for(DopravnaSpolocnost z: spolocnosti){
			if(z.vyhladajProstriedok(name)){z.sparuj(sporty.vyhladaj(sport), name, druh); }
		}
	}
	public String spravaParovanie(){
		String sprava="";
		for(DopravnaSpolocnost z: spolocnosti){
			sprava+= z.spravaParovanie();
		}
		return sprava;
	}
	public double getSuma(int pocetKm){
		double sum=0;
		for(DopravnaSpolocnost s:spolocnosti){
			sum += s.getSuma(pocetKm);
		}
		return sum;
	}
	public String financieVypis(int pocetKm){
		   String sprava="Dopravne spolocnosti:\n";
		   for(DopravnaSpolocnost s:spolocnosti){
				sprava+= s.financieVypis(pocetKm);
			}
		   return sprava;
	   }
	public String financieVypis(int pocetKm,String m){
		   String sprava="Dopravne spolocnosti:\n";
		   for(DopravnaSpolocnost s:spolocnosti){
				sprava+= s.financieVypis(pocetKm,m);
			}
		   return sprava;
	   }

	public boolean isCakam() {
		return cakam;
	}

	public void setCakam(boolean cakam) {
		this.cakam = cakam;
	}
	

	

	

}
