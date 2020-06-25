package org.lrp.algorithms.breadth_first_search;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
@EqualsAndHashCode
public class GraphNode {

    @Getter
    private LabyrinthCell cell;

    @Getter
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<GraphNode> neighbours;

    public GraphNode(LabyrinthCell cell) {
        this.cell = cell;
        neighbours = new HashSet<>();
    }

    public void connect(GraphNode node) {
        if (node.equals(this)) {
            throw new UnsupportedOperationException("Cannot connect node to itself");
        }

        neighbours.add(node);
        node.getNeighbours().add(this);
    }
}
