package mrmatt.solveur.structures;

import java.util.Arrays;


public class ListeTableau<E> implements Liste<E> {

    private E[] elements;

    private static final int TAILLE_INITIALE =10;
    private int nombreElements;

    /**
     * @author Julien ADAMI
     * constructeur qui initialise la liste d'élément avec la taille initiale
     * et qui met à zéro le nombre d'éléments dans le tableau
     */
    public ListeTableau() {
        this.elements = (E[]) new Object[ListeTableau.TAILLE_INITIALE];
        this.nombreElements = 0;
    }

    /**
     * @author Julien ADAMI
     * @param element l'élément à ajouter dans la liste
     */
    @Override
    public void ajouter(E element) throws IllegalArgumentException{
        this.illegalArgument(element);
        if (this.taille() == this.elements.length) {
            //on peut aussi utiliser System.arraycopy
            this.elements = Arrays.copyOf(this.elements, this.taille()*2);
        }

            this.elements[this.nombreElements] = element;
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
    public E enlever(int i) throws IndexOutOfBoundsException{
        this.outOfBound(i);
        E element = this.elements[i];
        this.elements[i] = null;
        for(int j = i; j<this.nombreElements-1;j++){
            this.elements[j]=this.elements[j+1];
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
    public E element(int i) throws IndexOutOfBoundsException{
        this.outOfBound(i);
        return this.elements[i];
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
            if (this.elements[i].equals(e)) {
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

    /**
     * @author Julien ADAMI
     * @param element
     * @throws IllegalArgumentException
     * méthode qui contrôle si l'élément est null ou si il n'est pas de type E
     */
    public void illegalArgument(E element) throws IllegalArgumentException{
        if(element==null || !element.getClass().equals(element.getClass())){
            throw new IllegalArgumentException("Element invalide");
        }
    }

    /**
     * @author Julien ADAMI
     * @param listeTableau
     * @return true si les deux listes sont égales
     */
    @Override
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

            if (!this.elements[i].equals(listeTableau1.elements[i])||this.elements[i]==null) {
                return false;
            }
        }
        return true;
    }
    
}