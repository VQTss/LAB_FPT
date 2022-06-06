package su22_02_thaivq_ce160568;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Thai Vo Quoc CE160568
 */
public class SU22_02_ThaiVQ_CE160568 {

    /**
     * @param args the command line arguments
     */
    private static FileManagement fm;

    public static void main(String[] args) throws IOException {
        fm = new FileManagement();
        Scanner sc = new Scanner(System.in);
        boolean isVaild = true;
        int choice = 0;
        do {
            isVaild = true;
            System.out.println("====== Format CSV Program ======");
            System.out.println("1.Import CSV");
            System.out.println("2.Format Address");
            System.out.println("3.Fortmat Name");
            System.out.println("4.Export CSV");
            System.out.println("5.Exit");
            System.out.print("Please choice one option: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    do {
                        isVaild = true;
                        System.out.print("Enter path: ");
                        String path = sc.nextLine();
                        FileCSV fcsv = new FileCSV(path); // Tạo đường dẫn
                        try {
                            // Nhập đường dẫn lấy từ fcsv
                            fm.importCSV(fcsv.getPathFile());
                        } catch (FileException ex) {
                            // Xác định có xuất hiện lỗi hay không
                            System.out.println(ex.getMessage());
                            isVaild = false;
                            sc.nextLine();
                        }
                    } while (isVaild == false);
                    break;
                case 2:
                    System.out.println("Format Address");
                    try {
                        fm.formatAddress();
                    } catch (FileException ex) {
                        ex.getMessage();
                    }

                    break;
                case 3:
                    System.out.println("Format Name");
                    try {
                        fm.formatName();
                    } catch (FileException ex) {
                        ex.getMessage();
                    }
                    break;
                case 4:
                    do {
                        isVaild = true;
                        System.out.print("Enter path: ");
                        String path = sc.nextLine();
                        FileCSV fcsv = new FileCSV(path);
                        try {
                            fm.exportCSV(fcsv.getPathFile());
                        } catch (FileException ex) {
                            System.out.println(ex.getMessage());
                            isVaild = false;
                            sc.nextLine();
                        }
                    } while (isVaild == false);
                    break;
                case 5:
                    isVaild = true;
                    System.out.println("Thank for using our software!\n"
                            + "See you again!");
                    break;
            }

        } while (isVaild == false || choice != 5);
    }

}
