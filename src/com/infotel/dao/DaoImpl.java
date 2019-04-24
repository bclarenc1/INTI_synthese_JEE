package com.infotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.infotel.metier.Formation;
import com.infotel.metier.Promo;
import com.infotel.metier.Stagiaire;

public class DaoImpl implements Idao {

	private Connection con;
	private PreparedStatement st;
	private ResultSet rs;
	
	@Override
	public int ajouterStagiaire(Stagiaire s) {
		try {
			con = GestionConnexion.getInstance();

			st = con.prepareStatement("INSERT INTO Stagiaire(nom,prenom,age,fpromo) VALUES(?,?,?,?)");
			st.setString(1,s.getNom());
			st.setString(2,s.getPrenom());
			st.setInt(3,s.getAge());
			st.setInt(4,s.getFpromo());
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error in ajouterStagiaire()");
			e.printStackTrace();
		}
		
		return s.getIdStagiaire();

	}

	@Override
	public int supprimerStagiaire(int idStagiaire) {
		try {
			con = GestionConnexion.getInstance();
			st = con.prepareStatement("DELETE FROM Stagiaire WHERE idStagiaire=?");
			st.setInt(1, idStagiaire);
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("error in supprimerStagiaire()");
			e.printStackTrace();
		}
		
		return idStagiaire;
	}

	@Override
	public List<Stagiaire> findAllStagiaires() {

		
		List<Stagiaire> list = new ArrayList<>();
		try {
			con = GestionConnexion.getInstance();
			st = con.prepareStatement("SELECT * FROM Stagiaire");
			rs = st.executeQuery(); 

			while (rs.next()) {
				Stagiaire s = new Stagiaire();
				s.setIdStagiaire(rs.getInt("idStagiaire"));
				s.setNom(rs.getString("nom"));
				s.setPrenom(rs.getString("prenom"));
				s.setAge(rs.getInt("age"));
		
				list.add(s);
			}

		} catch (Exception e) {
			System.out.println("Error in findAllStagiaires()");
		}
		
		for (Stagiaire stag : list) {
			System.out.println(stag);
		}
		return list;
	}

	@Override
	public int ajouterPromo(Promo p) {
		try {
			con = GestionConnexion.getInstance();

			st = con.prepareStatement("INSERT INTO Promo(nomPromo,effectif) VALUES(?,?)");
			st.setString(1,p.getNomPromo());
			st.setInt(2,p.getEffectif());
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error in ajouterPromo()");
			e.printStackTrace();
		}
		
		return p.getIdPromo();
	}

	@Override
	public int supprimerPromo(int idPromo) {
		try {
			con = GestionConnexion.getInstance();
			st = con.prepareStatement("DELETE FROM Promo WHERE idPromo=?");
			st.setInt(1, idPromo);
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("error in supprimerPromo()");
			e.printStackTrace();
		}
		
		return idPromo;
	}

	@Override
	public List<Promo> findAllPromos() {
		List<Promo> list = new ArrayList<>();
		try {
			con = GestionConnexion.getInstance();
			st = con.prepareStatement("SELECT * FROM Promo");
			rs = st.executeQuery(); 

			while (rs.next()) {
				Promo p = new Promo();
				p.setIdPromo(rs.getInt("idPromo"));
				p.setNomPromo(rs.getString("nomPromo"));
				p.setEffectif(Integer.parseInt(rs.getString("effectif")));
		
				list.add(p);
			}

		} catch (Exception e) {
			System.out.println("Error in findAllPromos()");
		}
		
		for (Promo prom: list) {
			System.out.println(prom);
		}
		return list;
	}

	@Override
	public int ajouterFormation(Formation f) {
		try {
			con = GestionConnexion.getInstance();

			st = con.prepareStatement("INSERT INTO Formation(nomformation) VALUES(?)");
			st.setString(1,f.getNomFormation());
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error in ajouterFormation()");
			e.printStackTrace();
		}
		
		return f.getIdFormation();

	}

	@Override
	public int supprimerFormation(int idFormation) {
		try {
			con = GestionConnexion.getInstance();
			st = con.prepareStatement("DELETE FROM Formation WHERE idFormation=?");
			st.setInt(1, idFormation);
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("error in supprimerFormation()");
			e.printStackTrace();
		}
		
		return idFormation;
		}

	@Override
	public List<Formation> findAllFormations() {
		List<Formation> list = new ArrayList<>();
		try {
			con = GestionConnexion.getInstance();
			st = con.prepareStatement("SELECT * FROM Formation");
			rs = st.executeQuery(); 

			while (rs.next()) {
				Formation f = new Formation();
				f.setIdFormation(rs.getInt("idFormation"));
				f.setNomFormation(rs.getString("nomFormation"));
		
				list.add(f);
			}

		} catch (Exception e) {
			System.out.println("Error in findAllFormations()");
		}
		
		for (Formation form : list) {
			System.out.println(form);
		}
		return list;
	}

	@Override
	public void attribuerStagiairePromo(int idStagiaire, int idPromo) {
		try {
			con = GestionConnexion.getInstance();
			st = con.prepareStatement("UPDATE Stagiaire SET fpromo=? WHERE idStagiaire=?");
			st.setInt(1, idPromo);
			st.setInt(2, idStagiaire);
			st.executeUpdate();
			System.out.printf("\nstagiaire %d ajoute a la promo %d \n", idStagiaire, idPromo);
			
		} catch (Exception e) {
			System.out.println("error during attribution");
			e.printStackTrace();
		}
	}
	
	@Override
	public void attribuerPromoFormation(int idPromo, int idFormation) {
		try {
			con = GestionConnexion.getInstance();
			st = con.prepareStatement("UPDATE Promo SET fformation=? WHERE idPromo=?");
			st.setInt(1, idFormation);
			st.setInt(2, idPromo);
			st.executeUpdate();
			System.out.printf("\nla promo %d suit desormais la formation %d\n", idPromo, idFormation);
			
		} catch (Exception e) {
			System.out.println("error during attribution");
			e.printStackTrace();
		}
	}

}
