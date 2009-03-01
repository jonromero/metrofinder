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
	private final Command helpCommand;
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
        exitCommand = new Command("Exit", Command.EXIT, 4);
		helpCommand = new Command("Help", Command.HELP, 3);
		aboutCommand = new Command("About", Command.SCREEN, 2);
		okCommand = new Command("OK", Command.OK, 8);
		srcCommand =  new Command("Source", Command.SCREEN, 1);
		calcCommand =  new Command("Calculate", Command.SCREEN, 4);
        nextCommand = new Command("OK", Command.SCREEN, 2);
        backCommand = new Command("Back", Command.SCREEN, 1);

        mainForm.addCommand(exitCommand);
		mainForm.addCommand(helpCommand);
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
			displayHelp();
 		else if(c == helpCommand)
			javax.microedition.lcdui.Display.getDisplay(this).setCurrent(displayAbout());

		//displayAbout();
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
		//		totalNodes.push(Algo.nodes_blue);
		//totalNodes.push(Algo.nodes_red);

		startNode = new ChoiceGroup("Select Start", ChoiceGroup.EXCLUSIVE);
		endNode =  new ChoiceGroup("Select Destination", ChoiceGroup.EXCLUSIVE);

		int i;

		for (i=0; i < Algo.nodes_green.length-1; i++){
			startNode.append(Algo.nodes_green[i], null);
			endNode.append(Algo.nodes_green[i], null);
		}

		for (i=0; i < Algo.nodes_blue.length-1; i++){
			startNode.append(Algo.nodes_blue[i], null);
			endNode.append(Algo.nodes_blue[i], null);
		}

		for (i=0; i < Algo.nodes_red.length-1; i++){
			startNode.append(Algo.nodes_red[i], null);
			endNode.append(Algo.nodes_red[i], null);
		}
	}
	public void displayHelp() {
	}

	public void processForm() {
		// process Form
	}

    private javax.microedition.lcdui.TextBox displayAbout()
    {
		txtCode = new javax.microedition.lcdui.TextBox("Lips Language System  - by Jon V\n I am ready!\n", "", 120, 0x0);
		txtCode.addCommand(exitCommand);
		txtCode.addCommand(okCommand);
		txtCode.setCommandListener(this);
		
		return txtCode;
			
	}

	private void displayMain()
	{
		StringItem infoTxt;
		StringItem infoTxt2;
		
		infoTxt = new StringItem("Welcome to MetroFinder v 1.0\n\n", "MetroFinder allows you to check how many stops you have\n and gives you a time approximation for your destination\n\n");

		infoTxt2 = new StringItem("Fast tutorial","Click menu and select a source, the a destionation and then run calculate. If you want to go again, select clear\n\n\nFor updates, check the About. Enjoy");

		mainForm.append(infoTxt);
		mainForm.append(infoTxt2);
		
		mainForm.setCommandListener(this);
		javax.microedition.lcdui.Display.getDisplay(this).setCurrent(mainForm);

	}

	private void displaySource()
	{
		Form source =  new Form("MetroFinder");
		StringItem infoTxt;
		
		infoTxt = new StringItem("Select Source",null);
		
		source.append(infoTxt);
		source.append(startNode);
		source.addCommand(nextCommand);
		source.addCommand(backCommand);
		//source.addCommand(exitCommand);

		source.setCommandListener(this);
		javax.microedition.lcdui.Display.getDisplay(this).setCurrent(source);

	}

	private void displayDestination()
	{
		Form dest =  new Form("MetroFinder");
		StringItem infoTxt;
		
		infoTxt = new StringItem("Select Destination",null);
		
		dest.append(infoTxt);
		dest.append(endNode);
		dest.addCommand(calcCommand);
		dest.addCommand(srcCommand);

		dest.setCommandListener(this);
		javax.microedition.lcdui.Display.getDisplay(this).setCurrent(dest);
	}

	private void displayCalculate()
	{
		Form result =  new Form("MetroFinder");
		StringItem infoTxt;
		//String[] results;
		Vector results;

		results = Algo.calc(startNode.getSelectedIndex(), endNode.getSelectedIndex());

		String tmp = "";
		Enumeration vEnum = results.elements();
		while(vEnum.hasMoreElements()){
			tmp += vEnum.nextElement();
		}
		
		infoTxt = new StringItem("Results\n", tmp);

		result.append(infoTxt);
		result.addCommand(backCommand);

		result.setCommandListener(this);
		javax.microedition.lcdui.Display.getDisplay(this).setCurrent(result);
	}

}
