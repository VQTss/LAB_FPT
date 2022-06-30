package su22_17_2slot_khoaqd_ce160561;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 
 */
public class Validate {

    private static final Scanner in = new Scanner(System.in);
    private static final String PHONE_VALID = "^\\d{9,10}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)$";

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
    public String checkInputDate() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); // định dạng data
                Date date = format.parse(result);
                // kiểm tra đúng định dạng hay không
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.out.println("Re-input");
                    System.out.print("Enter again: ");
                }
                // bắt lỗi exeception NumberFormatException và ParseException
            } catch (NumberFormatException ex) {
                System.out.println("Re-input");
                System.out.print("Enter again: ");
            } catch (ParseException ex) {
                System.out.println("Re-input");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     *
     * @return
     */
    public String checkInputPhone() {
        while (true) {
            String result = in.nextLine().trim();
            // kiểm tra độ dài và kiểm tra dữ liệu nhập vào có đúng với format  PHONE_VALID hay không
            if (result.length() != 0 && result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.out.println("Re-input");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     *
     * @return
     */
    public String checkInputEmail() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() != 0 && !validateEmail(result)) {
                return result;
            } else {
                System.out.println("Re-input");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     *
     * @param regex
     * @return
     */
    public boolean validateEmail(String regex) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX); // đoạn chuổi kiểm tra email
        Matcher matcher = pattern.matcher(regex); // kiểm tra regex nhập vào đúng định dạng trong đoạn chuổi kiểm tra email không
        return matcher.matches();
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

    // dùng để check kí tự đặt biệt và số 

    /**
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
     *
     * @param la
     * @return
     */
    public String checkInputUsername(ArrayList<Account> la) {
        while (true) {
            String result = checkInputString();
            for (int i = 0; i < la.size(); i++) {
                if (result.equalsIgnoreCase(la.get(i).getUsername())) {
                    System.out.println("Username exist!!!");
                    System.out.print("Enter again: ");
                }
            }
            return result;
        }
    }
    
    /**
     * kiểm tra nhập yes and no
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
}
