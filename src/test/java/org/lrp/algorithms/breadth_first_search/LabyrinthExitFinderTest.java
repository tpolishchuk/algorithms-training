package org.lrp.algorithms.breadth_first_search;

import org.junit.Test;

import static org.junit.Assert.*;

public class LabyrinthExitFinderTest {

    @Test
    public void findSingleExit() {
        String labyrinthString = " -----------\n" +
                                 "| 0 0 0 0 1 |\n" +
                                 "| 0 1 1 0 2 |\n" +
                                 "| 0 2 1 0 0 |\n" +
                                 "| 0 0 1 0 0 |\n" +
                                 " -----------\n";
        LabyrinthExitFinder finder = new LabyrinthExitFinder(labyrinthString, "\n");
        LabyrinthCell expectedCell = new LabyrinthCell(1, 2, 2);

        GraphNode exitNode = finder.findNearestExitNode();
        LabyrinthCell actualCell = exitNode.getCell();

        assertEquals("Got an unexpected exit cell: " + actualCell, expectedCell, actualCell);

        int stepsToTheNearestExit = actualCell.getX() + actualCell.getY();
        assertEquals("Got an unexpected exit amount of steps to the nearest exit: " + stepsToTheNearestExit,
                     3, stepsToTheNearestExit);
    }

    @Test
    public void findSingleExitEqualsEntrance() {
        String labyrinthString = " -----------\n" +
                                 "| 2 0 0 0 1 |\n" +
                                 "| 0 1 1 0 0 |\n" +
                                 "| 0 0 1 0 0 |\n" +
                                 "| 0 0 1 0 0 |\n" +
                                 " -----------\n";
        LabyrinthExitFinder finder = new LabyrinthExitFinder(labyrinthString, "\n");
        LabyrinthCell expectedCell = new LabyrinthCell(0, 0, 2);

        GraphNode exitNode = finder.findNearestExitNode();
        LabyrinthCell actualCell = exitNode.getCell();

        assertEquals("Got an unexpected exit cell: " + actualCell, expectedCell, actualCell);

        int stepsToTheNearestExit = actualCell.getX() + actualCell.getY();
        assertEquals("Got an unexpected exit amount of steps to the nearest exit: " + stepsToTheNearestExit,
                     0, stepsToTheNearestExit);
    }

    @Test
    public void findNearestExitNodeMultipleExits() {
        String labyrinthString = " -----------\n" +
                                 "| 0 0 0 0 1 |\n" +
                                 "| 0 1 1 0 0 |\n" +
                                 "| 0 0 1 0 2 |\n" +
                                 "| 1 0 2 0 0 |\n" +
                                 " -----------\n";
        LabyrinthExitFinder finder = new LabyrinthExitFinder(labyrinthString, "\n");
        LabyrinthCell expectedCell = new LabyrinthCell(2, 3, 2);

        GraphNode exitNode = finder.findNearestExitNode();
        LabyrinthCell actualCell = exitNode.getCell();

        assertEquals("Got an unexpected exit cell: " + actualCell, expectedCell, actualCell);

        int stepsToTheNearestExit = actualCell.getX() + actualCell.getY();
        assertEquals("Got an unexpected exit amount of steps to the nearest exit: " + stepsToTheNearestExit,
                     5, stepsToTheNearestExit);
    }

    @Test
    public void searchForExitInLabyrinthWithoutExit() {
        try {
            String labyrinthString = " -----\n" +
                                     "| 0 1 |\n" +
                                     " -----\n";
            LabyrinthExitFinder finder = new LabyrinthExitFinder(labyrinthString, "\n");
            GraphNode exitNode = finder.findNearestExitNode();
            fail("Exit cell is successfully found in labyrinth without exit");
        }catch (IllegalStateException e) {
            assertEquals("Got an unexpected assertion message",
                         "Labyrinth does not have any exit!",
                         e.getMessage());
        }
    }

    @Test
    public void initEmptyLabyrinth() {
        try {
            String labyrinthString = " -----------\n";
            LabyrinthExitFinder finder = new LabyrinthExitFinder(labyrinthString, "\n");
            fail("Empty labyrinth is successfully initialized");
        } catch (UnsupportedOperationException e) {
            assertEquals("Got an unexpected assertion message",
                         "Labyrinth must have at least size 1x1",
                         e.getMessage());
        }
    }

    @Test
    public void initLabyrinthWithRowsOfDifferentLength() {
        try {
            String labyrinthString = " -----------\n" +
                                     "| 0 0 0 0 1 |\n" +
                                     "| 0 1 1 0 |\n" +
                                     "| 0 0 1 0 2 |\n" +
                                     " -----------\n";
            LabyrinthExitFinder finder = new LabyrinthExitFinder(labyrinthString, "\n");
            fail("Labyrinth with rows of different length is successfully initialized");
        } catch (UnsupportedOperationException e) {
            assertEquals("Got an unexpected assertion message",
                         "All rows must have the same number of cells",
                         e.getMessage());
        }
    }
}
