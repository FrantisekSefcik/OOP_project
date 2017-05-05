package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import aktivita.PocetUcastnikov;
import aktivita.ZoznamSportov;
import aktivita.main;

public class GUI_OknoSport extends Stage {

    private main main;
    private ZoznamSportov zoznamSportov;
    private PocetUcastnikov pocetUcast;
    
    private Button sportovec;
	private Button trener;
	private Button obsluha;
	private Button end_vypln;
	private Button dalsi_sport;
	private Button pridaj_s1;
	private Button pridaj_s2;
	private Button dokonc_s;
	private Button pridaj_t1;
	private Button dokonc_t;
	private Button pridaj_o1;
	private Button pridaj_o2;
	private Button dokonc_o;
	private Button hlavny_napln;
	private Button ubytovanie;
	private Button schval;
	
	private Label pocet_slb;
	private Label cena_slb;
	private Label meno_slb;
	private Label cena_slb2;
	private Label cena_tlb;
	private Label meno_tlb;
	private Label popis1;
	private Label popis2;
	private Label popist1;
	private Label cenalb;
	private Label pocetlb;
	private Label pocet_olb;
	private Label cena_olb;
	private Label meno_olb;
	private Label cena_olb2;
	private Label popis_o1;
	private Label popis_o2;
	private Label hlavny_slb;
	private Label infoKontakt;
	
	private TextField pocet_s;
	private TextField cena_s;
	private TextField meno_s;
	private TextField cena_s2;
	private TextField cena_t;
	private TextField meno_t;
	private TextField kontaktnaOsoba;
	private TextField kontakt;
	private TextField cena;
	private TextField pocet;
	private TextField zabezpecenie;
	private TextField pocet_o;
	private TextField cena_o;
	private TextField meno_o;
	private TextField cena_o2;
	private TextField text1;
	private TextField hlavny_s;
	private TextField sprava;
	
	private TextArea vypis_s = new TextArea();
	private ScrollPane skrolVypis_s = new ScrollPane(vypis_s);
	private TextArea vypis_o = new TextArea();
	private ScrollPane skrolVypis_o = new ScrollPane(vypis_o);
	private TextArea vypis_hsp = new TextArea();
	private ScrollPane skrolVypis_hsp = new ScrollPane(vypis_hsp);
	private TextArea vypis = new TextArea();
	private ScrollPane skrolVypis = new ScrollPane(vypis);
    
    Scene scene3,scene_s,scene_t,scene_o,scene1;
    
	public GUI_OknoSport(main a){
		super();
		main=a;
		setTitle("Sporty");
		zoznamSportov = main.getSporty();
		
		vypis_hsp.appendText(main.vypisS());
		//initModality(APPLICATION_MODAL);
		
		///hlavny 
		GridPane grid_h = new GridPane();
	    grid_h.setHgap(10);
	    grid_h.setVgap(10);
	    
	    grid_h.add(hlavny_napln = new Button("Napln sport"),0,1);
	    grid_h.add(hlavny_slb = new Label("Nazov sportu :"),0,0);
	    grid_h.add(hlavny_s = new TextField(),1,0);
	    grid_h.add(vypis_hsp,2,0);
	    vypis_hsp.setMaxSize(250, 100);
	    grid_h.add(ubytovanie= new Button("Aktualizuj data"), 0, 2);
	    pocetUcast= new PocetUcastnikov(main);
		pocetUcast.setText("0");
		main.pridajSledovatela(pocetUcast);
		grid_h.add(pocetUcast,2,1);
		grid_h.add(sprava =new TextField("Stav neznamy"),2,2);
		grid_h.add(schval = new Button("Schval"),2,3);
		
		//naplnenie sportu
        VBox layout3 = new VBox(10);
        layout3.getChildren().add(infoKontakt = new Label("Kontaktne udaje"));
        layout3.getChildren().add(kontaktnaOsoba = new TextField());
		layout3.getChildren().add(kontakt = new TextField());
		layout3.getChildren().add(sportovec = new Button("pridaj sportovec"));
		layout3.getChildren().add(trener = new Button("pridaj trener"));
		layout3.getChildren().add(obsluha = new Button("pridaj obsluha"));
		layout3.getChildren().add(end_vypln = new Button("Dokonc"));
		layout3.getChildren().add(vypis);
		
		//naplnenie sportovec
		GridPane grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(10, 20, 10, 20));
	    ///pridaj skupinu		    
	    grid.add(popis1= new Label("Pridaj vsetkych:"),1,0);
	    grid.add(pocet_slb = new Label("Pocet sportovcov :"),0,1);
	    grid.add(pocet_s = new TextField("10"), 1,1);
	    grid.add(cena_slb = new Label("Naklady os. :"),0,2);
	    grid.add(cena_s = new TextField("99"), 1,2);
	    grid.add(pridaj_s1 = new Button("Pridaj vsetkych"), 1,3);
	    ///pridaj jednotlivca
	    grid.add(popis2= new Label("Pridaj jednotlivca:"),1,4);
	    grid.add(meno_slb = new Label("Meno sportovca :"),0,5);
	    grid.add(meno_s = new TextField(), 1,5);
	    grid.add(cena_slb2 = new Label("Naklady os. :"),0,6);
	    grid.add(cena_s2 = new TextField(), 1,6);
	    grid.add(pridaj_s2 = new Button("pridaj jednotlivca"), 1,7);
	    
