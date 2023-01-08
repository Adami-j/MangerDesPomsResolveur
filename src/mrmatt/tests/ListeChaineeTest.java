package mrmatt.tests;

import mrmatt.solveur.structures.ListeChainee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;


public class ListeChaineeTest {
    ListeChainee<String> liste;

    @Before
    public void setUp() throws Exception {
        liste = new ListeChainee<String>();
    }

    @Test
    public void testAjouter() {

        liste.ajouter("test1");
        liste.ajouter("test2");
        liste.ajouter("test3");
        assertEquals(3, liste.taille());
    }


    @Test
    public void testEstVide() {
        ListeChainee<String> liste = new ListeChainee<String>();
        assertTrue(liste.estVide());

        liste.ajouter("test");
        assertFalse(liste.estVide());
    }

    @Test
    public void testTaille() {
        ListeChainee<String> liste = new ListeChainee<String>();
        assertEquals(0, liste.taille());

        liste.ajouter("test1");
        assertEquals(1, liste.taille());

        liste.ajouter("test2");
        assertEquals(2, liste.taille());
    }

    @Test
    public void testEnlever() {
        ListeChainee<String> liste = new ListeChainee<String>();
        liste.ajouter("test1");

        liste.enlever(0);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEnleverIndexInvalide() {
        ListeChainee<String> liste = new ListeChainee<String>();
        liste.enlever(0);
    }

    @Test
    public void testElement() {
        ListeChainee<String> liste = new ListeChainee<String>();
        liste.ajouter("test1");
        liste.ajouter("test2");
        liste.ajouter("test3");

        assertEquals("test2", liste.element(1));
        assertEquals("test3", liste.element(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testElementIndexInvalide() {

        liste.element(0);
    }

    @Test
    public void testContient() {
        ListeChainee<String> liste = new ListeChainee<String>();
        liste.ajouter("test1");
        liste.ajouter("test2");
        liste.ajouter("test3");
        System.out.println( liste.toString());
        assertTrue(liste.contient("test1"));
        assertTrue(liste.contient("test3"));
        assertFalse(liste.contient("test1"));

    }


    @Test
    public void testListeVide() {
        assertTrue(liste.estVide());

    }

    @Test
    public void testListeNonVide() {
        liste.ajouter("test1");
        assertFalse(liste.estVide());

    }



}
