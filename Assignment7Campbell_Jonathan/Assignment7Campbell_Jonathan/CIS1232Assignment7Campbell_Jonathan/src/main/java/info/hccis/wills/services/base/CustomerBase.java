package info.hccis.wills.services.base;

import info.hccis.util.CisUtility;

/**
 * Represents a customer
 *
 * @author bjmac
 * @since 8-Jun-2021
 */
public abstract class CustomerBase {

    private String firstName;
    private String lastName;

    public static final int TYPE_PREFERRED = 1;
    public static final int TYPE_SENIOR = 2;

    public CustomerBase() {
    }

    /**
     * Constructor that accepts first and last name as one string
     *
     * @since 20210608
     * @author BJM
     */
    public CustomerBase(String name) {
        setFirstAndLastName(name);
    }

    public CustomerBase(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Method to return the discount rate.
     *
     * @since 20210608
     * @author BJM
     */
    public double getDisountRate() {
        double discount = 0;
        return discount;
    }

    /**
     * Get the description of the type of customer
     *
     * @since 20210608
     * @author BJM
     */
    public String getCustomerTypeDesctipion() {
        String description = "Regular";
        return description;
    }

    /**
     * Get the first and last name out of the one string.Note that it is
     * expected to have exactly two parts. Note also that it is called from the
     * constructor which is why it is set to final (We'll get to this in
     * inheritance. It will work without final but give a warning.
     *
     * @param name Full name (first and last separated by space)
     * @since 20210608
     * @author BJM
     */
    public final void setFirstAndLastName(String name) {
        String[] parts = name.split(" ");
        if (parts.length >= 2) {
            firstName = parts[0];
            lastName = parts[1];
        }
    }

    public void getInformation() {
        this.firstName = CisUtility.getInputString("First Name?");
        this.lastName = CisUtility.getInputString("Last Name?");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void display() {
        CisUtility.display(this.toString());
    }

    public String toString() {
        String output = "Name: " + firstName + " " + lastName + " Customer Type: " + getCustomerTypeDesctipion();
        return output;
    }
}
