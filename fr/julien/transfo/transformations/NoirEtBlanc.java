package fr.julien.transfo.transformations;

import java.awt.image.BufferedImage;

public class NoirEtBlanc extends AbstractTransformation implements ITransformation {

	private static final ITransformation instance = new NoirEtBlanc();
	private int m=0;
	
	private NoirEtBlanc(){
		super();
	}
	
	@Override
	public void effectuerTransformation(int i, int j, BufferedImage image,
			BufferedImage img) {
		int rgb = image.getRGB(i,j);
		if(m==0){
			m=getRGBMoyen(image);
		}
		if(rgb<m){
			img.setRGB(i,j,-16777216);
		}
		else {
			img.setRGB(i,j,-1);
		}
		
	}
	
	private int getRGBMoyen(BufferedImage image){
		int w = image.getWidth();
		int h = image.getHeight();
		int[] rgbs = new int[w*h];
		image.getRGB(0,0,w,h,rgbs,0,w);
		int moyenne=0;
		for(int i=0; i<w*h; i++){
			moyenne+=rgbs[i]/(w*h);
		}
		return moyenne;
	}

	@Override
	public String getIdentifiant() {
		return "Noir et blanc";
	}

	@Override
	public boolean isUnique() {
		return true;
	}

	/**
	 * @return the instance
	 */
	public static ITransformation getInstance() {
		return instance;
	}

	
	
}
