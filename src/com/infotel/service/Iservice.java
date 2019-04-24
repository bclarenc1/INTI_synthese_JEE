package com.infotel.service;

import java.util.List;

import com.infotel.metier.Formation;
import com.infotel.metier.Promo;
import com.infotel.metier.Stagiaire;

public interface Iservice {

	public int ajouterStagiaire(Stagiaire s);
	public int supprimerStagiaire(int idStagiaire);
	public List<Stagiaire> findAllStagiaires();

	public int ajouterPromo(Promo p);
	public int supprimerPromo(int idPromo);
	public List<Promo> findAllPromos();

	public int ajouterFormation(Formation f);
	public int supprimerFormation(int idFormation);
	public List<Formation> findAllFormations();
	
	public void attribuerStagiairePromo(int idStagiaire, int idPromo);
	public void attribuerPromoFormation(int idPromo, int idFormation);

}
