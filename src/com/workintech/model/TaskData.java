package com.workintech.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {
    //Şimdilik bu şekilde kalsın(bu şekilde instance oluşturmak iyi değil.)
    private Set<Task> annsTasks = new HashSet<>();
    private Set<Task> bobsTasks = new HashSet<>();
    private Set<Task> carolsTasks = new HashSet<>();
    private Set<Task> unassignedTasks = new HashSet<>();

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
                    List<Set<Task>> setList = new ArrayList<>();
                    setList.add(annsTasks);
                    setList.add(bobsTasks);
                    setList.add(carolsTasks);
                    return getUnion(setList);
                case "unassigned":
                    return unassignedTasks;

                default:
                    System.out.println("Invalid input");
                    return null;
            }
        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
            return null;
        }
    }

    public void importTasks(Task task) {
        switch (task.getAssignee()) {
            case "Ann":
                annsTasks.add(task);
                break;
            case "Bob":
                bobsTasks.add(task);
                break;
            case "Carol":
                carolsTasks.add(task);
                break;
            case "":
                unassignedTasks.add(task);
                break;
        }
    }

    public Set<Task> getUnion(List<Set<Task>> setList) {
        Set<Task> result = new HashSet<>();
        for (Set<Task> set : setList) {
            result.addAll(set);
        }
        return result;
    }

    public Set<Task> getIntersect(Set<Task> firstSet, Set<Task> secondSet) {
        Set<Task> result = new HashSet<>(firstSet);
        result.retainAll(secondSet);
        return result;
    }

    public Set<Task> getDifference(Set<Task> firstSet, Set<Task> secondSet) {
        Set<Task> result = new HashSet<>(firstSet);
        result.removeAll(secondSet);
        return result;
    }


}

