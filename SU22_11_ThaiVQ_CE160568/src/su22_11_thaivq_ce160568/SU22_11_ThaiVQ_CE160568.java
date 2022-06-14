package su22_11_thaivq_ce160568;

import java.util.Locale;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class SU22_11_ThaiVQ_CE160568 {

    /**
     * @param args the command line arguments
     */
    private static Validate v = new Validate();
    private static CheckProgram c = new CheckProgram();
    public static void main(String[] args) {
        Locale vietnamese = new Locale("vi");
        Locale english = Locale.ENGLISH;
        //loop until user want to exit
        while (true) {
            int choice = v.menu();
            switch (choice) {
                case 1:
                    c.login(vietnamese);
                    break;
                case 2:
                    c.login(english);
                    break;
                case 3:
                    return;
            }
        }
    }

}
