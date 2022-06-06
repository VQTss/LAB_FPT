package su22_03_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class ArraysManagement {

    ElementArrays arrays;

    /**
     * Dùng để kiểm tra độ dài của mảng có lớn hơn 0
     *
     * @param inputVal
     * @return
     */
    public int chechIn(int[] inputVal) {
        if (inputVal.length > 0) {
            return 0;
        }
        return -1;
    }

    /**
     * Sắp xếp thep thứ tự tăng dần
     *
     * @param arr
     */
    public void sortAscending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean isChange = true; // Dùng để kiểm tra mảng đã sắp xếp hay chưa
            for (int j = 0; j < n - i - 1; j++) { // tại sao n - i - 1 vì phần tử j+1 < n nhưng
                // mỗi lần swap thì có 1 phần tử vào đúng chổ của nó nên j + 1< n - i
                if (arr[j] > arr[j + 1]) {
                    isChange = false;
                    // Đổi vị trí
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (isChange) { // nếu mảng không đổi vị trí thì thoát khỏi vòng lặp
                break;
            }
        }
        arrays = new ElementArrays(arr);

    }

    /**
     *
     * @param arr
     */
    public void sortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean isChange = true;
            for (int j = 0; j < n - i - 1; j++) {
                isChange = false;
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (isChange) {
                break;
            }
        }
        arrays = new ElementArrays(arr);

    }

    /**
     * In ra các phần tử trong mảng theo định dạng
     *
     * @param arr
     * @param sign
     */
    public void PrintArrays(int[] arr, int sign) {
        if (sign == 1) {
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    System.out.printf("[%d]\n", arr[i]);
                } else {
                    System.out.printf("[%d]->", arr[i]);
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    System.out.printf("[%d]\n", arr[i]);
                } else {
                    System.out.printf("[%d]<-", arr[i]);
                }
            }
        }
    }

}
