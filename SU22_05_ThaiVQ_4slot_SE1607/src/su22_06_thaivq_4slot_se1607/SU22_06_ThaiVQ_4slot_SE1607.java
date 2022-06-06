/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_06_thaivq_4slot_se1607;

/**
 *
 * @author thaiq
 */
public class SU22_06_ThaiVQ_4slot_SE1607 {

    /**
     * @param args the command line arguments
     */
    private static MatrixManagement matrix;

    public static void main(String[] args) {
        matrix = new MatrixManagement();
        matrix.inputMatrix(1);
        matrix.inputMatrix(2);
        int choice = 0;
        do {
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            choice = matrix.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    matrix.additionMatrix();
                    break;
                case 2:
                    matrix.subtractionMatrix();
                    break;
                case 3:
                    matrix.multiplicationMatrix();
                    break;
                case 4:
                    break;
            }
        } while (choice != 4);
    }

}
