package fr.julien.transfo.transformations;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public abstract class AbstractFiltre implements ITransformation {

	private float[][] masques;
	private int dimension;
	
	public AbstractFiltre(float[][] masques, int dimension){
		this.masques=masques;
		this.dimension=dimension;		
	}
	
	private BufferedImage appliquerFiltre(BufferedImage image, float[] filtre){
		Kernel kernel = new Kernel(dimension, dimension, filtre);
		ConvolveOp convo = new ConvolveOp(kernel);
		BufferedImage result=convo.filter(image, null);
		return result;
	}
	
	@Override
	public BufferedImage transformer(BufferedImage image){
		BufferedImage res=image;
		for(float[] m : masques){
			res=appliquerFiltre(res, m);
		}
		return res;
		
	}

	@Override
	public boolean isUnique() {
		return false;
	}

}
