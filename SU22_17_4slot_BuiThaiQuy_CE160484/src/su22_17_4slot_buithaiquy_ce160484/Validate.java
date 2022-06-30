package su22_17_4slot_buithaiquy_ce160484;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author
 */
public class Validate {

    private static final Scanner in = new Scanner(System.in);

    /**
     *
     * @param min
     * @param max
     * @return
     */
    public int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.out.println("Re-input");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     *
     * @return
     */
    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.out.println("Not empty");
            } else if (!isValidName(result)) {
                System.out.println("Re-input");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * dùng để check kí tự đặt biệt và số
     *
     * @param name
     * @return
     */
    public boolean isValidName(String name) {
        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~"; // đoạn chuổi dùng để check
        String str2[] = name.split(""); // cắt chuổi thành một mảng
        int count = 0;
        for (int i = 0; i < str2.length; i++) { // đi qua từng index trong mảng str2
            if (specialCharacters.contains(str2[i])) { // kiểm tra từ kí tự có nằm trong  specialCharacters không
                count++;
            }
        }

        if (name != null && count == 0) { // trả về đúng khi khong có chứa kí đặt biệt và số
            return true;
        } else { // ngược lạis
            return false;
        }
    }

    /**
     * kiểm tra nhập yes and no
     *
     * @return
     */
    public boolean checkInputYN() {
        while (true) {
            String result = in.nextLine();
            if (result.length() == 1 && result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.length() == 1 && result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Re-input.");
            System.out.print("Enter again: ");
        }
    }

    /**
     *
     * @return
     */
    public String checkInputStringPass() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (!Password_Validation(result)) { // kiểm tra có chứa kí tự đặt biệt và số hay không
                System.out.println("Input must contain at least 6 characters, including uppercase letters, lower case \n"
                        + "letters, numeric characters and 1 special character.!");
                System.out.print("Enter again: ");
            } else if (result.isEmpty()) {
                System.out.println("Not empty!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     *
     * @param password
     * @return
     */
    public boolean Password_Validation(String password) {

        if (password.length() >= 6) {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            //Pattern eight = Pattern.compile (".{8}");

            Matcher hasLetter = letter.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            return hasLetter.find() && hasDigit.find() && hasSpecial.find();

        } else {
            return false;
        }

    }
    
     //check user input double

    /**
     *
     * @return
     */
    public double checkInputDouble() {
        //loop until user input correct
        while (true) {
            try {
                String str = checkInputString();
                double result = Double.parseDouble(str);
                return result;
            } catch (NumberFormatException e) {
                System.out.println("The number must be input double");
                System.out.print("Enter again: ");
            }
        }
    }
    
}
