/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0002;

import java.util.Scanner;

/**
 *
 * @author 
 */
public class menu {
    private static final Scanner in = new Scanner(System.in);
    //kiểm tra đầu vào của người dùng một số nguyên
    public int checkInput() {
        //lặp lại cho đến khi người dùng nhập chính xác
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    //cho phép người dùng nhập số mảng
    public int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        int n = checkInput();
        return n;
    }
}
