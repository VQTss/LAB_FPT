package su22_03_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class ElementArrays {

    private int numberOfArrays;
    private int[] arrayNumber;

    // Tạo một mảng
    public ElementArrays(int[] arrayNumber) {
        this.setNumberOfArrays(arrayNumber.length);
        this.setArrayNumber(arrayNumber);
    }
    // Lấy độ dài trong mảng

    public int getNumberOfArrays() {
        return numberOfArrays;
    }

    // Set độ dài của mảng
    public void setNumberOfArrays(int numberOfArrays) {
        this.numberOfArrays = numberOfArrays;
    }

    // Lấy các phần tử của mảng
    public int[] getArrayNumber() {
        return arrayNumber;
    }

    // Set các phần tử của mảng
    public void setArrayNumber(int[] arrayNumber) {
        this.arrayNumber = arrayNumber;
    }
}
