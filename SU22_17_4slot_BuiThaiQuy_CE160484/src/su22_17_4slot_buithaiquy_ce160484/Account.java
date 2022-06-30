
package su22_17_4slot_buithaiquy_ce160484;

/**
 *
 * @author 
 */
public class Account {
   private String IDBank;
   private String userName;
   private String password;
   private double money;

    /**
     *
     * @param IDBank
     * @param userName
     * @param password
     * @param money
     */
    public Account(String IDBank, String userName, String password, double money) {
        this.IDBank = IDBank;
        this.userName = userName;
        this.password = password;
        this.money = money;
    }
   
    /**
     *
     */
    public Account() {
    }

    /**
     *
     * @return
     */
    public double getMoney() {
        return money;
    }

    /**
     *
     * @param money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     *
     * @return
     */
    public String getIDBank() {
        return IDBank;
    }

    /**
     *
     * @param IDBank
     */
    public void setIDBank(String IDBank) {
        this.IDBank = IDBank;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
   
   
   
   
   
}
