package mrmatt.solveur;

import mrmatt.sources.Niveau;

public class Solveur {

	public static String trouverSolution(Niveau niveau) {
		return null;
	}
	
	public static void main(String[] args) {
		String solution = trouverSolution(new Niveau("niveaux/1rocher.txt"));
		if (solution == null) {
			System.out.println("Pas de solution.");
		} else {
			System.out.println("Une solution est : " + solution);
		}
	}

}
