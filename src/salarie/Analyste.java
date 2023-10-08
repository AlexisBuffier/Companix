package salarie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Analyste extends Salarie {

	private int nbDeplacementClient;
	
	private static ArrayList<Analyste> listeAnalyste = new ArrayList<Analyste>();

	public Analyste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Analyste(String code, String nom, String prenom, Date dateEmbauche, int nbDeplacementClient) {
		super(code, nom, prenom, dateEmbauche);

		this.nbDeplacementClient = nbDeplacementClient;
	}
	
	public static void afficherListeAnalyste()
	{
		if(listeAnalyste.size() > 0)
		{
			Collections.sort(listeAnalyste, Salarie.ComparatorCode);
			
			System.out.println("Liste de tous les analystes :");
			System.out.println();
			for(int i = 0; i < listeAnalyste.size(); i++)
			{
				String code 		= listeAnalyste.get(i).getCode();
				String nom 			= listeAnalyste.get(i).getNom();
				String prenom 		= listeAnalyste.get(i).getPrenom();
				Date   dateEmbauche = listeAnalyste.get(i).getDateEmbauche();
				int    nbDeplacementClient 	= listeAnalyste.get(i).getNbDeplacementClient();
				
				System.out.println("Code : " + code);
				System.out.println("Nom : " + nom);
				System.out.println("Prenom : " + prenom);
				System.out.println("Date d'embauche : " + dateEmbauche);
				System.out.println("Nombre de déplacement client : " + nbDeplacementClient);
				System.out.println();
			}
		}
		else
		{
			System.out.println("Liste des analystes vide !");
		}
		
		
	}
	
	public static void addAnalyste(Analyste analyste)
	{
		listeAnalyste.add(analyste);
	}
	
	public static boolean verifCodeAnalyste(String code)
	{
		for(int i = 0; i < listeAnalyste.size(); i++)
		{	
			if(code.equals(listeAnalyste.get(i).getCode()))
			{
				return true;
			}
		}
		return false;
	}

	public int getNbDeplacementClient() {
		return nbDeplacementClient;
	}

	public void setNbDeplacementClient(int nbDeplacementClient) {
		this.nbDeplacementClient = nbDeplacementClient;
	}

	public static ArrayList<Analyste> getListeAnalyste() {
		return listeAnalyste;
	}

	public static void setListeAnalyste(ArrayList<Analyste> listeAnalyste) {
		Analyste.listeAnalyste = listeAnalyste;
	}
	
	
	
	
}
