package fr.formation.afpa.model;

import fr.formation.afpa.service.EtudiantService;

public class Etudiant extends EtudiantService{
	private String id;
	private String prénom;
	private String nom;
	private String date;

	public Etudiant() {
	}

	public Etudiant(String id, String prénom, String nom, String date) {
		this.id = id;
		this.prénom = prénom;
		this.nom = nom;
		this.date = date;
	}

	public String getID() {
		return id;
	}



	public String getPrénom() {
		return prénom;
	}

	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Etudiant [ID=" + id + ", prénom=" + prénom + ", nom=" + nom + ", date=" + date + "]";
	}


}
