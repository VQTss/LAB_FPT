package su22_08_4slot_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class Table {

    //initialize width for table output
    private int widthID = 5; // khởi tạo độ rộng của ID
    private int widthName = 5; // khởi tạo độ rộng của Name
    private int widthAge = 6; // khởi tạo độ rộng của Age
    private int widthSalary = 13; // khởi tạo độ rộng của Salary
    private int widthLocation = 13; // khởi tạo độ rộng của Location
    public String barLine = ""; // khởi tạo độ rộng của -----
    //initialize template for table output
    public String template = ""; // khởi tạo độ rộng của nội dung

    /**
     * Update width for table if have width greater than current width
     *
     * @param id
     * @param title
     * @param rentalPrice
     * @param author
     * @param volume
     */
    public void updateWidth(String id, String title, String rentalPrice, String author, String volume) {
        widthID = Math.max(widthID, id.length()); // cập nhật độ rộng của ID
        widthName = Math.max(widthName, title.length()); // cập nhật độ rộng của name
        widthAge = Math.max(widthAge, rentalPrice.length()); // cập nhật độ rộng của age
        widthSalary = Math.max(widthSalary, author.length()); // cập nhật độ rộng của salary
        widthLocation = Math.max(widthLocation, volume.length()); // cập nhật độ rộng của location

    }

    /**
     * update that print to screen
     */
    public void updateTemplate() {
        String col1 = "";
        for (int i = 0; i < widthID + 2; i++) {
            col1 += "-";
        }
        String col2 = "";
        for (int i = 0; i < widthName + 5; i++) {
            col2 += "-";
        }
        String col3 = "";
        for (int i = 0; i < widthAge + 2; i++) {
            col3 += "-";
        }
        String col4 = "";
        for (int i = 0; i < widthSalary + 5; i++) {
            col4 += "-";
        }
        String col5 = "";
        for (int i = 0; i < widthLocation + 2; i++) {
            col5 += "-";
        }
        barLine = "+" + col1 + "+" + col2 + "+" + col3 + "+" + col4 + "+" + col5 + "+" + col5 + "+";
        template = "| %" + widthID + "s | %" + widthName + "s    | %" + widthAge + "s | %" + widthSalary + "s    | %" + widthLocation + "s | %" + widthLocation + "s |\n";
    }
}
