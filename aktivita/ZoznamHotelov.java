package aktivita;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Objekty.Ucastnici;

public class ZoznamHotelov implements ZlozkaHotel{
	Hotel hotel;
	List<ZlozkaHotel> hotely = new ArrayList<>();
	List<Hotel> HotelyZ;
	List<Ucastnici> ucastnici;
	ZoznamSportov sporty;
	private main main;
	private boolean cakam;
	
	public ZoznamHotelov(main main) {
		this.main = main;
	}
	
	public void priradUbytovanie(){
		HotelyZ = this.dostanHotel();
		for(Hotel z : HotelyZ ){
			z.priradHosta(this.neubytovaniU());
		}
	}
	public List<Ucastnici> neubytovaniU(){
		
		List<Ucastnici> ucastnicis = new ArrayList<>();
		for(Ucastnici u: main.getUcastnici()){
			if(u.isIzbaHas()== false){
				ucastnicis.add(u);
			}
		}
		return ucastnicis;
	}
	
	public void pridajHotel(String name,String mesto,String ulica,int cislo){
		hotel = new Hotel(name,mesto,ulica,cislo);
		hotely.add(hotel);
	}
	public boolean existHotel(String name){				
		for(Hotel z: HotelyZ= dostanHotel()){
    		if(z.getMenoHotela().equals(name))return true;
    	}	return false;	}
	
	public void vyhladajHotel(String name){
		for(Hotel z: HotelyZ= dostanHotel()){
    		if(z.getMenoHotela().equals(name))hotel =z; 
    	}
	}
	public void pridajIzbu(int lozka,int cisloI, double cenaN){
		hotel.priradIzbu(lozka, cisloI, cenaN);
	}
	public String vypisHotelov(){
		String sprava="ZOZNAM HOTELOV\n";
		for(Hotel z: HotelyZ= dostanHotel()){
    		sprava +="|"+ z.getMenoHotela()+"| Pocet izieb: "+z.getPocetIzieb()+" | lozok: "+Integer.toString(z.getPocetLozok())+"\n";
    	}
		return sprava;
	}
	public String financieVypis(int pocetDni){
		   String sprava="Hotely:\n";
		   for(Hotel z: HotelyZ= dostanHotel()){
	    		sprava +=z.financieVypis(pocetDni);
	    	}
		   return sprava;
	   }
	public String financieVypis(int pocetDni,String m){
		   String sprava="Hotely:\n";
		   for(Hotel z: HotelyZ= dostanHotel()){
	    		sprava +=z.financieVypis(pocetDni,m);
	    	}
		   return sprava;
	   }
	
		
	public List<Hotel> dostanHotel() {
		 List<Hotel> n = new ArrayList<>();
		for(ZlozkaHotel z: hotely){
			n.addAll(z.dostanHotel());
		}		return n;
	}
	public double getSuma(int pocetDni){
		double sum=0;
		for(Hotel z: HotelyZ= dostanHotel()){
    		sum += z.getSuma(pocetDni);
    	}
		return sum;
	}

	public boolean isCakam() {
		return cakam;
	}

	public void setCakam(boolean cakam) {
		this.cakam = cakam;
	}

	

}
