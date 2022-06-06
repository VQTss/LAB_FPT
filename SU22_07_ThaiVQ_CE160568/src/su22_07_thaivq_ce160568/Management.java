package su22_07_thaivq_ce160568;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author thaiq
 */
public class Management {

    validate v = new validate();
    Account a;

    //create a new account
    public void createNewAccount() {
        //check file data exist or not
        if (!v.checkFileExist()) { // kiểm tra file có tồn tại hay không
            return;
        }
        String username = v.checkInputUsername();
        String password = v.checkInputPassword();
        //check username exist or not
        if (!v.checkUsernameExist(username)) { // kiểm tra username có trùng trong file hay khống
            System.out.println("Username exist.");
            return;
        }
        a = new Account(username, password); // tạo đối tượng account
        addAccountData(); // Thêm account
    }

    //login system
    public void loginSystem() {
        //check file data exist or not
        if (!v.checkFileExist()) { // Kiểm tra file có tồn tại hay không
            return;
        }
        String username = v.checkInputUsername(); // nhập userame
        String password = v.checkInputPassword(); // nhập password
        //check username exist or not
        if (!v.checkUsernameExist(username)) {
            if (!password.equalsIgnoreCase(v.passwordByUsername(username))) { // kiểm tra password có trùng khớp hay không
                System.out.println("Password incorrect.");
            }
            System.out.println("Login success.");
        }
    }

    //write new account to data
    public void addAccountData() {
        File file = new File("user.dat");
        try {
            FileWriter fileWriter = new FileWriter(file, true); // Thêm acc mới vào file
            fileWriter.write(a.getUserName() + ";" + a.getPassword() + "\n"); // viết account mới vào file
            fileWriter.close(); // đóng file
            System.out.println("Create successly.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
