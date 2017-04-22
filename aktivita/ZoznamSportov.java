package aktivita;
import java.util.ArrayList;
import java.util.List;

import Objekty.Ucastnici;


public class ZoznamSportov {
	
	private List<ZlozkaSport> zlozky = new ArrayList<>();
	private String nazovUdalosti="";
	private int pocetDni= 0;
	private int pocetKm= 0;
	private int pocetSportov=0;
	
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
		pocetSportov++;
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

	public int zistiPocetU() {
		// TODO Auto-generated method stub
		return 0;
	}
}
