package aktivita;
import java.util.ArrayList;
import java.util.List;

import Objekty.Obsluha;
import Objekty.Sportovci;
import Objekty.Trener;
import Objekty.Ucastnici;

//agregacia
//overloading
//kontaktne udaje pri pridavani sportu, odoslanie na dalsi stupen , zobrazenie dat

public class main {
	
	private int pocetUcastnikov=0;
	private int pocetSportov=0;
	private ZoznamHotelov hotel = new ZoznamHotelov(this);
	private ZoznamSportov sporty = new ZoznamSportov(this);
	private ZoznamDoprava doprava = new ZoznamDoprava();
	
	List<Ucastnici> u = new ArrayList<Ucastnici>();
	List<SledovatelPoctu> sledovatelia = new ArrayList<>();
	
	public ZoznamHotelov getHotel(){
		return hotel;
	}
	public ZoznamDoprava getDoprava() {
		return doprava;
	}
	public ZoznamSportov getSporty() {
		return sporty;
	}
	
	public void incrementPocetUcastnikov(){
		pocetUcastnikov++;
	}
	//sledovatelia Poctu
	public void pridajSledovatela(SledovatelPoctu sledovatelStavu) {
		sledovatelia.add(sledovatelStavu);
	}
	public void upovedomSledovatelov(){
		for(SledovatelPoctu e: sledovatelia){
			e.upovedom();
		}
	}
	
	
	public boolean stavInfo(){
		return sporty.zistiInfo();
	}
	
	public String vytvorSport(String name,String osoba,String kontakt){			
			return sporty.vytvorSport(name,osoba,kontakt);
	}
	
	/*
	public void nastav(String meno, int cena){
		Trener trener= new Trener(cena,meno);
		novy.priradTrener(trener);		
	}*/
	
	public void aktualizuj(String name,int dni,int vzd){
		sporty.setNazovUdalosti(name);sporty.setPocetDni(dni);sporty.setPocetKm(vzd);
	};
	
	public void vytvorSportovcovS(int pocet,int cena){
		sporty.vytvorSportovcovS(pocet, cena);
		upovedomSledovatelov();
	}
	
	public void vytvorSportovcovJ(String name,int cena){
		sporty.vytvorSportovcovJ(name, cena);
			upovedomSledovatelov();
	}
	
	public void vytvorObsluhuS(int pocet,int cena){
		 
		sporty.vytvorObsluhuS(pocet, cena);
		upovedomSledovatelov();
	}
	
	public void vytvorObsluhuJ(String name,int cena){
		sporty.vytvorObsluhuJ(name, cena);
	}
	public void vytvorTrenera(String name,int cena){
		sporty.vytvorTrenera(name, cena);
		upovedomSledovatelov();
	}
	public String vypis(){
		return sporty.vypis();
	}
	public String vypisS(){
		return sporty.spravaSport();
	}
		
    public boolean vyhladaj(String name){
    	return sporty.existSport(name);   	
    }
    public void dostanSport(String name){
    	sporty.dostanSport(name);
    }
    
	public int zistiPocetU() {
		return pocetUcastnikov;
	}

	public void setDoprava(ZoznamDoprava doprava) {
		this.doprava = doprava;
	}
	public List<Ucastnici> getUcastnici(){
		return sporty.vyberUcastnikov();
	}
}
