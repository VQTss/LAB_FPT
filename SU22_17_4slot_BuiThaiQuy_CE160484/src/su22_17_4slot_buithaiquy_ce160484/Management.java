package su22_17_4slot_buithaiquy_ce160484;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author
 */
public class Management {

    ArrayList<Account> accounts; // lưu trữ account
    private int numberOfAccount; // điếm số lượng account lưu 
    static Account a;
    static Validate v = new Validate();
    boolean status = false; // kiểm tra trạng thái đăng nhập hay chưa
    Account accoutLogin;
    

    /**
     * hàm khởi tạo Management
     */
    public Management() {
        this.accounts = new ArrayList<>();
        this.numberOfAccount = 0;
    }

    /**
     * tạo acccount mới
     * @return
     */
    public int CreateNewAccount() {
        a = new Account();
        System.out.print("Enter username: ");
        a.setUserName(v.checkInputString()); // đăng kí username
        System.out.print("Enter password: ");
        a.setPassword(v.checkInputStringPass()); // đănh kí password
        System.out.print("Enter confirm password: ");
        while (true) {
            String confirm = v.checkInputStringPass(); // xác nhận password
            if (a.getPassword().equals(confirm)) { // kiểm tra password confirm có trùng với passoword không
                // nếu đúng thì break, không thì nhập lại
                break;
            } else {
                System.out.println("Re-input");
                System.out.print("Enter again: ");
            }
        }
        System.out.print("Enter money for account: ");
        a.setMoney(v.checkInputDouble()); // nhập số tiền cho account
        int id = 0, count = 0;
        // mã ngân hàng tự động
        for (int j = 1;; ++j) {
            boolean valid = true;
            for (int i = 0; i < this.accounts.size(); i++) {
                Account a = this.accounts.get(i);
                if (a.getIDBank().equals("IDBank" + String.valueOf(j))) {
                    valid = false;
                }
            }
            if (valid == true) {
                id = j;
                a.setIDBank("IDBank" + j); // set mã ngân hàng
                this.accounts.add(new Account(a.getIDBank(), a.getUserName(), MD5Encryption(a.getPassword()), a.getMoney()));
                System.out.println("Create account succes: " + a.getIDBank());
                break;
            }
        }
        return ++numberOfAccount; // cộng số lượng account
    }

    /**
     *
     * @return
     */
    public int getNumberOfAccount() {
        return numberOfAccount;
    }

    /**
     * đăng nhập
     */
    public void login() {
        this.status = false;
        if (accounts.isEmpty()) { // kiểm tra danh sách account có rỗng hay khong
            System.out.println("Accout empty.");
            this.status = false;
            return;
        }
        System.out.print("Enter username: ");
        String username = v.checkInputString(); // đăng nhập user name
        System.out.print("Enter Password: ");
        String password = v.checkInputStringPass(); // đăng nhập password
        accoutLogin = findAccount(username, password); // đăng nhập
        if (accoutLogin == null) { // đăng nhập không thành công và báo lỗi
            System.out.println("Invalid username or password.");
            this.status = false;
        } else {
            this.status = true; // kiểm tra đã đăng nhập
        }
    }

    /**
     * đăng nhập
     * @param username
     * @param password
     * @return
     */
    public Account findAccount(String username, String password) {
        for (int i = 0; i < accounts.size(); i++) {
            Account ac = this.accounts.get(i);
            // tìm kiếm username và password trong arraylist
            if (username.equals(ac.getUserName())) { // kiểm tra userName có trùng với userName nào trong accounts hay không
                if (MD5Encryption(password).equals(ac.getPassword())) { // mã hóa password truyền vào và so sánh với password trong accounts
                    return ac;
                } else {
                    return null; // nếu không sai mật khẩu
                }
            }
        }
        return null; // username không tồn tại
    }

    /**
     * tìm kiếm account bằng id ngân hàng
     * @param id
     * @return
     */
    public Account findAccount(String id) {
        System.out.println(id);
        for (int i = 0; i < this.accounts.size(); i++) {
            Account ac = this.accounts.get(i);
            if (id.equals(ac.getIDBank())) { // kiểm tra ID có trùng với id ngân hàng nào trong accounts hay không
                return ac;
            }
        }
        return null; // không tìm thấy
    }

    /**
     * mã hóa password
     *
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
     *  rút tiền
     */
    public void withdrawAccount() {
        // kiểm tra đã đăng nhập chưa
        if (status) { // nếu có
            System.out.println("Money of account: " + accoutLogin.getMoney()); // hiển thị số tiền trong tài khoản
            System.out.print("Enter the amount money want to withdraw: ");
            double withdraw = v.checkInputDouble(); // nhập số tiền muốn rút
            accoutLogin.setMoney(accoutLogin.getMoney() - withdraw); // trừ số tiền muốn rút vào tài khoản
            System.out.println("Money of account: " + accoutLogin.getMoney()); // hiển thị số tiền trong tài khoản
            System.out.println("Success.");
        } else { // nếu chưa đăng nhập. yêu cầu đăng nhập
            System.out.println("Please login account or create new a account.");
        }
    }

