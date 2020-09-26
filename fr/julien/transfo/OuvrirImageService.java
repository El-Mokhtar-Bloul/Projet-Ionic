package fr.julien.transfo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import fr.julien.transfo.ihm.FenetrePrincipale;

public class OuvrirImageService {
	
	private static final OuvrirImageService instance = new OuvrirImageService();
	
	private OuvrirImageService(){
		super();
	}

	
	public void chargerImage(FenetrePrincipale fp){
		JFileChooser f = new JFileChooser();
		f.setDialogTitle("Choisir une image");
		f.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "Image jpg";
			}
			@Override
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().toLowerCase().endsWith(".jpg") || f.getName().toLowerCase().endsWith(".png");
			}
		});
		if(f.showSaveDialog(null)==0){
			try {
				BufferedImage image = ImageIO.read(f.getSelectedFile());
				fp.setImage(image);
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
	
	public static OuvrirImageService getInstance() {
		return instance;
	}

	
}
