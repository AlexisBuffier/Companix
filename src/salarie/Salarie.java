package salarie;

import java.util.Comparator;
import java.util.Date;

public class Salarie {
	private String code;
	private String nom;
	private String prenom;
	private Date dateEmbauche;
	
	public Salarie() {
		// TODO Auto-generated constructor stub
	}
	
	public Salarie(String code, String nom, String prenom, Date dateEmbauche) {
		this.setCode(code);
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
	}
	
	public static Comparator<Salarie> ComparatorCode = new Comparator<Salarie>() 
	 {
		 @Override
		 public int compare(Salarie s1, Salarie s2) 
		 {
			 return s1.getCode().compareTo(s2.getCode());
		 }
	 };

	//// GETTER ////
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	
	public String getCode() {
		return code;
	}
	
	//// SETTER ////

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
	
	
}
