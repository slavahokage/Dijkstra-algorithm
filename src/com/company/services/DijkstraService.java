package com.company.services;

import com.company.structures.Graph;
import com.company.structures.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraService {

    private List<Node> processed;

    private Graph graph;

    public DijkstraService(Graph graph) {
        this.graph = graph;
        processed = new ArrayList<>();
    }

    public void findMinimumDistancesToNodes() {
        Node node = findLowestCostNode();
        Map<Node, Integer> costs = graph.getCosts();
        Map<Node, Node> parents = graph.getParents();

        while (node != null) {
            Integer cost = costs.get(node);
            HashMap<Node, Integer> neighbors = node.getNeighbors();
            if (neighbors != null) {
                for (Map.Entry<Node, Integer> neighbour : neighbors.entrySet()) {
                    Integer newCost;
                    if (neighbour.getValue() == Integer.MAX_VALUE) {
                        newCost = Integer.MAX_VALUE;
                    } else {
                        newCost = neighbour.getValue() + cost;
                    }

                    if (costs.get(neighbour.getKey()) > newCost) {
                        costs.put(neighbour.getKey(), newCost);
                        parents.put(neighbour.getKey(), node);
                    }
                }
            }
            processed.add(node);
            node = findLowestCostNode();
        }
    }

    private Node findLowestCostNode() {
        Integer lowestCost = Integer.MAX_VALUE;
        Node lowestCostNode = null;
        Map<Node, Integer> costs = graph.getCosts();
        for (Node node : costs.keySet()) {
            Integer cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }

        return lowestCostNode;
    }
}
