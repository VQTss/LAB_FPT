
package j1.s.p0002;

/**
 *
 * @author
 */
public class J1SP0002 {

    /**
     * @param args the command line arguments
     */
    private static menu m;
    private static ArrayObject arrO;

    public static void main(String[] args) {
        m = new menu();
        arrO = new ArrayObject();
        int n = m.inputSizeOfArray();
        arrO.inputValueOfArray(n);
        System.out.print("Unsorted array: ");
        arrO.printArray();
        System.out.print("Sorted array: ");
        arrO.selectionSort();
        arrO.printArray();
    }

}
