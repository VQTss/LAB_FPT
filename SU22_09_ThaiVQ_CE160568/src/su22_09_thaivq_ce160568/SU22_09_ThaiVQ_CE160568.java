package su22_09_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class SU22_09_ThaiVQ_CE160568 {

    /**
     * @param args the command line arguments
     */
    private static Validate v = new Validate();
    private static EquationNumber e = new EquationNumber();
    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            int choice = v.menu();
            switch (choice) {
                case 1:
                    e.superlativeEquation();
                    break;
                case 2:
                    e.quadraticEquation();
                    break;
                case 3:
                    return;
            }
        }
    }

}