	    grid.add(dokonc_s = new Button("Dokonc"), 0,8);
	    grid.add(vypis_s, 1,9);
	    
	    /////naplnenie trener
	    GridPane grid_t = new GridPane();
	    grid_t.setHgap(10);
	    grid_t.setVgap(10);
	    grid_t.setPadding(new Insets(10, 20, 10, 20));
	    grid_t.add(popist1= new Label("Pridaj Trenera:"),1,0);
	    grid_t.add(meno_tlb = new Label("Meno trenera :"),0,1);
	    grid_t.add(meno_t = new TextField("Jano"), 1,1);
	    grid_t.add(cena_tlb = new Label("Naklady os. :"),0,2);
	    grid_t.add(cena_t = new TextField("111"), 1,2);
	    grid_t.add(pridaj_t1 = new Button("pridaj trenera"), 1,3);
	    grid_t.add(dokonc_t = new Button("dokonc"), 0,4);
	    
	  //naplnenie obsluha
		GridPane grid_o = new GridPane();
	    grid_o.setHgap(10);
	    grid_o.setVgap(10);
	    grid_o.setPadding(new Insets(10, 20, 10, 20));
	    ///pridaj skupinu		    
	    grid_o.add(popis_o1= new Label("Pridaj vsetkych:"),1,0);
	    grid_o.add(pocet_olb = new Label("Pocet Obsluhy :"),0,1);
	    grid_o.add(pocet_o = new TextField("5"), 1,1);
	    grid_o.add(cena_olb = new Label("Naklady os. :"),0,2);
	    grid_o.add(cena_o = new TextField("100"), 1,2);
	    grid_o.add(pridaj_o1 = new Button("pridaj vsetkych"), 1,3);
	    ///pridaj jednotlivca
	    grid_o.add(popis_o2= new Label("Pridaj jednotlivca:"),1,4);
	    grid_o.add(meno_olb = new Label("Meno Obsluhy :"),0,5);
	    grid_o.add(meno_o = new TextField(), 1,5);
	    grid_o.add(cena_olb2 = new Label("Naklady os. :"),0,6);
	    grid_o.add(cena_o2 = new TextField(), 1,6);
	    grid_o.add(pridaj_o2 = new Button("pridaj jednotlivca"), 1,7);
	    
	    grid_o.add(dokonc_o = new Button("dokonc"), 0,8);
	    grid_o.add(vypis_o, 1,9);
	    ///////////////////////////////////////////////////////////////////////////////////////
		///buttons
	    hlavny_napln.setOnAction(e->{
	    	if(zoznamSportov.existSport(hlavny_s.getText())){this.setScene(scene3);zoznamSportov.dostanSport(hlavny_s.getText());}
	    	vypis.clear();			vypis.appendText(zoznamSportov.vypis()); kontaktnaOsoba.setText(zoznamSportov.getKontaktnaOsoba()); kontakt.setText(zoznamSportov.getKontakt());
	    });
	    
