package j1.s.p0063;

import java.util.Scanner;
/**
 *
 * @author thaiq
 */
public class menu {

    private static final Scanner in = new Scanner(System.in);
    private static Managemet m = new Managemet();
    public String checkInputString() {
        //loop until user input true value
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public int checkInputInt(String str) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Input must be digit.");
                System.out.print(str);
            }
        }
    }

    public double checkInputSalary() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                if (result < 0) {
                    System.out.println("Salary is greater than zero");
                    System.out.print("Please input salary: ");
                } else {
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.out.println("You must input digidt.");
                System.out.print("Please input salary: ");
            }
        }
    }

    public int checkInputNumberStudent() {
        System.out.print("Enter number student: ");
        int n = checkInputInt("Enter number student: ");
        return n;
    }

    public void inputPersonInfo() {
        System.out.println("Input Information of Person");
        System.out.print("Please input name: ");
        String name = checkInputString();
        System.out.print("Please input address: ");
        String address = checkInputString();
        System.out.print("Please input salary: ");
        double salary = checkInputSalary();
        m.addPerson(new Person(name, address, salary)); // Thêm thông tin vào management
    }
}
