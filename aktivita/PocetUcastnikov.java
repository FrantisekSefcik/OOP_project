package aktivita;
import javafx.scene.control.TextField;

public class PocetUcastnikov extends TextField implements SledovatelPoctu{

	private main main;
	private int pocet;
	
	public PocetUcastnikov(main main){
		super();
		this.main=main;
	}
	
	public void upovedom() {
		pocet = main.zistiPocetU();
		setText("Pocet ucastnikov >> "+Integer.toString(pocet));
	}

}
