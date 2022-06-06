/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_01_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class FileAndDic {

    private String path; // thuộc tính path

    // Constructor
    public FileAndDic(String path) throws FileException {
        this.setPath(path);
    }

    // Phương thức get để lấy giá trị
    public String getPath() {
        return path;
    }

    // Phương thức set để gán giá trị 
    public void setPath(String path) throws FileException {
        // Kiểm tra đường dẫn người dùng có nhập là rỗng hay không
        if (path.equals("")) {
            throw new FileException("The file cannot be empty!");
        } else {
            this.path = path;
        }
    }
}
