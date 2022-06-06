package su22_02_thaivq_ce160568;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class FileManagement {

    File newFile = null;
    ArrayList<FileCSV> list = new ArrayList<>();// Lưu trữ dữ liệu đọc từ tập tin

    /**
     * Nhập đường dẫn file và lấy dữ liệu từ tệp
     *
     * @param path
     * @throws IOException
     * @throws FileException
     */
    public void importCSV(String path) throws IOException, FileException {
        File f = new File(path);
        if (f.isFile()) { // Kiểm tra đường dẫn có phải là tập tin hay không
            if (f.getPath().contains(".csv")) { // Kiểm tra tập tin có đuôi .csv không
                BufferedReader br = new BufferedReader(new FileReader(f));  // Đọc tập tin
                String line = "";

                // Vòng lặp dùng để kiểm tra còn dữ liệu trong tập tin hay không
                // Nếu còn thì tiếp tục lấy dữ liệu, nếu dữ liệu bằng null thì dừng vòng lặp lại
                int count = 0;
                while ((line = br.readLine()) != null) {
                    if (count != 0) {
                        String[] person = line.split(",");
                        list.add(new FileCSV(Integer.parseInt(person[0]), person[1], person[2], Integer.parseInt(person[3]), person[4]));
                    }
                    count++;
                }
                System.out.println("Import: Done");
            } else {
                throw new FileException("This file is not file csv");
            }
        } else {
            throw new FileException("The path is not file csv");
        }
    }

    /**
     * Truy xuất chuyển đổi bên hàm main
     *
     * @return
     */
    /**
     * Định dạng cột địa chỉ
     *
     * @param dataCSV
     * @throws FileException
     * @throws IOException
     */
    public void formatAddress() throws FileException, IOException {

        for (FileCSV fileCSV : list) {
            String address = fileCSV.getAddress();
            String fix = address.replaceAll("\\s+", " ").trim();  // Dùng để cắt khoảng trắng dư thừa
            if (fix.contains(" - ")) {
                address = fix.replace(" - ", "-");
            } else if (fix.contains(" -")) {
                // Cầu Giấy -Hà Nội -Việt Nam
                address = fix.replace(" -", "-");
            } else {
                // Cầu Giấy- Hà Nội- Việt Nam
                address = fix.replace("- ", "-");
            }
            fileCSV.setAddress(address);
        }
        System.out.println("Format: Done");
    }

    /**
     * Định dạng cột tên
     *
     * @param dataCSV
     * @return
     * @throws FileException
     */
    public void formatName() throws FileException {
        for (FileCSV fileCSV : list) {
            String name = fileCSV.getName();
            char[] charArray = name.replaceAll("\\s+", " ").trim().toCharArray();  // Dùng để cắt khoảng trắng dư thừa
            boolean foundSpace = true;
            for (int j = 0; j < charArray.length; j++) {
                // nếu phần tử trong mảng là một chữ cái
                if (Character.isLetter(charArray[j])) {
                    // kiểm tra khoảng trắng có trước chữ cái
                    if (foundSpace) {
                        //đổi chữ cái thành chữ in hoa bằng phương thức toUpperCase()
                        charArray[j] = Character.toUpperCase(charArray[j]);
                        foundSpace = false;
                    }
                } else {
                    foundSpace = true;
                }
            }
            name = String.valueOf(charArray);
            fileCSV.setName(name);
        }
        System.out.println("Format: Done");
    }

    /**
     * Xuất tập tin theo đường dẫn
     *
     * @param path
     * @throws IOException
     * @throws FileException
     */
    public void exportCSV(String path) throws IOException, FileException {
        File f = new File(path);
        if (f.isFile()) {
            if (f.getPath().contains(".csv")) {
                FileWriter write = new FileWriter(f); // Viết dữ liệu vào tập tin
                write.append("ID,Name,Email,Phone,Address\n");
                for (FileCSV object : list) {
                    write.append(object.getID() + "," + object.getName() + "," + object.getEmail() + "," + object.getPhone() + "," + object.getAddress() + "\n");
                }
                // Đóng tập tin
                write.close();
                System.out.println("Export: Done");
            } else {
                throw new FileException("This file is not file csv");
            }
        } else {
            File newFile = new File(path + "\\demo.csv");
            System.out.println("Creating new file demo.csv at path: " + newFile.getPath());
            FileWriter write1 = new FileWriter(newFile);
            write1.append("ID,Name,Email,Phone,Address\n");
            for (FileCSV object : list) {
                write1.append(object.getID() + "," + object.getName() + "," + object.getEmail() + "," + object.getPhone() + "," + object.getAddress() + "\n");
            }

            write1.close();
            System.out.println("Export: Done");
        }
    }
}
