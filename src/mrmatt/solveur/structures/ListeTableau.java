package mrmatt.solveur.structures;



import java.util.Arrays;


public class ListeTableau<E> implements Liste<E> {

    private E[] elements;

    private static final int tailleInitiale=10;
    private int nombreElements;

    public ListeTableau() {
        elements = (E[]) new Object[tailleInitiale];
        nombreElements = 0;
    }

    @Override
    public void ajouter(E element) {

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

    @Override
    public E element(int i) {
        this.outOfBound(i);
        return elements[i];
    }

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

    public void outOfBound(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= this.taille()) {
            throw new IndexOutOfBoundsException("Indice incorrect");
        }
    }

    public boolean equals(Object listeTableau){

        if (listeTableau==null || this.getClass()!=listeTableau.getClass()){
            return false;
        }

        ListeTableau<E> listeTableau1 = (ListeTableau<E>) listeTableau;

        if(this.nombreElements!=listeTableau1.nombreElements)
            return false;

        for (int i =0; i<this.nombreElements-1;i++){
            if(this.element(i)!= listeTableau1.element(i)){
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