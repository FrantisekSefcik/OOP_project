package aktivita;
import java.util.ArrayList;
import java.util.List;

import Objekty.Obsluha;
import Objekty.Sportovci;
import Objekty.Trener;
import Objekty.Ucastnici;


public class ZoznamSportov {
	
	private List<ZlozkaSport> zlozky = new ArrayList<>();
	private String nazovUdalosti="";
	private int pocetDni= 0;
	private int pocetKm= 0;
	private int pocetSportov=0;
	private Sport novy;
	private main main;
	
	public ZoznamSportov(main main){
		this.main=main;
	}
	public boolean zistiInfo(){
		if(pocetDni != 0 && pocetKm != 0 && pocetSportov != 0 && !nazovUdalosti.isEmpty()){return true;}else{return false;}
	}
	
	public int getPocetDni() {
		return pocetDni;
	}
	public void setPocetDni(int pocetDni) {
		this.pocetDni = pocetDni;
	}
	public int getPocetKm() {
		return pocetKm;
	}
	public void setPocetKm(int pocetKm) {
		this.pocetKm = pocetKm;
	}
	public int getPocetSportov() {
		return pocetSportov;
	}
	public void setPocetSportov(int pocetSportov) {
		this.pocetSportov = pocetSportov;
	}
	public String getNazovUdalosti() {
		return nazovUdalosti;
	}
	public void setNazovUdalosti(String nazovUdalosti) {
		this.nazovUdalosti = nazovUdalosti;
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

	
	/////////////////////////////////////
	public void vytvorSportovcovS(int pocet,int cena){
		Sportovci osoba; 
		for(int i=1;i<=pocet;i++){
		osoba = new Sportovci();
			osoba.setMeno("anonym");
			osoba.setNaklady(cena);
			novy.priradSportovec(osoba);
			main.incrementPocetUcastnikov();
		}
	}
	
	public void vytvorSportovcovJ(String name,int cena){
		Sportovci osoba; 	
		osoba = new Sportovci();
			osoba.setMeno(name);
			osoba.setNaklady(cena);
			novy.priradSportovec(osoba);
			main.incrementPocetUcastnikov();
	}
	
	public void vytvorObsluhuS(int pocet,int cena){
		 
		for(int i=1;i<=pocet;i++){
			novy.priradObsluhu(new Obsluha(cena,"anonym"));
			main.incrementPocetUcastnikov();		
		}
	}
	
	public void vytvorObsluhuJ(String name,int cena){
			novy.priradObsluhu(new Obsluha(cena,name));
			main.incrementPocetUcastnikov();
	}
	public void vytvorTrenera(String name,int cena){
		novy.priradTrener(new Trener(cena,name));
		main.incrementPocetUcastnikov();
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
		String sprava = "      Ubytovanie";
		for(ZlozkaSport z: zlozky){
    		sprava+= z.vypisHotel()+"\n";
    	}
		return sprava;
	}
	
}
