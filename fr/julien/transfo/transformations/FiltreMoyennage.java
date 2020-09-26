package fr.julien.transfo.transformations;



public class FiltreMoyennage extends AbstractFiltre {


	private static final ITransformation instance = new FiltreMoyennage();

	private FiltreMoyennage(){
		super(new float[][]{ { 1/9f, 1/9f, 1/9f, 1/9f, 1/9f, 1/9f, 1/9f, 1/9f, 1/9f}}, 3);
	}

	@Override
	public String getIdentifiant() {
		return "Moyenner";
	}

	/**
	 * @return the instance
	 */
	public static ITransformation getInstance() {
		return instance;
	}
}