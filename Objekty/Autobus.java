package Objekty;

public class Autobus extends DopravneProstriedky{
	final int maxKM = 1500;
	final int rychlostKM = 100;
	private String typ ="Autobus";
	
	
	public Autobus(String name,int miesta,double cena){
		super(name,miesta, cena);
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getTypS() {
		return "B";
	}
}
