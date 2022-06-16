package su22_12_thaivq_ce160568;

import java.util.ArrayList;

/**
 *
 * @author Vo Quoc Thai CE160568
 */
public class Management {

    ArrayList<Person> listPerson = new ArrayList<>(); // lưu trữ danh sách liên lạc
    static Validate v = new Validate();
    static Person p;
    static Table t = new Table();

    public void addContact() {
        System.out.println("----------- Add a contact ----------");
        p = new Person(); // khởi tạo đối tượng Person
        System.out.print("Enter name: ");
        p.setName(v.checkInputString()); // set gía trị cho name
        System.out.print("Enter group: ");
        p.setGroup(v.checkInputString()); // set gía trị cho group
        System.out.print("Enter address: ");
        p.setAddress(v.checkInputString()); // set gía trị cho address
        System.out.print("Enter phone: ");
        p.setPhone(v.checkInputPhone()); // set giá trị cho phone
        int id = 0, count = 0;
        // update ID tự động
        for (int j = 1;; ++j) {
            boolean valid = true;
            for (int i = 0; i < this.listPerson.size(); i++) {
                Person a = this.listPerson.get(i);
                if (a.getID() == j) { // kiêm tra ID có trùng chưa
                    valid = false;
                } else if (a.getAddress().equals(p.getAddress()) && a.getName() == p.getName()
                        && a.getGroup().equals(p.getGroup())) { // kiểm tra liên lạc đó có trong bảng chưa
                    count++;
                }
            }
            if (valid == true) {
                id = j;
                p.setID(id); // set giá trị ID
                // lưu trữ dữ liệu vào arraylist
                this.listPerson.add(new Person(p.getID(), p.getName(), p.getGroup(), p.getPhone(), p.getAddress())); 
                // cập nhật độ dài cho bảng
                t.updateWidth(p.getID() + "", p.getName(), p.getGroup(), p.getAddress(), p.getPhone());
                break;
            } else if (count != 0) { // thoát khỏi vòng lặp j
                break;
            }
        }
        return;
    }
    // in ra tất cả các liên lạc có trong arraylist
    public void displayAll() {
        System.out.println("------- Display all contact -------");
        t.updateTemplate(); // cập nhật độ dài của bảng
        System.out.println(t.barLine); // in ra + --- + --- +
        System.out.printf(t.template, "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone"); // cập nhật bảnh
        System.out.println(t.barLine);
        for (int i = 0; i < this.listPerson.size(); i++) {
            Person a = this.listPerson.get(i);
            // in ra các giá trị có trong arraylist
            System.out.printf(t.template, a.getID(), a.getName(), a.getFirstName(), a.getLastName(), a.getGroup(), a.getAddress(), a.getPhone());
        }
        System.out.println(t.barLine);
    }
    // tìm kiếm ID
    public int findContact(int ID) {
        
        for (int i = 0; i < this.listPerson.size(); i++) {
            Person a = this.listPerson.get(i);
            if (a.getID() == ID) { // nếu đúng ID thì ra về vị trí nằm trong arraylist
                return i;
            }
        }
        return -1;
    }
    // xóa danh sách liên lạc
    public boolean deleteContact() {
        System.out.println("------ Delete a contact ------");
        System.out.print("Enter ID:");
        int id = v.checkInputInt();
        int index = findContact(id);
        if (index != - 1) { // nếu id trả về khác -1 thì xóa
            this.listPerson.remove(index); // xóa liên lạc ở vị trí i
            System.out.println("Successful.");
            return true;
        } else {
            // index == -1  nghĩa là không tìm thấy ID
            System.out.println("Not found '" + id + "' in Contact!"); 
            return false;
        }
    }
}
