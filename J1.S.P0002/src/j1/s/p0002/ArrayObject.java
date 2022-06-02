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
public class ArrayObject {

    private int[] arr;

   

    /**
     * Lấy array
     *
     * @return
     */
    public int[] getArr() {
        return arr;
    }

    /**
     * set một array
     *
     * @param arr
     */
    public void setArr(int[] arr) {
        this.arr = arr;
    }
    

    public int radomINT(int min, int max) {
        // Tạo giá trị int ngẫu nhiên từ min đến max
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }


    //cho phép người dùng nhập số mảng
    public void inputValueOfArray(int n) {
        this.arr = new int[n];
        for (int i = 0; i < n; i++) {
            this.arr[i] = radomINT(1, n);
        }
    }

    public void selectionSort() {
        int indexMin, i, j;
        int n  = this.arr.length;
        // lap qua ta ca cac so
        for (i = 0; i <  n; i++) {
            // thiet lap phan tu hien tai la min
            indexMin = i;
            // kiem tra phan tu hien tai co phai la nho nhat khong
            for (j = i + 1; j < n; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                // Trao doi cac so
                int temp = arr[indexMin];
                arr[indexMin] = arr[i];
                arr[i] = temp;
            }
        }
    }
      // Xuất mảng
    public void printArray() {
        int n = this.arr.length;
        System.out.print("[");
        for (int i = 0; i < n; ++i) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println("]");
    }

}
