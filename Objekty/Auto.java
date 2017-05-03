package Objekty;

public class Auto extends DopravneProstriedky{
	
	final int maxKM = 1000;
	final int rychlostKM = 120;
	private String typ ="Auto";
	
	public Auto(String name,int miesta,double cena){
		super(name,miesta, cena);
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getTypS() {
		return "A";
	}
}
