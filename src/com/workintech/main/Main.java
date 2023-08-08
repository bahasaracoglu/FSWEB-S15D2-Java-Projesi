package com.workintech.main;

import com.workintech.enums.Priority;
import com.workintech.enums.Status;
import com.workintech.model.Task;
import com.workintech.model.TaskData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static List<Task> generateDummyData(int count) {
        List<Task> dummyData = new ArrayList<>();
        String[] projects = {"Project A", "Project B", "Project C"};
        String[] descriptions = {"Description 1", "Description 2", "Description 3"};
        String[] assignees = {"Ann", "Bob", "Carol",""};
        Priority[] priorities = Priority.values();
        Status[] statuses = Status.values();

        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String project = projects[random.nextInt(projects.length)];
            String description = descriptions[random.nextInt(descriptions.length)];
            String assignee = assignees[random.nextInt(assignees.length)];
            Priority priority = priorities[random.nextInt(priorities.length)];
            Status status = statuses[random.nextInt(statuses.length)];
            if (assignee.equals("")) status=Status.IN_QUEUE;
            dummyData.add(new Task(project, description, assignee, priority, status));
        }

        return dummyData;
    }



    public static void main(String[] args) {
        TaskData newData = new TaskData();

        System.out.println("Hello world!");
        List<Task> dummyData = generateDummyData(15);

        for (Task task : dummyData) {
            newData.importTasks(task);
        }

//        for (Task task : dummyData) {
//            System.out.println(task);
//        }


        //--------------------CEVAPLAR----------------------
        //Tüm çalışanlarının üzerindeki tasklar nelerdir ? Unassigned hariç tuttuldu.
        System.out.println(newData.getTasks("all"));
        //Her bir çalışanın üzerindeki tasklar nelerdir ?
        System.out.println(newData.getTasks("ann"));
        System.out.println(newData.getTasks("bob"));
        System.out.println(newData.getTasks("carol"));

    }



}
