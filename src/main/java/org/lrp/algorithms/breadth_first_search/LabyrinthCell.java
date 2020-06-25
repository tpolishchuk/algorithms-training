package org.lrp.algorithms.breadth_first_search;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class LabyrinthCell {

    private final int MIN_X_Y = 0;
    private final int MAX_X_Y = 100;

    //From the left to the right
    @Getter
    private int x;

    //From the top to bottom
    @Getter
    private int y;

    @Getter
    private int value;

    public LabyrinthCell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;

        validate();
    }

    public void validate() {
        String message = "%s coordinate should be more or equal to %d and less than %d! Current value is %d";

        if (x < MIN_X_Y || x > MAX_X_Y) {
            throw new UnsupportedOperationException(String.format(message, "X", MIN_X_Y, MAX_X_Y, x));
        }

        if (y < MIN_X_Y || y > MAX_X_Y) {
            throw new UnsupportedOperationException(String.format(message, "Y", MIN_X_Y, MAX_X_Y, y));
        }

        message = "Value %d does not belong to allowed range {0, 1, 2}";

        if (value < 0 || value > 2) {
            throw new UnsupportedOperationException(String.format(message, value));
        }
    }
}
