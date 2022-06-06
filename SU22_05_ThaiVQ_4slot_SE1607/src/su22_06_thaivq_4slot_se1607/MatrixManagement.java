package su22_06_thaivq_4slot_se1607;

import java.util.Scanner;

/**
 *
 * @author thaiq
 */
public class MatrixManagement {

    private static final Scanner sc = new Scanner(System.in);
    private Matrix matrix1;
    private Matrix matrix2;

    /**
     * Kiểm tra giá trị nhập vào có phải số nguyên hay không
     *
     * @param i
     * @param j
     * @return
     */
    public int checkInputInt(int i, int j) {
        while (true) {
            while (true) {
                try {
                    int result = Integer.parseInt(sc.nextLine());
                    return result;
                } catch (NumberFormatException ex) {
                    System.err.println("Error: Value of matrix is digit!");
                    System.out.print("Enter Matrix" + "[" + (i) + "]" + "[" + (j) + "]:");
                }
            }
        }
    }

    /**
     * Kiểm tra hàng và cột phải là số nguyên
     *
     * @return
     */
    public int checkInputInt() {
        while (true) {
            while (true) {
                try {
                    int result = Integer.parseInt(sc.nextLine());
                    return result;
                } catch (NumberFormatException ex) {
                    System.err.println("Error: The input must be a integer!");

                }
            }
        }

    }

    /**
     * Hàm dùng cho hàm main dùng để chọn chức năng
     *
     * @param min
     * @param max
     * @return
     */
    public int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Error: Value of matrix is digit!");
            }
        }
    }

    /**
     * Hàm nhập giá trị của ma trận
     *
     * @param n
     */
    public void inputMatrix(int n) {
        if (n == 1) {
            System.out.print("Enter Row Matrix: ");
            int row = checkInputInt();
            System.out.print("Enter Colum Matrix: ");
            int col = checkInputInt();
            int[][] matrix = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]: ");
                    matrix[i][j] = checkInputInt(i + 1, j + 1);
                }
            }
            matrix1 = new Matrix(row, col, matrix);
        } else {
            System.out.print("Enter Row Matrix: ");
            int row = checkInputInt();
            System.out.print("Enter Colum Matrix: ");
            int col = checkInputInt();
            int[][] matrix = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]: ");
                    matrix[i][j] = checkInputInt();
                }
            }
            matrix2 = new Matrix(row, col, matrix);
        }

    }

    /**
     * In ra ma trận
     *
     * @param a
     */
    public void displayMatrix(int[][] a) {
        int row = a.length;
        int col = a[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + a[i][j] + "]");
            }
            System.out.println();
        }
    }

    /**
     * Hàm cộng 2 ma trận
     */
    public void additionMatrix() {
        displayMatrix(matrix1.getA());
        System.out.println("+");
        displayMatrix(matrix2.getA());
        System.out.println("=");
        int row = matrix1.getRowNum();
        int col = matrix1.getColNum();
        int[][] C = new int[row][col]; // Hàm để chứa giá trị khi côngj
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                C[i][j] = matrix1.getA()[i][j] + matrix2.getA()[i][j];
            }
        }
        displayMatrix(C);
    }

    /**
     * Hàm trừ 2 ma trận
     */
    public void subtractionMatrix() {
        displayMatrix(matrix1.getA());
        System.out.println("-");
        displayMatrix(matrix2.getA());
        System.out.println("=");
        int row = matrix1.getRowNum();
        int col = matrix1.getColNum();
        int[][] C = new int[row][col]; // hàm dùng để chứa giá trị khi trừ
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                C[i][j] = matrix1.getA()[i][j] - matrix2.getA()[i][j];
            }
        }
        displayMatrix(C);
    }

    /**
     * Nhân 2 ma trận
     */
    public void multiplicationMatrix() {
        displayMatrix(matrix1.getA());
        System.out.println("*");
        displayMatrix(matrix2.getA());
        System.out.println("=");
        int row1 = matrix1.getRowNum();
        int col1 = matrix1.getColNum();
        int row2 = matrix2.getRowNum();
        int col2 = matrix2.getColNum();
        if (col1 != row2) { // Kiểm tra xem số cột của ma trận 1 có bằng số với số hàng của ma trận 2 
            // Vì quy định khi nhân 2 ma trận
            System.out.println("Can't multiple");
        } else {
            int[][] C = new int[row1][col2];
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    C[i][j] = 0;
                    for (int k = 0; k < col1; k++) {
                        C[i][j] = matrix1.getA()[i][k] * matrix2.getA()[k][j];
                    }
                }
            }
            displayMatrix(C);
        }
    }

}
