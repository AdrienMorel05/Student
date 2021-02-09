package fr.formation.afpa.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import fr.formation.afpa.dao.EtudiantDaoFile;
import fr.formation.afpa.dao.IEtudiantDao;
import fr.formation.afpa.model.Etudiant;

public class EtudiantService implements IEtudiantService  {

	private String id, prénom, nom, date;
	
	private IEtudiantDao dao = new EtudiantDaoFile();
	
	public List<Etudiant> listEtudiant() {
		//on récupère les informations mise dans le fichier grace à ajouterEtudiant
		File file= new File("Etudiant.txt");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			
	//maintenant qu'on lit les données du fichier il faut les récupere et les mettre dans une Arraylist

			String line= br.readLine();
			List<String> list =new ArrayList<String>();
			while(line != null); 
			list.add(br.readLine());
		
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		
		
		return dao.getAll();
	}
	public Etudiant modifierEtudiant(Etudiant e) {
		//il faut arriver sur la page ajouter avec toutes les mentions de l'étudiant affiché
		return dao.update(e);
	}

	public void ajouterEtudiant(Etudiant e) {
		//on récupere les infos rentré dans la fenetre ajouterSwing et on les integres à un fichier
		
	}


}
