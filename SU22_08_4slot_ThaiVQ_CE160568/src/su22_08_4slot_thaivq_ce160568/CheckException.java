package su22_08_4slot_thaivq_ce160568;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class CheckException {

    private final static Scanner in = new Scanner(System.in);

    // check id must be existed in DB.
    public boolean checkIdExist(ArrayList<worker> lw, String id) {
        //check from first to last list id worker exist or not
        for (worker w : lw) {
            if (id.equalsIgnoreCase(w.getId())) {
                return true;
            }
        }
        return false;
    }

    //check salary must be greater than 0
    public int checkInputSalary() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Salary must be greater than 0");
                System.out.print("Enter again: ");
            }
        }
    }

//    check worker duplicate
    public boolean checkWorkerExist(ArrayList<worker> lw, String id,
            String name, int age, int salary, String workLocation) {
        //check from first to last list worker  worker exist or not
        for (worker w : lw) {
            if (id.equalsIgnoreCase(w.getId()) // Kiểm tra có worker trong mảng hay chưa để thêm vào
                    && name.equalsIgnoreCase(w.getName())
                    && age == w.getAge()
                    && salary == w.getSalary()) {
                return false;
            }
        }
        return true;
    }

    //get worker by code
    public  worker getWorkerByCode(ArrayList<worker> lw, String id) {
        for (worker w : lw) {
            if (id.equalsIgnoreCase(w.getId())) { // Kiểm tra có ID trong mảng hay không
                return w;
            }
        }
        return null;
    }
}
