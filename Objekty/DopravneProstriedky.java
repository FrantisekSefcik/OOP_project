package Objekty;

import java.awt.List;

import aktivita.Sport;

public abstract class DopravneProstriedky {
	
	private String menoProstriedku;
	private double cenaKM;
	private int pocetMiest;
	private Cesta cestaTam;
	private Cesta cestaNaspat;
	
	
	
	public DopravneProstriedky(String name,Integer miesta , double cena){
		this.menoProstriedku=name;
		this.cenaKM = cena;
		this.setPocetMiest(miesta);
		cestaTam = new Cesta(this);
	    cestaNaspat = new Cesta(this);
	}
	
	public double getSuma(int pocetKm){
		double sum=0;
		if(cestaTam.isFree()==false)sum+=pocetKm*cenaKM;
		if(cestaNaspat.isFree()==false)sum+=pocetKm*cenaKM;
		return sum;
	}
	
	//metoda pridelenia sportovcov do dopravneho prostriedku, zistuje o aku cestu sa jedna ci tam alebo spiatocnu
	//zavola funkciu pridelenia v triede cesta
    public void sparuj(Sport sport,String druh){
		switch (druh) {
		case "Tam":
			cestaTam.sparuj(sport, druh);
			break;
        case "Spiatocna":
			cestaNaspat.sparuj(sport, druh);
			break;

		default:
			break;
		}
    }
	
	//sprava o parametroch prostriedku
    // pouzite prekonavanie, v druhej metode je metoda prekonana parametrom pocetKM
	public String spravaProstriedok(){
		String sprava="";
		sprava+="|"+ this.getTypS(this)+"| "+menoProstriedku+" |"+ Integer.toString(pocetMiest)+"\n";
		return sprava;
	}
	public String spravaProstriedok(int pocetKm){
		String sprava="";
		sprava+="|"+ this.getTypS(this)+"| "+menoProstriedku+" | Suma: "+ Double.toString(this.getSuma(pocetKm))+"$\n";
		return sprava;
	}
	
	//vytvara spravu pri parovani spojeni, pouzivatel zisti ci je dopravny prostriedok volny
	public String spravaParovanie(){
		String n ="";
		if(cestaTam.isObsadene()&&cestaNaspat.isObsadene()){n="full";}
		else{
			int a = cestaTam.getFreeMiesta();
			int b = cestaNaspat.getFreeMiesta();
			if(a==pocetMiest&&b==pocetMiest){n="free";}else{
				n = Integer.toString(a)+" | "+Integer.toString(b);
			}
		}
		String sprava="";
		sprava+="|"+ this.getTypS(this)+"| "+menoProstriedku+" |"+ Integer.toString(pocetMiest)+" | "+n+"\n";
		return sprava;
	}
	
	//vyuzitie RTTI pri zisteni o aky typ prostriedku ide, pouzite v metodach nad
	public String getTypS(DopravneProstriedky t){
		if(t instanceof Auto)return"A";
		else if(t instanceof Autobus)return"B";
		else if(t instanceof Lietadlo)return"L";
		else return "Undefined";
		
	}
	
	public String getMenoProstriedku(){
		return menoProstriedku;
	}
	public int getPocetMiest() {
		return pocetMiest;
	}

	public void setPocetMiest(int pocetMiest) {
		this.pocetMiest = pocetMiest;
	}
	
	

	
	

}
