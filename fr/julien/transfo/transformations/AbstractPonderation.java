package fr.julien.transfo.transformations;

import java.awt.Color;
import java.awt.image.BufferedImage;

public abstract class AbstractPonderation extends AbstractTransformation implements ITransformation {

	private float redRed;
	private float redGreen; 
	private float redBlue;
	private float greenRed;
	private float greenGreen; 
	private float greenBlue;
	private float blueRed;
	private float blueGreen; 
	private float blueBlue;
	
	public AbstractPonderation(float redRed, float redGreen, float redBlue,
			float greenRed, float greenGreen, float greenBlue, float blueRed,
			float blueGreen, float blueBlue) {
		this.redRed = redRed;
		this.redGreen = redGreen;
		this.redBlue = redBlue;
		this.greenRed = greenRed;
		this.greenGreen = greenGreen;
		this.greenBlue = greenBlue;
		this.blueRed = blueRed;
		this.blueGreen = blueGreen;
		this.blueBlue = blueBlue;
	}



	@Override
	public void effectuerTransformation(int i, int j, BufferedImage image,
			BufferedImage img) {
		Color c = new Color(image.getRGB(i, j));
		int outputRed = (int) Math.min(255, ((c.getRed() * redRed) + (c.getGreen() *redGreen) + (c.getBlue() * redBlue)));
		int outputGreen = (int) Math.min(255, ((c.getRed() * greenRed) + (c.getGreen() *greenGreen) + (c.getBlue() *greenBlue)));
		int outputBlue = (int) Math.min(255, ((c.getRed() * blueRed) + (c.getGreen() *blueGreen) + (c.getBlue() * blueBlue)));
		img.setRGB(i,j,new Color(outputRed, outputGreen, outputBlue).getRGB());
		
	}

}
