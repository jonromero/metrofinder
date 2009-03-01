
/** 
 * 
 * Algorithm that finds how many nodes we are away
 * This is very bad. Need HUGE code refactoring
 * This is to be done again in Lisp
 * 
 * @author Jon Vlachoyiannis (jon@emotionull.com)
 * Under GPL
 * 01/03/2009
 */

package Algorithm;
import java.util.*;

public class Algorithm {
    public final String nodes_green[] = {"Peiraias", "Falhro", "Mosxato", "Tauros", "Petralona", "Thiseio", "Monasthraki", "Omonoia", "Panepistimio", "Viktoria", "Attikh", "Agios Nikolaos", "Katw Pathsia", "Agios Eleu8erios", "Perissos", "Peukakia", "Nea Ionia", "Irakleio", "Eirhnh", "Neratziotisa", "Marousi", "KAT", "Khfisia"};
    
	public final String nodes_blue[] = {"Aigalew", "Elaiwnas", "Keramaikos", "Monastiraki", "Syntagma", "Euagelismos", "Abelokhpoi", "Panormou", "Katexakh", "E8nikh Amuna", "Xalandri", "Doukisshs Plakentias", "???", "Painia-Kantza", "Korwpi"};
    
	public final String nodes_red[] = {"Agios Dhmitrios", "Dafnh", "Agios Ioannis", "Neos Kosmos", "Suggrou-Fix", "Akropolh", "Sudagma", "Panepisthmio", "Omonoia", "Metaxourgio", "Sta8mos Larisshs", "Attikh", "Sepolia", "Agios Adwnios"};

	public Algorithm() {

	}

	public Vector calc(int src, int dest) {
		int node_start = 0;
		int node_color_start = 0;
		int node_end = 0;
		int node_color_end = 0;

		int n = 0;
		int n1 = 0;
		int n2 = 0;

		Vector results = new Vector();

		final int nd_intsec_green_blue = 6;
		final int nd_intsec_blue_green = 3;
		final int nd_intsec_red_blue = 6;
		final int nd_intsec_blue_red = 4;
		final int nd_intsec_red_green = 8;
		final int nd_intsec_green_red = 8;

		if (src < nodes_green.length){
			node_color_start = 0;
			node_start = src;
		}
		
		else if (src < nodes_blue.length) {
			node_color_start = 1;
			node_start = src - nodes_green.length - 1;
		}
		
		else if (src < nodes_red.length) {
			node_color_start = 2;
			node_start = src - nodes_green.length - 1 - nodes_blue.length -1;

		}

		if (dest < nodes_green.length){
			node_color_end = 0;
			node_end = dest;
		}
		
		else if (dest < nodes_blue.length) {
			node_color_end = 1;
			node_end = dest - nodes_green.length - 1;
		}
		
		else if (dest < nodes_red.length) {
			node_color_end = 2;
			node_end = dest - nodes_green.length - 1 - nodes_blue.length -1;

		}


		// Algorithm
		if (node_color_start == node_color_end) {
			n = calcTotalNodes(node_start, node_end);
		}

		// Green / Blue
		else if (node_color_start == 0 && node_color_end == 1) {
			n1 = calcTotalNodes(node_start, nd_intsec_green_blue);
			n2 = calcTotalNodes(nd_intsec_blue_green, node_end);
			n = math_abs(n1) + math_abs(n2);
		}

		// Blue / Green
		else if (node_color_start == 1 && node_color_end == 0) {
			n1 = calcTotalNodes(node_start, nd_intsec_blue_green);
			n2 = calcTotalNodes(nd_intsec_green_blue, node_end);
			n = math_abs(n1) + math_abs(n2);
		}

		// Green / Red
		else if (node_color_start == 0 && node_color_end == 2) {
			n1 = calcTotalNodes(node_start, nd_intsec_green_red);
			n2 = calcTotalNodes(nd_intsec_red_green, node_end);
			n = math_abs(n1) + math_abs(n2);
		}

		// Red / Green
		else if (node_color_start == 2 && node_color_end == 0) {
			n1 = calcTotalNodes(node_start, nd_intsec_red_green);
			n2 = calcTotalNodes(nd_intsec_green_red, node_end);
			n = math_abs(n1) + math_abs(n2);
		}


		// Blue / Red
		else if (node_color_start == 1 && node_color_end == 2) {
			n1 = calcTotalNodes(node_start, nd_intsec_blue_red);
			n2 = calcTotalNodes(nd_intsec_red_blue, node_end);
			n = math_abs(n1) + math_abs(n2);
		}


		// Red / Blue
		else if (node_color_start == 2 && node_color_end == 1) {
			n1 = calcTotalNodes(node_start, nd_intsec_red_blue);
			n2 = calcTotalNodes(nd_intsec_blue_red, node_end);
			n = math_abs(n1) + math_abs(n2);
		}


		// I miss Python's multiple returning system :(
		// and I refuse to create a struct :D

		results.addElement("Total nodes to change:" + String.valueOf(n));
		results.addElement("Move " + String.valueOf(n1) + " until ");
		results.addElement("and then " + String.valueOf(n2) + " until ");

		for (int i=0; i < node_start; i++)
			results.addElement("Node" + nodes_green[i] + ": X minutes");
		

		return results;
	}


	private int calcTotalNodes(int nd_st, int nd_en) {
		return nd_en - nd_st;
	}

	// So we don't need CLDC 1.1
	private int math_abs(int num) {
		if (num >= 0)
			return num;
		else
			return num*(-1);
	}

}