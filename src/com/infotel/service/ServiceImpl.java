package com.infotel.service;

import java.util.List;

import com.infotel.dao.DaoImpl;
import com.infotel.dao.Idao;
import com.infotel.metier.Formation;
import com.infotel.metier.Promo;
import com.infotel.metier.Stagiaire;

public class ServiceImpl implements Iservice {

	private Idao dao = new DaoImpl();

	@Override
	public int ajouterStagiaire(Stagiaire s) {
		return dao.ajouterStagiaire(s);
	}

	@Override
	public int supprimerStagiaire(int idStagiaire) {
		return dao.supprimerStagiaire(idStagiaire);
	}

	@Override
	public List<Stagiaire> findAllStagiaires() {
		return dao.findAllStagiaires();
	}

	@Override
	public int ajouterPromo(Promo p) {
		return dao.ajouterPromo(p);
	}

	@Override
	public int supprimerPromo(int idPromo) {
		return dao.supprimerPromo(idPromo);
	}

	@Override
	public List<Promo> findAllPromos() {
		return dao.findAllPromos();
	}

	@Override
	public int ajouterFormation(Formation f) {
		return dao.ajouterFormation(f);
	}

	@Override
	public int supprimerFormation(int idFormation) {
		return dao.supprimerFormation(idFormation);
	}

	@Override
	public List<Formation> findAllFormations() {
		return dao.findAllFormations();
	}

	@Override
	public void attribuerStagiairePromo(int idStagiaire, int idPromo) {
		dao.attribuerStagiairePromo(idStagiaire, idPromo);
	}
	
	@Override
	public void attribuerPromoFormation(int idPromo, int idFormation) {
		dao.attribuerPromoFormation(idPromo, idFormation);
	}
}
