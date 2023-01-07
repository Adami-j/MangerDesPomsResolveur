package mrmatt.solveur.structures;



import java.util.Arrays;


public class ListeTableau<E> implements Liste<E> {

    private E[] elements;

    private static final int tailleInitiale=10;
    private int nombreElements;

    /**
     * @author Julien ADAMI
     * constructeur qui initialise la liste d'élément avec la taille initiale
     * et qui met à zéro le nombre d'éléments dans le tableau
     */
    public ListeTableau() {
        elements = (E[]) new Object[tailleInitiale];
        nombreElements = 0;
    }

    /**
     * @author Julien ADAMI
     * @param element l'élément à ajouter dans la liste
     */
    @Override
    public void ajouter(E element) throws IllegalArgumentException{

        if(element==null || !element.getClass().equals(element.getClass())){
            throw new IllegalArgumentException("Element invalide");
        }
        if (this.taille() == elements.length) {
            elements = Arrays.copyOf(elements, this.taille()*2);
        }

            elements[nombreElements] = element;
            this.nombreElements++;
    }

    @Override
    public boolean estVide() {
        return this.nombreElements == 0;
    }


    @Override
    public int taille() {
        return this.nombreElements;
    }

    /**
     * @author Julien ADAMI
     * @param i la position de l'élément.
     * @return
     * renvoie E l'élément supprimé de la liste
     * décale tous les éléments de la liste ou leur index est sup a i vers la gauche
     */
    @Override
    public E enlever(int i) {
        this.outOfBound(i);
        E element = elements[i];
        elements[i] = null;
        for(int j = i; j<this.nombreElements-1;j++){
            elements[j]=elements[j+1];

        }
        this.nombreElements--;
        return element;
    }

    /**
     * @author Julien ADAMI
     * @param i index
     * @return
     * retourne l'élément à l'index i dans la liste
     */
    @Override
    public E element(int i) {
        this.outOfBound(i);
        return elements[i];
    }

    /**
     * @author Julien ADAMI
     * @param e L'élément à comparer
     * @return
     * retourne vrai si l'élément existe
     */
    @Override
    public boolean contient(E e) {
        boolean contient = false;
        for (int i = 0; i < this.taille(); i++) {
            if (elements[i].equals(e)) {
                contient =true;
            }
        }
        return contient;
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

    public boolean equals(Object listeTableau) {

        if (listeTableau == null || this.getClass() != listeTableau.getClass()) {
            return false;
        }


        ListeTableau<?> listeTableau1 = (ListeTableau<?>) listeTableau;

        if(listeTableau1.nombreElements!=this.nombreElements || (listeTableau1.estVide()!=this.estVide())){
            return false;
        }

        int taille = (listeTableau1.nombreElements+this.nombreElements)/2;

        for (int i = 0; i < taille; i++) {

            if (!elements[i].equals(listeTableau1.elements[i])||elements[i]==null) {
                return false;
            }
        }

        return true;

    }




    public String toString() {
        String res = "";
        for (int i = 0; i < this.taille(); i++) {
            res +="Element "+i+" : "+ elements[i] + " ";
        }
        return res;
    }


}