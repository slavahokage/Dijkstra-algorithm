package com.company.structures;

import java.util.HashMap;

public class Node {

    private String name;

    private HashMap<Node, Integer> neighbors;

    public Node() {
    }

    public Node(String name, HashMap<Node, Integer> neighbors) {
        this.name = name;
        this.neighbors = neighbors;
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Node, Integer> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(HashMap<Node, Integer> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbour(Node neighbour, Integer distance) {
        if (neighbors == null){
            neighbors = new HashMap<>();
        }

        this.neighbors.put(neighbour, distance);
    }

    @Override
    public String toString() {
        return "{"+name+"}";
    }
}
