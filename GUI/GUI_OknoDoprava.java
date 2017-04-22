package GUI;

import aktivita.ZoznamDoprava;
import aktivita.main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI_OknoDoprava extends Stage {
	private main main;
	private ZoznamDoprava doprava;
	
	private Button pridaj_h;
	Button pridaj_s2;
	Button pridajProstriedok_s;
	Button end_s;
	Button pridaj_p;
	Button end_p;
	
	TextField meno_s;
	TextField cislou_s;
	TextField meno_p;
	TextField miesta_p;
	TextField cena_p;
	
	Label popis_s1;
	Label meno_slb;
	Label cislou_slb;
	Label druhlb;
	Label meno_plb;
	Label miesta_plb;
	Label cena_plb;
	ComboBox<String> comboBox;
	
	private Scene scene1,scene_s,scene_p;
	
	public GUI_OknoDoprava(main main){
		super();
		this.main = main;
		doprava = main.getDoprava();
		setTitle("Doprava");
		
		GridPane grid_h = new GridPane();
	    grid_h.setHgap(10);
	    grid_h.setVgap(10);
	    
	    grid_h.add(pridaj_h = new Button("Pridaj Dopravnu S"), 0, 0);
	    
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
	    comboBox.setValue("Normal");
	    grid_p.add(meno_plb = new Label("Nazov prostriedku: "),0,1);
	    grid_p.add(meno_p = new TextField(),1,1);
	    grid_p.add(miesta_plb = new Label("Pocet miest na sedenie: "),0,2);
	    grid_p.add(miesta_p = new TextField(),1,2);
	    grid_p.add(cena_plb = new Label("Cena za Km: "),0,3);
	    grid_p.add(cena_p = new TextField(),1,3);
	    grid_p.add(pridaj_p = new Button("Pridaj"), 1,5);
	    grid_p.add(end_p = new Button("spat"), 1,6);
		
		//////////////////////////////////////////////////////////////////////
		////Buttons
		pridaj_h.setOnAction(e->setScene(scene_s));
		end_s.setOnAction(e->setScene(scene1));
		pridaj_s2.setOnAction(e->{if(doprava.vyhladajSpolocnost(meno_s.getText())){			
		                         }else{doprava.pridajSpolocnost(meno_s.getText(), Integer.parseInt(cislou_s.getText()));cislou_s.clear();}});
		pridajProstriedok_s.setOnAction(e->{if(doprava.vyhladajSpolocnost(meno_s.getText())){setScene(scene_p);} });
		pridaj_p.setOnAction(e->{ doprava.pridajProstriedok(comboBox.toString(), meno_p.getText(), Integer.parseInt(miesta_p.getText()),  Integer.parseInt(cena_p.getText()));});
		///Buttons
		////////////////////////////////////////////////////////////////////
	    
	    scene1 = new Scene(grid_h,600,600);
	    scene_s = new Scene(grid_s,600,600);
	    scene_p = new Scene(grid_p,600,600);
	    
	    setScene(scene1);
	    show();
	    
	}

}
