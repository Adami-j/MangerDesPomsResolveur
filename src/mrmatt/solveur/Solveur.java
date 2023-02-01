package mrmatt.solveur;

import mrmatt.solveur.structures.DictionnaireChaine;
import mrmatt.solveur.structures.ListeChainee;
import mrmatt.solveur.structures.ListeTableau;
import mrmatt.sources.Niveau;

public class Solveur {

private static ListeTableau<Noeud> noeudTraiter;
private static ListeTableau<Noeud> noeudATraiter;
private static DictionnaireChaine<String,Noeud> dictionnaireChaineNoeudTraiter;
private static ListeChainee<String> listeDesSolutions;
	public static String trouverSolution(Niveau niveau) {
		dictionnaireChaineNoeudTraiter = new DictionnaireChaine<String,Noeud>();
		Noeud noeud = new Noeud(dictionnaireChaineNoeudTraiter,"",niveau);
		listeDesSolutions = new ListeChainee<String>();
		noeudTraiter = new ListeTableau<Noeud>();
		noeudATraiter = new ListeTableau<Noeud>();
		noeudATraiter.ajouter(noeud);
		String solution = null;
		while(!noeudATraiter.estVide()){

			Noeud noeud1 = noeudATraiter.element(0);
			noeudTraiter.ajouter(noeud1);
			noeudATraiter.enlever(0);
			solution = noeud1.calculerFils();
			if(solution != null){
				listeDesSolutions.ajouter(solution);
			}else{
				ListeTableau<Noeud> listeFils = noeud1.getListeFils();
				for(int i = 0; i < listeFils.taille(); i++){
					Noeud noeud2 = listeFils.element(i);

					if(!noeudTraiter.contient(noeud2) && !noeudATraiter.contient(noeud2)&& !noeud2.isVisite()){
						noeudATraiter.ajouter(noeud2);

					}

				}

			}

		}

		return listeDesSolutions.getMaillon(0).getDonnee();
	}
	
	public static void main(String[] args) {
		String solution = trouverSolution(new Niveau("src/niveaux/1rocher.txt"));
		if (solution == null) {
			System.out.println("Pas de solution.");
		} else {
			System.out.println("Une solution est : " + solution+"\n");
			System.out.println("Voici toutes les solutions :");
			for(int i = 0; i < listeDesSolutions.taille(); i++){
				System.out.println("      Solution "+i+" : "+listeDesSolutions.getMaillon(i).getDonnee());
			}
		}
	}

}
