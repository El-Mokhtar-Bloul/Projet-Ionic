package fr.julien.transfo.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.julien.transfo.EnregistrementImageService;
import fr.julien.transfo.OuvrirImageService;
import fr.julien.transfo.transformations.CouleurUnique;
import fr.julien.transfo.transformations.FiltreBruiteur;
import fr.julien.transfo.transformations.FiltreGaussien;
import fr.julien.transfo.transformations.FiltreMDIF;
import fr.julien.transfo.transformations.FiltreMoyennage;
import fr.julien.transfo.transformations.FiltrePrewitt;
import fr.julien.transfo.transformations.FiltreSobel;
import fr.julien.transfo.transformations.InversionCouleurs;
import fr.julien.transfo.transformations.NiveauGris;
import fr.julien.transfo.transformations.NiveauGrisPondere;
import fr.julien.transfo.transformations.NoirEtBlanc;
import fr.julien.transfo.transformations.Rotation;
import fr.julien.transfo.transformations.Sepia;

public class Menu extends JMenuBar {
	
	private static final long serialVersionUID = -6776748595659994783L;

	public Menu(final FenetrePrincipale fp){
		final ListeTransformations transformations=fp.getTransformations();
		
		/* Fichier */
		JMenu fichier = new JMenu("Fichier");
		fichier.setMnemonic(KeyEvent.VK_F);
		JMenuItem nouveau = new JMenuItem("Ouvrir image");
		nouveau.setMnemonic(KeyEvent.VK_N);
		nouveau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OuvrirImageService.getInstance().chargerImage(fp);				
			}
		});
		fichier.add(nouveau);
		JMenuItem enregistrer = new JMenuItem("Enregistrer");
		enregistrer.setMnemonic(KeyEvent.VK_E);
		enregistrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EnregistrementImageService.getInstance().enregistrer(fp.getResultat().getImage());
				
			}
		});
		fichier.add(enregistrer);
		fichier.addSeparator();
		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.setMnemonic(KeyEvent.VK_Q);
		quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fichier.add(quitter);
		
		/* Transformations */
		JMenu transfo = new JMenu("Transformations");
		transfo.setMnemonic(KeyEvent.VK_T);
		
		JMenu menuCouleurs = new JMenu("Couleurs");
		transfo.setMnemonic(KeyEvent.VK_C);
		
		JMenuItem noirEtBlanc = new JMenuItem("Noir et blanc");
		noirEtBlanc.setMnemonic(KeyEvent.VK_N);
		noirEtBlanc.addActionListener(new ListenerTransformation(transformations, NoirEtBlanc.getInstance()));
		menuCouleurs.add(noirEtBlanc);
		
		JMenu menuNiveauGris = new JMenu("Niveaux de gris");
		menuNiveauGris.setMnemonic(KeyEvent.VK_G);
		JMenuItem niveauGris = new JMenuItem("Normal");
		niveauGris.setMnemonic(KeyEvent.VK_N);
		niveauGris.addActionListener(new ListenerTransformation(transformations, NiveauGris.getInstance()));
		menuNiveauGris.add(niveauGris);
		JMenuItem niveauGrisPondere = new JMenuItem("Pondere");
		niveauGrisPondere.setMnemonic(KeyEvent.VK_P);
		niveauGrisPondere.addActionListener(new ListenerTransformation(transformations, NiveauGrisPondere.getInstance()));
		menuNiveauGris.add(niveauGrisPondere);
		menuCouleurs.add(menuNiveauGris);

		JMenuItem sepia = new JMenuItem("Sepia");
		sepia.setMnemonic(KeyEvent.VK_S);
		sepia.addActionListener(new ListenerTransformation(transformations, Sepia.getInstance()));
		menuCouleurs.add(sepia);
		
		JMenuItem inverser = new JMenuItem("Inverser");
		inverser.setMnemonic(KeyEvent.VK_I);
		inverser.addActionListener(new ListenerTransformation(transformations, InversionCouleurs.getInstance()));
		menuCouleurs.add(inverser);

		JMenu conserverCouleur = new JMenu("Conserver une couleur");
		final Map<String, Color> couleurs = new HashMap<String, Color>();
		couleurs.put("Rouge", Color.RED);
		couleurs.put("Orange", Color.ORANGE);
		couleurs.put("Jaune", Color.YELLOW);
		couleurs.put("Vert", Color.GREEN);
		couleurs.put("Bleu", Color.BLUE);
		couleurs.put("Indigo", new Color(47, 0, 127));
		couleurs.put("violet", new Color(127, 0, 255));

		for(final String s : couleurs.keySet()){
			JMenuItem item = new JMenuItem(s);
			item.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					transformations.ajouterTransformation(new CouleurUnique(couleurs.get(s)));					
				}
			});
			conserverCouleur.add(item);
		}
		menuCouleurs.add(conserverCouleur);
		transfo.add(menuCouleurs);
		
		JMenuItem rotation = new JMenuItem("Rotation");
		rotation.setMnemonic(KeyEvent.VK_R);
		rotation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				transformations.ajouterTransformation(Rotation.getInstance());				
			}
		});
		transfo.add(rotation);
		
		JMenu detectionContour = new JMenu("Détection du contour");
		JMenuItem sobel = new JMenuItem("Filtre de Sobel");
		sobel.setMnemonic(KeyEvent.VK_S);
		sobel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				transformations.ajouterTransformation(FiltreSobel.getInstance());				
			}
		});
		detectionContour.add(sobel);
		JMenuItem prewitt = new JMenuItem("Filtre de Prewitt");
		prewitt.setMnemonic(KeyEvent.VK_S);
		prewitt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				transformations.ajouterTransformation(FiltrePrewitt.getInstance());				
			}
		});
		detectionContour.add(prewitt);
		JMenuItem mdif = new JMenuItem("Filtre MDIF");
		mdif.setMnemonic(KeyEvent.VK_M);
		mdif.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				transformations.ajouterTransformation(FiltreMDIF.getInstance());				
			}
		});
		detectionContour.add(mdif);
		transfo.add(detectionContour);
		
		JMenu lisser = new JMenu("Lissage");
		lisser.setMnemonic(KeyEvent.VK_L);
		JMenuItem moyennage = new JMenuItem("Filtre de moyennage");
		moyennage.setMnemonic(KeyEvent.VK_M);
		moyennage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				transformations.ajouterTransformation(FiltreMoyennage.getInstance());				
			}
		});
		lisser.add(moyennage);
		JMenuItem gaussien = new JMenuItem("Filtre Gaussien");
		gaussien.setMnemonic(KeyEvent.VK_G);
		gaussien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				transformations.ajouterTransformation(FiltreGaussien.getInstance());				
			}
		});
		lisser.add(gaussien);
		transfo.add(lisser);
		
		JMenuItem bruiter = new JMenuItem("Bruiter");
		bruiter.setMnemonic(KeyEvent.VK_B);
		bruiter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				transformations.ajouterTransformation(FiltreBruiteur.getInstance());				
			}
		});
		transfo.add(bruiter);
		
		add(fichier);
		add(transfo);
	}

}
