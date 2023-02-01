package mrmatt.solveur.structures;


public class DictionnaireChaine<C, V> implements Dictionnaire<C, V> {
    /**
     * @author Julien ADAMI
     * @param <C> clé
     * @param <V> valeur
     * classe de l'entrée du dico
     */
    class Entree<C,V>{
        C cle;
        V valeur;

        public Entree(C cle, V valeur) {
            this.cle = cle;
            this.valeur = valeur;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) return false;
            Entree<C, V> entree = (Entree<C, V>) o;
            return cle==entree.cle;
        }

    }

    private ListeChainee<Entree<C,V>> listeChainee;
    int tailleDico ;

    public DictionnaireChaine(){
        this.listeChainee = new ListeChainee<Entree<C,V>>();
        this.tailleDico=0;
    }

    /**
     * @author Julien ADAMI
     * @param cle
     * @param valeur
     * @throws IllegalArgumentException
     * méthode inserer qui ajoute à la listeChainee une entree
     * si cle null, erreur d'argument
     * incrémente la variable de la taille du dico
     */
    @Override
    public void inserer(C cle, V valeur) throws IllegalArgumentException {
        if(cle==null){
            throw new IllegalArgumentException();
        }

        this.listeChainee.ajouter(new Entree<C, V>(cle,valeur));
        this.tailleDico++;
    }

    /**
     * @author Julien ADAMI
     * @param cle
     * @return true si contenu
     */
    @Override
    public boolean contient(C cle) {
        this.illegalCleArgumentException(cle);
        boolean res = false;

        for(int i = 0; i<tailleDico;i++){
            if(this.listeChainee.getMaillon(i).getDonnee().cle.equals(cle)){
                 res = true;
            }
        }
        return res;
    }

    /**
     * @autor Julien ADAMI
     * @param cle
     * @throws IllegalArgumentException
     * méthode extraite qui check et renvoie IllegalArgumentException si cle est null
     */
    public void illegalCleArgumentException(C cle)throws IllegalArgumentException{
        if(cle==null){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public V valeur(C cle) {
        this.illegalCleArgumentException(cle);
        V valeur = null;

        for(int i = 0; i<this.tailleDico;i++){
            if(this.listeChainee.getMaillon(i).getDonnee().cle.equals(cle)){
                valeur = this.listeChainee.getMaillon(i).getDonnee().valeur;
            }
        }
        return valeur;
    }
}