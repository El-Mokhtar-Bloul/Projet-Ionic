package fr.julien.transfo.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import fr.julien.transfo.transformations.ITransformation;

public class ListeTransformations extends JPanel {

	private static final long serialVersionUID = -6043015891914443592L;
	private JTable table;
	private List<ITransformation> transformations;
	private FenetrePrincipale fp;

	public ListeTransformations(FenetrePrincipale fp){
		this.fp=fp;
		setLayout(new BorderLayout());
		transformations = new ArrayList<ITransformation>();
		Object[] entetes = new Object[]{"Transformation"};
		Object[][] data = new Object[0][entetes.length];
		table=new JTable(new DefaultTableModel(data, entetes){

			private static final long serialVersionUID = -8975221726042829454L;

			@Override
			public boolean isCellEditable(int iRowIndex, int iColumnIndex){
				return false;
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setColumnHeaderView(table.getTableHeader());
		add(scrollPane, BorderLayout.CENTER);
		scrollPane.setPreferredSize(new Dimension(150, 150));
		JPanel toolbar = new JPanel();
		JButton monter = new JButton();
		monter.setIcon(new ImageIcon(getClass().getResource("monter.png")));
		monter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0){
					int indice=table.getSelectedRow();
					if(indice>0){
						ITransformation t = transformations.get(indice);
						transformations.set(indice, transformations.get(indice-1));
						transformations.set(indice-1, t);
						DefaultTableModel model = ((DefaultTableModel)table.getModel());
						model.setValueAt(model.getValueAt(indice-1, 0), indice, 0);
						model.setValueAt(t.getIdentifiant(), indice-1, 0);
						update();
						table.getSelectionModel().addSelectionInterval(indice-1, indice-1);
					}
				}
			}
		});
		toolbar.add(monter);
		JButton descendre = new JButton();
		descendre.setIcon(new ImageIcon(getClass().getResource("descendre.png")));
		descendre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0){
					int indice=table.getSelectedRow();
					if(indice+1<table.getRowCount()){
						ITransformation t = transformations.get(indice);
						transformations.set(indice, transformations.get(indice+1));
						transformations.set(indice+1, t);
						DefaultTableModel model = ((DefaultTableModel)table.getModel());
						model.setValueAt(model.getValueAt(indice+1, 0), indice, 0);
						model.setValueAt(t.getIdentifiant(), indice+1, 0);
						update();
						table.getSelectionModel().addSelectionInterval(indice+1, indice+1);
					}
				}
				
			}
		});
		toolbar.add(descendre);
		JButton supprimer = new JButton();
		supprimer.setIcon(new ImageIcon(getClass().getResource("supprimer.png")));
		supprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0){
					supprimerTransformation(table.getSelectedRow());		
				}
			}
		});
		toolbar.add(supprimer);
		add(toolbar, BorderLayout.SOUTH);
	}

	public void ajouterTransformation(ITransformation transformation){
		boolean ok=true;
		for(ITransformation t : transformations){
			if(t.getIdentifiant().equals(transformation.getIdentifiant()) && t.isUnique()){
				ok=false;
			}
		}
		if(ok){
			transformations.add(transformation);
			((DefaultTableModel)(table.getModel())).addRow(new String[]{transformation.getIdentifiant()});
			update();
		}
		else {
			JOptionPane.showMessageDialog(null, "La transformation existe déjà", "Ajout impossible", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void supprimerTransformation(int indice){
		transformations.remove(indice);
		((DefaultTableModel)(table.getModel())).removeRow(indice);
		update();
	}

	public List<ITransformation> getTransformations() {
		return transformations;
	}

	public void update(){
		if(fp.getSource().getImage()!=null){
			fp.getResultat().setImage(fp.getSource().getImage());
			fp.getSource().repaint();
			for(ITransformation t : transformations){
				fp.getResultat().setImage(t.transformer(fp.getResultat().getImage()));
			}
		}
	}

}
