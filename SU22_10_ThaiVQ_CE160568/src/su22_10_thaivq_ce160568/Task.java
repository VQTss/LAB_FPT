package su22_10_thaivq_ce160568;

import java.util.ArrayList;

/**
 *
 * @author Thai Vo Quoc CE160568
 */
public class Task {

    private int ID; // thuộc tính ID
    private String typeID; // thuộc tính typeID
    private String name; // thuộc tính Name
    private String date; // thuộc tính date
    private double planFrom; // thuộc tính from
    private double planTo; // thuộc tính to
    private String assign; // thuộc tính assign
    private String review; // thuộc tính review
    

    /**
     * Tạo mới task
     */
    public Task() {
    }

    /**
     * Tạo mới task
     * @param ID
     * @param typeID
     * @param name
     * @param date
     * @param planFrom
     * @param planTo
     * @param assign
     * @param review
     */
    public Task(int ID, String typeID, String name, String date, double planFrom, double planTo, String assign, String review) {
        this.ID = ID;
        this.typeID = typeID;
        this.name = name;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.review = review;
    }

    /**
     * get ID
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * set ID
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * get Type ID
     * @return
     */
    public String getTypeID() {
        return typeID;
    }

    /**
     * set Type ID
     * @param typeID
     */
    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    /**
     *  get Name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public double getPlanFrom() {
        return planFrom;
    }

    /**
     *
     * @param planFrom
     */
    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    /**
     *
     * @return
     */
    public double getPlanTo() {
        return planTo;
    }

    /**
     *
     * @param planTo
     */
    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    /**
     *
     * @return
     */
    public String getAssign() {
        return assign;
    }

    /**
     *
     * @param assign
     */
    public void setAssign(String assign) {
        this.assign = assign;
    }

    /**
     *
     * @return
     */
    public String getReview() {
        return review;
    }

    /**
     *
     * @param review
     */
    public void setReview(String review) {
        this.review = review;
    }

   
}
