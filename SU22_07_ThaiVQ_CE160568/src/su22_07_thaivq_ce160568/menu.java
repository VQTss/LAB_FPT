package su22_07_thaivq_ce160568;

import java.util.Scanner;

/**
 *
 * @author thaiq
 */
public class menu {

    private final static Scanner in = new Scanner(System.in);
    
    //check user input number limit
    public int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) { // Kiểm tra dữ liệu vào có rỗng hay không
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check user input yes/ no
    public boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //display menu
    public int menu() {
        System.out.println("--------------------------------------------");
        System.out.println("1. Create a new account.");
        System.out.println("2. Login system.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 3);
        return choice;
    }
}
