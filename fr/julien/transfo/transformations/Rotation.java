package fr.julien.transfo.transformations;

import java.awt.image.BufferedImage;

public class Rotation extends AbstractTransformation implements ITransformation {
	
	private static final ITransformation instance = new Rotation();
	
	private Rotation(){
		super();
	}

	@Override
	public void effectuerTransformation(int i, int j, BufferedImage image,
			BufferedImage img) {		
	}
	
	@Override
	public BufferedImage transformer(BufferedImage image){
		int w = image.getWidth();
		int h = image.getHeight();
		BufferedImage img = new BufferedImage(h,w,BufferedImage.TYPE_INT_RGB);
		int[] r = new int[w*h];
		image.getRGB(0,0,w,h,r,0,w);
		img.getRaster().setDataElements(0, 0, h, w, r);
		for(int i=0; i<w; i++){
			for(int j=0; j<h; j++){
				img.setRGB(j,i,image.getRGB(i, j));
			}
		}
		return img;
	}


	@Override
	public String getIdentifiant() {
		return "Rotation";
	}

	@Override
	public boolean isUnique() {
		return false;
	}

	public static ITransformation getInstance() {
		return instance;
	}

}
