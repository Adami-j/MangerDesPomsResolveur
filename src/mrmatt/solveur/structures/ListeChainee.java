package mrmatt.solveur.structures;

public class ListeChainee<T> implements Liste<T> {

    /**
     *
     */
    public class Maillon {
        private T donnee;
        private Maillon suivant;

        public Maillon(T donnee,Maillon suivant){
            this.donnee=donnee;
            this.suivant=suivant;
        }

        public T getDonnee() {
            return donnee;
        }



        public Maillon getSuivant() {
            return suivant;
        }


    }

    /**
     * tête de la listeChainee
     * @author Julien ADAMI
     */
    private Maillon tete;

    private int tailleListeChainee;

    /**
     * constructeur avec la tête qui est le maillon de départ de la liste chainée et la taille de la liste init a 0
     * @author Julien ADAMI
     */
    public ListeChainee(){
        this.tete=null;
        this.tailleListeChainee=0;
    }

    /**
     * @author Julien ADAMI
     * @param element l'élément à ajouter
     * ajout un élément à la listeChainee (qui n'est en réalité par réellement une liste)
     *                cas 1 : tête null donc on ajoute directement un maillon avec l'élément
     *                cas 2 : le maillon à une tête, on remonte jusqua la dernière tête puis on donne au dernier
     *                maillon le suivant qui est l'élément et le maillon "null"
        */

    @Override
    public void ajouter(T element) {
        Maillon nouveauMaillon = new Maillon(element, null);
        if (this.estVide()) {
            tete = nouveauMaillon;
        } else {
            Maillon maillonTete = this.getTete();

            maillonTete.suivant = nouveauMaillon;
        }
        tailleListeChainee++;
    }

    @Override
    public boolean estVide() {
        return this.taille()==0;
    }

    @Override
    public int taille() {
        return this.tailleListeChainee;
    }


    /**
     * @author Julien ADAMI
     * @param i la position de l'élément.
     * @return
     * renvoie E l'élément supprimé de la listechainee
     * décale tous les éléments de la liste ou leur index est sup à i vers la gauche
     *  cas 1 : la liste est vide on renvoie la donnee dans tete mais elle est null
     *  cas 2 : on récupère la tete et on la met dans un maillon temporaire
     *  puis on remonte jusqua la position i-1, on revoie la donnée de c
     *
     */
    @Override
    public T enlever(int i) {
        this.outOfBound(i);
        T elementSupprime;
        if (i == 0) {
            elementSupprime = tete.donnee;
            tete = tete.suivant;
        } else {
            Maillon maillonPrecedent = getMaillon(i - 1);
            elementSupprime = maillonPrecedent.suivant.donnee;
            maillonPrecedent.suivant = maillonPrecedent.suivant.suivant;
            for (int id = i; id < this.tailleListeChainee - 1; id++) {
                Maillon maillon = getMaillon(i);
                maillon.donnee = maillon.suivant.donnee;
            }
        }
        this.tailleListeChainee--;
        return elementSupprime;
    }

    /**
     * @author Julien ADAMI
     * @param indice
     * @return
     */
    public Maillon getMaillon(int indice) {
        this.outOfBound(indice);
        Maillon maillon = tete;
        for (int i = 0; i < indice; i++) {
            maillon = maillon.suivant;
        }
        return maillon;
    }

    public Maillon getTete(){
        Maillon maillonTete = this.tete;
        for (int i = 0; i < tailleListeChainee-1; i++) {
            maillonTete = maillonTete.suivant;
        }
        return maillonTete;
    }

    /**
     * @author Julien ADAMI
     * @param i
     * @return element à la position i
     */
    @Override
    public T element(int i) {
        this.outOfBound(i);
        Maillon maillonTmp = this.tete;
        for (int j = 0; j < i; j++) {
            maillonTmp = maillonTmp.suivant;
        }

        if(i==0){
            return this.tete.donnee;
        }
        return maillonTmp.donnee;
    }

    /**
     * @author Julien ADAMI
     * @param e L'élément à comparer.
     * @return
     */
    @Override
    public boolean contient(T e) {
        if(e==null){
            return false;
        }

        for (Maillon maillonTete = tete; maillonTete != null; maillonTete = maillonTete.suivant) {
            if (maillonTete.donnee.equals(e)) {
                return true;
            }
        }
        return false;

    }

    /**
     * @author Julien ADAMI
     * @param i index
     * @throws IndexOutOfBoundsException
     * méthode qui check si l'index est correct
     * et renvoie une exception IndexOutOfBouds avec le message Indice incorrect
     */
    public void outOfBound(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= this.taille()) {
            throw new IndexOutOfBoundsException("Indice incorrect");
        }
    }

    public int getTailleListeChainee() {
        return tailleListeChainee;
    }

    @Override
    public boolean equals(Object listeChainee) {
        if (this == listeChainee) {
            return true;
        }
        if (listeChainee == null || getClass() != listeChainee.getClass()) {
            return false;
        }

        ListeChainee<?> listeChainee1 = (ListeChainee<?>) listeChainee;

        if ( listeChainee1.tailleListeChainee!= this.tailleListeChainee) {
            return false;
        }
        Maillon courant = this.tete;
        Maillon courantListrChainee1 =(Maillon) listeChainee1.tete;
        while (courant != null) {
            if (!courant.donnee.equals(courantListrChainee1.donnee)) return false;
            courant = courant.suivant;
            courantListrChainee1 = courantListrChainee1.suivant;
        }
        return true;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Maillon courant = this.tete;
        while (courant != null) {
            sb.append(courant.donnee);
            sb.append(" ");
            courant = courant.suivant;
        }
        return sb.toString();
    }
}

