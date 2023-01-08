package mrmatt.solveur;


import mrmatt.solveur.structures.DictionnaireChaine;
import mrmatt.sources.Commande;
import mrmatt.sources.Niveau;



public class Noeud {

    class Fils{

    }
    private DictionnaireChaine<Configuration,String> dictionnaireChaine;
    private  Niveau niveauActuel;

    private Noeud filsHaut;
    private Noeud filsBas;
    private Noeud filsGauch;
    private Noeud filsDroit;

    private String commandes;

    public Noeud(DictionnaireChaine<Configuration, String> dictionnaireChaine, String commandes, Niveau niveauActuel) {
        this.dictionnaireChaine = dictionnaireChaine;
        this.commandes = commandes;
        this.niveauActuel = niveauActuel;
    }

    public Niveau getNiveauActuel() {
        return niveauActuel;
    }

    public Noeud getFilsHaut() {
        return filsHaut;
    }

    public Noeud getFilsBas() {
        return filsBas;
    }

    public Noeud getFilsGauch() {
        return filsGauch;
    }

    public Noeud getFilsDroit() {
        return filsDroit;
    }

    public void calculerFils(){
        if(this.getNiveauActuel().deplacementPossible(Commande.HAUT)){
            Niveau niveauHaut = this.getNiveauActuel().copier();
            niveauHaut.deplacer(Commande.HAUT);
            this.filsHaut = new Noeud(this.dictionnaireChaine,this.commandes+"H",niveauHaut);
        }
        if(this.getNiveauActuel().deplacementPossible(Commande.BAS)){
            Niveau niveauBas = this.getNiveauActuel().copier();
            niveauBas.deplacer(Commande.BAS);
            this.filsBas = new Noeud(this.dictionnaireChaine,this.commandes+"B",niveauBas);
        }
        if(this.getNiveauActuel().deplacementPossible(Commande.GAUCHE)){
            Niveau niveauGauche = this.getNiveauActuel().copier();
            niveauGauche.deplacer(Commande.GAUCHE);
            this.filsGauch = new Noeud(this.dictionnaireChaine,this.commandes+"G",niveauGauche);
        }
        if(this.getNiveauActuel().deplacementPossible(Commande.DROITE)){
            Niveau niveauDroit = this.getNiveauActuel().copier();
            niveauDroit.deplacer(Commande.DROITE);
            this.filsDroit = new Noeud(this.dictionnaireChaine,this.commandes+"D",niveauDroit);
        }

    }


    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(o.getClass()!=this.getClass()){
            return false;
        }
        Noeud n = (Noeud) o;
        return n==this;

    }

}
