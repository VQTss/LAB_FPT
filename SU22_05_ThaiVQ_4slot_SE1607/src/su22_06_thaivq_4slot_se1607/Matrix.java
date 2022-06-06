package su22_06_thaivq_4slot_se1607;

/**
 *
 * @author thaiq
 */
public class Matrix {

    private final int SIZE = 50;

    // Thuoc tinh
    private int rowNum; // so hang
    private int colNum; // so cot
    private int[][] a;

    public Matrix(int rowNum, int colNum, int[][] a) {
        if (rowNum > SIZE || this.colNum > SIZE) {
            System.out.println("SIZE cannot greater than 50");
        } else {
            this.rowNum = rowNum;
            this.colNum = colNum;
            this.setA(a);
        }

    }

    // Phuong thuc
    // Ham khoi tao khong doi so
    public Matrix() {

    }
    // Lấy ma trận
    public int[][] getA() {
        return a;
    }
    // Hàm đặt giá trị cho ma trận
    public void setA(int[][] a) {
        this.a = a;
    }

    // Ham lay thong tin so hang
    public int getRowNum() {
        return this.rowNum;
    }

    // Ham lay thong ton so cot
    public int getColNum() {
        return this.colNum;
    }
}
