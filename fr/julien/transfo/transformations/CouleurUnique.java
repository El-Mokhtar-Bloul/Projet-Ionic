package fr.julien.transfo.transformations;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class CouleurUnique extends AbstractTransformation implements ITransformation {

	private Color couleurDominante;
	private int marge=30000;

	public CouleurUnique(Color couleurDominante) {
		this.couleurDominante = couleurDominante;
	}

	@Override
	public void effectuerTransformation(int i, int j, BufferedImage image,
			BufferedImage img) {
		Color c = new Color(image.getRGB(i, j));
		int dis=(int) Math.pow(c.getRed()-couleurDominante.getRed(), 2) 
		+ (int) Math.pow(c.getBlue()-couleurDominante.getBlue(), 2) 
		+ (int) Math.pow(c.getGreen()-couleurDominante.getGreen(), 2);
		int nb=(c.getRed()+c.getBlue()+c.getGreen())/3;
		if(dis<marge){
			img.setRGB(i,j,c.getRGB());
		}
		else {
			img.setRGB(i,j,new Color(nb, nb, nb).getRGB());
		}

	}

	public void setCouleurDominante(Color couleurDominante) {
		this.couleurDominante = couleurDominante;
	}

	@Override
	public String getIdentifiant() {
		return "Couleur unique "+couleurDominante.getRGB();
	}

	@Override
	public boolean isUnique() {
		return true;
	}



}
