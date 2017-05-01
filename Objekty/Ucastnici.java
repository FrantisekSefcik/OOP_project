package Objekty;


public abstract class Ucastnici {
	
	private Izba izba;
	private boolean izbaHas;
	private String meno;
	private int naklady = 0;
	
	public Ucastnici(){
		
	}
	
	public Ucastnici(int naklady){
		this.setNaklady(naklady);
	}
	public Ucastnici(int naklady,String name){
		this.setNaklady(naklady);
		this.meno= name;
	}

	public boolean isIzbaHas() {
		return izbaHas;
	}

	public void setIzbaHas(boolean izbaHas) {
		this.izbaHas = izbaHas;
	}
	public void priradIzba(Izba i){
		this.izba=i;
		izbaHas = true;
	}
	
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
	public String vypisHotel(){
		String sprava="";
		sprava+="Meno : "+meno+"| Hotel: "+izba.getMenoHotela()+"| Izba: "+Integer.toString(izba.getCisloIzby())+"\n";
		return sprava;
	}
		
}
