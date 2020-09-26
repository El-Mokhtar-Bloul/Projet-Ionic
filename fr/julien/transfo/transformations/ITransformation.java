package fr.julien.transfo.transformations;

import java.awt.image.BufferedImage;

public interface ITransformation {
	
	public BufferedImage transformer(BufferedImage image);
	public String getIdentifiant();
	public boolean isUnique();

}
