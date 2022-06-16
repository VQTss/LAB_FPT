
package su22_12_thaivq_ce160568;

/**
 *
 * @author Vo Quoc Thai CE160568
 */
public class SU22_12_ThaiVQ_CE160568 {

    /**
     * @param args the command line arguments
     */
    private static Management m = new Management();
    private static Validate v = new Validate();
    public static void main(String[] args) {
        while (true) {
            int choice = v.menu();
            switch (choice) {
                case 1:
                    m.addContact();
                    break;
                case 2:
                     m.displayAll();
                    break;
                case 3:
                   m.deleteContact();
                    break;
                case 4:
                    return;
            }
        }
    }
    
}
