package aktivita;

import java.util.ArrayList;
import java.util.List;

public class ZoznamHotelov implements ZlozkaHotel{
	Hotel hotel;
	List<ZlozkaHotel> hotely = new ArrayList<>();
	List<Hotel> HotelyZ;
	
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
    		sprava += z.getMenoHotela()+" Pocet izieb: "+z.getPocetIzieb()+"\n";
    	}
		return sprava;
	}
	
	
	
	public List<Hotel> dostanHotel() {
		 List<Hotel> n = new ArrayList<>();
		for(ZlozkaHotel z: hotely){
			n.addAll(z.dostanHotel());
		}		return n;
	}

}
