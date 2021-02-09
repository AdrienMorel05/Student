package fr.formation.afpa.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

// c'est la premiere fenetre avec les etudiant en liste

public class MainLancement {
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
		bonjour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		bonjour.setBounds(92, 86, 399, 26);
		bonjour.setBackground(Color.GRAY);
		bonjour.setEditable(false);
		bonjour.setText("Pour modifier les informations d'un elève, cliquez sur son ID");
		jp.add(bonjour);

		// le tableau des étudiants
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		table.setAutoCreateRowSorter(true);
		table.setBackground(SystemColor.controlHighlight);
		table.setEnabled(false);
		table.setBounds(92, 112, 690, 228);
		table.setForeground(Color.GRAY);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nom", "Pr\u00E9nom", "Date"},
				{"1", "Morel", "Adrien", "05/05/1992 "},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Nom", "Pr\u00E9nom", "Date"
			}
		));
		table.setAutoscrolls(true);
		table.getAutoscrolls();
		
		JTextPane titrefn1 = new JTextPane();
		titrefn1.setText("                                                                       Liste des Etudiants");
		titrefn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		titrefn1.setEditable(false);
		titrefn1.setBackground(Color.GRAY);
		titrefn1.setBounds(92, 35, 690, 26);
		jp.add(titrefn1);
		jp.add(table);

		table.setSurrendersFocusOnKeystroke(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);

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
		menuBar.setBorderPainted(false);
		menuBar.setForeground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 905, 26);
		menuBar.setBackground(SystemColor.activeCaption);
		jp.add(menuBar);
		JMenu fichier = new JMenu("Fichier");
		menuBar.add(fichier);
		JMenuItem enregistrermenu = new JMenuItem("Enregistrer un nouvel étudiant");
		enregistrermenu.setMnemonic('e');
		fichier.add(enregistrermenu);

		JMenuItem afficher = new JMenuItem("Afficher la liste des étudiants");
		afficher.setMnemonic('a');
		fichier.add(afficher);
		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic('x');
		fichier.add(exit);
		ajout.setBorder(new EmptyBorder(2, 2, 2, 2));
		ajout.setBounds(338, 353, 191, 58);
		jp.add(ajout);
		fermer.setBounds(818, 433, 75, 25);
		jp.add(fermer);

		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		////////////////////////// SECONDE
		////////////////////////// FENETRE////////////////////////////////////////////////

		JFrame jf2 = new JFrame();
		jf2.setTitle("Ajout ou modification étudiant");
		jf2.setSize(765, 370);
		JPanel panel = new JPanel();
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
		prénom.setBounds(382, 150, 44, 16);
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
				List<String> etudiant = new ArrayList<>();
				
				etudiant.add(nomRec);
				etudiant.add(prénomRec);
				etudiant.add(dateRec);
				String EtudiantToString = etudiant.toString();
				FileWriter file;
				try {
					file = new FileWriter("Etudiant.txt");
					BufferedWriter bf = new BufferedWriter(file);
					bf.write(EtudiantToString);
					bf.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				System.out.println(EtudiantToString);
				jf2.setVisible(false);
				JOptionPane.showMessageDialog(null, "L'étudiant a bien été enregistré");
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
		bienvenue.setBackground(Color.LIGHT_GRAY);
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
		chPhoto.setBounds(61, 280, 174, 25);
		panel.add(chPhoto);

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
//					
					jimage.setIcon(new ImageIcon(selFile.getAbsolutePath()));
				}
			}
		});

		jf2.setVisible(false);

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
		
// action sur le bouton exit
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
			}
		});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}

	public static void main(String[] args) {
		MainLancement fn = new MainLancement();
	}
}
