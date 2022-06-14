package su22_10_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class SU22_10_ThaiVQ_CE160568 {

    /**
     * @param args the command line arguments
     */
    private static Management m = new Management();
    private static Validate v = new Validate();

    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            int choice = v.menu();
            switch (choice) {
                case 1:
                    m.addTask();
                    break;
                case 2:
                    m.deleteTask();
                    break;
                case 3:
                    m.showTable();
                    break;
                case 4:
                    return;
            }
        }
    }
}
