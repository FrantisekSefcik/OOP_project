package aktivita;
import java.util.ArrayList;
import java.util.List;

import Objekty.Datum;
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
	private String nazovUdalosti;
	private String miestoKonania;
	private String miestoOdjazdu;
	private int pocetDni= 0;
	private int pocetKm= 0;
	private String datum1;
	private String datum2;
	private ZoznamHotelov hotel = new ZoznamHotelov(this);
	private ZoznamSportov sporty = new ZoznamSportov(this);
	private ZoznamDoprava doprava = new ZoznamDoprava(this);
	private Datum datum = new Datum();
	
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
	public void incrementPocetSportov(){
		pocetSportov++;
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
		if(pocetKm != 0  && pocetSportov != 0 && !nazovUdalosti.isEmpty()){return true;}else{return false;}
	}
	
	public String vytvorSport(String name,String osoba,String kontakt){			
			return sporty.vytvorSport(name,osoba,kontakt);
	}
	
	//vytvorenie vlastnej vynimky parametreExceptions, overuje ci ma format datumu spravnu velkost a vydialenost je >5,, volanie v GUI.
	public void aktualizuj(String name,String miesto,String datum1,String datum2,int vzd,String zakaldna) throws parametreExceptions{
		if(datum1.length()!=10||datum2.length()!=10||vzd<5){throw new parametreExceptions();}
		
		nazovUdalosti=name;setMiestoKonania(miesto);this.setDatum1(datum1);this.setDatum2(datum2);pocetKm=vzd;setMiestoOdjazdu(zakaldna);
		pocetDni=datum.zistiPocetDni(datum1, datum2);
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
	public int getPocetDni() {
		return pocetDni;
	}
	public void setPocetDni(int pocetDni) {
		this.pocetDni = pocetDni;
	}
	public String getMiestoKonania() {
		return miestoKonania;
	}
	public void setMiestoKonania(String miestoKonania) {
		this.miestoKonania = miestoKonania;
	}
	public String getDatum1() {
		return datum1;
	}
	public void setDatum1(String datum1) {
		this.datum1 = datum1;
	}
	public String getDatum2() {
		return datum2;
	}
	public void setDatum2(String datum2) {
		this.datum2 = datum2;
	}
	public String getMiestoOdjazdu() {
		return miestoOdjazdu;
	}
	public void setMiestoOdjazdu(String miestoOdjazdu) {
		this.miestoOdjazdu = miestoOdjazdu;
	}
	public int getPocetKm(){
		return pocetKm;
	}
}
