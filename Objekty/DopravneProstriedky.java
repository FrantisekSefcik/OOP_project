package Objekty;

public abstract class DopravneProstriedky {
	
	private String menoProstriedku;
	private double cenaKM;
	private int pocetMiest;
	
	public DopravneProstriedky(String name,Integer miesta , double cena){
		this.menoProstriedku=name;
		this.cenaKM = cena;
		this.pocetMiest =miesta;
	}

	
	

}
