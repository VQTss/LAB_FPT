package su22_17_2slot_khoaqd_ce160561;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author
 */
public class Management {

    private static final Scanner in = new Scanner(System.in);
    static ArrayList<Account> list = new ArrayList<>();
    static Account a;
    static Validate v = new Validate();

    /**
     *
     * @param la
     * @return
     */
    public String checkInputUsername() {
        while (true) {
            String result = v.checkInputString();
            for (int i = 0; i < list.size(); i++) {
                if (result.equalsIgnoreCase(list.get(i).getUsername())) {
                    System.out.println("Username exist!!!");
                }
            }
            return result;
        }
    }

    /**
     * mã hóa password
     * @param password
     * @return
     */
    public String MD5Encryption(String password) {
        try {
            // Lớp MessageDigest này cung cấp các ứng dụng chức năng của thuật toán tiêu hóa tin nhắn, chẳng hạn như SHA-1 hoặc SHA-256.
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            return DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
        } catch (NoSuchAlgorithmException ex) {
            // ẩn khi một thuật toán mật mã cụ thể được yêu cầu nhưng không khả dụng trong môi trường
            ex.printStackTrace();
        }
        return null;
    }

    /**
     *
     */
    public void addAccount() {
        a = new Account();
        System.out.print("Enter Username: ");
        a.setUsername(checkInputUsername());
        System.out.print("Enter Password: ");
        a.setPassword(v.checkInputString());
        System.out.print("Enter Name: ");
        a.setName(v.checkInputString());
        System.out.print("Enter Phone: ");
        a.setPhone(v.checkInputPhone());
        System.out.print("Enter email: ");
        a.setEmail(v.checkInputEmail());
        System.out.print("Enter address: ");
        a.setAddress(v.checkInputString());
        System.out.print("Enter Date Of Birth: ");
        a.setDateOfBirth(v.checkInputDate());
        list.add(new Account(a.getUsername(), MD5Encryption(a.getPassword()), a.getName(), a.getPhone(), a.getEmail(),
                a.getAddress(), a.getDateOfBirth()));
        System.out.println("Add success!!!");
    }

    /**
     *
     */
    public void login() {
        if (list.isEmpty()) {
            System.out.println("Accout empty.");
            return;
        }
        System.out.print("Enter username: ");
        String username = v.checkInputString();
        System.out.print("Enter Password: ");
        String password = v.checkInputString();
        Account accoutLogin = findAccount(username, password); // đăng nhập
        if (accoutLogin != null) {
            System.out.println("Wellcome");
            System.out.print("Hi " + accoutLogin.getUsername()
                    + ", do you want chage password now? Y/N: ");
            changePassword(accoutLogin); // thay đổi mk
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public Account findAccount(String username,
            String password) {
        for (int i = 0; i < list.size(); i++) {
            Account ac = this.list.get(i);
            // tìm kiếm username và password trong arraylist
            if (username.equalsIgnoreCase(ac.getUsername())) {
                if (MD5Encryption(password).equalsIgnoreCase(ac.getPassword())) {
                    return ac;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param accoutLogin
     */
    public void changePassword(Account accoutLogin) {
        boolean choice = v.checkInputYN();

        if (choice) {
            System.out.print("Old password: ");
            String oldPassword = v.checkInputString();
            System.out.print("New password: ");
            String newPassword = v.checkInputString();
            System.out.print("Renew password: ");
            String renewPassword = v.checkInputString();
            // kiểm tra xem mk cũ có đsúng hay không
            if (MD5Encryption(oldPassword).equalsIgnoreCase(accoutLogin.getPassword()) == false) {
                System.out.println("Old password incorrect.");
            }
            // kiểm tra mật khẩu mới và re-mật khẩu mới có trùng với nhau hay không
            if (newPassword.equalsIgnoreCase(renewPassword) == false) {
                System.out.println("New password and Renew password not the same.");
            }
            // thay đổi maakt khẩu
            if (MD5Encryption(oldPassword).equalsIgnoreCase(accoutLogin.getPassword()) == true
                    && newPassword.equalsIgnoreCase(renewPassword) == true) {
                accoutLogin.setPassword(MD5Encryption(newPassword));
                System.out.println("Change password success");
            }
        }
    }

    /**
     *
     */
    public void display() {
        while (true) {
            System.out.println("1. Add user");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = v.checkIntLimit(1, 3);
            switch (choice) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    return;
            }
        }
    }

}
