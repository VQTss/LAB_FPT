package j1.s.p0063;

import java.util.ArrayList;
import java.util.Comparator;
/**
 *
 * @author thaiq
 */
public class Managemet {

    menu m = new menu();
    static ArrayList<Person> al = new ArrayList<>();

    public void addPerson(Person p) { // Thêm phần tử vào arraylist
        al.add(p);
    }
    // Phương thức sort
    public void sortBySalary() {
        al.sort(new Comparator<Person>() {
            @Override // Dùng comparator để sort
            public int compare(Person o1, Person o2) {
                int a1 = (int) o1.getSalary();
                int a2 = (int) o2.getSalary();
                return a1 - a2; // So sánh để sắp xếp tăng dần
            }
        });
    }
    // Phương thức phản hồi thông tin
    public void displayPersonInfo4() {
        for (int i = 0; i < al.size(); i++) {
            Person p = al.get(i); // Lấy phần tử trong arraylist
            p.displayPersonInfo(); // dùng phương thức in ra thông tin 
        }
    }
}
