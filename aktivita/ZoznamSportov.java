package aktivita;
import java.util.ArrayList;
import java.util.List;

import Objekty.Obsluha;
import Objekty.Sportovci;
import Objekty.Trener;
import Objekty.Ucastnici;


public class ZoznamSportov {
	
	private List<ZlozkaSport> zlozky = new ArrayList<>();
	private int pocetSportov=0;
	private Sport novy;
	private main main;
	private boolean schvalSport;
	private boolean schvalUbytovanie;
	private boolean schvalDoprava;
	private boolean cakam;
	
	public ZoznamSportov(main main){
		this.main=main;
	}
	
	public int getPocetSportov() {
		return pocetSportov;
	}
	public void setPocetSportov(int pocetSportov) {
		this.pocetSportov = pocetSportov;
	}
	
	public double getSuma(){
		double sum=0;
		for(ZlozkaSport z: zlozky){
    		sum +=z.getSum();
    	}
		return sum;
	}
	
	public boolean isSplnene(){
		for(ZlozkaSport z: zlozky){
    		if(z.isNaplnene()==false){return false;}
    	}
		return true;
	}
	public boolean isUbytovanieSplnene(){
		for(ZlozkaSport z: zlozky){
    		if(z.isStavUbytovanie()==false){return false;}
    	}
		return true;
	}
	public boolean isDopravaSplnene(){
		for(ZlozkaSport z: zlozky){
    		if(z.isStavCesta()==false){return false;}
    	}
		return true;
	}

	public String spravaSport(){
		String sprava = "ZOZNAM SPORTOV\n";
		for(ZlozkaSport z: zlozky){
    		sprava+= z.spravaS()+"\n";
    	}
		return sprava;
	} 
	public String spravaSHotel(){
		String sprava = "ZOZNAM SPORTOV\n";
		for(ZlozkaSport z: zlozky){
    		sprava+= z.spravaH()+"\n";
    	}
		return sprava;
	} 
	public String spravaSDoprava(){
		String sprava = "ZOZNAM SPORTOV\n";
		for(ZlozkaSport z: zlozky){
    		sprava+= z.spravaD()+"\n";
    	}
		return sprava;
	} 
	public String spravaDopravaP(){
		String sprava = "ZOZNAM SPORTOV\n";
		for(ZlozkaSport z: zlozky){
    		sprava+= z.spravaDP()+"\n";
    	}
		return sprava;
	} 
	public Sport vyhladaj(String name){
		for(ZlozkaSport z: zlozky){
    		if(z.getMeno().equals(name))return (Sport) z ;
        	}
		return null;
	}
	
	public boolean existSport(String name){		
		for(ZlozkaSport z: zlozky){
    		if(z.getMeno().equals(name))return true;
    	}	return false;
	}

	
	public void pridajSport(ZlozkaSport sport){
		zlozky.add(sport);
		main.incrementPocetSportov();
	}
    public List<ZlozkaSport> vyberSporty(){
    	return zlozky;
    }
    public List<Ucastnici> vyberUcastnikov(){
    	List<Ucastnici> ucastnici = new ArrayList<>();
    	for(ZlozkaSport z: zlozky){
    		ucastnici.addAll(z.getUcastnici());
    	}
      	return ucastnici; 
    }
    public List<Sport> vyberSport(){
    	List<Sport> jednotka = new ArrayList<>();
    	for(ZlozkaSport z: zlozky){
    		jednotka.addAll(z.getSport());
    	}
    	return jednotka;
    }
    
   public String celkovyVypis(){
	   String sprava="";
	   for(ZlozkaSport z: zlozky){
   		sprava+= z.celkovyVypis()+"\n";
   	}
	   return sprava;
   }
   public String financieVypis(){
	   String sprava="Sporty:\n";
	   for(ZlozkaSport z: zlozky){
   		sprava+= z.financieVypis();
   	}
	   return sprava;
   }
   public String financieVypis(String s){
	   String sprava="Sporty:\n";
	   for(ZlozkaSport z: zlozky){
   		sprava+= z.financieVypis(s);
   	}
	   return sprava;
   }
	
	/////////////////////////////////////
	public void vytvorSportovcovS(int pocet,int cena){
		Sportovci osoba; 
		for(int i=1;i<=pocet;i++){
		osoba = new Sportovci();
			osoba.setMeno("anonym");
			osoba.setNaklady(cena);
			novy.priradSportovec(osoba);
			main.incrementPocetUcastnikov();
			main.upovedomSledovatelov();
		}
	}
	
	public void vytvorSportovcovJ(String name,int cena){
		Sportovci osoba; 	
		osoba = new Sportovci();
			osoba.setMeno(name);
			osoba.setNaklady(cena);
			novy.priradSportovec(osoba);
			main.incrementPocetUcastnikov();
			main.upovedomSledovatelov();
	}
	
	public void vytvorObsluhuS(int pocet,int cena){
		 
		for(int i=1;i<=pocet;i++){
			novy.priradObsluhu(new Obsluha(cena,"anonym"));
			main.incrementPocetUcastnikov();	
			main.upovedomSledovatelov();
		}
	}
	
	public void vytvorObsluhuJ(String name,int cena){
			novy.priradObsluhu(new Obsluha(cena,name));
			main.incrementPocetUcastnikov();
			main.upovedomSledovatelov();
	}
	public void vytvorTrenera(String name,int cena){
		novy.priradTrener(new Trener(cena,name));
		main.incrementPocetUcastnikov();
		main.upovedomSledovatelov();
	}
	public String vypis(){
		return novy.vypis();
	}
	public String vytvorSport(String name,String osoba,String kontakt){			
		if(this.existSport(name)){}else{
		novy = new Sport(name,osoba,kontakt);
		
		this.pridajSport(novy);
		pocetSportov++;
		}
		return Integer.toString(pocetSportov);
	}
	public void dostanSport(String name){
    	novy= this.vyhladaj(name);
    }
	public String getKontaktnaOsoba() {
		return novy.getKontaktnaOsoba();
	}
	
	public String getKontakt() {
		return novy.getKontakt();
	}
	public String vypisHotel(){
		String sprava = "      Ubytovanie\n-----------------------------------------------------------\n";
		for(ZlozkaSport z: zlozky){
    		sprava+= z.vypisHotel()+"\n";
    	}
		return sprava;
	}

	public boolean isCakam() {
		return cakam;
	}

	public void setCakam(boolean cakam) {
		this.cakam = cakam;
	}

	public boolean isSchvalSport() {
		return schvalSport;
	}

	public void setSchvalSport(boolean schvalSport) {
		this.schvalSport = schvalSport;
	}

	public boolean isSchvalUbytovanie() {
		return schvalUbytovanie;
	}

	public void setSchvalUbytovanie(boolean schvalUbytovanie) {
		this.schvalUbytovanie = schvalUbytovanie;
	}

	public boolean isSchvalDoprava() {
		return schvalDoprava;
	}

	public void setSchvalDoprava(boolean schvalDoprava) {
		this.schvalDoprava = schvalDoprava;
	}
	
}
