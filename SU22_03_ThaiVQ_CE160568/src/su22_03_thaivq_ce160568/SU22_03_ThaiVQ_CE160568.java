package su22_03_thaivq_ce160568;

import java.util.Scanner;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class SU22_03_ThaiVQ_CE160568 {

    /**
     * @param args the command line arguments
     */
    private static ArraysManagement arrM;
    private static ElementArrays elementArrays;

    public static void main(String[] args) {
        arrM = new ArraysManagement();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean isValid = true;

        do {
            try {
                isValid = true;
                System.out.println("========= Bubble Sort program =========");
                System.out.println("1. Input Element");
                System.out.println("2. Sort Ascending");
                System.out.println("3. Sort Descending");
                System.out.println("4. Exit");
                System.out.print("Please choice one option: ");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        int n = 0;
                        do {
                            try {
                                isValid = true;
                                System.out.println("-------Input length of array-------");
                                System.out.print("Enter number: ");
                                n = sc.nextInt();
                                sc.nextLine();
                                if (n <= 0) {
                                    System.out.println("    Error: Please input a number greater than zero!");
                                    isValid = false;
                                }
                            } catch (Exception e) {
                                System.out.println("    Error: Please input a integer number!");
                                isValid = false;
                                sc.nextLine();
                            }
                        } while (isValid == false);
                        int[] arr = new int[n];
                        for (int i = 0; i < n; i++) {
                            System.out.printf("Enter number %d: ", (i + 1));
                            arr[i] = sc.nextInt();
                        }
                        elementArrays = new ElementArrays(arr);
                        if (arrM.chechIn(elementArrays.getArrayNumber()) != 0) {
                            System.out.println("Array cannot empty!");
                        }
                        break;
                    case 2:
                        System.out.println("----- Ascending -----");
                        arrM.sortAscending(elementArrays.getArrayNumber());
                        arrM.PrintArrays(elementArrays.getArrayNumber(), 1);
                        break;
                    case 3:
                        System.out.println("----- Descending -----");
                        arrM.sortDescending(elementArrays.getArrayNumber());
                        arrM.PrintArrays(elementArrays.getArrayNumber(), 2);
                        break;
                    case 4:
                        isValid = true;
                        System.out.println("Thank for using our software!\n"
                                + "See you again!");
                        break;
                    default:
                        System.out.println("Error: The function must be from 1 to 4!");
                        isValid = false;
                        break;
                }

            } catch (Exception e) {
                System.out.println("    Error: Please function must be a integer");
                isValid = false;
                sc.nextLine();
                break;
            }
        } while (isValid == false || choice != 4);

    }

}
