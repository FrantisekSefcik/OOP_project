package ubytovanie;

import aktivita.ZoznamHotelov;


public aspect Ubytuj {
	
	
	
	
	after(ZoznamHotelov h): call(* ZoznamHotelov.pridajIzbu(..)) && target(h) {
		 h.priradUbytovanie();
	}

}
