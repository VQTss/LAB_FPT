
package su22_04_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE1605686
 */
public class Country {

    /**
     * Attribute countryCode
     */
    protected String countryCode;

    /**
     * Attribute countryName
     */
    protected String countryName;

    /**
     * Attribute totalArea
     */
    protected float totalArea;

    /**
     * Create new country
     */
    public Country() {
    }

    /**
     * Create new country
     * @param countryCode
     * @param countryName
     * @param totalArea
     */
    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    /**
     * Get countryCode
     * @return
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Set countryCode
     * @param countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Get country name
     * @return
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Set countryName
     * @param countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Get totalArea
     * @return
     */
    public float getTotalArea() {
        return totalArea;
    }

    /**
     * Set totalArea
     * @param totalArea
     */
    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    /**
     * Phản hồi 1 chuỗi cái thuộc tính có trong country
     * @return
     */
    public String display() {

        return this.getCountryCode() + "\t\t" + this.getCountryName() + "\t\t" + this.getTotalArea();
    }

}
