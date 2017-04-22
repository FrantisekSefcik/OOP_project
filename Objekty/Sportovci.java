package Objekty;

public class Sportovci extends Ucastnici{

	private String meno;
	private int naklady = 0;
	private Izba izba;
	
	///constructors
	public Sportovci(){};
	public Sportovci(int naklady){
		this.naklady = naklady;
	}
	public Sportovci(int naklady,String name){
		this.naklady = naklady;
		this.meno= name;
	}
	
	///navratove hodnoty	
	public String getMeno(){
		return meno;
	}
	public int getNaklady(){
		return naklady;
	}
	public void setMeno(String name){
		this.meno=name;
	}
	public void setNaklady(int cena){
		naklady=cena;
	}
	
	
}
