package aktivita;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageTypeSpecifier;

import GUI.GUI_error;
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
	private boolean cakamS;
	private boolean cakamU;
	private boolean cakamD;
	
	List<Ucastnici> u = new ArrayList<Ucastnici>();
	List<SledovatelPoctu> sledovatelia = new ArrayList<>();
	
	
	
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
	
	public double getSuma(){
		double sum=0;
		sum+=sporty.getSuma();
		sum+=doprava.getSuma(pocetKm);
		sum+=hotel.getSuma(pocetDni);
		return sum;
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
	////vypisy do GUI spravca
	public String hlavnyVypis(String druh){
		String sprava="";
		switch(druh){
		
		case("Ubytovanie"):return sporty.vypisHotel();
		
	    case("Celkovy vypis"): return this.celkovyVypis();
	    
	    case("Naklady vypis"): return this.financieVypis();
	    
	    case("Naklady detailny vypis"): return this.financieDetailVypis(druh);
	    }
				
		return sprava;
		}
		
	public String celkovyVypis(){
		String sprava="";
		sprava+="///// Cekovy vypis//////\n"+"Udalost: "+nazovUdalosti+"\nCas konania: "+datum1+"-"+datum2+"\nMiesto konanie: " +miestoKonania+"\n---------------------------------------------------\n";
		sprava+=sporty.celkovyVypis();
		return sprava;
	}
	public String financieVypis(){
		String sprava="Vypis nakladov\n------------------------------------------\n";
		
		sprava+=sporty.financieVypis()+"\n\n";
		sprava+=hotel.financieVypis(pocetDni)+"\n\n";
		sprava+=doprava.financieVypis(pocetKm)+"\n\n";
		
		return sprava;
	}
	public String financieDetailVypis(String n){
		String sprava="Vypis nakladov detailne\n------------------------------------------\n";
		
		sprava+=sporty.financieVypis(n)+"\n\n";
		sprava+=hotel.financieVypis(pocetDni,n)+"\n\n";
		sprava+=doprava.financieVypis(pocetKm,n)+"\n\n";
		
		return sprava;
	}
	public String sprava(){
		String sprava="";
		sprava+="- Sporty       >>";
		if(sporty.isSchvalSport()&&sporty.isCakam()){sprava+="SCHVALENE";}
		else{     if(sporty.isCakam()){sprava+="Caka na schvalenie!";}
		          else{   if(sporty.isSplnene()){sprava+="Splnene";}else{sprava+="Nesplnene";}}	
		    }
		sprava+=" >Suma:"+Double.toString(sporty.getSuma())+"$\n";
		sprava+="- Ubytovanie >>";
		if(sporty.isSchvalUbytovanie()&&hotel.isCakam()){sprava+="SCHVALENE";}
		else{     if(hotel.isCakam()){sprava+="Caka na schvalenie!";}
		          else{   if(sporty.isUbytovanieSplnene()){sprava+="Splnene";}else{sprava+="Nesplnene";}}	
		    }
		sprava+=" >Suma:"+Double.toString(hotel.getSuma(pocetDni))+"$\n";
		sprava+="- Doprava      >>";
		if(sporty.isSchvalDoprava()&&doprava.isCakam()){sprava+="SCHVALENE";}
		else{     if(doprava.isCakam()){sprava+="Caka na schvalenie!";}
		          else{   if(sporty.isDopravaSplnene()){sprava+="Splnene";}else{sprava+="Nesplnene";}}	
		    }
		sprava+=" >Suma:"+Double.toString(doprava.getSuma(pocetKm))+"$";
		return sprava;
	}	
	////koniec vypisy GUI
	
	public void schval(String s){
		
		switch(s){
		
		case("Sporty"): if(sporty.isSplnene()&& sporty.isCakam()){ sporty.setSchvalSport(true);}else{new GUI_error("Nesplnene poziadavky");}
		    break;
		case("Ubytovanie"): if(sporty.isUbytovanieSplnene()&& hotel.isCakam()){sporty.setSchvalUbytovanie(true);}else{new GUI_error("Nesplnene poziadavky");}
		    break;
		case("Doprava"): if(sporty.isDopravaSplnene()&& doprava.isCakam()){sporty.setSchvalDoprava(true);}else{new GUI_error("Nesplnene poziadavky");}
		}
	}
	
	public boolean vyhladaj(String s){
		return sporty.existSport(s);
	}
	
	public String vypis(){
		return sporty.vypis();
	}
	public String vypisS(){
		return sporty.spravaSport();
	}
	public String vypisHotel(){
		return sporty.vypisHotel();
	}
	public int zistiPocetU() {
		return pocetUcastnikov;
	}

	//////////get-set
	public ZoznamHotelov getHotel(){
		return hotel;
	}
	public ZoznamDoprava getDoprava() {
		return doprava;
	}
	public ZoznamSportov getSporty() {
		return sporty;
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
	//////////////get-set/////////////////
}