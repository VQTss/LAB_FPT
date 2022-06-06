package j1.s.p0068;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author thaiq
 */
public class StudentManagement {

    Scanner sc = new Scanner(System.in);
    ArrayList<Student> s = new ArrayList<>();

    public void addStudent() {
        System.out.println("Please input student information ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Classes: ");
        String classes = sc.nextLine();
        System.out.print("Mark: ");
        double mark = sc.nextDouble();
        sc.nextLine();
        this.s.add(new Student(name, classes, mark));
    }

    public void sortStudent() {
        this.s.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void display() {
        for (int i = 0; i < this.s.size(); i++) {
            System.out.printf("-------------------- Student %d --------------------\n",(i+1));
            Student student = this.s.get(i);
            System.out.println(student.display());
        }
    }

}
