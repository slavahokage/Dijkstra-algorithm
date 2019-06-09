package com.company;

import com.company.services.DijkstraService;
import com.company.structures.Graph;
import com.company.structures.Node;

public class Main {

    public static void main(String[] args) {
        Graph graphScheme = new Graph();

        Node nodeStart = new Node("start");
        Node a = new Node("a");
        Node b = new Node("b");
        Node fin = new Node("fin");

        nodeStart.addNeighbour(a, 6);
        nodeStart.addNeighbour(b, 2);

        a.addNeighbour(fin, 1);

        b.addNeighbour(a, 3);
        b.addNeighbour(fin, 5);

        graphScheme.addNode(nodeStart);
        graphScheme.addNode(a);
        graphScheme.addNode(b);
        graphScheme.addNode(fin);

        graphScheme.addCost(a, 6);
        graphScheme.addCost(b, 2);
        graphScheme.addCost(fin, Integer.MAX_VALUE);

        graphScheme.addParent(a, nodeStart);
        graphScheme.addParent(b, nodeStart);
        graphScheme.addParent(fin, null);

        DijkstraService dijkstraService = new DijkstraService(graphScheme);

        dijkstraService.findMinimumDistancesToNodes();

        graphScheme.printCostToNodes();
    }
}
