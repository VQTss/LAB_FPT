package su22_01_thaivq_ce160568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class FileManagement {

    private FileAndDic file;

    public FileManagement(FileAndDic file) {
        this.file = file;
    }

    String getPath() {
        return this.file.getPath();
    }

    // Kiểm tra đường dẫn có hợp lệ hay không
    public void checkInputPath(String path) throws FileException {
        File pathName = new File(path);
        // kiểm tra đường dẫn có tồn tại hay không
        if (pathName.exists()) {
            if (pathName.isDirectory()) { // kiểm tra đường dẫn có phải là thư mục hay không
                System.out.println("Đường dẫn đến thư mục");
            } else { // Vì đường dẫn đã đúng thì chỉ có 2 trường hợp 1 là thư mục 2 là tệp
                System.out.println("Đường dẫn đến tệp");
            }
        } else {
            // Bắt ngoại lệ
            throw new FileException("Đường dẫn không tồn tại");
        }
    }

    // Liệt kê các tệp có đuôi .java
    public List<String> getAllFileNameJavaInDirectory(String path) throws FileException {
        File pathName = new File(path); // Tạo một instance file
        List<String> listAllFile = new ArrayList<>(); //  Tạo arraylist để lưu trữ
        String FILE_TEXT_EXT = ".java";
        if (pathName.exists()) { // Kiểm tra đường dẫn có tồn tại hay  không
            if (pathName.isDirectory()) { // Kiểm tra đường dẫn có phải là thư mục hay không
                String[] list = pathName.list(new FilenameFilter() { // giao tiếp với interface FilenameFilter 
                    @Override
                    public boolean accept(File dir, String name) { // Overide phương thức appect có trong interface FilenameFilter
                        if (name.endsWith(FILE_TEXT_EXT)) {
                            listAllFile.add(name); // Thêm file .java vào list
                        }
                        return name.endsWith(FILE_TEXT_EXT); // Kiểm tra tham số có kết thúc phần đuôi có .java hay không . Tạo list demo 
                    }
                });
                if (list.length == 0) {  // kiểm tra độ dài của list để biết rằng trong thư mục có chứa file .java
                    System.out.println("Không có tồn tại file có đuôi .java");
                }
            } else { // Bắt ngoại lệ khi đường dẫn là một tệp tin
                throw new FileException("Đường dẫn không tồn tại");
            }
        } else {
            throw new FileException("Đường dẫn không tồn tại");
        }
        return listAllFile; // Trả về một list
    }

    public boolean appendContentToFile(String path, String contentInput) throws IOException, FileException {
        File pathFile = new File(path); // Tạo một instance file
        if (!pathFile.exists()) { // Kiểm tra đường dẫn có tồn tại hay  không
            throw new FileException("Đường dẫn không hợp lệ");
        } else {
            if (!pathFile.isFile()) {  // Kiểm tra đường dẫn có phải là thư mục hay không
                File file = new File(path + "\\newfile.txt");
                file.createNewFile(); // tạo tập tin mới nếu đường dẫn là thư mục
                System.out.println("Tập tin đã được tạo");
                FileWriter fw = new FileWriter(file); // Lớp dùng để ghi file và văn bản
                BufferedWriter bw = new BufferedWriter(fw); //  cung cấp việc ghi dữ liệu hiệu quả với các mảng đơn, các ký tự và chuỗi.
                bw.write(contentInput); // Viết vào thư mục
                bw.close(); // đóng tập tin
                return true;
            } else {
                // Do là thêm nội dung nên đường dẫn hợp lệ khi là tệp tin
                FileWriter fw = new FileWriter(pathFile); // Lớp dùng để ghi file và văn bản
                BufferedWriter bw = new BufferedWriter(fw); //  cung cấp việc ghi dữ liệu hiệu quả với các mảng đơn, các ký tự và chuỗi.
                bw.write(contentInput); // Viết vào thư mục
                bw.close(); // đóng tập tin
                return true;
            }
        }
    }

    public int countCharacter(String path) throws IOException, FileException {
        File pathFile = new File(path); // Tạo một instance file
        int count = 0; // Biến dùng để điếm từ
        if (!pathFile.exists()) { // Kiểm tra đường dẫn có tồn tại hay  không
            throw new FileException("Đường dẫn không hợp lệ");
        } else {
            if (!pathFile.isFile()) {  // Kiểm tra đường dẫn có phải là thư mục hay không
                throw new FileException("Đường dẫn không hợp lệ");
            } else {
                BufferedReader br = new BufferedReader(new FileReader(pathFile));
                try {
                    String str = br.readLine();
                    count = str.length(); // điếm số lượng kí tự có trong chuổi
//                    String[] arrChar = str.split("[ ,.]"); // Dùng để cắt một chuổi thành mảng. 
//                    for (String string : arrChar) { // Nó Cắt luôn cái khoảng trắng thành các phần tử của mảng
//                        if (!string.equals("")) { // Kiểm tra xem phần tử trong mảng có phải là rỗng ( khoảng trắng )
//                            count++;
//                        }
//                    }
                } finally {
                    br.close(); // Đóng file
                }
            }
        }
        return count; // Trả về số lượng kí tự có trong tập tin
    }

    public static File[] getFileWithSizeGreaterThanInput(String path, int size) throws FileException {
        File pathFile = new File(path); // Tạo một instance file
        File[] fileList = null; // Tạo một mảng rỗng
        if (!pathFile.exists()) { // Kiểm tra đường dẫn có tồn tại hay  không
            throw new FileException("Đường dẫn không hợp lệ");
        } else {
            if (pathFile.isFile()) { // Kiểm tra đường dẫn có phải là thư mục hay không
                throw new FileException("Đường dẫn không hợp lệ");
            } else {
                // Dùng interface FileFilter() để lọc các file có kích thước lớn hơn size
                fileList = pathFile.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        if (((int) pathname.length() / 1024) > size) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
//                // Kiểm tra đường dẫn có phải là thư mục hay không
//                int i = 0, j = 0;
//                // Vòng while dùng để khởi tạo số phần tử cho mảng fileList 
//                // Vì không biết trong đường dẫn thư mục có chứa bao nhiêu file
//                // có kích thước lớn hơn  size
//                while (i < pathFile.listFiles().length) {
//                    int byteGreater = (int) pathFile.listFiles()[i].length();
//                    if (byteGreater > size) {
//                        j++;
//                    }
//                    i++;
//                }
//                fileList = new File[j];
//                j = 0;
//                i = 0;
//                // Vòng while này dùng để gán giá trị cho mảng fileList
//                while (i < pathFile.listFiles().length) {
//                    int byteGreater = (int) pathFile.listFiles()[i].length();
//                    if (byteGreater > size) {
//                        fileList[j] = pathFile.listFiles()[i];
//                        j++;
//                    }
//                    i++;
//                }

            }
        }
        return fileList; // Trả về mảng các file có kích thước lớn  size
    }

}
