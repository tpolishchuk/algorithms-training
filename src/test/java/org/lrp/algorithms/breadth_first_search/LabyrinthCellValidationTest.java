package org.lrp.algorithms.breadth_first_search;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class LabyrinthCellValidationTest {

    @Test
    public void initValidCell() {
        LabyrinthCell cell = new LabyrinthCell(RandomUtils.nextInt(0,101),
                                               RandomUtils.nextInt(0,101),
                                               RandomUtils.nextInt(0,3));
        assertNotNull("Cell is not initialized", cell);
    }

    @Test
    public void initCellWithXLessThanMinimal() {
        try {
            LabyrinthCell cell = new LabyrinthCell(-1, 1, 1);
            fail("new LabyrinthCell(-1, 1, 1) is successfully initialized");
        }
        catch (UnsupportedOperationException e) {
            assertEquals("Got an unexpected assertion message",
                         "X coordinate should be more or equal to 0 and less than 100! Current value is -1",
                         e.getMessage());
        }
    }

    @Test
    public void initCellWithXMoreThanMaximum() {
        try {
            LabyrinthCell cell = new LabyrinthCell(101, 1, 1);
            fail("new LabyrinthCell(101, 1, 1) is successfully initialized");
        }
        catch (UnsupportedOperationException e) {
            assertEquals("Got an unexpected assertion message",
                         "X coordinate should be more or equal to 0 and less than 100! Current value is 101",
                         e.getMessage());
        }
    }

    @Test
    public void initCellWithYLessThanMinimal() {
        try {
            LabyrinthCell cell = new LabyrinthCell(1, -1, 1);
            fail("new LabyrinthCell(1, -1, 1) is successfully initialized");
        }
        catch (UnsupportedOperationException e) {
            assertEquals("Got an unexpected assertion message",
                         "Y coordinate should be more or equal to 0 and less than 100! Current value is -1",
                         e.getMessage());
        }
    }

    @Test
    public void initCellWithYMoreThanMaximum() {
        try {
            LabyrinthCell cell = new LabyrinthCell(1, 101, 1);
            fail("new LabyrinthCell(1, 101, 1) is successfully initialized");
        }
        catch (UnsupportedOperationException e) {
            assertEquals("Got an unexpected assertion message",
                         "Y coordinate should be more or equal to 0 and less than 100! Current value is 101",
                         e.getMessage());
        }
    }

    @Test
    public void initCellWithValueOutOfRange() {
        try {
            LabyrinthCell cell = new LabyrinthCell(1, 1, 3);
            fail("new LabyrinthCell(1, 1, 3) is successfully initialized");
        }
        catch (UnsupportedOperationException e) {
            assertEquals("Got an unexpected assertion message",
                         "Value 3 does not belong to allowed range {0, 1, 2}",
                         e.getMessage());
        }
    }
}
