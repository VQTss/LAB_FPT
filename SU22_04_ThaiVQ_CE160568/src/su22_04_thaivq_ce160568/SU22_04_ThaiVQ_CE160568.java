/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_04_thaivq_ce160568;

import java.util.Scanner;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class SU22_04_ThaiVQ_CE160568 {

    private static ManageEastAsiaCountries meac;

    /**
     *
     * @return
     */
    public static String printChar() {
        String t = "";
        for (int i = 0; i < 30; i++) {
            t += "=";
        }
        return t;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isValid = true;
        int choice = 0;
        meac = new ManageEastAsiaCountries();
        do {
            System.out.printf("%30sMenu%30s\n", " ", " ");
            System.out.printf("%s%s\n", printChar(), printChar());
            System.out.println("1. Input the information of 11 countries in East Asian");
            System.out.println("2. Display the information of country you've just input");
            System.out.println("3. Search the information of country by user-entered name");
            System.out.println("4. Display the information of contries sorted name in ascending order");
            System.out.println("5. Exits");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    do {
                        isValid = true;
                        String code, name, terrain;
                        float totalArea;
                        System.out.print("Enter code of country: ");
                        code = sc.nextLine().trim();
                        System.out.print("Enter name of country: ");
                        name = sc.nextLine().trim();
                        System.out.print("Enter total area: ");
                        totalArea = sc.nextFloat();
                        sc.nextLine();
                        System.out.print("Enter terrian of country: ");
                        terrain = sc.nextLine().trim();
                        boolean check = meac.addCountryInformation(new EastAsiaCountries(code, name, totalArea, terrain));
                        if (check == false) {
                            System.out.println("The total area must be greater than 0!");
                            isValid = false;
                        }
                    } while (isValid == false);
                    break;
                case 2:
                    EastAsiaCountries meac1 = meac.getRecentlyEnteredInformation();
                    meac.showCountry(meac1.getCountryCode(), meac1.getCountryName(), String.valueOf(meac1.getTotalArea()), meac1.getCountryTerrain());
                    break;
                case 3:

                    System.out.print("Enter the name you want to search for: ");
                    String name = sc.nextLine().trim();
                    EastAsiaCountries meac2 = meac.searchInformationByName(name);
                    meac.showCountry(meac2.getCountryCode(), meac2.getCountryName(), String.valueOf(meac2.getTotalArea()), meac2.getCountryTerrain());
                    break;
                case 4:
                    meac.sortInformationByAscendingOrder();
                    meac.showCountry();
                    break;
                case 5:
                    isValid = true;
                    System.out.println("\n--------------------");
                    System.out.println("Thanks for using our software!\n"
                            + "See you again!");
                    break;
            }

        } while (isValid == false || choice != 5);

    }

}
