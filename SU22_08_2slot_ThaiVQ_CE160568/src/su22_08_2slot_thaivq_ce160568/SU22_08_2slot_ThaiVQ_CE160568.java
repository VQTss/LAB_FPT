
package su22_08_2slot_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class SU22_08_2slot_ThaiVQ_CE160568 {

    /**
     * @param args the command line arguments
     */
    private static Management am;
    private static ElementArray ae;
    public static void main(String[] args) {
         am = new Management();
        int n = am.inputSizeOfArray();
        am.inputValueOfArray(n);
        System.out.print("Unsorted array: ");
        am.printArray();
        System.out.print("Sorted array: ");
        am.Sort();
        am.printArray();
        int k  = am.inputSizeOfArray();
        am.search(k);
    }
    
}
