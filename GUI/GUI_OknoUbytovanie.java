package GUI;

import aktivita.PocetUcastnikov;
import aktivita.ZoznamHotelov;
import aktivita.ZoznamSportov;
import aktivita.main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI_OknoUbytovanie extends Stage {
	private main main;
	private PocetUcastnikov pocetUcast;
	private ZoznamHotelov hotels;
	private ZoznamSportov sports;
	
	private Button pridaj_h;
	private Button pridaj_h2;
	private Button end_h;
	private Button pridajIzbu_h;
	private Button pridaj_i;
	private Button end_i;
	private Button ubytuj_h;
	private Button vypis_hlavny;
	
	private TextField meno_h;
	private TextField cislou_h;
	private TextField adresa_m;
	private TextField adresa_u;
	private TextField lozka_i;
	private TextField cislo_i;
	private TextField cena_i;
	
	private Label popis_h1;
	private Label meno_hlb;
	private Label cislou_hlb;
	private Label adresa_mlb;
	private Label adresa_ulb;
	private Label lozka_ilb;
	private Label cislo_ilb;
	private Label cena_ilb;
	
	private TextArea vypis_h = new TextArea();
	private ScrollPane skrolVypis_h = new ScrollPane(vypis_h);
	private TextArea vypis_s = new TextArea();
	private ScrollPane skrolVypis_s = new ScrollPane(vypis_s);
	private TextArea vypis = new TextArea();
	private ScrollPane skrolVypis = new ScrollPane(vypis);
	
	private Scene scene1,scene_h,scene_i,scene_v;
	
	public GUI_OknoUbytovanie(main main){
		super();
		this.main = main;
		hotels = main.getHotel();
		sports = main.getSporty();
		setTitle("Ubytovanie");
		
		///hlavny 
				GridPane grid_h = new GridPane();
			    grid_h.setHgap(10);
			    grid_h.setVgap(10);
			    
			    grid_h.add(pridaj_h = new Button("Pridaj Hotel"), 0, 0);
			    pocetUcast = new PocetUcastnikov(main);
			    main.pridajSledovatela(pocetUcast);
			    grid_h.add(pocetUcast, 2, 1);
			    grid_h.add(vypis_h,2,0);
			    vypis_h.setText("Ziadne dostupne hotely");
			    vypis_h.setMaxSize(250, 100);
			    grid_h.add(vypis_s,3,0);
			    vypis_s.setMaxSize(250, 100);
			    vypis_s.setText(sports.spravaSHotel());	
			    grid_h.add(ubytuj_h = new Button("Prirad ubytovanie") ,3,2);
			    grid_h.add(vypis_hlavny = new Button("Vypis"), 0, 4);
			    
			    
			    
			   ////Hotel
			    GridPane grid_hotel = new GridPane();
			    grid_hotel.setHgap(10);
			    grid_hotel.setVgap(10);
			    
			    grid_hotel.add(popis_h1= new Label("Pridaj Hotel:"),1,0);
			    grid_hotel.add(meno_hlb = new Label("Nazov Hotela :"),0,1);
			    grid_hotel.add(meno_h = new TextField("Carlton"), 1,1);
			    grid_hotel.add(adresa_mlb = new Label("Mesto :"),0,2);
			    grid_hotel.add(adresa_m = new TextField("Namestovo"), 1,2);
			    grid_hotel.add(adresa_ulb = new Label("Ulica a cislo :"),0,3);
			    grid_hotel.add(adresa_u = new TextField("Ulicna 442"), 1,3);
			    grid_hotel.add(cislou_hlb = new Label("Cislo uctu :"),0,4);
			    grid_hotel.add(cislou_h = new TextField("44552323"), 1,4);
			    
			    grid_hotel.add(pridaj_h2 = new Button("pridaj hotel"), 1,5);
			    grid_hotel.add(pridajIzbu_h = new Button("pridaj izby"), 1,6);
			    grid_hotel.add(end_h = new Button("spat"), 1,7);
			    
			    /////izby
			    GridPane grid_izba = new GridPane();
			    grid_izba.setHgap(10);
			    grid_izba.setVgap(10);
			    grid_izba.add(lozka_ilb = new Label("Pocet posteli :"),0,1);
			    grid_izba.add(lozka_i = new TextField(), 1,1);
			    grid_izba.add(cislo_ilb = new Label("Cislo izby :"),0,2);
			    grid_izba.add(cislo_i = new TextField(), 1,2);
			    grid_izba.add(cena_ilb = new Label("Cena za noc :"),0,3);
			    grid_izba.add(cena_i = new TextField(), 1,3);
			    grid_izba.add(pridaj_i = new Button("pridaj izbu"), 1,4);
			    grid_izba.add(end_i = new Button("dokonc"), 1,5);
			    
			    VBox ubytovanie = new VBox(2);
                ubytovanie.getChildren().add(vypis);
			    
			    
			   
			    
			    
			    ////////////////////////////////////////////////////////////////////////////////////
			    //////Buttons
			    pridaj_h.setOnAction(e-> this.setScene(scene_h));
			    pridaj_h2.setOnAction(e-> {if(hotels.existHotel(meno_h.getText())){}else{hotels.pridajHotel(meno_h.getText(), adresa_m.getText(), adresa_u.getText(), Integer.parseInt(cislou_h.getText()));
			    adresa_m.clear();adresa_u.clear();cislou_h.clear();}});
			    end_h.setOnAction(e-> {this.setScene(scene1);vypis_h.setText(hotels.vypisHotelov());vypis_s.clear();vypis_s.setText(sports.spravaSHotel());});
			    pridajIzbu_h.setOnAction(e->{if(hotels.existHotel(meno_h.getText())){hotels.vyhladajHotel(meno_h.getText());this.setScene(scene_i);}});
			    pridaj_i.setOnAction(e->{ hotels.pridajIzbu(Integer.parseInt(lozka_i.getText()), Integer.parseInt(cislo_i.getText()), Double.parseDouble(cena_i.getText()));
			    cislo_i.clear();});
			    end_i.setOnAction(e-> this.setScene(scene_h));
			    ubytuj_h.setOnAction(e-> {hotels.priradUbytovanie();vypis_s.clear();vypis_s.setText(sports.spravaSHotel());});
			    vypis_hlavny.setOnAction(e->{this.setScene(scene_v);vypis.setText(sports.vypisHotel());});
			    
			    
			    /////Buttons
			    ///////////////////////////////////////////////////////////////////////////////////
			    
				scene1 = new Scene(grid_h,600,600);
				scene_h = new Scene(grid_hotel,600,600);
				scene_i = new Scene(grid_izba,600,600);
				scene_v = new Scene(ubytovanie,600,600);
				setScene(scene1);
				show();
	}

}