	    pridaj_s1.setOnAction(e->{try{zoznamSportov.vytvorSportovcovS(Integer.parseInt(pocet_s.getText().toString()), 
				Integer.parseInt(cena_s.getText().toString()));
		vypis_s.clear();
		vypis_s.appendText(zoznamSportov.vypis());
	    }catch(Exception xe){
			new GUI_error("Nespravny vstup");
		}
		});
		
		pridaj_s2.setOnAction(e->{try{zoznamSportov.vytvorSportovcovJ(meno_s.getText().toString(), 
				Integer.parseInt(cena_s2.getText().toString()));
		vypis_s.clear();
		vypis_s.appendText(zoznamSportov.vypis());
		}catch(Exception xe){
			new GUI_error("Nespravny vstup");
		}
		});
		dokonc_s.setOnAction(e->{this.setScene(scene3);vypis.clear();			vypis.appendText(zoznamSportov.vypis());});
		
		end_vypln.setOnAction(e-> {this.setScene(scene1);vypis_hsp.clear();vypis_hsp.appendText(main.vypisS());
		                         if(zoznamSportov.isSplnene()){sprava.setText("Splnene");}else{sprava.setText("Nesplnene");}
		});
		
		sportovec.setOnAction(e-> this.setScene(scene_s));
		
		trener.setOnAction(e-> this.setScene(scene_t));
		
		pridaj_t1.setOnAction(e-> {try{zoznamSportov.vytvorTrenera(meno_t.getText().toString(),Integer.parseInt(cena_t.getText()));
		}catch(Exception xe){
			new GUI_error("Nespravny vstup");
		}});
		
		dokonc_t.setOnAction(e-> {this.setScene(scene3);vypis.clear();			vypis.appendText(zoznamSportov.vypis());});
		
		obsluha.setOnAction(e-> this.setScene(scene_o));
		
		pridaj_o1.setOnAction(e->{ try{zoznamSportov.vytvorObsluhuS(Integer.parseInt(pocet_o.getText().toString()), 
				Integer.parseInt(cena_o.getText().toString()));
		vypis_o.clear();
		vypis_o.appendText(zoznamSportov.vypis());
		}catch(Exception xe){
			new GUI_error("Nespravny vstup");
		}
		
			});
		
		pridaj_o2.setOnAction(e->{try{zoznamSportov.vytvorObsluhuJ(meno_o.getText().toString(), 
				Integer.parseInt(cena_o2.getText().toString()));
		vypis_o.clear();
		vypis_o.appendText(zoznamSportov.vypis());}catch(Exception xe){
			new GUI_error("Nespravny vstup");
		}
			});
		
		dokonc_o.setOnAction(e-> {this.setScene(scene3);vypis.clear();			vypis.appendText(zoznamSportov.vypis());});
		ubytovanie.setOnAction(e->{ vypis_hsp.clear();vypis_hsp.appendText(main.vypisS());
		                        if(zoznamSportov.isSplnene()){sprava.setText("Splnene");}else{sprava.setText("Nesplnene");}});
		schval.setOnAction(e->{if(zoznamSportov.isSplnene()){ if(zoznamSportov.isSchvalSport()){this.close();}else{zoznamSportov.setCakam(true);sprava.setText("Cakam na schvalenie");}
		                       }else{ new GUI_error("Neboli este splnene poziadavky");}});
		/////Buttons
		///////////////////////////////////////////
		
		scene_s = new Scene(grid,800,600);
		scene_t = new Scene(grid_t,800,600);
		scene_o = new Scene(grid_o,800,600);
		scene3 = new Scene(layout3,600,600);
		scene1 = new Scene(grid_h,600,600);
				
		setScene(scene1);
		show();
	}
}
