package fr.formation.afpa.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import fr.formation.afpa.service.EtudiantService;
import fr.formation.afpa.service.IEtudiantService;

// c'est la premiere fenetre avec les etudiant en liste

public class MainLancement implements Serializable{
	JButton ajout = new JButton("Ajouter un nouvel étudiant");
	JButton fermer = new JButton("Fermer");
	JList<Etudiant> ListEtudiant = new JList<>();
	List<Etudiant> etudiant = new ArrayList<>();
	private JTable table;
	private JTextField InfoDate;
	private JTextField InfoNom;
	private JTextField InfoPrénom;
	private JLabel date;
	private JLabel nom;
	private JLabel prénom;
	private JLabel id;
	JScrollPane scrollPane;
	IEtudiantService ies=new EtudiantService();

	public MainLancement() {
		JFrame jf = new JFrame();
		jf.setTitle("Etudiant");
		jf.setSize(923, 514);
		JPanel jp = new JPanel();
		jp.setBackground(SystemColor.activeCaption);
		jp.setForeground(Color.LIGHT_GRAY);
		jf.getContentPane().add(jp);
		jp.setLayout(null);
		// texte d'intro
		JTextPane bonjour = new JTextPane();
		bonjour.setBounds(92, 86, 399, 26);
		bonjour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		bonjour.setBackground(Color.GRAY);
		bonjour.setEditable(false);
		bonjour.setText("Pour modifier les informations d'un elève, cliquez sur son ID");
		jp.add(bonjour);

		// le tableau des étudiants

		table = new JTable();
		
		table.setBounds(90, 111, 679, 240);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		DefaultTableModel model = new  DefaultTableModel();
		String[] colonnes = {"ID", "Nom", "Prénom","Date de naissance", "note"};
		model.setColumnIdentifiers(colonnes);
		
		etudiant = ies.listEtudiant();
		Object[] ligne= new Object[5];
		if(etudiant.size() > 0) {
			for (int i = 0; i < etudiant.size(); i++) {
				Etudiant etudiants = etudiant.get(i); 
				ligne[0]=etudiants.getIdEtudiant();
				ligne[1]=etudiants.getNom();
				ligne[2]=etudiants.getPrénom();			
				ligne[3]=etudiants.getNaissance();
			//	ligne[4]=etudiants.getNote();
			model.addRow(ligne);
			}
		}	
	
		table.getSelectedRow();
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model);
		
		JScrollPane scrolPane = new JScrollPane(table);
		scrolPane.setBounds(92, 112, 684, 229);
		jp.add(scrolPane);
		
		// entete tableau
		JTextPane titrefn1 = new JTextPane();
		titrefn1.setBounds(92, 35, 690, 26);
		titrefn1.setText("                                                                       Liste des Etudiants");
		titrefn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		titrefn1.setEditable(false);
		titrefn1.setBackground(Color.GRAY);
		jp.add(titrefn1);

		// séparator de visibilité
		JSeparator separator = new JSeparator();
		separator.setBounds(2, 422, 903, 2);
		separator.setForeground(Color.GRAY);
		separator.setBackground(Color.GRAY);
		jp.add(separator);
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(2, 24, 903, 2);
		separator_1.setForeground(Color.GRAY);
		separator_1.setBackground(Color.GRAY);
		jp.add(separator_1);

		// le menu Jbar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 905, 26);
		menuBar.setBorderPainted(false);
		menuBar.setForeground(Color.LIGHT_GRAY);
		menuBar.setBackground(SystemColor.activeCaption);
		jp.add(menuBar);
		JMenu fichier = new JMenu("Fichier");
		menuBar.add(fichier);
		JMenuItem enregistrermenu = new JMenuItem("Enregistrer un nouvel étudiant");
		enregistrermenu.setMnemonic('e');
		fichier.add(enregistrermenu);
		JFileChooser fc = new JFileChooser();
		JMenuItem enregistrersous = new JMenuItem("enregistrer sous");
		enregistrersous.setMnemonic('s');
		fichier.add(enregistrersous);
		
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic('x');
		fichier.add(exit);
		ajout.setBounds(495, 354, 191, 58);
		ajout.setBorder(new EmptyBorder(2, 2, 2, 2));
		jp.add(ajout);
		fermer.setBounds(818, 433, 75, 25);
		jp.add(fermer);
		
