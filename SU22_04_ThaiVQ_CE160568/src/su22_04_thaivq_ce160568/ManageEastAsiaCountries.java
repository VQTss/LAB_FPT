package su22_04_thaivq_ce160568;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class ManageEastAsiaCountries {

    ArrayList<EastAsiaCountries> eacs = new ArrayList<>();

    /**
     * Thêm thông tin country 
     * @param ea
     * @return
     */
    public boolean addCountryInformation(EastAsiaCountries ea) {
        if (ea.getTotalArea() > 0) {
            updateWidth(ea.getCountryCode(), ea.getCountryName(), String.valueOf(ea.getTotalArea()), ea.getCountryTerrain());
            eacs.add(ea);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Lấy thông country vừa nhập
     * @return
     */
    public EastAsiaCountries getRecentlyEnteredInformation() {
        if (eacs.size() > 0) { // Kiểm arraylist có rỗng hay không
            EastAsiaCountries eac = this.eacs.get(eacs.size() - 1); // Nhập giá trị thì thêm vào phần cuối của array 
            return eac;                                             // nên lấy giá trị của array ở cuối mảng
        } else {
            return null;
        }
    }

    /**
     * Tìm kiếm thông tin country bằng tên country
     * @param name
     * @return
     */
    public EastAsiaCountries searchInformationByName(String name) {
        for (int i = 0; i < eacs.size(); i++) {
            EastAsiaCountries eac = this.eacs.get(i);
            if (eac.getCountryName().equalsIgnoreCase(name)) {
                return eac;
            }
        }
        return null;
    }

    /**
     * Sắp xếp theo tên ngược chiều alphabet
     * @return
     */
    public void sortInformationByAscendingOrder() {
        this.eacs.sort(new Comparator<EastAsiaCountries>() {
            @Override // Dùng phương thức sort 
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o2.getCountryName().compareTo(o1.getCountryName()); // Sort ngược chiều alphabet
            }
        });
    }

   

    /**
     * In ra thông tin country theo dạng bảng 
     * @param countryCode
     * @param countryName
     * @param totalArea
     * @param countryTerrain
     */
    public void showCountry(String countryCode, String countryName, String totalArea, String countryTerrain) {
        int No = 0;
        updateTemplate();
        System.out.println(barLine);
        System.out.printf(template, "ID", "Name", "Total Area", "Terrain");
        System.out.println(barLine);
        System.out.printf(template, countryCode + "", countryName, totalArea, countryTerrain);
        System.out.println(barLine);
    }

    /**
     * In ra thông tin country theo dạng bảng 
     */
    public void showCountry() {
        int No = 0;
        updateTemplate();
        System.out.println(barLine);
        System.out.printf(template, "ID", "Name", "Total Area", "Terrain");
        System.out.println(barLine);
        for (int i = 0; i < this.eacs.size(); i++) {
            EastAsiaCountries a = this.eacs.get(i);
            No++;
            System.out.printf(template, a.getCountryCode() + "", a.getCountryName(), a.getTotalArea(), a.getCountryTerrain());
        }
        System.out.println(barLine);
    }
    // khởi tạo độ dài 
    private int countryCode = 2; 
    private int countryName = 5;
    private int TotalArea = 13;
    private int countryTerrain = 6;
    private String barLine = "";
    // khởi tạo template cho bảng
    private String template = "";

    /**
     * cập nhật độ dài khi người dùng nhập vào
     * @param Code
     * @param Name
     * @param Total
     * @param Terrain
     */
    public void updateWidth(String Code, String Name, String Total, String Terrain) {
        countryCode = Math.max(countryCode, Code.length());
        countryName = Math.max(countryName, Name.length());
        TotalArea = Math.max(TotalArea, Total.length());
        countryTerrain = Math.max(countryTerrain, Terrain.length());

    }

    /**
     * update that print to screen
     */
    public void updateTemplate() {
        String col1 = "";
        for (int i = 0; i < countryCode + 2; i++) {
            col1 += "-";
        }
        String col2 = "";
        for (int i = 0; i < countryName + 5; i++) {
            col2 += "-";
        }
        String col3 = "";
        for (int i = 0; i < TotalArea + 2; i++) {
            col3 += "-";
        }
        String col4 = "";
        for (int i = 0; i < countryTerrain + 5; i++) {
            col4 += "-";
        }
        barLine = "+" + col1 + "+" + col2 + "+" + col3 + "+" + col4 + "+";
        template = "| %" + countryCode + "s | %-" + countryName + "s    | %" + TotalArea + "s | %-" + countryTerrain + "s    |\n";
    }
}
