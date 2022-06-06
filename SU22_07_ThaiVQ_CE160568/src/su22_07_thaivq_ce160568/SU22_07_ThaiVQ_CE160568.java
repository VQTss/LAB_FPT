package su22_07_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc
 */
public class SU22_07_ThaiVQ_CE160568 {

    /**
     * @param args the command line arguments
     */
    private static Management management = new Management(); // tạo đối tượng management
    private static menu m = new menu(); // tạo đối tượng menu

    public static void main(String[] args) {
        // loop until user want to exit
        while (true) {
            int choice = m.menu();
            switch (choice) {
                case 1:
                    management.createNewAccount();
                    break;
                case 2:
                    management.loginSystem();
                    break;
                case 3:
                    return;
            }
        }

    }
}
