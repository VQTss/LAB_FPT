package j1.s.p0068;

import java.util.Scanner;

/**
 *
 * @author thaiq
 */
public class J1SP0068 {

    /**
     * @param args the command line arguments
     */
    private static StudentManagement sm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====== Collection Sort Program ======");
        sm = new StudentManagement();
        sm.addStudent();
        do {
            System.out.print("Do you want to enter more student information?(Y/N): ");
            String check = sc.nextLine();
            if (check.equals('y') || check.equals("y")) {
                sm.addStudent();
            } else {
                break;
            }
        } while (true);
        sm.sortStudent();
        sm.display();
    }

}
