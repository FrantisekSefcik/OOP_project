package Objekty;

public class Datum {
	private int dni1;
	private int dni2;
	private int mesiace1;
	private int mesiace2;
	private int roky1;
	private int roky2;
	private String s="";
	
	public int zistiPocetDni(String datum1,String datum2){
		this.zistiDni(datum1, datum2);
			return (dni2-dni1)+(mesiace2-mesiace1)*30+(roky2-roky1)*365;
	}
	public void zistiDni(String datum1,String datum2){
		dni1= Integer.parseInt(datum1.substring(0, 2));
		mesiace1= Integer.parseInt(datum1.substring(3, 5));
		roky1= Integer.parseInt(datum1.substring(6, 10));
		dni2= Integer.parseInt(datum2.substring(0, 2));
		mesiace2= Integer.parseInt(datum2.substring(3, 5));
		roky2= Integer.parseInt(datum2.substring(6, 10));
	}

}
