package GUI;

import javax.imageio.ImageTypeSpecifier;

import aktivita.PocetUcastnikov;
import aktivita.main;
import aktivita.parametreExceptions;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
	import javafx.scene.control.*;
	import javafx.scene.layout.*;
	import javafx.stage.*;

	public class GUI extends Application{
		
		private Button button1;
		private Button dokonc;
		private Button button3;
		private Button button4;
		private Button button_pridaj;
		private Button pridaj_s;
		private Button aktualizuj;
		private Button spat_i;
		private Button spat_s;
		private Button vypisy;
		private Button vypis_v;
		private Button spat_v;
		private Button schval;
		private Button akt;
		
		private TextField meno_sportu; 
		private TextField vzdialenost;
		private TextField pocetdni;
		private TextField sporty_i;
		private TextField nazovakcie;
		private TextField kontaktnaOsoba;
		private TextField kontakt;
		private TextField datum1;
		private TextField datum2;
		private TextField zakladna;
		private TextField suma;
		
		
		private Label meno_sportulb;
		private Label label1;
		private Label vzdialenostlb;
		private Label pocetdnilb;
		private Label nazovakcielb;
		
		private TextArea vypis = new TextArea();
		private ScrollPane skrolVypis = new ScrollPane(vypis);
		private TextArea vypis2 = new TextArea();
		
		ComboBox<String> comboBox;
		ComboBox<String> comboBox2;
		private PocetUcastnikov pocetUcast;
		
		Scene scene1,scene2,scene3,scene_v;
		Stage window;
		   @Override
		   
	    	public void start(Stage hlavneOkno) throws Exception{
	    	window = hlavneOkno;
			window.setTitle("Správca");
			
	    	main main = new main();
	    	
	        //hlavne menu
	    	GridPane main_layout = new GridPane();
	    	main_layout.setHgap(10);
	    	main_layout.setVgap(10);
	    	main_layout.setPadding(new Insets(10, 20, 10, 20));
	    	
			main_layout.add(button1= new Button("Aktualizuj Informacie"),0,0);
			pocetUcast= new PocetUcastnikov(main);
			pocetUcast.setText("Pocet ucastnikov >> 0");
			main.pridajSledovatela(pocetUcast);
			main_layout.add(pocetUcast, 1, 0);
			main_layout.add(dokonc= new Button("Posun dalej"),0,1);
			main_layout.add(vypisy= new Button("Vypisy"),0,2);
			main_layout.add(suma= new TextField( "Financne prostriedky"),1,1);
			main_layout.add(comboBox2 = new ComboBox<>(),2,0);
		    comboBox2.getItems().addAll("Ubytovanie","Sporty","Doprava");
		    main_layout.add(schval= new Button("Schval"),2,1);
			vypis2.setMaxSize(400, 80);
			main_layout.add(vypis2,2,2);
			vypis2.appendText(main.sprava());
			main_layout.add(akt= new Button("Aktualizuj"),2,3);
			///informacie
			GridPane info_layout = new GridPane();
			info_layout.setHgap(3);
			info_layout.setVgap(10);
			info_layout.setPadding(new Insets(10, 20, 10, 20));
			
			info_layout.add(nazovakcie = new TextField("OH"), 1, 0);
			info_layout.add(nazovakcielb = new Label("Nazov udalosti:"), 0, 0);
			info_layout.add(pridaj_s = new Button("Pridaj sporty"), 0, 3);
			info_layout.add(sporty_i = new TextField("Pocet : 0"), 1, 3);
			info_layout.add(vzdialenostlb = new Label("Vzdialenost v km: "), 0, 1);
			info_layout.add(pocetdnilb = new Label("Miesto konania : "), 0, 2);
			info_layout.add(vzdialenost = new TextField("100"), 1, 1);
			info_layout.add(datum1 = new TextField("10/12/2017"), 2, 0);
			datum1.setPromptText("Odchod dd/mm/rrrr");
			info_layout.add(datum2 = new TextField("12/12/2017"), 2, 1);
			datum2.setPromptText("Prichod dd/mm/rrrr");
			info_layout.add(pocetdni = new TextField("Budapest"), 1, 2);
			info_layout.add(zakladna = new TextField("Namestovo"), 2, 2);
			zakladna.setPromptText("Zadaj miesto odjazadu");
			info_layout.add(aktualizuj = new Button("Aktualizuj"), 0, 4);
			info_layout.add(spat_i = new Button("Spat"), 0, 5);
			
				
			//vlozenie sportu
			VBox layout2 = new VBox(10);
			layout2.getChildren().add(meno_sportulb = new Label("Nazov sportu :"));
			layout2.getChildren().add(meno_sportu = new TextField("Futbal"));
			layout2.getChildren().add(kontaktnaOsoba = new TextField("Andrej Maurery"));
			kontaktnaOsoba.setPromptText("Kontaktná osoba");
			layout2.getChildren().add(kontakt = new TextField("0944283219 / maurery@gmail.com"));
			kontakt.setPromptText("kontakt: tel.cis/email");
			layout2.getChildren().add(button_pridaj = new Button("pridaj"));
			layout2.getChildren().add(spat_s = new Button("Spat"));
			
			//vypisy
			VBox box =new VBox(5);
			box.getChildren().add(comboBox = new ComboBox<>());
		    comboBox.getItems().addAll("Celkovy vypis","Ubytovanie","Naklady vypis","Naklady detailny vypis");
			box.getChildren().add(vypis_v = new Button("Vypis"));
			box.getChildren().add(vypis);
			box.getChildren().add(spat_v = new Button("Spat"));
			
		    ///////////////////////////////////////////////////////////////////////////////////////
			///buttons
			button1.setOnAction( e-> window.setScene(scene2));
			pridaj_s.setOnAction(e->window.setScene(scene3));
			spat_s.setOnAction(e-> window.setScene(scene2));
			
			//pouzitie vlastnej vynimky 
			aktualizuj.setOnAction(e->{
				try{main.aktualizuj(nazovakcie.getText(),pocetdni.getText(),datum1.getText(),datum2.getText(),
					Integer.parseInt(vzdialenost.getText()),zakladna.getText());
					}catch(parametreExceptions ex){
						new GUI_error("Nespravny format datumu alebo vzdialenost");
					}});
			
			button_pridaj.setOnAction(e->{if(main.vyhladaj(meno_sportu.getText())){}else{ sporty_i.setText( main.vytvorSport(meno_sportu.getText(),
					                 kontaktnaOsoba.getText(),kontakt.getText())); meno_sportu.clear();kontakt.clear();kontaktnaOsoba.clear();} });
			spat_i.setOnAction(e-> {window.setScene(scene1);suma.setText("Suma: "+Double.toString(main.getSuma())+"$");
			                        vypis2.clear();vypis2.appendText(main.sprava());});
			dokonc.setOnAction(e->{ if(main.stavInfo()){new GUI_OknoSport(main);new GUI_OknoUbytovanie(main);new GUI_OknoDoprava(main);}
			});
			vypisy.setOnAction(e->window.setScene(scene_v));
			spat_v.setOnAction(e->window.setScene(scene1));
			vypis_v.setOnAction(e->{vypis.clear();vypis.appendText(main.hlavnyVypis(comboBox.getSelectionModel().getSelectedItem().toString()));});
			akt.setOnAction(e-> {vypis2.clear();vypis2.appendText(main.sprava());});
			schval.setOnAction(e->main.schval(comboBox2.getSelectionModel().getSelectedItem().toString()));
			////buttons
			//////////////////////////////////////////////////////////////////////////////////////////
			scene_v= new Scene(box,800,600);
			scene3 = new Scene(layout2,800,600);
			scene2 = new Scene(info_layout,800,600);
			scene1 = new Scene(main_layout,800,600);
			
			window.setScene(scene1);
			window.show();
		} 
	 public static void main(String[] args){
		 
		 launch(args);
		 
		 
	 }

		
		
	}


