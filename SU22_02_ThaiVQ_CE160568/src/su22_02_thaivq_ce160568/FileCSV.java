package su22_02_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class FileCSV {

    private String pathFile;

    // Tạo FileCSV mới
    public FileCSV(String pathFile) {
        this.setPathFile(pathFile);
    }

    // Lấy đường dẫn của FileCSV
    public String getPathFile() {
        return pathFile;
    }

    // Set đường dẫn của FileCSV
    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
    int ID, phone;
    String name, email, address;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

      // Tạo đối tượng để lấy dữ liệu từ file
      public FileCSV(int ID, String name, String email, int phone, String address) {
        this.setID(ID);
        this.setEmail(email);
        this.setAddress(address);
        this.setName(name);
        this.setPhone(phone);
    }


    @Override
    public String toString() {
        return "person{" + "ID=" + ID + ", phone=" + phone + ", name=" + name + ", email=" + email + ", address=" + address + '}';
    }
}
