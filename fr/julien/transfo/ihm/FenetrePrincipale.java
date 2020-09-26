package fr.julien.transfo.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = -7973524383994420294L;
	private PanelImage source;
	private PanelImage resultat;
	private ListeTransformations transformations;

	public FenetrePrincipale(){
		setLayout(new BorderLayout());
		JPanel nord = new JPanel(new BorderLayout());
		transformations = new ListeTransformations(this);
		nord.add(new Menu(this));
		add(nord, BorderLayout.NORTH);
		JPanel barreOutils = makeBarreOutils();
		add(barreOutils, BorderLayout.WEST);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		source = new PanelImage();
		source.setBorder(BorderFactory.createTitledBorder("Image source"));
		resultat = new PanelImage();
		resultat.setBorder(BorderFactory.createTitledBorder("Resultat des transformations"));
		source.setBackground(Color.red);
		resultat.setBackground(Color.blue);
		JPanel centre = new JPanel();
		centre.setBorder(BorderFactory.createEtchedBorder());
		centre.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx=2;
		c.weighty=1;
		c.insets = new Insets(10, 10, 10, 10);
		c.fill=GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=0;
		centre.add(source, c);
		c.gridx=1;
		centre.add(resultat, c);
		add(centre, BorderLayout.CENTER);
		setSize(800, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public JPanel makeBarreOutils(){
		JPanel res = new JPanel();
		res.setBorder(BorderFactory.createEtchedBorder());
		res.add(transformations);
		return res;
	}



	public void setImage(BufferedImage image){
		source.setImage(image);
		resultat.setImage(image);
		transformations.update();
	}

	/**
	 * @return the resultat
	 */
	public PanelImage getResultat() {
		return resultat;
	}

	/**
	 * @return the source
	 */
	public PanelImage getSource() {
		return source;
	}

	/**
	 * @return the transformations
	 */
	public ListeTransformations getTransformations() {
		return transformations;
	}

	


}
