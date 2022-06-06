package su22_09_thaivq_ce160568;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class Validate {

    private static final Scanner sc = new Scanner(System.in);
    private ArrayList<Double> newArr;

    //dispaly menu
    public int menu() {
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 3);
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
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("The number must be input double");
                System.out.print("Enter again: ");
            }
        }
    }

    //check number is odd or not
    public void checkOdd() {
        for (Double double1 : newArr) { // In phần tử lẽ trong arraylist ra ngoài
            System.out.print(double1 + " ");
        }
        System.out.println("");
    }

    //check number is even or not
    public void checkEven(double[] arr) {
        int n = arr.length;
        newArr = new ArrayList<>(); // khởi tạo arraylist rỗng
        for (int i = 0; i < n; i++) {
            if ((int) Math.abs(arr[i]) % 2 == 0) { // Kiểm tra số chẳn
                System.out.print(arr[i] + " "); // In số chẳn
            } else {
              newArr.add(Double.valueOf(arr[i]));   // Thêm phần tử lẻ vào arraylist
            }
        }
        System.out.println("");
    }

    //check number is squarenumber or not
    public void checkSquareNumber(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) { // Kiểm tra từng số có phải là square number
            if ((int) Math.sqrt(arr[i]) * (int) Math.sqrt(arr[i]) == arr[i]) {
                System.out.print(arr[i] + " "); // in ra  square number
            }
        }
        System.out.println("");
    }
}