		JButton EnregistrerListe = new JButton("Enregistrer ");
		EnregistrerListe.setBounds(642, 433, 140, 25);
		jp.add(EnregistrerListe);
	

		JButton modifier = new JButton("Modifier Etudiant ");
		modifier.setBounds(187, 354, 191, 58);
		jp.add(modifier);
		
		
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		////////////////////////// SECONDE
		////////////////////////// FENETRE////////////////////////////////////////////////

		JFrame jf2 = new JFrame();
		jf2.setTitle("Ajout étudiant");
		jf2.setSize(765, 370);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setSize(500, 800);
		panel.setLayout(null);
		jf2.getContentPane().add(panel);

		JLabel date = new JLabel("Date de naissance");
		date.setBounds(382, 218, 109, 16);
		panel.add(date);

		InfoDate = new JTextField();
		InfoDate.setColumns(10);
		InfoDate.setBounds(503, 215, 116, 22);
		panel.add(InfoDate);

		JLabel nom = new JLabel("Nom");
		nom.setBounds(382, 85, 26, 16);
		panel.add(nom);

		InfoNom = new JTextField();
		InfoNom.setColumns(10);
		InfoNom.setBounds(503, 82, 116, 22);
		panel.add(InfoNom);

		JLabel prénom = new JLabel("Prénom");
		prénom.setBounds(382, 150, 64, 16);
		panel.add(prénom);

		InfoPrénom = new JTextField();
		InfoPrénom.setColumns(10);
		InfoPrénom.setBounds(503, 147, 116, 22);
		panel.add(InfoPrénom);

		// bouton enregistrer

		JButton enregistrer = new JButton("Enregistrer");
		enregistrer.setBounds(503, 280, 102, 25);
		panel.add(enregistrer);
		enregistrer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nomRec = InfoNom.getText();
				String prénomRec = InfoPrénom.getText();
				String dateRec = InfoDate.getText();
				
				if (nomRec.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enregistrement impossible, merci d'entrer un Nom");
					InfoNom.setBorder(new LineBorder(Color.red, 1));
					return;
				} else if (prénomRec.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enregistrement impossible, merci d'entrer un prénom");
					return;
				} else if (dateRec.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Enregistrement impossible, merci d'entrer une date de naissance");
					return;
				} else
					model.addRow(new Object[] { (table.getRowCount()+1), nomRec, prénomRec, dateRec});
			
				List<Etudiant> etudiantliste = new ArrayList<>();
//				etudiantliste = ies.listEtudiant();
//				
//				for (int i = 0; i < etudiantliste.size()-1; i++) {
//					identifiant += 1;
//				}
				Etudiant etudiant= new Etudiant( nomRec, prénomRec, dateRec);
//				etudiantliste.add(etudiant);
				ies.ajouterEtudiant(etudiant);
			
					
					
				
				
				
				jf2.setVisible(false);
				JOptionPane.showMessageDialog(null, "L'étudiant a bien été enregistré");
				InfoNom.setText("");
				InfoPrénom.setText("");
				InfoDate.setText("");
				jf.setVisible(true);
				
			}
		});

		// bouton annuler
		JButton cancel = new JButton("Annuler");
		cancel.setBounds(637, 280, 93, 25);
		panel.add(cancel);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jf2.setVisible(false);
				jf.setVisible(true);
			}
		});

		JTextPane bienvenue = new JTextPane();
		bienvenue.setFont(new Font("Tahoma", Font.BOLD, 15));
		bienvenue.setText("Merci de cliquer sur enregistrer dès que vous avez terminé");
		bienvenue.setEditable(false);
		bienvenue.setBackground(SystemColor.inactiveCaption);
		bienvenue.setBounds(154, 13, 449, 22);
		panel.add(bienvenue);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 265, 742, 2);
		panel.add(separator_2);

		String img = "C:\\\\Users\\\\afpa\\\\Documents\\\\etudiantSwing\\\\stockage\\\\Profil.jpg";
		ImageIcon icone = new ImageIcon(img);
		JLabel jimage = new JLabel(icone, SwingConstants.LEFT);
		jimage.setBounds(28, 54, 272, 183);
		panel.add(jimage);

		JButton chPhoto = new JButton("Changer la photo");
		chPhoto.setBounds(54, 280, 174, 25);
		panel.add(chPhoto);

		jf2.setLocationRelativeTo(null);
		jf2.setVisible(false);

