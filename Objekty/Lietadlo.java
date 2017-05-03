package Objekty;

public class Lietadlo extends DopravneProstriedky{
	final int maxKM = 2500;
	final int rychlostKM = 750;
	private String typ ="Lietadlo";
	

	public Lietadlo(String name,int miesta,double cena){
		super(name,miesta, cena);
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getTypS() {
		return "L";
	}
}
