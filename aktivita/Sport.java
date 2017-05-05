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
	private boolean stavDopravaTo=false;
	private boolean stavDopravaFrom=false;
	
	
	///constructors
	public Sport(){};
	public Sport(String name,String osoba,String kontakt){		
		this.meno_Sportu = name;
		this.setKontaktnaOsoba(osoba);
		this.setKontakt(kontakt);
	}
	
	public double getSum(){
		double sum=0;
		for (Ucastnici u:this.getUcastnici()) {
			sum+=u.getNaklady();
			}
		return sum;
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
		if(stavSport == true && stavObsluha == true && stavTrener == true){ stavNaplnene=true;}
	}
	
	public void priradSportovec(Sportovci osoba){
		sportovec.add(osoba);
		stavSport=true;
		if(stavSport == true && stavObsluha == true && stavTrener == true){ stavNaplnene=true;}
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
		int m=1;
		for (int i = 0; i < trener.size(); i++) {
		sprava+=trener.get(i).getMeno() + "  Naklady  : " + trener.get(i).getNaklady() + "$\n";
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
	public String celkovyVypis(){
		String sprava = meno_Sportu+"\n"+ "_____________________________________________________\n";
		sprava += "Trener : \n";
		for (Trener t: trener) {
		sprava+=t.celkovyVypis();
		}
		sprava += "Sportovci : \n";
		for (Sportovci s : sportovec) {
			sprava+=s.celkovyVypis();
		}
		sprava+="Obsluha : \n";
		for (Obsluha o : obsluha) {
			sprava+= o.celkovyVypis();
		}
				return sprava;
	   }
	public String spravaS(){
		String n;
		
		if(stavNaplnene==true){n="OK";}else{n="Nenaplnene";}
		String sprava = meno_Sportu + " T:"+trener.size()+" S:"+sportovec.size()+" O:"+ obsluha.size()+ " | "+ n;
		return sprava;
	}
	public String financieVypis(){		
		String sprava = meno_Sportu + " | Kontakt: "+kontakt+" | Suma : " + Double.toString(this.getSum())+"$\n";
		return sprava;
	}
	public String financieVypis(String s){		
		String sprava =" | Kontakt: "+kontakt+" | Suma : " + Double.toString(this.getSum())+"$\n";
		sprava += this.vypis();
		return sprava;
	}
	public String spravaD(){
		String n;		
		int i = trener.size()+ sportovec.size()+ obsluha.size();
		if(stavDopravaTo==true&&stavDopravaFrom==true){n="OK";}else if(stavDopravaTo==true||stavDopravaFrom==true){n="To or From";}else{n="NO";}
		String sprava = meno_Sportu +  " |Pocet: "+ Integer.toString(i)+" |"+n;
		return sprava;
	}
	public String spravaDP(){
		String n;		
		int tam = this.zistiPocetTam();
		int nas = this.zistiPocetNaspat();
		if(tam==0&&nas==0){n="OK";}else{n=Integer.toString(tam)+" | "+Integer.toString(nas);}
		
		String sprava = meno_Sportu +  " >>|tam-spat: "+n;
		return sprava;
	}
	public int zistiPocetTam(){
		int i=0;
		for (Ucastnici u:this.getUcastnici()) {
			if(u.isStavCestaTam()==false)i++;
			}
		return i;
	}
	public int zistiPocetNaspat(){
		int i=0;
		for (Ucastnici u:this.getUcastnici()) {
			if(u.isStavCestaNaspat()==false)i++;
			}
		return i;
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
		sprava += meno_Sportu+"\n";
		for (Ucastnici i:u) {
		sprava+= i.vypisHotel();
		}		
		return sprava+"-----------------------------------------------------------\n";
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
		u.addAll(trener);
		u.addAll(obsluha);
		u.addAll(sportovec);
		
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
	public boolean isNaplnene(){
		return stavNaplnene;
	}
	public boolean isStavUbytovanie(){
		for (Ucastnici u:this.getUcastnici()) {
			if(u.isIzbaHas()==false){stavUbytovanie = false; return false;}
			}
		stavUbytovanie = true; return true; 
	}
	public boolean isStavCesta(){
		stavDopravaTo=true;
		stavDopravaFrom=true;
		for (Ucastnici u:this.getUcastnici()) {
			if(u.isStavCestaTam()==false){stavDopravaTo=false;}
			if(u.isStavCestaNaspat()==false){stavDopravaFrom=false;}
			}
		 if(stavDopravaFrom==true && stavDopravaTo==true){return true;}
		 return false;
	}
	

}
