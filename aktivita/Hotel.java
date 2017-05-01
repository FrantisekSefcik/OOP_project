package aktivita;
import java.util.ArrayList;
import java.util.List;

import Objekty.Izba;
import Objekty.Ucastnici;

public class Hotel implements ZlozkaHotel{

	private String menoHotela;	
	private int cisloUctu;
	private String adresa;
	private int pocetIzieb=0;
	private boolean obsadene;
	List<Izba> izby = new ArrayList<Izba>();
	
	public Hotel(String name,String mesto,String ulica,int cislo){
		menoHotela=name;cisloUctu=cislo; adresa = mesto + "\n"+ ulica;
	}
	public int getPocetLozok(){
		int z = 0;
		for(Izba i:izby){
		z += i.getPocetLozok();
		}
		return z;
	}
	public void priradHosta(List<Ucastnici> u){
		for(Izba i : izby ){
			if(i.isObsadene() == false){obsadene = i.priraHosta(u);}
		}
		
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
		Izba izba = new Izba(lozka,cisloI,cenaN,this);
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
	public boolean isObsadene() {
		return obsadene;
	}
	public void setObsadene(boolean obsadene) {
		this.obsadene = obsadene;
	}
	
}
