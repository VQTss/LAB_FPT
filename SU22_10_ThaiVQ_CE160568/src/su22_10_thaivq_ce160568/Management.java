package su22_10_thaivq_ce160568;

import java.util.ArrayList;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class Management {

    private int numberID = 0;
    static Validate v = new Validate();
    static Task t = new Task();
    static Table table = new Table();
    static ArrayList<Task> taskList = new ArrayList<>(); // lưu trữ task
    public int addTask() {
        System.out.println("----------------Add Task------------------");
        System.out.print("Requirement Name: ");
        String requirementName = v.checkInputString();
        System.out.print("Task Type: ");
        int taskType = v.checkInputIntLimit(1, 4);
        System.out.print("Date: ");
        String date = v.checkDate();
        System.out.print("From: ");
        double from = v.checkInputDouble();
        System.out.print("To: ");
        double to = v.checkInputDouble();
        System.out.print("Assignee: ");
        String assignee = v.checkInputString();
        System.out.print("Reviewer: ");
        String review = v.checkInputString();
        boolean isExist = v.checkDuplicate(date, assignee, from, to);
        //check value of variable isExist
        if (isExist) {
            System.out.println("Duplicate!!!");
        } else {
            String type = v.checkType(taskType);
            int id = v.checkID(requirementName, taskType, date, from, to, assignee);
            Task newTask = new Task(id, type, requirementName, date, from, to, assignee, review);
            table.updateWidth(String.valueOf(id), type, requirementName, date, String.valueOf(from));
            setTaskList(newTask);
            System.out.println("Add successful!!");
        }
        return ++this.numberID;
    }

    public void deleteTask() {
        if (v.checkEmpty()) {
            System.out.println("List task is empty!");
            return;
        } else {
            System.out.println("-------Del Task---------");
            System.out.print("Enter ID: ");
            int id = v.checkInputInt();
            //check indexInList not equal - 1 or not
            int a = v.findTask(id);
            if (a != -1) {
                getTaskList().remove(a);
                System.out.println("Delete successful!");
            } else {
                System.out.println("ID is not exist!");
            }
        }
    }

    public void showTable() {
        table.updateTemplate();
        System.out.println(table.barLine);
        System.out.printf(table.template, "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        System.out.println(table.barLine);
        for (int i = 0; i < getTaskList().size(); i++) {
            Task task = getTaskList().get(i);
            System.out.printf(table.template, task.getID(), task.getName(), task.getTypeID(), task.getDate(), task.getPlanFrom(), task.getAssign(), task.getReview());
        }
        System.out.println(table.barLine);
    }

    public  ArrayList<Task> getTaskList() {
        return taskList;
    }

    public  void setTaskList(Task tkList) {
       this.taskList.add(tkList);
    }
    
}
