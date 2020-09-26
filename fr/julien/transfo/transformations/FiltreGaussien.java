package fr.julien.transfo.transformations;



public class FiltreGaussien extends AbstractFiltre {


	private static final ITransformation instance = new FiltreGaussien();

	private FiltreGaussien(){
		super(new float[][]{ { 4/1344f, 18/1344f, 19/1344f, 18/1344f, 4/1344f, 18/1344f, 80/1344f, 132/1344f, 80/1344f, 18/1344f, 29/1344f, 132/1344f, 218/1344f, 132/1344f, 29/1344f, 18/1344f, 80/1344f, 132/1344f, 80/1344f, 18/1344f, 4/1344f, 18/1344f, 29/1344f, 18/1344f, 4/1344f}}, 5);
	}

	@Override
	public String getIdentifiant() {
		return "Gaussien";
	}

	/**
	 * @return the instance
	 */
	public static ITransformation getInstance() {
		return instance;
	}
}