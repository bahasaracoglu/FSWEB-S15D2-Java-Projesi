package com.workintech.model;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;

    public Set<Task> getTasks(String name) {
        try {
            switch (name) {
                case "ann":
                    return annsTasks;
                case "bob":
                    return bobsTasks;
                case "carol":
                    return carolsTasks;
                default:
                    System.out.println("Invalid input");
                    return null;
            }
        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
            return null;
        }
    }

    public Set<Task> getUnion(Set[] setList) {
        Set<Task> result = new HashSet<>();
        for (Set set : setList) {
            result.addAll(set);
        }
    return result;
    }

}

