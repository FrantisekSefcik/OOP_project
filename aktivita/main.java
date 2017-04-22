package aktivita;
import java.util.ArrayList;
import java.util.List;

import Objekty.Obsluha;
import Objekty.Sportovci;
import Objekty.Trener;
import Objekty.Ucastnici;

public class main {
	
	private int pocetUcastnikov=0;
	private int pocetSportov=0;
	Sport novy;
	private ZoznamHotelov hotel = new ZoznamHotelov();
	ZoznamSportov sporty = new ZoznamSportov();
	private ZoznamDoprava doprava = new ZoznamDoprava();
	List<Ucastnici> u = new ArrayList<Ucastnici>();
	List<SledovatelPoctu> sledovatelia = new ArrayList<>();
	
	public ZoznamHotelov getHotel(){
		return hotel;
	}
	
	public ZoznamDoprava getDoprava() {
		return doprava;
	}
	
	
	public void pridajSledovatela(SledovatelPoctu sledovatelStavu) {
		sledovatelia.add(sledovatelStavu);
	}
	public void upovedomSledovatelov(){
		for(SledovatelPoctu e: sledovatelia){
			e.upovedom();
		}
	}
	
	
	public String vytvorSport(String name){			
		if(sporty.existSport(name)){}else{
		novy = new Sport();
		novy.setMeno(name);
		sporty.pridajSport(novy);
		pocetSportov++;
		}
		return Integer.toString(pocetSportov);
	}
	public boolean stavInfo(){
		return sporty.zistiInfo();
	}
	
	public void nastav(String meno, int cena){
		Trener trener= new Trener(cena,meno);
		novy.priradTrener(trener);		
	}
	
	public void aktualizuj(String name,int dni,int vzd){
		sporty.setNazovUdalosti(name);sporty.setPocetDni(dni);sporty.setPocetKm(vzd);
	};
	
	public void vytvorSportovcovS(int pocet,int cena){
		Sportovci osoba; 
		for(int i=1;i<=pocet;i++){
		osoba = new Sportovci();
			osoba.setMeno("anonym");
			osoba.setNaklady(cena);
			novy.priradSportovec(osoba);
			pocetUcastnikov++;
		}
		upovedomSledovatelov();
	}
	
	public void vytvorSportovcovJ(String name,int cena){
		Sportovci osoba; 	
		osoba = new Sportovci();
			osoba.setMeno(name);
			osoba.setNaklady(cena);
			novy.priradSportovec(osoba);
			pocetUcastnikov++;
			upovedomSledovatelov();
	}
	
	public void vytvorObsluhuS(int pocet,int cena){
		 
		for(int i=1;i<=pocet;i++){
			novy.priradObsluhu(new Obsluha(cena,"anonym"));
			pocetUcastnikov++;			
		}
		upovedomSledovatelov();
	}
	
	public void vytvorObsluhuJ(String name,int cena){
			novy.priradObsluhu(new Obsluha(cena,name));
			pocetUcastnikov++;
			upovedomSledovatelov();
	}
	public void vytvorTrenera(String name,int cena){
		novy.priradTrener(new Trener(cena,name));
		pocetUcastnikov++;
		upovedomSledovatelov();
	}
	public String vypis(){
		return novy.vypis();
	}
	public String vypisS(){
		return sporty.spravaSport();
	}
		
    public boolean vyhladaj(String name){
    	   	    	return sporty.existSport(name);   	
    }
    public void dostanSport(String name){
    	novy= sporty.vyhladaj(name);
    }
    
	public int zistiPocetU() {
		return pocetUcastnikov;
	}

	public void setDoprava(ZoznamDoprava doprava) {
		this.doprava = doprava;
	}
}
