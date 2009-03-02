import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.ChoiceGroup;
import java.util.*;

import Algorithm.*;

// Generated class. Modify.
public final class MetroFinder extends MIDlet implements CommandListener {
    private final Command exitCommand;
    private final Command okCommand;
	private final Command srcCommand;
	private final Command calcCommand;
	private final Command nextCommand;
	private final Command backCommand;

	private final Command aboutCommand;
    private TextBox txtCode;
 
    private final Form mainForm;

	private Algorithm Algo;

	ChoiceGroup startNode;
	ChoiceGroup endNode;
	

    public MetroFinder() {
        mainForm = new Form("MetroFinder");
        exitCommand = new Command("Έξοδος", Command.EXIT, 5);
		aboutCommand = new Command("Σχετικά", Command.SCREEN, 3);
		okCommand = new Command("Προορισμός", Command.OK, 8);
		srcCommand =  new Command("Αφετηρία", Command.SCREEN, 2);
		calcCommand =  new Command("Υπολογισμός", Command.OK, 1);
        nextCommand = new Command("Προορισμός", Command.OK, 2);
        backCommand = new Command("Πίσω", Command.SCREEN, 4);

		StringItem infoTxt;
		StringItem infoTxt2;
		
		infoTxt = new StringItem("Καλώς ήρθες στο MetroFinder v 1.0\n\n", "Το MetroFinder σου δείχνει πόσες στάσεις Μετρο και Ηλεκτρικού έχεις μέχρι τον προορισμό σου, πόση ώρα και πόσες αλλαγές μεταφορικών μέσων πρέπει να κάνεις\n\n");

		infoTxt2 = new StringItem("Χρήση","Επέλεξε το <Μenu>, μετά την αφετηρία, τον προορισμό σου και επέλεξε <Υπολογισμό>. \nΓια updates, έλεγξε το <Σχετικά>.\n\nEnjoy");

		mainForm.append(infoTxt);
		mainForm.append(infoTxt2);
		
        mainForm.addCommand(exitCommand);
		mainForm.addCommand(aboutCommand);
		//mainForm.addCommand(okCommand);
		mainForm.addCommand(srcCommand);
		//		mainForm.addCommand(calcCommand);

        mainForm.setCommandListener(this);
        Display.getDisplay(this).setCurrent(mainForm);
    }
    
    protected void startApp() {
		Display display = Display.getDisplay(this);

		Algo = new Algorithm();

		initNodes();

		//		mainForm.append(startNode);
		//mainForm.append(endNode);
		//display.setCurrent(mainForm);
		displayMain();

    }
    
    protected void pauseApp() {
        // Place your code here.
    }
    
    protected void destroyApp(boolean unconditional) {
        // Place your code here.
    }
    
    public void commandAction(Command c, Displayable d) {
        if (c == exitCommand) {
            destroyApp(true);
            notifyDestroyed();
        }
		else if(c == aboutCommand)
			displayAbout();
 		else if(c == okCommand) 
			displayMain();

 		else if(c == srcCommand) 
			displaySource();

		else if(c == calcCommand) 
			displayCalculate();

		else if(c == nextCommand) 
			displayDestination();

		else if(c == backCommand) 
			displayMain();

    }

	void initNodes() {
		startNode = new ChoiceGroup("Επιλογή αφετηρίας", ChoiceGroup.EXCLUSIVE);
		endNode =  new ChoiceGroup("Επιλογή προορισμού", ChoiceGroup.EXCLUSIVE);

		int i;

		for (i=0; i < Algo.nodes_green.length; i++){
			startNode.append(Algo.nodes_green[i], null);
			endNode.append(Algo.nodes_green[i], null);
		}

		for (i=0; i < Algo.nodes_blue.length; i++){
			startNode.append(Algo.nodes_blue[i], null);
			endNode.append(Algo.nodes_blue[i], null);
		}

		for (i=0; i < Algo.nodes_red.length; i++){
			startNode.append(Algo.nodes_red[i], null);
			endNode.append(Algo.nodes_red[i], null);
		}
	}

	private void displayMain()
	{
		mainForm.setCommandListener(this);
		javax.microedition.lcdui.Display.getDisplay(this).setCurrent(mainForm);

	}

	private void displaySource()
	{
		Form source = new Form("MetroFinder");
		initNodes();
	
		source.append(startNode);
		source.addCommand(nextCommand);
		source.addCommand(backCommand);
		//source.addCommand(exitCommand);

		source.setCommandListener(this);
		javax.microedition.lcdui.Display.getDisplay(this).setCurrent(source);

	}

	private void displayDestination()
	{
		Form dest = new Form("MetroFinder");

		dest.append(endNode);
		dest.addCommand(calcCommand);
		dest.addCommand(srcCommand);

		dest.setCommandListener(this);
		javax.microedition.lcdui.Display.getDisplay(this).setCurrent(dest);
	}

	private void displayCalculate()
	{
		Form result = new Form("MetroFinder");
		StringItem infoTxt;
		//String[] results;
		Vector results;

		results = Algo.calc(startNode.getSelectedIndex(), endNode.getSelectedIndex());

		String tmp = "";
		Enumeration vEnum = results.elements();
		while(vEnum.hasMoreElements()){
			tmp += "\n" + vEnum.nextElement();
		}
		
		infoTxt = new StringItem("Διαδρομή\n", tmp);

		result.append(infoTxt);
 		result.addCommand(backCommand);

		result.setCommandListener(this);
		javax.microedition.lcdui.Display.getDisplay(this).setCurrent(result);
	}

	private void displayAbout()
	{
		Form about = new Form("MetroFinder");

		StringItem infoTxt;
		StringItem infoTxt2;
		StringItem infoTxt3;
		StringItem infoTxt4;
		StringItem infoTxt5;

		infoTxt = new StringItem("Καλώς ήρθες στο MetroFinder v 1.0\n\n", "Το MetroFinder σου δείχνει πόσες στάσεις Μετρο και Ηλεκτρικού έχεις μέχρι τον προορισμό σου, πόση ώρα και πόσες αλλαγές μεταφορικών μέσων πρέπει να κάνεις\n\n");

		infoTxt2 = new StringItem("Updates","Η τελευταία έκδοση βρίσκεται εδώ: http://github.com/jonromero/metrofinder/tree/master");
		
		infoTxt3 = new StringItem("Website\n","http://jon.is.emotionull.com");

		infoTxt4 = new StringItem("Email\n","jon@emotionull.com");

		infoTxt5 = new StringItem("από τον Γιάννη Βλαχογιάννη (2009)\n","Published under GPL 3.0");


		about.append(infoTxt);
		about.append(infoTxt2);
		about.append(infoTxt3);
		about.append(infoTxt4);
		about.append(infoTxt5);

		about.addCommand(backCommand);
		
		about.setCommandListener(this);
		javax.microedition.lcdui.Display.getDisplay(this).setCurrent(about);

	}


}
