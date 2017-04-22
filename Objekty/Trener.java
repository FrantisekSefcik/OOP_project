package Objekty;

public class Trener extends Ucastnici{

	private String meno;
	private int naklady = 0;
	private Izba izba;
	
	
	///constructors
	public Trener(){};
	public Trener(int naklady){
		this.naklady = naklady;
	};
	public Trener(int naklady,String name){
		this.naklady = naklady;
		this.meno= name;
	};
	
	///navratove hodnoty	
		public String getMeno(){
			return meno;
		}
		public int getNaklady(){
			return naklady;
		}
		
		
		
	
}
