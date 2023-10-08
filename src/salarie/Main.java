package salarie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		String date = "04/10/2023";
		
		Date dateFormate = new SimpleDateFormat("dd/MM/yyyy").parse(date);	
		
		Concepteur concepteur1 = new Concepteur("01", "BUFFIER", "Alexis", dateFormate, 3);
		Concepteur concepteur2 = new Concepteur("02", "PESTANA", "Cyril", dateFormate, 10);
		
		Analyste analyste1 = new Analyste("01", "BUFFIER", "Alexis", dateFormate, 10);
		Analyste analyste2 = new Analyste("02", "PESTANA", "Cyril", dateFormate, 15);
		
		Concepteur.addConcepteur(concepteur1);
		Concepteur.addConcepteur(concepteur2);
		
		Analyste.addAnalyste(analyste1);
		Analyste.addAnalyste(analyste2);
		
		ArrayList<Concepteur> listeConcepteur = Concepteur.getListeConcepteur();
		ArrayList<Analyste> listeAnalyste = Analyste.getListeAnalyste();
		
		try (Scanner scan = new Scanner(System.in)) {
			
			int menu = -1;
			
			
			while(menu != 0)
			{
				menu();
				System.out.print("Choix : ");
				boolean valide = false;
	
			    while (!valide) {
			    	try 
			    	{
			    		menu = scan.nextInt();
			    		valide = true;
			        } 
			    	catch (InputMismatchException e) 
			    	{
			    		System.out.println("Erreur: Veuillez entrer un chiffre.");
			    		scan.next();
		            }
		        }
				
				if(menu == 1)
				{
					System.out.println("Choix du menu : Ajouter un concepteur");
					System.out.println("////////////////////////");
					System.out.println();
					
					System.out.println("Saisir le code, nom, prénom, date d’embauche et nombre d’année de développement : ");
					
					System.out.print("Code : ");
					String code = scan.next();	
					
					while(verifCode(code, listeConcepteur))
					{
						System.out.print("Code déjà existant, saisir un nouveau code : ");
						code = scan.next();	
					}
					
					System.out.print("Nom : ");
					String nom = scan.next();
					
					System.out.print("Prenom : ");
					String prenom = scan.next();
					
					System.out.print("Date d'embauche (format : dd/mm/yyyy) : ");
					String dateEmbauche = scan.next();
					
					while(!verifFormatDate(dateEmbauche))
					{
						System.out.println("Mauvais format de date, saisisser une nouvelle date au format jour/mois/annee : ");
						dateEmbauche = scan.next();
					}
					
					Date dateEmbaucheFormate = new SimpleDateFormat("dd/MM/yyyy").parse(dateEmbauche);	
					
					System.out.print("Nombre d'année de dev : ");
					int nbAnneeDev = scan.nextInt();
					
					
					
					Concepteur concepteur = new Concepteur(code, nom, prenom, dateEmbaucheFormate, nbAnneeDev);
					
					Concepteur.addConcepteur(concepteur);
					
					
				}
				else if(menu == 2)
				{
					System.out.println("Choix du menu : Supprimer un concepteur");
					System.out.println("////////////////////////");
					System.out.println();
					
					System.out.print("Code : ");
					String code = scan.next();
					
					
					int i = 0;
					boolean found = false;

					while(i < listeConcepteur.size()) 
					{
					    if(code.equals(listeConcepteur.get(i).getCode())) 
					    {
					        listeConcepteur.remove(i);
					        System.out.println("Concepteur " + code + " supprimé");
					        System.out.println();
					        found = true;
					        break; 
					    }
					    else 
					    {
					        i++;
					    }
					}

					if(!found) {
					    System.out.println("Aucun concepteur avec ce code n'existe !");
					    System.out.println();
					}
	
				}
				else if(menu == 3)
				{
					System.out.println("Choix du menu : Lister les concepteurs existants");
					System.out.println("////////////////////////");
					System.out.println();
					
					Concepteur.afficherListeConcepteur();
				}
				else if(menu == 4)
				{
					System.out.println("Choix du menu : Ajouter un analyste");
					System.out.println("////////////////////////");
					System.out.println();
					
					System.out.println("Saisir le code, nom, prénom, date d’embauche et nombre de déplacement client : ");
					
					System.out.print("Code : ");
					String code = scan.next();	
					
						
					while(verifCode(code, listeAnalyste))
					{
						System.out.print("Code déjà existant, saisir un nouveau code : ");
						code = scan.next();	
					}
					
					System.out.print("Nom : ");
					String nom = scan.next();
					
					System.out.print("Prenom : ");
					String prenom = scan.next();
					
					System.out.print("Date d'embauche (format : dd/mm/yyyy) : ");
					String dateEmbauche = scan.next();
					
				
					while(!verifFormatDate(dateEmbauche))
					{
						System.out.println("Mauvais format de date, saisisser une nouvelle date au format jour/mois/annee : ");
						dateEmbauche = scan.next();
					}
						
					
					Date dateEmbaucheFormate = new SimpleDateFormat("dd/MM/yyyy").parse(dateEmbauche);	
					
					System.out.print("Nombre de déplacement client : ");
					int nbDeplacementClient = scan.nextInt();
					
					
					Analyste analyste = new Analyste(code, nom, prenom, dateEmbaucheFormate, nbDeplacementClient);
					
					Analyste.addAnalyste(analyste);
				}
				else if(menu == 5)
				{
					System.out.println("Choix du menu : Supprimer un analyste");
					System.out.println("////////////////////////");
					System.out.println();
					
					System.out.print("Code : ");
					String code = scan.next();
					
					
					int i = 0;
					boolean found = false;

					while(i < listeAnalyste.size()) 
					{
					    if(code.equals(listeAnalyste.get(i).getCode())) 
					    {
					        listeAnalyste.remove(i);
					        System.out.println("Analyste " + code + " supprimé");
					        System.out.println();
					        found = true;
					        break; 
					    }
					    else 
					    {
					        i++;
					    }
					}

					if(!found) {
					    System.out.println("Aucun concepteur avec ce code n'existe !");
					    System.out.println();
					}
				}
				else if(menu == 6)
				{
					System.out.println("Choix du menu : Lister les analystes existants");
					System.out.println("////////////////////////");
					System.out.println();
					
					Analyste.afficherListeAnalyste();
				}
				else if(menu == 7)
				{
					System.out.println("Choix du menu : Lister tous les salariés");
					System.out.println("////////////////////////");
					System.out.println();
					
					HashMap<Object, Object> listeSalarie = new HashMap<Object, Object>();
					
					listeSalarie.put("CONCEPTEUR", listeConcepteur);
					listeSalarie.put("ANALYSTE", listeAnalyste);
					
					for (HashMap.Entry<Object,Object> entry : listeSalarie.entrySet())
					{
						Object key = entry.getKey();
						
						if(key == "CONCEPTEUR")
						{
							Concepteur.afficherListeConcepteur();
							System.out.println("---------------");
						}
						else if(key == "ANALYSTE")
						{
							Analyste.afficherListeAnalyste();
							System.out.println("---------------");
						}
					}
				}
				else
				{
					System.out.println("Choix de menu inexistant !");
				}
			}
		}
	}

	private static void menu() {
		
		System.out.println("////////////");
		System.out.println("////MENU////");
		System.out.println("////////////");
		System.out.println("1.Ajouter un concepteur");
		System.out.println("2.Supprimer un concepteur");
		System.out.println("3.Lister les concepteurs existants");
		System.out.println("4.Ajouter un analyste");
		System.out.println("5.Supprimer un analyste");
		System.out.println("6.Lister les analystes existants");
		System.out.println("7.Lister tous les salariés");
		
	}
	
	private static boolean verifCode(String code, ArrayList<? extends Salarie> list) {
        for(Salarie salarie : list) {
            if(code.equals(salarie.getCode())) {
                return true;
            }
        }
        return false;
    }
	
	private static boolean verifFormatDate(String date)
	{	
		return date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})");	
	}
}
