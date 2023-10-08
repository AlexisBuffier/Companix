package salarie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class Concepteur extends Salarie {

	private int nbAnneeDev;

	private static ArrayList<Concepteur> listeConcepteur = new ArrayList<Concepteur>();
	
	public Concepteur(String code, String nom, String prenom, Date dateEmbauche, int nbAnneeDev) {
		super(code, nom, prenom, dateEmbauche);
		
		this.nbAnneeDev = nbAnneeDev;
	}
	
	public static void addConcepteur(Concepteur concepteur)
	{
		listeConcepteur.add(concepteur);
	}
	
	 
	
	public static void afficherListeConcepteur()
	{
		if(listeConcepteur.size() > 0)
		{
			Collections.sort(listeConcepteur, Salarie.ComparatorCode);
			
			System.out.println("Liste de tous les concepteurs :");
			System.out.println();
			for(int i = 0; i < listeConcepteur.size(); i++)
			{
				String code 		= listeConcepteur.get(i).getCode();
				String nom 			= listeConcepteur.get(i).getNom();
				String prenom 		= listeConcepteur.get(i).getPrenom();
				Date   dateEmbauche = listeConcepteur.get(i).getDateEmbauche();
				int    nbAnneeDev 	= listeConcepteur.get(i).getNbAnneeDev();
				
				System.out.println("Code : " + code);
				System.out.println("Nom : " + nom);
				System.out.println("Prenom : " + prenom);
				System.out.println("Date d'embauche : " + dateEmbauche);
				System.out.println("Nombre d'année de dev : " + nbAnneeDev);
				System.out.println();
			}	
		}
		else
		{
			System.out.println("Liste des concepteurs vide !");
		}
	}

	public int getNbAnneeDev() {
		return nbAnneeDev;
	}

	public void setNbAnneeDev(int nbAnneeDev) {
		this.nbAnneeDev = nbAnneeDev;
	}
	
	public static ArrayList<Concepteur> getListeConcepteur() {
		return listeConcepteur;
	}

	public static void setListeConcepteur(ArrayList<Concepteur> listeConcepteur) {
		Concepteur.listeConcepteur = listeConcepteur;
	}



	
	
	
}
