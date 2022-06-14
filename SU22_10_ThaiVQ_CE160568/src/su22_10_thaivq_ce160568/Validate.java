package su22_10_thaivq_ce160568;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import static su22_10_thaivq_ce160568.Management.t;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class Validate {

    private static final Scanner sc = new Scanner(System.in);
    static Task t = new Task();
    static Management m = new Management();
    static final String CHECKDATE = "\\\\d{1,2}[-]\\\\d{1,2}[-]\\\\d{4}";

    //dispaly menu
    public int menu() {
        System.out.println("=====Task Program=====");
        System.out.println("\t1. Add Task");
        System.out.println("\t2. Delete Task");
        System.out.println("\t3. Display Task");
        System.out.println("\t4. Exit");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 4);
        return choice;
    }

    //check user input number limit
    public int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input double
    public double checkInputDouble() {
        //loop until user input correct
        while (true) {
            try {
                String str = checkInputString();
                if (str.matches("^(\\\\d+\\\\.([5]|[0]))$")) {
                    System.out.println("Input must be x.0 or x.5 number");
                }
                double result = Double.parseDouble(str);
                if (result >= 8.0 && result <= 17.5) {
                    return result;
                } else {
                    System.out.println("Plan From and To must be within 8h-17h30");
                    System.out.print("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("The number must be input double");
                System.out.print("Enter again: ");
            }
        }
    }

    //kiểm tra đầu vào của người dùng một số nguyên
    public int checkInputInt() {
        //lặp lại cho đến khi người dùng nhập chính xác
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * check user input string
     *
     * @return
     */
    public String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = sc.nextLine().trim();
            if (result.matches("[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]")) {
                System.out.println("Input cannot contains special characters!");
            }
            if (result.isEmpty()) {
                System.out.println("Not empty!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    boolean checkDuplicate(String date, String assignee, double planFrom, double planTo) {
        boolean isExist = false;
        //loop use to access each element of arraylist from begining to the end
        for (Task task : m.getTaskList()) {
            //compare date in list with date input and assignee in list and assignee input
            if (date.equals(task.getDate()) && assignee.equals(task.getAssign())) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    public String checkDate() {
        String result = "";
        Date d;
        do {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
            sdfrmt.setLenient(false);
            String input = checkInputString();
            if (input.matches("\\\\d{1,2}[-]\\\\d{1,2}[-]\\\\d{4}")) {
                System.out.println("Input is Invalid Date format");
            } else {
                try {
                    d = sdfrmt.parse(input);
                    Date now = new Date();
                    if (d.before(now)) {
                        System.out.println("Date cannot be the past. Please enter again!");
                    } else {
                        break;
                    }
                } catch (ParseException ex) {
                    System.out.println("Date doesn't existed!!");
                }
            }
        } while (true);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        result = dateFormat.format(d);
        return result;
    }

    public String checkType(int check) {
        String[] strArr = {"Code", "Test", "Design", "Review"};
        String result = strArr[check - 1];
        return result;
    }

    public boolean checkEmpty() {
        if (m.getTaskList().isEmpty()) {
            return true;
        }
        return false;
    }

    public int findTask(int id) {
        for (int i = 0; i < m.getTaskList().size(); i++) {
            Task task = m.getTaskList().get(i);
            if (task.getID() == id) {
                return i;
            }
        }
        return -1;
    }

    public int checkID(String requirementName, int taskType, String date, double from, double to, String assignee) {
        int id = 0, count = 0;
        for (int j = 1;; ++j) {
            boolean valid = true;
            for (int i = 0; i < m.getTaskList().size(); i++) {
                Task a = m.getTaskList().get(i);
                if (a.getID() == j) {
                    valid = false;
                } else if (a.getName().equals(requirementName) && a.getDate().equals(date)
                        && a.getPlanFrom() == from && a.getPlanTo() == to && a.getAssign().equals(assignee)) {
                    count++;
                }
            }
            if (valid == true) {
                id = j;
                return id;
            } else if (count != 0) {
                break;
            }
        }
        return 0;
    }
}
