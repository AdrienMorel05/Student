package fr.formation.afpa.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fr.formation.afpa.model.Etudiant;

public class EtudiantDaoFile implements IEtudiantDao {

	File file = new File("stockage/etudiant2.txt");
	List<Etudiant> etudiant;

	public List<Etudiant> getAll() {
		return recupEtudiant();
	}

	@Override
	public String add(Etudiant e) {
		List<Etudiant> listeEtudiant = null;
		String messageUtilisateur = null;
		System.out.println(e);
		listeEtudiant = recupEtudiant();
		if (listeEtudiant != null && listeEtudiant.size() != 0) {
			for (int i = 0; i < listeEtudiant.size(); i++) {

				if (listeEtudiant.get(i).getid() == e.getid()) {
					int id = listeEtudiant.size();
					e.setID(id + 1);
					listeEtudiant.add(e);
					if (enregistrementFile(listeEtudiant)) {
					}

					return messageUtilisateur = "enregistré";
				}

				else {
					listeEtudiant.add(e);
					if (enregistrementFile(listeEtudiant)) {
						messageUtilisateur = "Enregistement effectué";
					}

					return messageUtilisateur;

				}
			}
		} else {

			listeEtudiant = new ArrayList<>();
			listeEtudiant.add(e);
			if (enregistrementFile(listeEtudiant)) {
				messageUtilisateur = "Enregistrement effectué";
			} else

				return messageUtilisateur;

		}

		return messageUtilisateur;
	}

	
	
	
	@Override
	public void update(Etudiant e) {
		List<Etudiant> listeEtudiants = new ArrayList<Etudiant>();

		if (recupEtudiant().size() != 0) {

			listeEtudiants = recupEtudiant();

			for (int i = 0; i < listeEtudiants.size(); i++) {

				if (listeEtudiants.get(i).getid() == e.getid()) {

					listeEtudiants.remove(i);
					listeEtudiants.add(e);

				}

			}

			enregistrementFile(listeEtudiants);

		}

	}

	@Override
	public Etudiant getEtudiantByid(long idEtudiant) {
		return null;
	}

	private List<Etudiant> recupEtudiant() {

		List<Etudiant> listeEtudiants = new ArrayList<Etudiant>();
		try {

			if (file.length() != 0) {
				FileInputStream os = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(os);
				listeEtudiants = (List<Etudiant>) ois.readObject();
				ois.close();
			} else {
				return listeEtudiants;
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			return listeEtudiants;
		} catch (IOException e) {

			e.printStackTrace();
			return listeEtudiants;
		}

		return listeEtudiants;
	}

	private boolean enregistrementFile(List<Etudiant> liste) {
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(liste);
			objectOutputStream.close();
			return true;
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}

	}

}
