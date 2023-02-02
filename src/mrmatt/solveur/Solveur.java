package mrmatt.solveur;

import mrmatt.solveur.structures.DictionnaireChaine;
import mrmatt.solveur.structures.ListeChainee;
import mrmatt.solveur.structures.ListeTableau;
import mrmatt.sources.Niveau;

public class Solveur {

	/**
	 * @author Julien ADAMI
	 * déclaration des paramètres listes/dico nécessaires à la fonction trouver solution
	 * tous les param sont en statique pour pouvoir être utilisés dans la fonction elle même statique
	 */
	private static ListeTableau<Noeud> noeudTraiter;
private static ListeTableau<Noeud> noeudATraiter;
private static DictionnaireChaine<String,Noeud> dictionnaireChaineNoeudTraiter;
private static ListeChainee<String> listeDesSolutions;

	/**
	 * @author Julien ADAMI
	 * @param niveau
	 * @return
	 */
	public static String trouverSolution(Niveau niveau) {
		Solveur.dictionnaireChaineNoeudTraiter = new DictionnaireChaine<String,Noeud>();
		Noeud noeud = new Noeud(dictionnaireChaineNoeudTraiter,"",niveau);
		Solveur.listeDesSolutions = new ListeChainee<String>();
		Solveur.noeudTraiter = new ListeTableau<Noeud>();
		Solveur.noeudATraiter = new ListeTableau<Noeud>();
		Solveur.noeudATraiter.ajouter(noeud);
		String solution = null;
		while(!Solveur.noeudATraiter.estVide()){

			Noeud noeud1 = noeudATraiter.element(0);
			Solveur.noeudTraiter.ajouter(noeud1);
			Solveur.noeudATraiter.enlever(0);
			solution = noeud1.calculerFils();
			if(solution != null){
				Solveur.listeDesSolutions.ajouter(solution);
			}else{
				ListeTableau<Noeud> listeFils = noeud1.getListeFils();
				for(int i = 0; i < listeFils.taille(); i++){
					Noeud noeud2 = listeFils.element(i);

					if(!Solveur.noeudTraiter.contient(noeud2) && !Solveur.noeudATraiter.contient(noeud2)&& !noeud2.isVisite()){
						Solveur.noeudATraiter.ajouter(noeud2);

					}

				}

			}

		}

		return Solveur.listeDesSolutions.getMaillon(0).getDonnee();
	}

	/**
	 * @author Julien ADAMI
	 * @param args
	 * affichage des solutions en utilisant trouverSolution
	 */
	public static void main(String[] args) {
		String solution = trouverSolution(new Niveau("src/niveaux/1rocher.txt"));
		if (solution == null) {
			System.out.println("Pas de solution.");
		} else {
			System.out.println("Une solution est : " + solution+"\n");
			System.out.println("Voici toutes les solutions :");
			for(int i = 0; i < Solveur.listeDesSolutions.taille(); i++){
				System.out.println("      Solution "+(i+1)+" : "+Solveur.listeDesSolutions.getMaillon(i).getDonnee());
			}

		}
	}

}
