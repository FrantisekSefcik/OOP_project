package Objekty;
import java.util.ArrayList;
import java.util.List;

public class Izba {

	private int pocetLozok;
	private int cisloIzby;
	private double cenaIzby; 
	private List<Ucastnici> ubytovani = new ArrayList<>();
	
	public Izba(int lozka,int cisloI,double cenaN){
		pocetLozok=lozka;cisloIzby=cisloI;cenaIzby=cenaN;
	}

	public int getPocetLozok() {
		return pocetLozok;
	}

	public void setPocetLozok(int pocetLozok) {
		this.pocetLozok = pocetLozok;
	}

	public int getCisloIzby() {
		return cisloIzby;
	}

	public void setCisloIzby(int cisloIzby) {
		this.cisloIzby = cisloIzby;
	}

	public double getCenaIzby() {
		return cenaIzby;
	}

	public void setCenaIzby(double cenaIzby) {
		this.cenaIzby = cenaIzby;
	}
	
}
