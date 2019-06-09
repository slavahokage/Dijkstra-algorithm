package com.company.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private List<Node> nodes;

    private Map<Node, Integer> costs;

    private Map<Node, Node> parents;

    public Graph() {
    }

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Map<Node, Integer> getCosts() {
        return costs;
    }

    public void setCosts(HashMap<Node, Integer> costs) {
        this.costs = costs;
    }

    public void addNode(Node node){
        if (nodes == null){
            nodes = new ArrayList<>();
        }

        nodes.add(node);
    }

    public void addCost(Node node, Integer cost){
        if (costs == null){
            costs = new HashMap<>();
        }

        costs.put(node, cost);
    }

    public void addParent(Node nodeChild, Node nodeParent){
        if (parents == null){
            parents = new HashMap<>();
        }

        parents.put(nodeChild, nodeParent);
    }

    public void setCosts(Map<Node, Integer> costs) {
        this.costs = costs;
    }

    public Map<Node, Node> getParents() {
        return parents;
    }

    public void setParents(Map<Node, Node> parents) {
        this.parents = parents;
    }

    public void printCostToNodes() {
        for (Map.Entry cost : costs.entrySet()) {
            System.out.println("From start point to point with name " + cost.getKey()+" = "+ cost.getValue());
        }
    }
}
