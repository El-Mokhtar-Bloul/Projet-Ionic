package fr.julien.transfo.lancement;

import javax.swing.UIManager;

import fr.julien.transfo.ihm.FenetrePrincipale;

public class Lanceur {
	
	public static void main(String[] args){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e){}
		new FenetrePrincipale();
	}

}
