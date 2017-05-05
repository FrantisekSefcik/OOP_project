package Objekty;
import java.util.ArrayList;
import java.util.List;

import aktivita.Hotel;

public class Izba {
    
	private Hotel hotel;
	private int pocetLozok;
	private int cisloIzby;
	private double cenaIzby; 
	static Balicek balicek;
	private List<Ucastnici> ubytovani = new ArrayList<>();
	private List<Balicek> baliky= new ArrayList<>();
	private int pocetUbytovanych =0;
	private boolean obsadene = false;
	
	public Izba(int lozka,int cisloI,double cenaN,Hotel h){
		pocetLozok=lozka;cisloIzby=cisloI;cenaIzby=cenaN;setHotel(h);
	}
	//vnorena trieda, 
	static class Balicek{
		Chladnicka chladnicka;
		Vybavenie vybavenie;
		private String uroven;
		
		public Balicek(String s){
			switch(s){
			case("Exclusive"): chladnicka= new Chladnicka(s);vybavenie=new Vybavenie(s);
			break;
			case("Standard"): chladnicka= new Chladnicka(s);vybavenie=new Vybavenie(s);
			break;
			case("Normal"): chladnicka= new Chladnicka(s);vybavenie=new Vybavenie(s);
			break;
			default:		
			}
			uroven=s;
		}
		
					static class Chladnicka{
						private String uroven;
						public Chladnicka(String s){this.uroven=s;}
						
						public double zistiCenu(){
							switch(uroven){
							case("Exclusive"): return 10;
							
							case("Standard"): return 5;
							
							case("Normal"): return 2;
							
							default: return 0;		
							}
						}
			 		}
					static class Vybavenie{
						
						private String uroven;
						public Vybavenie(String s){this.uroven=s;}
						
						public double zistiCenu(){
							switch(uroven){
							case("Exclusive"): return 15;
							
							case("Standard"): return 7.5;
							
							case("Normal"): return 0;
							
							default: return 0;		
							}
						}
						
			 		}
		public double zistiCenu(){
			return chladnicka.zistiCenu()+vybavenie.zistiCenu();
		}
		
		
	}
	
	
	
	//vyhlada v zozname ucastnikov, ktorz nemaju pridelene ubztovanie a priradi ich tolko kolko je volnych posteli 
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
	
	public String sprava(int pocetDni){
		String sprava="";
		sprava+= "Cislo izby : "+Integer.toString(cisloIzby)+"  | Suma: "+Double.toString(this.getSuma(pocetDni))+"$\n";
		return sprava;
	}
	
	
	
	public boolean isFree(){
		if(pocetUbytovanych==0){return true;}
		return false;
	}
	public double getSuma(int pocetDni){
		return cenaIzby*(pocetDni-1);
	}
	
	public void priradBalicek(Trener t){
		baliky.add(new Balicek("Exclusive"));
	}
	public void priradBalicek(Sportovci t){
		baliky.add(new Balicek("Exclusive"));
	}
	public void priradBalicek(Obsluha t){
		baliky.add(new Balicek("Exclusive"));
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
