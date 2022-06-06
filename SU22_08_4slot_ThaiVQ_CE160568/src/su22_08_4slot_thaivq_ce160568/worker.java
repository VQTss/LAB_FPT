package su22_08_4slot_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class worker {

    private String id;
    private String name;
    private int age;
    private int salary;
    private String workLocation;
    private String status;

    /**
     *  tạo đối tượng rỗng
     */
    public worker() {
    }

    /**
     * tạo mới worker
     * @param id
     * @param name
     * @param age
     * @param salary
     * @param workLocation
     * @param status
     */
    public worker(String id, String name, int age, int salary, String workLocation, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
        this.status = status;
    }

    /**
     * lấy ID
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * set ID
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
     * get Age
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * set Age
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * get salary
     * @return
     */
    public int getSalary() {
        return salary;
    }

    /**
     * set salary
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * get location
     * @return
     */
    public String getWorkLocation() {
        return workLocation;
    }

    /**
     * set location
     * @param workLocation
     */
    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    /**
     * get status
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * set status
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
