package fr.julien.transfo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class EnregistrementImageService {
	
	private static final EnregistrementImageService instance = new EnregistrementImageService();
	
	private EnregistrementImageService(){
		super();
	}
	
	public void enregistrer(BufferedImage image){
		JFileChooser f = new JFileChooser();
		f.setDialogTitle("Enregistrement de l'image");
		f.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Image jpg";
			}

			@Override
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().toLowerCase().endsWith(".jpg");
			}
		});
		if(f.showSaveDialog(null)==0){
			try {
				String path = f.getSelectedFile().getPath();
				if(!path.toLowerCase().endsWith(".jpg")){
					path=path+".jpg";
				}
				String[] mots = path.split("\\.");
				ImageIO.write(image, mots[mots.length-1], new File(path));
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static EnregistrementImageService getInstance() {
		return instance;
	}
	
}
