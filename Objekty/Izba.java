package Objekty;
import java.util.ArrayList;
import java.util.List;

import aktivita.Hotel;

public class Izba {
    
	private Hotel hotel;
	private int pocetLozok;
	private int cisloIzby;
	private double cenaIzby; 
	private List<Ucastnici> ubytovani = new ArrayList<>();
	
	private int pocetUbytovanych =0;
	private boolean obsadene = false;
	
	public Izba(int lozka,int cisloI,double cenaN,Hotel h){
		pocetLozok=lozka;cisloIzby=cisloI;cenaIzby=cenaN;setHotel(h);
	}
	
	public boolean priraHosta(List<Ucastnici> u){
		
		
			for(int i=0;obsadene == false && i<u.size();i++){
				
				if(u.get(i).isIzbaHas()==false){
					ubytovani.add(u.get(i));
					u.get(i).priradIzba(this);
					pocetUbytovanych++;
					if(pocetUbytovanych==pocetLozok)obsadene = true;
				}
			}
			return obsadene;
		}
	

	public int getPocetLozok() {
		return pocetLozok;
	}

	public void setPocetLozok(int pocetLozok) {
		this.pocetLozok = pocetLozok;
	}

	public int getCisloIzby() {
		return cisloIzby;
	}

	public void setCisloIzby(int cisloIzby) {
		this.cisloIzby = cisloIzby;
	}

	public double getCenaIzby() {
		return cenaIzby;
	}

	public void setCenaIzby(double cenaIzby) {
		this.cenaIzby = cenaIzby;
	}
	public boolean isObsadene(){
		return obsadene;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getMenoHotela(){
		return hotel.getMenoHotela();
	}
	
}
