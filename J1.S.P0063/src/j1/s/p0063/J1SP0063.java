package j1.s.p0063;

/**
 *
 * @author thaiq
 */
public class J1SP0063 {

    /**
     * @param args the command line arguments
     */
    private static menu m = new menu();
    private static Managemet managemet = new Managemet();

    public static void main(String[] args) {
        int n = m.checkInputNumberStudent();
        for (int i = 0; i < n; i++) {
            m.inputPersonInfo();
        }
        managemet.sortBySalary();
        managemet.displayPersonInfo4();
    }
    
}
