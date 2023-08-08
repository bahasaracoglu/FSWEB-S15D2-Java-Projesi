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
                case "all":
                    Set<Task> result = new HashSet<>();
                    result.addAll(annsTasks);
                    result.addAll(bobsTasks);
                    result.addAll(carolsTasks);
                    return result;
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
        for (Set<Task> set : setList) {
            result.addAll(set);
        }
    return result;
    }

    public Set<Task> getIntersect(Set<Task> firstSet,Set<Task> secondSet ){
        Set<Task> result = new HashSet<>(firstSet);
        result.retainAll(secondSet);
        return result;
    }
    public Set<Task> getDifference(Set<Task> firstSet,Set<Task> secondSet ){
        Set<Task> result = new HashSet<>(firstSet);
        result.removeAll(secondSet);
        return result;
    }

    public Set<Task> getUnassigned(){
       Set<Task> allTasks = getTasks("all");
       return null;
    }
}

