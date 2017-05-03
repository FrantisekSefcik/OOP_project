package Objekty;


public abstract class Ucastnici {
	
	private Izba izba;
	private Cesta cestaTam;
	private Cesta cestaNaspat;
	private boolean stavCestaTam;
	private boolean stavCestaNaspat;
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
		try{
		sprava+="Meno : "+meno+"| Hotel: "+izba.getMenoHotela()+"| Izba: "+Integer.toString(izba.getCisloIzby())+"\n";
		return sprava;
		}catch (Exception e) {
			sprava+="Meno : "+meno+"   >>Nepriradene ubytovanie!"+"\n";
			return sprava;
		}
	}

	public boolean isStavCestaTam() {
		return stavCestaTam;
	}

	public void setStavCestaTam(boolean stavCestaTam) {
		this.stavCestaTam = stavCestaTam;
	}

	public boolean isStavCestaNaspat() {
		return stavCestaNaspat;
	}

	public void setStavCestaNaspat(boolean stavCestaNaspat) {
		this.stavCestaNaspat = stavCestaNaspat;
	}

	public Cesta getCestaNaspat() {
		return cestaNaspat;
	}

	public void setCestaNaspat(Cesta cestaNaspat) {
		this.cestaNaspat = cestaNaspat;
		setStavCestaNaspat(true);
	}

	public Cesta getCestaTam() {
		return cestaTam;
	}

	public void setCestaTam(Cesta cestaTam) {
		this.cestaTam = cestaTam;
		setStavCestaTam(true);
	}
		
}
