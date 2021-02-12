package fr.formation.afpa.dao;

import java.util.List;

import fr.formation.afpa.model.Etudiant;

public interface IEtudiantDao {
	
	public List<Etudiant> getAll();
	
	public String add(Etudiant e);
	
	public void update(Etudiant e);

	public Etudiant getEtudiantByid(long idEtudiant);
}
