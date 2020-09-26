package fr.julien.transfo.transformations;


public class Sepia extends AbstractPonderation implements ITransformation {
	
	private static final ITransformation instance = new Sepia();
	
	private Sepia(){
		super(0.393f, 0.769f, 0.189f, 0.349f, 0.686f, 0.168f, 0.272f, 0.534f, 0.131f);
	}

	@Override
	public String getIdentifiant() {
		return "Sepia";
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
