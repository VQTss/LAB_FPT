package j1.s.p0055;

/**
 *
 * @author
 */
public class J1SP0055 {

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
                    m.addDoctor();
                    break;
                case 2:
                    m.updateDoctor();
                    break;
                case 3:
                    m.deleteDoctor();
                    break;
                case 4:
                    m.searchDoctor();
                    break;
                case 5:
                    return;
            }

        }
    }

}