//////////////////		
		JFrame jf3 = new JFrame();
		jf3.setTitle("Modification étudiant");
		jf3.setSize(765, 370);
		JPanel panel3 = new JPanel();
		panel3.setBackground(SystemColor.activeCaption);
		panel3.setSize(500, 800);
		panel3.setLayout(null);
		jf3.getContentPane().add(panel3);

		JLabel date3 = new JLabel("Date de naissance");
		date3.setBounds(382, 218, 109, 16);
		panel3.add(date3);

		InfoDate = new JTextField();
		InfoDate.setColumns(10);
		InfoDate.setBounds(503, 215, 116, 22);
		panel3.add(InfoDate);

		JLabel nom3 = new JLabel("Nom");
		nom3.setBounds(382, 85, 26, 16);
		panel3.add(nom3);

		InfoNom = new JTextField();
		InfoNom.setColumns(10);
		InfoNom.setBounds(503, 82, 116, 22);
		panel3.add(InfoNom);

		JLabel prénom3 = new JLabel("Prénom");
		prénom3.setBounds(382, 150, 64, 16);
		panel3.add(prénom3);

		InfoPrénom = new JTextField();
		InfoPrénom.setColumns(10);
		InfoPrénom.setBounds(503, 147, 116, 22);
		panel3.add(InfoPrénom);

		// bouton modifier de la 3eme fenetre

		JButton modifier3 = new JButton("Modifier");
		modifier3.setBounds(503, 280, 102, 25);
		panel3.add(modifier3);
		modifier3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nomRec = InfoNom.getText();
				String prénomRec = InfoPrénom.getText();
				String dateRec = InfoDate.getText();
				int i;
				if (nomRec.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enregistrement impossible, merci d'entrer un Nom");
					InfoNom.setBorder(new LineBorder(Color.red, 1));
					return;
				} else if (prénomRec.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enregistrement impossible, merci d'entrer un prénom");
					return;
				} else if (dateRec.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Enregistrement impossible, merci d'entrer une date de naissance");
					return;
				} else
					i = table.getSelectedRow();
	               model.setValueAt(nomRec, i, 0);
	               model.setValueAt(prénomRec, i, 1);
	               model.setValueAt(dateRec, i, 2);
			
				List<Etudiant> etudiantliste = new ArrayList<>();

				Etudiant etudiant= new Etudiant( nomRec, prénomRec, dateRec);

				ies.modifierEtudiant(etudiant);
			
					
					
				
		
				jf3.setVisible(false);
				JOptionPane.showMessageDialog(null, "L'étudiant a bien été modifié");
				InfoNom.setText("");
				InfoPrénom.setText("");
				InfoDate.setText("");
				jf.setVisible(true);
				
			}
		});

		// bouton annuler
		JButton cancel3 = new JButton("Annuler");
		cancel3.setBounds(637, 280, 93, 25);
		panel3.add(cancel3);
		cancel3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jf3.setVisible(false);
				jf.setVisible(true);
			}
		});

		JTextPane bienvenue3 = new JTextPane();
		bienvenue3.setFont(new Font("Tahoma", Font.BOLD, 15));
		bienvenue3.setText("Merci de cliquer sur modifier dès que vous avez terminé");
		bienvenue3.setEditable(false);
		bienvenue3.setBackground(SystemColor.inactiveCaption);
		bienvenue3.setBounds(154, 13, 449, 22);
		panel3.add(bienvenue3);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 265, 742, 2);
		panel3.add(separator_3);

		String img3 = "C:\\\\Users\\\\afpa\\\\Documents\\\\etudiantSwing\\\\stockage\\\\Profil.jpg";
		ImageIcon icone3 = new ImageIcon(img);
		JLabel jimage3 = new JLabel(icone, SwingConstants.LEFT);
		jimage3.setBounds(28, 54, 272, 183);
		panel3.add(jimage3);

		JButton chPhoto3 = new JButton("Changer la photo");
		chPhoto3.setBounds(54, 280, 174, 25);
		panel3.add(chPhoto3);

		jf3.setLocationRelativeTo(null);
		jf3.setVisible(false);
		
