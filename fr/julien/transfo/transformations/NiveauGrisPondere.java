package fr.julien.transfo.transformations;


public class NiveauGrisPondere extends AbstractPonderation implements ITransformation {
	
	private static final ITransformation instance = new NiveauGrisPondere();
	
	private NiveauGrisPondere(){
		super(0.299f, 0.587f, 0.114f, 0.299f, 0.587f, 0.114f, 0.299f, 0.587f, 0.114f);
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
