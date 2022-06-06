package su22_08_4slot_thaivq_ce160568;

import java.util.ArrayList;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class Management {

    static ArrayList<worker> list = new ArrayList<>();
    static Menu m = new Menu();
    static CheckException ce = new CheckException();
    static Table t = new Table();

    //allow user add worker
    public static void addWorker() {
        System.out.print("Enter code: ");
        String id = m.checkInputString();
        System.out.print("Enter name: ");
        String name = m.checkInputString();
        System.out.print("Enter age: ");
        int age = m.checkInputIntLimit(18, 50);
        System.out.print("Enter salary: ");
        int salary = ce.checkInputSalary();
        System.out.print("Enter work location: ");
        String workLocation = m.checkInputString();
        if (!ce.checkWorkerExist(list, id, name, age, salary, workLocation)) {
           System.out.println("Code(id) must be existed in database."); // Kiểm tra coi trùng hay không
        } else {
            list.add(new worker(id, name, age, salary, workLocation, "UP")); // Thêm worker vào mảng
            t.updateWidth(id, name, String.valueOf(age), String.valueOf(salary), workLocation); // cập nhật độ rộng cho table
            System.out.println("Add success.");
        }
    }

    //allow user increase salary for user
    public static void changeSalary(int status) {
        if (list.isEmpty()) {
            System.out.println("List empty."); // Kiểm tra danh sách worker có bị rỗng hay không
            return;
        }
        System.out.print("Enter code: ");
        String id = m.checkInputString();
        worker w = ce.getWorkerByCode(list, id); // tìm kiếm worker theo ID
        if (w == null) {
            System.out.println("Not exist worker.");
        } else {
            int salaryCurrent = w.getSalary();
            int salaryUpdate;
            //check user want to update salary
            if (status == 1) {
                System.out.print("Enter salary: ");
                //loop until user input salary update > salary current
                while (true) {
                    salaryUpdate = ce.checkInputSalary();
                    //check user input salary update > salary current
                    if (salaryUpdate <= salaryCurrent) { // Kiểm tra lương vừa nhập có lớn hơn hiện tại hay không
                        System.out.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                w.setSalary(salaryUpdate);
            } else {
                System.out.print("Enter salary: ");
                //loop until user input salary update < salary current
                while (true) {
                    salaryUpdate = ce.checkInputSalary();
                    //check user input salary update < salary current
                    if (salaryUpdate >= salaryCurrent) { // Kiểm tra lương vừa nhập có lớn hơn hiện tại hay không
                        System.out.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                w.setSalary(salaryUpdate); // cập nhật lương
                w.setStatus("DOWN"); // cập nhật trạng thái
            }

            System.out.println("Update success");
        }
    }

    //allow user print history
    public void printList() {
        if (list.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        t.updateTemplate(); // cập nhật độ rộng
        System.out.println(t.barLine);
        System.out.printf(t.template, "Code", "Name", "Age", "Salary", "Status", "Work Location"); // cập nhật nội dung
        System.out.println(t.barLine); // cập nhật của thanh ---- 
        for (int i = 0; i < this.list.size(); i++) {
            worker a = this.list.get(i);
            System.out.printf(t.template, a.getId() + "", a.getName(), a.getAge(), a.getSalary(), a.getStatus() + "", a.getWorkLocation() + ""); // cập nhật nội dung
        }
        System.out.println(t.barLine); // cập nhật của thanh ---- 

    }

}
