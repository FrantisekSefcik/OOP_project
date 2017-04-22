package GUI;

import javax.imageio.ImageTypeSpecifier;

import aktivita.PocetUcastnikov;
import aktivita.main;
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
		
		private TextField meno_sportu; 
		private TextField vzdialenost;
		private TextField pocetdni;
		private TextField sporty_i;
		private TextField nazovakcie;
		
		private Label meno_sportulb;
		private Label label1;
		private Label vzdialenostlb;
		private Label pocetdnilb;
		private Label nazovakcielb;
		
		
		private PocetUcastnikov pocetUcast;
		
		Scene scene1,scene2,scene3;
		Stage window;
		   @Override
		   
	    	public void start(Stage hlavneOkno) throws Exception{
	    	window = hlavneOkno;
			window.setTitle("Spr�vca");
			
	    	main main = new main();
	    	
	        //hlavne menu
	    	GridPane main_layout = new GridPane();
	    	main_layout.setHgap(10);
	    	main_layout.setVgap(10);
	    	main_layout.setPadding(new Insets(10, 20, 10, 20));
	    	
			main_layout.add(button1= new Button("Aktualizuj Informacie"),0,0);
			main_layout.add(label1= new Label("Pocet sportovcov: "),1,0);
			pocetUcast= new PocetUcastnikov(main);
			main.pridajSledovatela(pocetUcast);
			main_layout.add(pocetUcast, 2, 0);
			main_layout.add(dokonc= new Button("Dokonc"),0,1);
			
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
			info_layout.add(pocetdnilb = new Label("Pocet dni : "), 0, 2);
			info_layout.add(vzdialenost = new TextField("100"), 1, 1);
			info_layout.add(pocetdni = new TextField("100"), 1, 2);
			info_layout.add(aktualizuj = new Button("Aktualizuj"), 0, 4);
			info_layout.add(spat_i = new Button("Spat"), 0, 5);
				
			//vlozenie sportu
			VBox layout2 = new VBox(10);
			layout2.getChildren().add(meno_sportulb = new Label("Nazov sportu :"));
			layout2.getChildren().add(meno_sportu = new TextField());
			layout2.getChildren().add(button_pridaj = new Button("pridaj"));
			layout2.getChildren().add(spat_s = new Button("Spat"));
			
		    ///////////////////////////////////////////////////////////////////////////////////////
			///buttons
			button1.setOnAction(e-> window.setScene(scene2));
			pridaj_s.setOnAction(e->window.setScene(scene3));
			spat_s.setOnAction(e-> window.setScene(scene2));
			aktualizuj.setOnAction(e-> main.aktualizuj(nazovakcie.getText(),Integer.parseInt(pocetdni.getText()), Integer.parseInt(vzdialenost.getText())));
			button_pridaj.setOnAction(e->{if(main.vyhladaj(meno_sportu.getText())){}else{ sporty_i.setText( main.vytvorSport(meno_sportu.getText())); 
			                              meno_sportu.clear();} });
			spat_i.setOnAction(e-> window.setScene(scene1));
			dokonc.setOnAction(e->{ if(main.stavInfo()){new GUI_OknoSport(main);new GUI_OknoUbytovanie(main);new GUI_OknoDoprava(main);}
			});
			////buttons
			//////////////////////////////////////////////////////////////////////////////////////////
			
			scene3 = new Scene(layout2,600,600);
			scene2 = new Scene(info_layout,600,600);
			scene1 = new Scene(main_layout,600,600);
			
			window.setScene(scene1);
			window.show();
		} 
	 public static void main(String[] args){
		 
		 launch(args);
		 
		 
	 }

		
		
	}

