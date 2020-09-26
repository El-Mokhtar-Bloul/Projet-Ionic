package fr.julien.transfo.transformations;


public class FiltreSobel extends AbstractFiltre {

	
	private static final ITransformation instance = new FiltreSobel();
	
	private FiltreSobel(){
		super(new float[][]{new float[]{1f, 0f, -1f, 2f, 0f, -2f, 1f, 0f, -1f}, new float[]{1f, 2f, 1f, 0f, 0f, 0f, -1f, -2f, -1f}}, 3);
	}

	@Override
	public String getIdentifiant() {
		return "Sobel";
	}
	
	/**
	 * @return the instance
	 */
	public static ITransformation getInstance() {
		return instance;
}
}