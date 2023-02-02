package mrmatt.tests;

import mrmatt.solveur.Solveur;
import mrmatt.sources.Niveau;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Julien ADAMI
 * classe de test de la classe Solver
 */
public class TestSolver {

    @Test
    public void testTrouverSolution() {
        Solveur solveur = new Solveur();

        String solution = solveur.trouverSolution(new Niveau("src/niveaux/1rocher.txt"));

        String solutionAttendue = "DBGDDDGHHDD";
        assertEquals(solutionAttendue, solution);
    }

}
