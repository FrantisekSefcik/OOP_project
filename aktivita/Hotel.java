package aktivita;
import java.util.ArrayList;
import java.util.List;

import Objekty.Izba;

public class Hotel implements ZlozkaHotel{

	private String menoHotela;	
	private int cisloUctu;
	private String adresa;
	private int pocetIzieb=0;
	List<Izba> izby = new ArrayList<Izba>();
	
	public Hotel(String name,String mesto,String ulica,int cislo){
		menoHotela=name;cisloUctu=cislo; adresa = mesto + "\n"+ ulica;
	}

	public String getMenoHotela() {
		return menoHotela;
	}

	public void setMenoHotela(String menoHotela) {
		this.menoHotela = menoHotela;
	}

	public int getCisloUctu() {
		return cisloUctu;
	}

	public void setCisloUctu(int cisloUctu) {
		this.cisloUctu = cisloUctu;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public void priradIzbu(int lozka,int cisloI, double cenaN){
		Izba izba = new Izba(lozka,cisloI,cenaN);
		izby.add(izba);
		pocetIzieb++;
	}
    public int getPocetIzieb() {
		return pocetIzieb;
	}

	@Override
	public List<Hotel> dostanHotel() {
		List<Hotel> j = new ArrayList<>();
		j.add(this);
		return j;
	}
	
}
