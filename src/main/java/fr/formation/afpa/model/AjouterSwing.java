package fr.formation.afpa.model;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import java.awt.Font;

// c'est la fenetre ajouter

public class AjouterSwing {
	private JTextField InfoPrénom;
	private JTextField InfoID;
	private JTextField InfoDate;
	private JTextField InfoNom;
	private JLabel date;
	private JLabel nom;
	private JLabel prénom;
	private JLabel id;


	public AjouterSwing() throws IOException {

		JFrame jf = new JFrame();
		jf.setTitle("Ajout ou modification");
		jf.setSize(500, 380);

		JPanel panel = new JPanel();
		jf.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		date = new JLabel("Date de naissance");
		date.setBounds(242, 230, 74, 16);
		panel.add(date);

		InfoDate = new JTextField();
		InfoDate.setBounds(318, 227, 136, 22);
		panel.add(InfoDate);
		InfoDate.setColumns(10);

		nom = new JLabel("Nom");
		nom.setBounds(242, 123, 26, 16);
		panel.add(nom);

		InfoNom = new JTextField();
		InfoNom.setBounds(318, 120, 136, 22);
		panel.add(InfoNom);
		InfoNom.setColumns(10);

		prénom = new JLabel("Prénom");
		prénom.setBounds(242, 180, 44, 16);
		panel.add(prénom);

		InfoPrénom = new JTextField();
		InfoPrénom.setBounds(318, 177, 136, 22);
		panel.add(InfoPrénom);
		InfoPrénom.setColumns(10);

		id = new JLabel("ID");
		id.setBounds(242, 68, 20, 19);
		panel.add(id);

		InfoID = new JTextField();
		InfoID.setBounds(318, 66, 136, 22);
		panel.add(InfoID);
		InfoID.setColumns(10);

		// le bouton enregistrer va nous permmetre de récupérer les infos des champs de
		// textes
		JButton enregistrer = new JButton("Enregistrer");
		enregistrer.setBounds(259, 283, 102, 25);
		panel.add(enregistrer);
		enregistrer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String idRec = InfoID.getText();
				String nomRec = InfoNom.getText();
				String prénomRec = InfoPrénom.getText();
				String dateRec = InfoDate.getText();
				List<String> etudiant = new ArrayList<>();
				etudiant.add(idRec);
				etudiant.add(nomRec);
				etudiant.add(prénomRec);
				etudiant.add(dateRec);
				String EtudiantToString = etudiant.toString();
				FileWriter file;
				try {
					file = new FileWriter("Etudiant.txt");
				BufferedWriter bf= new BufferedWriter(file);
				bf.write(EtudiantToString);
				bf.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			System.out.println(EtudiantToString);}
		});

		// bouton annuler
		JButton cancel = new JButton("Annuler");
		cancel.setBounds(373, 283, 93, 25);
		panel.add(cancel);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
			}
		});

		// image de profil standard
		String img = "C:\\\\Users\\\\afpa\\\\Documents\\\\etudiantSwing\\\\stockage\\\\Profil.jpg";
		ImageIcon icone = new ImageIcon(img);
		JLabel jimage = new JLabel(icone,JLabel.LEFT);
		jimage.setBounds(12, 66, 213, 188);
		panel.add(jimage);
		// bouton pour changer la photo
	
		JFileChooser chPhoto = new JFileChooser("Changer la photo");
		chPhoto.setBounds(52, 283, 97, 25);
		chPhoto.setMultiSelectionEnabled(true);
		panel.add(chPhoto);
		chPhoto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chPhoto.showOpenDialog(null);
				if (chPhoto.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					jimage.setIcon(chPhoto.getIcon(chPhoto.getSelectedFile()));;
				}                                   
				
			}
		});

		
		
		
		JTextPane bienvenue = new JTextPane();
		bienvenue.setFont(new Font("Tahoma", Font.BOLD, 14));
		bienvenue.setBounds(24, 13, 421, 22);
		bienvenue.setText("Merci de cliquer sur enregistrer dès que vous avez terminé !");
		bienvenue.setEditable(false);
		bienvenue.setBackground(Color.LIGHT_GRAY);
		panel.add(bienvenue);

		
		JSeparator separator4 = new JSeparator();
		separator4.setBounds(0, 267, 480, 3);
		panel.add(separator4);
		
		
		

		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) throws IOException {
		AjouterSwing fn = new AjouterSwing();

	}
}
