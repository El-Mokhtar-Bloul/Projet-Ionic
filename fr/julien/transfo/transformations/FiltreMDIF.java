package fr.julien.transfo.transformations;


public class FiltreMDIF extends AbstractFiltre {

	
	private static final ITransformation instance = new FiltreMDIF();
	
	private FiltreMDIF(){
		super(new float[][]{new float[]{0f, 1f, 0f, -1f, 0f, 1f, 2f, 0f, -2f, -1f, 1f, 3f, 0f, -3f, -1f, 1f, 2f, 0f, -2f, -1f, 0f, 1f, 0f, -1f, 0f}, new float[]{0f, 1f, 1f, 1f, 0f, 1f, 2f, 3f, 2f, 1f, 0f, 0f, 0f, 0f, 0f, -1f, -2f, -3f, -2f, -1f, 0f, -1f, -1f, -1f, 0f}}, 5);
	}

	@Override
	public String getIdentifiant() {
		return "MDIF";
	}
	
	/**
	 * @return the instance
	 */
	public static ITransformation getInstance() {
		return instance;
}
}