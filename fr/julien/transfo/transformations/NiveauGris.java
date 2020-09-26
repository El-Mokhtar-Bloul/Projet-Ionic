package fr.julien.transfo.transformations;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class NiveauGris extends AbstractTransformation implements ITransformation {

	private static final ITransformation instance = new NiveauGris();

	private NiveauGris(){
		super();
	}
	
	@Override
	public void effectuerTransformation(int i, int j, BufferedImage image,
			BufferedImage img) {
		Color c = new Color(image.getRGB(i, j));
		int nb=(c.getRed()+c.getBlue()+c.getGreen())/3;
		img.setRGB(i,j,new Color(nb, nb, nb).getRGB());

	}


	public static ITransformation getInstance() {
		return instance;
	}

	@Override
	public String getIdentifiant() {
		return "Niveaux de gris";
	}

	@Override
	public boolean isUnique() {
		return true;
	}



}
