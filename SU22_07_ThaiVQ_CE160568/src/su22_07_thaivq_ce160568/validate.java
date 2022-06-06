package su22_07_thaivq_ce160568;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author thaiq
 */
public class validate {

    private final static String VALID_USERNAME = "^\\S{5}\\S*$"; // check user name have >= 5 charactor
    private final static String VALID_PASSWORD = "^\\S{6}\\S*$"; // check password have >= 6 charactor
    menu m = new menu();

    //check file data exist or not
    public boolean checkFileExist() {
        File file = new File("user.dat");
        if (!file.exists()) {
            try {
                System.out.println("File not exist!!!"); // thông báo file không tồn tại
                file.createNewFile(); // tạo file mới
                System.out.println("File created.");
                return false;
            } catch (IOException ex) {
                ex.printStackTrace(); // bắt ngoại lệ nếu xảy ra lỗi
            }
        }
        return true;
    }

    //allow user input username
    public String checkInputUsername() {
        System.out.print("Enter username: ");
        //loop until user input correct
        while (true) {
            String result = m.checkInputString();
            if (result.matches(VALID_USERNAME)) { // kiểm tra dữ liệu có đúng theo yêu cầu không
                return result;
            }
            System.out.println("You must enter least at 5 character, and no space!");
            System.out.print("Enter again: ");
        }
    }

    //allow user input password
    public String checkInputPassword() {
        System.out.print("Enter password: ");
        //loop until user input correct
        while (true) {
            String result = m.checkInputString();
            if (result.matches(VALID_PASSWORD)) { // kiểm tra dữ liệu có đúng theo yêu cầu không
                return result;
            }
            System.out.println("You must enter least at 6 character, and no space!");
            System.out.print("Enter again: ");
        }
    }

    //check username exist
    public boolean checkUsernameExist(String username) {
        File file = new File("user.dat"); // đọc dữ liệu từ file
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0])) { // kiểm tra dữ liệu có trùng trong file hay không
                    return false;
                }
            }
            bufferedReader.close(); // đóng file
            fileReader.close(); // đóng file
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    //get password by username
    public String passwordByUsername(String username) {
        File file = new File("user.dat");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";"); // Cắt chuổi thành mảng
                if (username.equalsIgnoreCase(account[0])) { // kiểm tra username có hợp lệ hay không
                    return account[1];
                }
            }
            bufferedReader.close(); // đóng file
            fileReader.close(); // đóng file
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(); // ngoại lệ
        } catch (IOException ex) {
            ex.printStackTrace(); // ngoại lệ
        }
        return null;
    }
}
