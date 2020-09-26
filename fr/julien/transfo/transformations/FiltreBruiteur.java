package fr.julien.transfo.transformations;



public class FiltreBruiteur extends AbstractFiltre {

	
	private static final ITransformation instance = new FiltreBruiteur();
	
	private FiltreBruiteur(){
		super(new float[][]{ { 0.0f, -1.0f, 0.0f, -1.0f, 5.0f, -1.0f, 0.0f, -1.0f, 0.0f }}, 3);
	}

	@Override
	public String getIdentifiant() {
		return "Bruiter";
	}
	
	/**
	 * @return the instance
	 */
	public static ITransformation getInstance() {
		return instance;
}
}