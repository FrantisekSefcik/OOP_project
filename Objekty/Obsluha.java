package Objekty;

public class Obsluha extends Ucastnici{

	private String meno;
	private int naklady = 0;
	private Izba izba;
	
	///constructors
	public Obsluha(){};
	public Obsluha(int naklady){
		this.naklady = naklady;
	};
	public Obsluha(int naklady,String name){
		this.naklady = naklady;
		this.meno = name;
	};
	
	///navratove hodnoty	
		public String getMeno(){
			return meno;
		}
		public int getNaklady(){
			return naklady;
		}
		
}
