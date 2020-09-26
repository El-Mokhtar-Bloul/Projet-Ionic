package fr.julien.transfo.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.julien.transfo.transformations.ITransformation;

public class ListenerTransformation implements ActionListener {

	private ListeTransformations transformations;
	private ITransformation transfo;
	
	/**
	 * @param transformations
	 * @param transfo
	 */
	public ListenerTransformation(ListeTransformations transformations,
			ITransformation transfo) {
		super();
		this.transformations = transformations;
		this.transfo = transfo;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		transformations.ajouterTransformation(transfo);
	}

}
