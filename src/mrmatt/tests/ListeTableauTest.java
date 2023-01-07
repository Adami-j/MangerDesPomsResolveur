package mrmatt.tests;

import mrmatt.solveur.structures.Liste;
import mrmatt.solveur.structures.ListeTableau;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Julien ADAMI
 * Classe de test de la ListeTableau
 */
public class ListeTableauTest {

    Liste<String> liste;

    /**
     * @author Julien ADAMI
     * Méthode onStart qui initialise la listeTableau
     */
    @Before
    public void onStart(){
        liste = new ListeTableau<String>();
    }

    @Test
    public void testNbElementsInit(){
        assertEquals(liste.taille(),0);
    }

    @Test
    public void testAjouter() throws Exception {

        liste.ajouter("test");
        assertEquals("test", liste.element(0));
    }

    @Test
    public void testEstVide() throws Exception {
        assertTrue(liste.estVide());
    }




    @Test
    public void testEstVideFaux() throws Exception {
        liste.ajouter("coucou");
        assertFalse(liste.estVide());
    }

    @Test
    public void testIndexEnDehorsElement()throws IndexOutOfBoundsException{

       try{
           liste.element(-1);
       }catch (IndexOutOfBoundsException e){
           assertTrue(e.getMessage()=="Indice incorrect");
       }

    }

    @Test
    public void testContientVrai(){
        liste.ajouter("e");
        assertTrue(liste.contient("e"));
    }

    @Test
    public void testContientFaux(){
        liste.ajouter("f");
        assertFalse(liste.contient("e"));
    }

    @Test
    public void enleverIndexFaux(){
        try{
            liste.enlever(-1);
        }catch (IndexOutOfBoundsException e){
            assertTrue(e.getMessage()=="Indice incorrect");
        }
    }

    @Test
    public void enleverIndex(){
        liste.ajouter("cc");
        liste.ajouter("cou");
        assertTrue(liste.taille()==2);
        liste.enlever(0);
        assertTrue(liste.taille()==1);
        System.out.println(liste.toString());
    }

    @Test
    public void testEqualsNullMauvaisObject(){
        assertFalse(liste.equals(null));
        assertFalse(liste.equals(new String("cc")));
        assertTrue(liste.equals(new ListeTableau<String>()));
        liste.ajouter("bonjour");
        ListeTableau<Integer> listeTest = new ListeTableau<Integer>();
        listeTest.ajouter(1);
        System.out.println(liste.equals(listeTest));

    }


}
