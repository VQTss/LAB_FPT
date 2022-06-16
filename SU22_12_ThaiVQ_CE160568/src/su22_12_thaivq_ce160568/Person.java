
package su22_12_thaivq_ce160568;

/**
 *
 * @author Vo Quoc Thai CE160568
 */
public class Person {

    private int ID; // thuộc tính ID
    private String name; // thuojc tính name
    private String group; // thuộc tính group 
    private String phone; // thuộc tính phone
    private String firstName; // thuộc tính fisrt name
    private String lastName; // thuộc tính last name
    private String address; // thuộc tính addreess

    /**
     * create a new person
     */
    public Person() {
    }

    /**
     * create new person
     * @param ID
     * @param name
     * @param group
     * @param phone
     * @param address
     */
    public Person(int ID, String name, String group, String phone,String address) {
        this.ID = ID;
        this.name = name;
        this.group = group;
        this.phone = phone;
        this.address = address;
        this.firstName = "";
        this.lastName = "";
    }

    /**
     * get address
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * set address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get ID
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * set ID
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * get Name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get Group
     * @return
     */
    public String getGroup() {
        return group;
    }

    /**
     * set Group
     * @param group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * get phone
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *  set phone
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * get first name
     * @return
     */
    public String getFirstName() {
        int index = spaceLetter(this.getName()); 
        // VD:  Vo quoc thai -> first name = vo quoc thì cái index sẽ trả về vị trí dấu cách trước chữ 'thai'
        // vì vậy chúng ta sẽ tạo một chuổi con đi từ vị trí  0 cho đến ví trí index
        if (index != - 1) {
            this.firstName = this.getName().substring(0, index);
            return firstName;
        } else {
            this.firstName = "";
            return this.firstName;
        }
    }

    /**
     * get last name
     * @return
     */
    public String getLastName() {
        int index = spaceLetter(this.getName());
         // VD:  Vo quoc thai -> last name = thai thì cái index sẽ trả về vị trí dấu cách trước chữ 'thai'
        // vì vậy chúng ta sẽ tạo một chuổi con đi từ vị trí  index + 1 ( bắt đầu từ chữ t ) cho đến vị trí độ dài của chuổi
        int n = this.getName().length();
        if (index != - 1) {
            this.lastName = this.getName().substring(index+1, n);
            return lastName;
        } else {
            this.lastName = this.getName();
            return this.lastName;
        }
    }

    /**
     * hàm dùng dể lấy vị trí khoảng trắng trước last nama
     * @param name
     * @return
     */
    public int spaceLetter(String name) {
        for (int i = this.getName().length() - 1; i >= 0; i--) {
            if (this.getName().charAt(i) == ' ') { 
                return i;
            }
        }
        return -1;
    }
}
