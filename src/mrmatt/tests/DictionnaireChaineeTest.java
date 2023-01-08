package mrmatt.tests;

import mrmatt.solveur.structures.DictionnaireChaine;
import org.junit.Test;


import org.junit.Before;

import static org.junit.Assert.*;

public class DictionnaireChaineeTest {

        private DictionnaireChaine<String, Integer> dict;

        @Before
        public void setUp() {
            dict = new DictionnaireChaine<String, Integer>();
        }

        @Test
        public void testInserer() {
            dict.inserer("key1", 1);
            dict.inserer("key2", 2);

            assertTrue(dict.contient("key1"));
            assertTrue(dict.contient("key2"));
            assertFalse(dict.contient("key3"));
        }

        @Test
        public void testContient() {
            dict.inserer("key1", 1);
            dict.inserer("key2", 2);

            assertTrue(dict.contient("key1"));
            assertTrue(dict.contient("key2"));
            assertFalse(dict.contient("key3"));
        }

        @Test
        public void testValeur() {
            dict.inserer("key1", 1);
            dict.inserer("key2", 2);

            assertEquals(new Integer(1), dict.valeur("key1"));
            assertEquals(new Integer(2), dict.valeur("key2"));
            assertNull(dict.valeur("key3"));
        }

        @Test(expected = IllegalArgumentException.class)
        public void testInsererNullKey() {
            dict.inserer(null, 1);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testContientNullKey() {
            dict.contient(null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testValeurNullKey() {
            dict.valeur(null);
        }




}
