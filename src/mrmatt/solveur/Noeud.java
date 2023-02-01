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


    public String calculerFils(){
        String solution = null;
        String commandes = this.commandes;
        Niveau niveauActuel = this.niveauActuel;
        DictionnaireChaine<String, Noeud> dictionnaireChaine = this.dictionnaireChaine;
        this.visite = true;

        for(int i = 0; i < 4; i++){
             solution = null;
            Niveau niveau = niveauActuel.copier();
            String commande = "";
            switch (i){
                case 0:
                    if(niveau.deplacementPossible(Commande.HAUT) && niveau.enCours()){
                        niveau.deplacer(Commande.HAUT);
                        commande = "H";
                    }

                    break;
                case 1:

                    if(niveau.deplacementPossible(Commande.BAS) && niveau.enCours()){
                        niveau.deplacer(Commande.BAS);
                        commande = "B";
                    }
                    break;
                case 2:
                    if(niveau.deplacementPossible(Commande.GAUCHE) && niveau.enCours()){
                        niveau.deplacer(Commande.GAUCHE);
                        commande = "G";
                    }
                    break;
                case 3:
                    if(niveau.deplacementPossible(Commande.DROITE) && niveau.enCours()){
                        niveau.deplacer(Commande.DROITE);
                        commande = "D";
                    }
                    break;
            }


            niveau.calcule();
            if(niveau.estGagnant()){
               solution = commandes+commande;

            }else {

                Noeud noeud;
                if (dictionnaireChaine.contient(niveau.valeurChaine())) {
                    noeud = dictionnaireChaine.valeur(niveau.valeurChaine());
                    if(noeud.getCommandes().startsWith("DBGDDDDHH")){
                        System.out.println("ma bite");
                    }
                } else {
                    noeud = new Noeud(dictionnaireChaine, commandes + commande, niveau);
                    dictionnaireChaine.inserer(niveau.valeurChaine(), noeud);
                    noeud.setDictionnaireChaine(dictionnaireChaine);
                    if(noeud.getCommandes().startsWith("DBGDDDDHH")){
                        System.out.println("ma bite");
                    }
                }



                    listeFils.ajouter(noeud);


            }
        }

        return solution;

    }


    }
