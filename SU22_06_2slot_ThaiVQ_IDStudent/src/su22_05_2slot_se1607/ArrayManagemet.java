package su22_05_2slot_se1607;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class ArrayManagemet {

    private static final Scanner in = new Scanner(System.in);
    ArrayObject arr;

    public int randInt(int min, int max) {
        // Tạo giá trị int ngẫu nhiên từ min đến max
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;
    }

    //kiểm tra đầu vào của người dùng một số nguyên
    public int checkInputInt() {
        //lặp lại cho đến khi người dùng nhập chính xác
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    //cho phép người dùng nhập số mảng
    public int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        int n = checkInputInt();
        return n;
    }

    //cho phép người dùng nhập số mảng
    public void inputValueOfArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = randInt(1, n);
        }
        arr = new ArrayObject(a);

    }

    public void Sort() {
        int n = arr.getArr().length;
        // Duyệt qua từng phần tử của mảng
        int tmp; // biến tạm
        //Vòng lặp
        for (int i = 0; i < arr.getArr().length - 1; ++i) {
            for (int j = 0; j < arr.getArr().length - i - 1; ++j) {
                if (arr.getArr()[j] > arr.getArr()[j + 1]) {
                    // Hoán đổi 2 phần tử
                    tmp = arr.getArr()[j];
                    arr.getArr()[j] = arr.getArr()[j + 1];
                    arr.getArr()[j + 1] = tmp;
                }
            }
        }
    }

    // Xuất mảng
    public void printArray() {
        int n = arr.getArr().length;
        System.out.print("[");
        for (int i = 0; i < n; ++i) {
            System.out.print(arr.getArr()[i] + " ");
        }
        System.out.println("]");
    }

}
