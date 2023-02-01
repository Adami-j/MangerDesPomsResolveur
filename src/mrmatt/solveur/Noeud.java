package mrmatt.solveur;

import mrmatt.solveur.structures.DictionnaireChaine;
import mrmatt.solveur.structures.ListeTableau;
import mrmatt.sources.Commande;
import mrmatt.sources.Niveau;



public class Noeud {

    private DictionnaireChaine<String, Noeud> dictionnaireChaine;
    private  Niveau niveauActuel;

    private ListeTableau<Noeud> listeFils;

    private String commandes;
    private boolean visite;

    public Noeud(DictionnaireChaine<String, Noeud> dictionnaireChaine, String commandes, Niveau niveauActuel) {
        this.dictionnaireChaine = dictionnaireChaine;
        this.commandes = commandes;
        this.niveauActuel = niveauActuel;
        this.listeFils = new ListeTableau<Noeud>();
        this.visite = false;
    }

    public boolean isVisite() {
        return visite;
    }

    public DictionnaireChaine<String, Noeud> getDictionnaireChaine() {
        return dictionnaireChaine;
    }

    public String getCommandes() {
        return commandes;
    }

    public Niveau getNiveauActuel() {
        return niveauActuel;
    }

    public void setDictionnaireChaine(DictionnaireChaine<String, Noeud> dictionnaireChaine) {
        this.dictionnaireChaine = dictionnaireChaine;
    }

    public ListeTableau<Noeud> getListeFils() {
        return listeFils;
    }

    /**
     * @author Julien ADAMI
     * @return la solution si elle existe, null sinon
     * algo de base : parcours le noeud et on regarde pour chaque commande si elle est possible
     * si oui on la fait et on regarde si on à gagné, si oui on retourne la solution si elle n'existe pas
     *A la fin avant de retourner la solution, on ajoute le noeud dans le dictionnaire avec la commande associée
     */
    public String calculerFils(){
        String solution = null;
        String commandes = this.commandes;
        Niveau niveauActuel = this.niveauActuel;
        DictionnaireChaine<String, Noeud> dictionnaireChaine = this.dictionnaireChaine;
        this.visite = true;

        // autre solution, faire une enumération des commandes
        for(int i = 0; i < 4; i++){
             solution = null;
            Niveau nouveauNiveau = niveauActuel.copier();
            String commande = "";
            switch (i){
                case 0:
                    if(nouveauNiveau.deplacementPossible(Commande.HAUT) && nouveauNiveau.enCours()){
                        nouveauNiveau.deplacer(Commande.HAUT);
                        commande = "H";
                    }

                    break;
                case 1:

                    if(nouveauNiveau.deplacementPossible(Commande.BAS) && nouveauNiveau.enCours()){
                        nouveauNiveau.deplacer(Commande.BAS);
                        commande = "B";
                    }
                    break;
                case 2:
                    if(nouveauNiveau.deplacementPossible(Commande.GAUCHE) && nouveauNiveau.enCours()){
                        nouveauNiveau.deplacer(Commande.GAUCHE);
                        commande = "G";
                    }
                    break;
                case 3:
                    if(nouveauNiveau.deplacementPossible(Commande.DROITE) && nouveauNiveau.enCours()){
                        nouveauNiveau.deplacer(Commande.DROITE);
                        commande = "D";
                    }
                    break;
            }
            // on calcule l'état du nouveau niveau après avoir jouer la commande
            nouveauNiveau.calcule();

            if(nouveauNiveau.estGagnant()){
               solution = commandes+commande;
            }else {
                Noeud noeud;
                if (this.getDictionnaireChaine().contient(nouveauNiveau.valeurChaine())) {
                    noeud = this.getDictionnaireChaine().valeur(nouveauNiveau.valeurChaine());
                } else {
                    noeud = new Noeud(this.getDictionnaireChaine(), this.getCommandes() + commande, nouveauNiveau);
                    this.getDictionnaireChaine().inserer(nouveauNiveau.valeurChaine(), noeud);
                    noeud.setDictionnaireChaine(dictionnaireChaine);
                }
                this.getListeFils().ajouter(noeud);
            }
        }
        return solution;
    }

}
