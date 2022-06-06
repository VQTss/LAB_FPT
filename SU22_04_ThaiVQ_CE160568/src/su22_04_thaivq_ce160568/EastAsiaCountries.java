package su22_04_thaivq_ce160568;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class EastAsiaCountries extends Country {

    private String countryTerrain;

    /**
     *
     * @param countryCode
     * @param countryName
     * @param totalArea
     * @param countryTerrain
     */
    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    /**
     *
     * @return
     */
    public String getCountryTerrain() {
        return countryTerrain;
    }

    /**
     *
     * @param countryTerrain
     */
    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    /**
     *
     * @return
     */
    @Override
    public String display() {
        return super.display() + "\t\t" + this.getCountryTerrain();
    }

}
