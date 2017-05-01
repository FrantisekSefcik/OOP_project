package aktivita;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import Objekty.Obsluha;
import Objekty.Sportovci;
import Objekty.Trener;
import Objekty.Ucastnici;

public class Sport implements ZlozkaSport{
    ArrayList<Sportovci> sportovec =new ArrayList<Sportovci>();
	ArrayList<Obsluha> obsluha =new ArrayList<Obsluha>();
	ArrayList<Trener> trener =new ArrayList<Trener>();
	private String meno_Sportu;
	private String kontaktnaOsoba;
	private String kontakt;
	
	private boolean stavNaplnene=false;
	private boolean stavSport=false;
	private boolean stavObsluha=false;
	private boolean stavTrener=false;
	private boolean stavUbytovanie=false;
	
	
	///constructors
	public Sport(){};
	public Sport(String name,String osoba,String kontakt){		
		this.meno_Sportu = name;
		this.setKontaktnaOsoba(osoba);
		this.setKontakt(kontakt);
	}
	
	public void setMeno(String name){
		this.meno_Sportu= name;
	}
	public String getMeno(){
		return meno_Sportu;
	}
	public void priradTrener(Trener tren){		
		trener.add(tren);
		stavTrener=true;
	}
	
	public void priradSportovec(Sportovci osoba){
		sportovec.add(osoba);
		stavSport=true;
	}
	public ArrayList<Sportovci> vyberSportovcov(){
		return sportovec;
	}
	
	public void priradObsluhu(Obsluha obsluha2) {
		obsluha.add(obsluha2);
		stavObsluha=true;
		if(stavSport == true && stavObsluha == true && stavTrener == true){ stavNaplnene=true;}
		} 
	
	public String vypis(){
		String sprava = meno_Sportu+"\n"+ "_____________________________________________________\n";
		sprava += "Trener : \n";
		for (int i = 0; i < trener.size(); i++) {
		sprava+= trener.get(i).getMeno() + "  Naklady  : " + trener.get(i).getNaklady() + "$\n";
		}
		sprava += "Sportovci : \n";
		for (int i = 0; i < sportovec.size(); i++) {
			sprava+= "Meno: "+ sportovec.get(i).getMeno()+ "  Naklady: "+ sportovec.get(i).getNaklady()+"$\n";
		}
		sprava+="Obsluha : \n";
		for (int i = 0; i < obsluha.size(); i++) {
			sprava+= "Meno: "+ obsluha.get(i).getMeno()+ "  Naklady: "+ obsluha.get(i).getNaklady()+"$\n";
		}
				return sprava;
	}
	public String spravaS(){
		String n;
		
		if(stavNaplnene==true){n="OK";}else{n="Nenaplnene";}
		String sprava = meno_Sportu + " T:"+trener.size()+" S:"+sportovec.size()+" O:"+ obsluha.size()+ " | "+ n;
		return sprava;
	}
	public int pocetUbytovanych(){
		int i=0;
		for(Sportovci s:sportovec){
			if(s.isIzbaHas()==true)i++;
		}
		for(Trener t:trener){
			if(t.isIzbaHas()==true)i++;
		}
		for(Obsluha o:obsluha){
			if(o.isIzbaHas()==true)i++;
		}
		return i;
	}
	
	public String vypisHotel(){
		String sprava="";
		List<Ucastnici> u = this.getUcastnici();
		sprava += "\n";
		for (Ucastnici i:u) {
		sprava+= i.vypisHotel();
		}		
		return sprava;
	}
	
	public String spravaH(){
		String n;
		if(trener.size()+sportovec.size()+ obsluha.size()==this.pocetUbytovanych()){stavUbytovanie=true;}else{stavUbytovanie=false;}
		int i = trener.size()+ sportovec.size()+ obsluha.size();
		if(stavUbytovanie==true){n="OK";}else{n="NO";}
		String sprava = meno_Sportu + " | Pocet:" +Integer.toString(i)+" |"+Integer.toString(this.pocetUbytovanych()) +" | "+ n;
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
	public String getKontaktnaOsoba() {
		return kontaktnaOsoba;
	}
	public void setKontaktnaOsoba(String kontaktnaOsoba) {
		this.kontaktnaOsoba = kontaktnaOsoba;
	}
	public String getKontakt() {
		return kontakt;
	}
	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

}