    /**
     * nạp tiền
     */
    public void depositAccount() {
        // kiểm tra đã đăng nhập chưa
        if (status) { // nếu có
            System.out.println("Money of account: " + accoutLogin.getMoney()); // hiển thị số tiền trong tài khoản
            System.out.print("Enter the amount money want to deposit: ");
            double deposit = v.checkInputDouble();// nhập số tiền muốn nạp
            System.out.print("Do you want to deposit(Y/N)? ");
            // xác nhận có muốn nạp không
            if (v.checkInputYN()) { // nếu có
                accoutLogin.setMoney(accoutLogin.getMoney() + deposit); // công số tiền vào tài khoản
                System.out.println("Money of account: " + accoutLogin.getMoney()); // hiển thị số tiền trong tài khoản
                System.out.println("Success.");
            } else { // nếu không
                System.out.println("Thanks");
            }
        } else { // nếu không
            System.out.println("Please login account or create new a account.");
        }
    }

    /**
     * chuyển tiền qua tài khoản
     */
    public void transferMoney() {
        // kiểm tra đã đăng nhập chưa
        if (status) { // nếu có
            System.out.print("Enter the receive account: ");
            String id = v.checkInputString(); // nhập tên tài khoản nhận
            Account a = findAccount("IDBank" + id); // tìm kiếm tài khoản nhận
            if (a != null) { // nếu có
                System.out.println("Money of  account: " + accoutLogin.getMoney()); // hiển thị số tiền trong tài khoản
                System.out.print("Enter amount money want to transfer: ");
                double money = v.checkInputDouble(); // nhập số tiền muốn chuyển
                accoutLogin.setMoney(accoutLogin.getMoney() - money); // trừ số tiền muốn chuyển vào tài khoản
                a.setMoney(a.getMoney() + money); // công số tiền chuyển vào tài khoản nhận
                System.out.println("Money of account: " + accoutLogin.getMoney()); // hiển thị số tiền trong tài khoản
                System.out.println("Succes.");
            } else { // nếu không
                System.out.println("Fail.");
            }
        } else { // nếu không
            System.out.println("Please login account or create new a account.");
        }
    }

    /**
     *
     */
    public void deleteAccount() {
        if (status) {
            System.out.print("Are you really want to remove account?");
            if (v.checkInputYN()) {
                this.accounts.remove(accoutLogin);
                System.out.println("Delete succes.");
            } else {
                System.out.println("Delete fail.");
            }
        } else {
            System.out.println("Please login account or create new a account.");
        }
    }

    public void display() {
        while (true) {
            System.out.println("1. Add user");
            System.out.println("2. Login");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. Transfer");
            System.out.println("6. Remove");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = v.checkIntLimit(1, 7);
            switch (choice) {
                case 1:
                    CreateNewAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    withdrawAccount();
                    break;
                case 4:
                    depositAccount();
                    break;
                case 5:
                    transferMoney();
                    break;
                case 6:
                    deleteAccount();
                    break;
                case 7:
                    return;
            }
        }
    }

    public void loadAccount() throws IOException {
        File bookFile = new File("bank.dat");
        if (!bookFile.exists()) {
            bookFile.createNewFile();
            System.out.printf("The data file bank.dat" + " is not exits. "
                    + "Creating new data file bank.dat" + "... Done!\n");
        } else {
            System.out.printf("\nThe data file bank.dat" + " is found."
                    + " Data of account is loading... ");

            String Id, userName, password, money;
            try (BufferedReader br = new BufferedReader(new FileReader("bank.dat"))) {
                this.numberOfAccount = Integer.parseInt(br.readLine());
                for (int i = 0; i < this.numberOfAccount; i++) {
                    Id = br.readLine();
                    userName = br.readLine();
                    password = br.readLine();
                    money = br.readLine();
                    this.accounts.add(new Account(Id, userName, password, Double.parseDouble(money)));
                }
            }
            System.out.println("Done! [" + this.numberOfAccount + " accounts]");
        }
    }

    public void saveBook() throws IOException {
        // Overwrite data file
        FileWriter fw = new FileWriter(new File("bank.dat"));
        try {
            System.out.print("Account is saving into data file bank.dat...");
            // Writes number of comic book
            fw.append(String.valueOf(this.numberOfAccount) + "\n");
            for (int i = 0; i < this.numberOfAccount; i++) {
                String iD = this.accounts.get(i).getIDBank();
                String userName = this.accounts.get(i).getUserName();
                String password = this.accounts.get(i).getPassword();
                double money = this.accounts.get(i).getMoney();
                // Writes bank's information into data file
                fw.append(String.valueOf(iD) + "\n");
                fw.append(userName + "\n");
                fw.append(password + "\n");
                fw.append(String.valueOf(money) + "\n");
            }
        } finally {
            // Save data file ( from RAM into HDD)
            fw.close();
            System.out.println("Done! [" + this.numberOfAccount + " books]");
        }
    }

}
