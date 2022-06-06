
package j1.s.p0068;

/**
 *
 * @author thaiq
 */
public class Student {
    private String name;
    private String classes;
    private double mark;

    public Student(String name, String classes, double mark) {
        this.name = name;
        this.classes = classes;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    
    public String display() {
        return "Name: "+this.getName()+"\nClasses: "+this.getClasses()+ "\nMark: "+this.getMark();
    }
    
}
