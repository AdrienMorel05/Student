package fr.formation.afpa.service;

import java.util.List;

import fr.formation.afpa.dao.EtudiantDaoFile;
import fr.formation.afpa.dao.IEtudiantDao;
import fr.formation.afpa.model.Etudiant;

public class EtudiantService implements IEtudiantService  {
	private IEtudiantDao dao = new EtudiantDaoFile();
	@Override
	public List<Etudiant> listEtudiant() {
		return dao.getAll();
	}

	@Override
	public String ajouterEtudiant(Etudiant e) {
		return dao.add(e);
	}

	@Override
	public void modifierEtudiant(Etudiant e) {
		dao.update(e)	;	
	}

	@Override
	public Etudiant chercherUnEtudiantParSonId(long idEtudiant) {
		return dao.getEtudiantByid(idEtudiant);
	}

	
	

}