///////////////////ACTION ////////////////////

//action sur le bouton ajouter fenetre 1
		ajout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				jf2.setVisible(true);
			}
		});

// action sur le bouton fermer fenetre1		
		fermer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				jf.dispose();

			}
		});
// action sur le fichier ajouter fenetre1
		enregistrermenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				jf2.setVisible(true);
			}
		});

		
// Action sur le bouton enregister de la fenetre 1	
	EnregistrerListe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			int réponse =JOptionPane.showConfirmDialog(null, "Voulez vous enregistrer la liste des etudiants ?");
			if(réponse == JOptionPane.YES_OPTION) {
				
			}
			else if (réponse==JOptionPane.NO_OPTION) {
				return;
			}
			else 
				return;
				}
		});		
		
		
// action sur le bouton exit
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
			}
		});

		// bouton pour changer la photo
		
		chPhoto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				
				int res = file.showSaveDialog(null);
				// si l'utilisateur clique sur enregistrer dans Jfilechooser
				if (res == JFileChooser.APPROVE_OPTION) {
					File selFile = file.getSelectedFile();
					//resize(selFile.getPath());
					jimage.setIcon(new ImageIcon(selFile.getAbsolutePath()));
					
				}
			}
		});
		chPhoto3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				
				int res = file.showSaveDialog(null);
				// si l'utilisateur clique sur enregistrer dans Jfilechooser
				if (res == JFileChooser.APPROVE_OPTION) {
					File selFile = file.getSelectedFile();
					//resize(selFile.getPath());
					jimage3.setIcon(new ImageIcon(selFile.getAbsolutePath()));
					
				}
			}
		});
		
		enregistrersous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int val_retour = fc.showSaveDialog(jf);

	             if (val_retour == JFileChooser.APPROVE_OPTION) {
	                File fichier = fc.getSelectedFile();
	                //afficher le chemin absolu du fichier
	                System.out.println("Chemin absolu : "+fichier.getAbsolutePath()+"\n");
	             } else {
	                  System.out.println("L'enregistrement est annulée\n");
	             }
	          }	
			
		});
		
		// pour modifier un étudiant
		
modifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					jf.setVisible(false);	
					jf3.setVisible(true);
						 
					table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
				          @Override
				          public void valueChanged(ListSelectionEvent e) {
				                int i = table.getSelectedRow();
				                InfoNom.setText((String)model.getValueAt(i, 1));
				                InfoPrénom.setText((String)model.getValueAt(i, 2));
				                InfoDate.setText((String)model.getValueAt(i, 3));
				            }
				        });
				
			}
		});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}
	

	public static void main(String[] args) {
		MainLancement fn = new MainLancement();
	}
	
	// Méthode pour redimensionner l'image avec la même taille du Jlabel
	  public ImageIcon resize(String imgPath)
	  {JLabel l = null;
	    ImageIcon path = new ImageIcon(imgPath);
	    Image img = path.getImage();
	    Image newImg = img.getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon image = new ImageIcon(newImg);
	    return image;
	  }
}
