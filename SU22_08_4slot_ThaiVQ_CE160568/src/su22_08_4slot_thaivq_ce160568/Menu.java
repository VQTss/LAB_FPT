package su22_08_4slot_thaivq_ce160568;

import java.util.Scanner;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class Menu {

    private final static Scanner in = new Scanner(System.in);

    /**
     * check user input number limit
     * @param min
     * @param max
     * @return
     */
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
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    
    /**
     *check user input string
     * @return
     */
    public String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //show menu
    /**
     *
     * @return
     */
    public int menu() {
        System.out.println("1. Add worker.");
        System.out.println("2. Increase salary for worker.");
        System.out.println("3. Decrease for worker");
        System.out.println("4. Show adjusted salary worker information");
        System.out.println("5. Exist");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 5);
        return choice;
    }
}
