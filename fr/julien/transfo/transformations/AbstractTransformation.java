package fr.julien.transfo.transformations;

import java.awt.image.BufferedImage;

public abstract class AbstractTransformation implements ITransformation {
	
	@Override
	public BufferedImage transformer(BufferedImage image){
		int w = image.getWidth();
		int h = image.getHeight();
		BufferedImage img = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		int[] r = new int[w*h];
		image.getRGB(0,0,w,h,r,0,w);
		img.getRaster().setDataElements(0, 0, w, h, r);
		for(int i=0; i<w; i++){
			for(int j=0; j<h; j++){
				effectuerTransformation(i, j, image, img);
			}
		}
		return img;
	}
	
	public abstract void effectuerTransformation(int i, int j, BufferedImage image, BufferedImage img);

}
