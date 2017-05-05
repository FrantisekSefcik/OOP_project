package GUI;

import javax.print.attribute.standard.MediaName;

import aktivita.PocetUcastnikov;
import aktivita.ZoznamDoprava;
import aktivita.ZoznamSportov;
import aktivita.main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI_OknoDoprava extends Stage {
	private main main;
	private ZoznamDoprava doprava;
	private ZoznamSportov sporty;
	
	PocetUcastnikov pocetUcast;
	
	private Button pridaj_h;
	Button pridaj_s2;
	Button pridajProstriedok_s;
	Button end_s;
	Button pridaj_p;
	Button end_p;
	Button sparuj_h;
	Button end_d;
	Button prirad_d;
	Button schval;
	
	TextField meno_s;
	TextField cislou_s;
	TextField meno_p;
	TextField miesta_p;
	TextField cena_p;
	TextField prostriedok_d;
	TextField sport_d;
	TextField sprava;
	
	Label popis_s1;
	Label meno_slb;
	Label cislou_slb;
	Label druhlb;
	Label meno_plb;
	Label miesta_plb;
	Label cena_plb;
	Label miesto;
	Label prichod;
	Label odchod;
	Label zakladna;
	Label vzdialenost;
	ComboBox<String> comboBox;
	ComboBox<String> comboBox2;
	
	private TextArea vypis_h = new TextArea();
	private ScrollPane skrolVypis_h = new ScrollPane(vypis_h);
	private TextArea vypis_s = new TextArea();
	private ScrollPane skrolVypis_s = new ScrollPane(vypis_s);
	private TextArea vypis_d = new TextArea();
	private ScrollPane skrolVypis_d = new ScrollPane(vypis_d);
	private TextArea vypis_ds = new TextArea();
	private ScrollPane skrolVypis_ds = new ScrollPane(vypis_ds);
	
	private Scene scene1,scene_s,scene_p,scene_d;
	
	public GUI_OknoDoprava(main main){
		super();
		this.main = main;
		doprava = main.getDoprava();
		sporty = main.getSporty();
		setTitle("Doprava");
		
		GridPane grid_h = new GridPane();
	    grid_h.setHgap(10);
	    grid_h.setVgap(10);
	    
	    grid_h.add(pridaj_h = new Button("Pridaj Dopravnu S"), 0, 0);
	    grid_h.add(vypis_h, 1, 0);
	    vypis_h.setMaxSize(250, 100);
	    vypis_h.setText("Ziadne dostupne prostriedky.");
	    grid_h.add(vypis_s, 2, 0);
	    vypis_s.setMaxSize(250, 100);
	    vypis_s.setText(sporty.spravaSDoprava());
	    pocetUcast = new PocetUcastnikov(main);
	    main.pridajSledovatela(pocetUcast);
	    grid_h.add(pocetUcast, 2, 1);
	    grid_h.add(miesto = new Label("Miesto konania: "+main.getMiestoKonania()) ,2,2);
	    grid_h.add(zakladna = new Label("Miesto odjazdu: "+main.getMiestoOdjazdu()) ,2,3);
	    grid_h.add(prichod = new Label("Prichod "+main.getDatum1()) ,2,4);
	    grid_h.add(odchod = new Label("Odchod "+main.getDatum2()) ,2,5);
	    grid_h.add(vzdialenost = new Label("Vzdialenost: "+Integer.toString(main.getPocetKm())) ,2,6);
	    grid_h.add(sparuj_h = new Button("Sparuj spojenia"), 0, 1);
	    grid_h.add(sprava = new TextField("Nesplnene"), 1, 3);
	    grid_h.add(schval = new Button("Schval"), 1, 4);
	    
	////spolocnost
	    GridPane grid_s = new GridPane();
	    grid_s.setHgap(10);
	    grid_s.setVgap(10);
	    
		grid_s.add(popis_s1= new Label("Pridaj Dopravnu spolocnost:"),1,0);
		grid_s.add(meno_slb = new Label("Nazov spolocnosti :"),0,1);
	    
		grid_s.add(meno_s = new TextField("EasyJet"), 1,1);
	    grid_s.add(cislou_slb = new Label("Cislo uctu :"),0,4);
		grid_s.add(cislou_s = new TextField("44552323"), 1,4);
	    
		grid_s.add(pridaj_s2 = new Button("pridaj spolocnost"), 1,5);
		grid_s.add(pridajProstriedok_s = new Button("pridaj prostriedky"), 1,6);
		grid_s.add(end_s = new Button("spat"), 1,7);
		
		///Dopravne prostriedky
		GridPane grid_p = new GridPane();
	    grid_p.setHgap(10);
	    grid_p.setVgap(10);
	    
	    grid_p.add(druhlb = new Label("Druh prostriedku "),0,0);
	    grid_p.add(comboBox = new ComboBox<>(),1,0);
	    comboBox.getItems().addAll("Lietadlo","Auto","Autobus");
	    comboBox.setValue("Vyber");
	    grid_p.add(meno_plb = new Label("Nazov prostriedku: "),0,1);
	    grid_p.add(meno_p = new TextField(),1,1);
	    grid_p.add(miesta_plb = new Label("Pocet miest na sedenie: "),0,2);
	    grid_p.add(miesta_p = new TextField(),1,2);
	    grid_p.add(cena_plb = new Label("Cena za Km: "),0,3);
	    grid_p.add(cena_p = new TextField(),1,3);
	    grid_p.add(pridaj_p = new Button("Pridaj"), 1,5);
	    grid_p.add(end_p = new Button("spat"), 1,6);
	    
	    ////Sparuj
	    GridPane grid_d = new GridPane();
	    grid_d.setHgap(10);
	    grid_d.setVgap(10);
	    
	    grid_d.add(vypis_d, 0,0);
	    vypis_d.setMaxSize(250, 100);
	    grid_d.add(vypis_ds, 2,0);
	    vypis_ds.setMaxSize(250, 100);
	    grid_d.add(prostriedok_d = new TextField(),2,1);
	    prostriedok_d.setPromptText("Zadaj nazov prostriedku");
	    grid_d.add(sport_d = new TextField(),0,1);
	    sport_d.setPromptText("Zadaj nazov sportu");
	    grid_d.add(comboBox2 = new ComboBox<>(),1,1);
	    comboBox2.getItems().addAll("Tam","Spiatocna");
	    comboBox2.setValue("Tam");
	    grid_d.add(prirad_d = new Button("Prirad"), 0,3);
	    grid_d.add(end_d = new Button("spat"), 1,6);
		
		//////////////////////////////////////////////////////////////////////
		////Buttons
		pridaj_h.setOnAction(e->setScene(scene_s));
		end_s.setOnAction(e->{setScene(scene1); vypis_h.clear();vypis_h.appendText(doprava.spravaSpolocnosti());});
		pridaj_s2.setOnAction(e->{if(doprava.vyhladajSpolocnost(meno_s.getText())){			
		                         }else{doprava.pridajSpolocnost(meno_s.getText(), Integer.parseInt(cislou_s.getText()));cislou_s.clear();}});
		pridajProstriedok_s.setOnAction(e->{if(doprava.vyhladajSpolocnost(meno_s.getText())){setScene(scene_p);} });
		pridaj_p.setOnAction(e->{ doprava.pridajProstriedok(comboBox.getSelectionModel().getSelectedItem().toString(),
				                  meno_p.getText(), Integer.parseInt(miesta_p.getText()),  Integer.parseInt(cena_p.getText()));});
		end_p.setOnAction(e->{this.setScene(scene_s);vypis_s.clear();vypis_s.setText(sporty.spravaSDoprava());});
		sparuj_h.setOnAction(e->{this.setScene(scene_d);vypis_ds.appendText(doprava.spravaParovanie());vypis_d.appendText(sporty.spravaDopravaP());});
		end_d.setOnAction(e-> {this.setScene(scene1);
		                       if(sporty.isDopravaSplnene()){sprava.setText("Stav :Splnene");}else{sprava.setText("Stav: Nesplnene");} });
		prirad_d.setOnAction(e->{doprava.sparuj(prostriedok_d.getText(),sport_d.getText(), comboBox2.getSelectionModel().getSelectedItem().toString());
		                         vypis_d.clear();vypis_ds.clear();vypis_ds.appendText(doprava.spravaParovanie());vypis_d.appendText(sporty.spravaDopravaP());});
		schval.setOnAction(e->{if(sporty.isDopravaSplnene()){if(sporty.isSchvalDoprava()){this.close();}else{doprava.setCakam(true);sprava.setText("Cakam na schvalenie");}
		                       }else{ new GUI_error("Neboli este splnene poziadavky");}});
		///Buttons
		////////////////////////////////////////////////////////////////////
	    
	    scene1 = new Scene(grid_h,700,600);
	    scene_s = new Scene(grid_s,700,600);
	    scene_p = new Scene(grid_p,700,600);
	    scene_d = new Scene(grid_d,700,600);
	    
	    setScene(scene1);
	    show();
	    
	}

}
