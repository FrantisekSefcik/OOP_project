package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI_error extends Stage{
	
	private Scene scene1;
	private Label label1 = new Label("error!!");
	private Label label2 = new Label();
	private Button button = new Button("close");
public GUI_error(String message){
	super();
	label2.setText(message);
	
		
	VBox box= new VBox(5);
	box.setAlignment(Pos.CENTER);
	box.getChildren().add(label1);
	box.getChildren().add(label2);
	box.getChildren().add(button);
	label1.setAlignment(Pos.CENTER_LEFT);
	label1.setFont(new Font("Arial", 30));
	label2.setAlignment(Pos.CENTER);
	button.setAlignment(Pos.CENTER);
	
	button.setOnAction(e->this.close());
	
	scene1= new Scene(box,300,150);
	setScene(scene1);
	show();
	
}
}
