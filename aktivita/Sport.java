package aktivita;
import java.util.ArrayList;
import java.util.List;

import Objekty.Obsluha;
import Objekty.Sportovci;
import Objekty.Trener;
import Objekty.Ucastnici;

public class Sport implements ZlozkaSport{
    ArrayList<Sportovci> sportovec =new ArrayList<Sportovci>();
	ArrayList<Obsluha> obsluha =new ArrayList<Obsluha>();
	ArrayList<Trener> trener =new ArrayList<Trener>();
	private String meno_Sportu;
	
	
	///constructors
	public Sport(){};
	public Sport(String name){		
		this.meno_Sportu = name;
	}
	
	public void setMeno(String name){
		this.meno_Sportu= name;
	}
	public String getMeno(){
		return meno_Sportu;
	}
	public void priradTrener(Trener tren){		
		trener.add(tren);
	}
	
	public void priradSportovec(Sportovci osoba){
		sportovec.add(osoba);
	}
	public ArrayList<Sportovci> vyberSportovcov(){
		return sportovec;
	}
	public void priradObsluhu(Obsluha obsluha2) {
		obsluha.add(obsluha2);
		}
	public String vypis(){
		String sprava = meno_Sportu+"\n"+ "_____________________________________________________\n";
		sprava += "Trener : \n";
		for (int i = 0; i < trener.size(); i++) {
		sprava+= trener.get(i).getMeno() + "  Naklady  : " + trener.get(i).getNaklady() + "\n";
		}
		sprava += "Sportovci : \n";
		for (int i = 0; i < sportovec.size(); i++) {
			sprava+= "Meno: "+ sportovec.get(i).getMeno()+ "  Naklady: "+ sportovec.get(i).getNaklady()+"\n";
		}
		sprava+="Obsluha : \n";
		for (int i = 0; i < obsluha.size(); i++) {
			sprava+= "Meno: "+ obsluha.get(i).getMeno()+ "  Naklady: "+ obsluha.get(i).getNaklady()+"\n";
		}
				return sprava;
	}
	public String spravaS(){
		String sprava = meno_Sportu + " T:"+trener.size()+" S:"+sportovec.size()+" O:"+ obsluha.size();
		return sprava;
	}
	public List<Trener> vyberTrenerov() {		
		return trener;
	}
	public List<Sportovci> vyberSportovci() {		
		return sportovec;
	}
	
	public List<Ucastnici> getUcastnici() {
		List<Ucastnici> u = new ArrayList<Ucastnici>();
		u.addAll(sportovec);
		u.addAll(obsluha);
		u.addAll(trener);
		
		return u;
	}
	public List<Sport> getSport(){
		List<Sport> jednotka = new ArrayList<>();
		jednotka.add(this);
		return jednotka;
	}

}
