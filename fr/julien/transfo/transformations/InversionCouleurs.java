package fr.julien.transfo.transformations;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class InversionCouleurs extends AbstractTransformation implements ITransformation {

	private static final ITransformation instance = new InversionCouleurs();
	
	private InversionCouleurs(){
		super();
	}
	
	@Override
	public void effectuerTransformation(int i, int j, BufferedImage image,
			BufferedImage img) {
		Color c = new Color(image.getRGB(i, j));
		Color nouvelle = new Color(255-c.getRed(), 255-c.getGreen(), 255-c.getBlue());
		img.setRGB(i, j, nouvelle.getRGB());
	}

	@Override
	public String getIdentifiant() {
		return "Inversion couleurs";
	}

	@Override
	public boolean isUnique() {
		return false;
	}

	/**
	 * @return the instance
	 */
	public static ITransformation getInstance() {
		return instance;
	}

}
