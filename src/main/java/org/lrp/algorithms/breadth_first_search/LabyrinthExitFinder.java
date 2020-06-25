package org.lrp.algorithms.breadth_first_search;

import java.util.*;

/**
 * The util that needs to find the shortest way to the nearest exit from labyrinth for the ball
 * The labyrinth looks like
 * <p>
 * (y)(x)-->
 * |010001
 * |001002
 * |020010
 * v
 * <p>
 * Where:
 * 0 - is a free cell. Ball can move there
 * 1 - is a hurdle. Ball cannot to be moved there
 * 2 - is an exit
 * <p>
 * Ball always starts from the top left corner (x:0; y:0)
 */
public class LabyrinthExitFinder {

    private ArrayList<ArrayList<LabyrinthCell>> labyrinth = new ArrayList<>();

    public LabyrinthExitFinder(String labyrinthAsString, String rowsDelimiter) {
        initLabyrinth(labyrinthAsString, rowsDelimiter);
    }

    public GraphNode getStartNode() {
        return new GraphNode(labyrinth.get(0).get(0));
    }

    private void initLabyrinth(String labyrinthAsString, String rowsDelimiter) {
        int rowSize = 0;
        int y = 0;
        int x;

        Scanner scanner = new Scanner(labyrinthAsString).useDelimiter(rowsDelimiter);

        while (scanner.hasNext()) {

            ArrayList<LabyrinthCell> labyrinthRow = new ArrayList<>();
            x = 0;

            for (char digit : scanner.next().toCharArray()) {
                if (Character.isDigit(digit)) {
                    LabyrinthCell cell = new LabyrinthCell(x, y, Character.getNumericValue(digit));
                    labyrinthRow.add(cell);
                    x++;
                }
            }

            if (!labyrinthRow.isEmpty()) {
                if (rowSize == 0) {
                    rowSize = labyrinthRow.size();
                }

                if (labyrinthRow.size() != rowSize) {
                    throw new UnsupportedOperationException("All rows must have the same number of cells");
                }

                labyrinth.add(labyrinthRow);
                y++;
            }
        }

        if (rowSize == 0) {
            throw new UnsupportedOperationException("Labyrinth must have at least size 1x1");
        }
    }

    private void findLabyrinthWalkwaysForNode(GraphNode node) {
        int currentX = node.getCell().getX();
        int currentY = node.getCell().getY();
        //Node up (y-1)
        if (currentY - 1 >= 0) {
            LabyrinthCell cellUp = labyrinth.get(currentY - 1).get(currentX);
            if (cellUp.getValue() != 1) {
                node.connect(new GraphNode(cellUp));
            }
        }
        //Node left (x-1)
        if (currentX - 1 >= 0) {
            LabyrinthCell cellLeft = labyrinth.get(currentY).get(currentX - 1);
            if (cellLeft.getValue() != 1) {
                node.connect(new GraphNode(cellLeft));
            }
        }
        //Node down (y+1)
        if (currentY + 1 < labyrinth.size()) {
            LabyrinthCell cellDown = labyrinth.get(currentY + 1).get(currentX);
            if (cellDown.getValue() != 1) {
                node.connect(new GraphNode(cellDown));
            }
        }
        //Node right (x+1)
        if (currentX + 1 < labyrinth.get(0).size()) {
            LabyrinthCell cellRight = labyrinth.get(currentY).get(currentX + 1);
            if (cellRight.getValue() != 1) {
                node.connect(new GraphNode(cellRight));
            }
        }
    }

    public GraphNode findNearestExitNode() {
        GraphNode startNode = getStartNode();
        Set<GraphNode> visitedNodesSet = new HashSet<>();
        Queue<GraphNode> activeNodesQueue = new ArrayDeque<>();
        activeNodesQueue.add(startNode);

        GraphNode currentNode;

        while (!activeNodesQueue.isEmpty()) {
            currentNode = activeNodesQueue.remove();
            visitedNodesSet.add(currentNode);

            if (currentNode.getCell().getValue() == 2) {
                return currentNode;
            }

            findLabyrinthWalkwaysForNode(currentNode);
            activeNodesQueue.addAll(currentNode.getNeighbours());
            activeNodesQueue.removeAll(visitedNodesSet);
        }

        throw new IllegalStateException("Labyrinth does not have any exit!");
    }
}
