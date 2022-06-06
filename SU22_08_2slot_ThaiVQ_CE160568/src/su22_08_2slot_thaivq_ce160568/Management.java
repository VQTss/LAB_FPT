package su22_08_2slot_thaivq_ce160568;

import java.util.Scanner;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class Management {

    private static final Scanner in = new Scanner(System.in);
    ElementArray arr;

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
                System.out.println("Please input number");
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
        arr = new ElementArray(a);

    }

    public void Sort() {
        int n = arr.getArr().length;
        // Duyệt qua từng phần tử của mảng
        for (int i = 0; i < n - 1; i++) {
            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr.getArr()[j] < arr.getArr()[min_idx]) {
                    min_idx = j;
                }
            }
            // Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
            int temp = arr.getArr()[min_idx];
            arr.getArr()[min_idx] = arr.getArr()[i];
            arr.getArr()[i] = temp;
        }
    }

    public void search(int k) {
        int d = 0;
        int  c = arr.getArr().length - 1;
        int l;
        // duyệt vòng lặp while
        // nếu d còn nhỏ hơn hoặc bằng c thì còn tiếp tục thực hiện thân vòng lặp
        while (d <= c) {
            l = (d + c) / 2;

            // nếu phần tử tại vị trí j bằng số nguyên k cần tìm
            // thì thông báo tìm thấy số k tại vị trí j
            // và kết thúc vòng lặp
            if (arr.getArr()[l] == k) {
                System.out.println("Find " + k + " at index " + l);
                return; // kết thúc vòng lặp while và bỏ qua các lệnh bên dưới
            } else if (arr.getArr()[l] < k) {
                // nếu phần tử tại l nhỏ hơn số nguyên k
                // thì tăng d = l + 1
                // và quay lại thực hiện vòng lặp while
                d = l + 1;
            } else {
                // nếu phần tử tại l lớn hơn số nguyên k
                // thì giảm c = l - 1
                // và quay lại thực hiện vòng lặp while
                c = l - 1;
            }
        }

        // nếu sau khi thực hiện vòng lặp while
        // mà không tìm thấy số cần tìm
        // thì hiển thị thông báo không tìm thấy
        System.out.println("Not found!");
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
