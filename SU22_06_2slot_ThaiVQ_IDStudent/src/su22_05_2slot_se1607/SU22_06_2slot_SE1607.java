package su22_05_2slot_se1607;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class SU22_06_2slot_SE1607 {

    /**
     * @param args the command line arguments
     */
    private static ArrayManagemet am;
    private static ArrayObject ao;

    public static void main(String[] args) {
        am = new ArrayManagemet();
        int n = am.inputSizeOfArray();
        am.inputValueOfArray(n);
        System.out.print("Unsorted array: ");
        am.printArray();
        System.out.print("Sorted array: ");
        am.Sort();
        System.out.println("Enter search value: ");
        
        
        am.printArray();
    }

}
