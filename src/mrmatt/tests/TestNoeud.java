package mrmatt.tests;
import mrmatt.solveur.Noeud;
import mrmatt.solveur.structures.DictionnaireChaine;
import mrmatt.sources.Niveau;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNull;

/**
 * @author Julien ADAMI
 * classe de test de la classe Noeud
 */
public class TestNoeud {

    private Noeud noeud;
    DictionnaireChaine<String, Noeud> dictionnaireChaine = new DictionnaireChaine<String, Noeud>();
    Niveau niveau = new Niveau("src/niveaux/1rocher.txt");


    @Before
    public void onStart(){
        noeud = new Noeud(dictionnaireChaine,"",niveau);
    }

    @Test
    public void testCalculerFilsPremiereIterationNulle(){
       assertNull(noeud.calculerFils());
    }



}
