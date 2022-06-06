package su22_08_4slot_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class SU22_08_4slot_ThaiVQ_CE160568 {

    /**
     * @param args the command line arguments
     */
    private static Management m = new Management();
    private static Menu m1= new Menu();
    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            int choice = m1.menu();
            switch (choice) {
                case 1:
                    m.addWorker();
                    break;
                case 2:
                    m.changeSalary(1);
                    break;
                case 3:
                    m.changeSalary(2);
                    break;
                case 4:
                    m.printList();
                    break;
                case 5:
                    return;
            }
        }
    }

}
