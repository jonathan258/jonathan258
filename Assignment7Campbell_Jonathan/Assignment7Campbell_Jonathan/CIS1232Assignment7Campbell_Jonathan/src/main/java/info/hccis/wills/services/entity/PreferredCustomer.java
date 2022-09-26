package info.hccis.wills.services.entity;

import info.hccis.wills.services.base.CustomerBase;
import info.hccis.util.CisUtility;

/**
 * Represents a preferred customer
 * @author bjmac
 * @since 10-Jun-2021
 */
public class PreferredCustomer extends CustomerBase{

    public static final double DISCOUNT_PREFERRED = 0.10;

    private int customerSince;

    @Override
    public void getInformation() {
        super.getInformation(); 
        customerSince = CisUtility.getInputInt("When did this person become a customer?");
    }
    
    @Override
    public String getCustomerTypeDesctipion() {
        return "Preferred";
    }

    @Override
    public double getDisountRate() {
        return DISCOUNT_PREFERRED;
    }
    
    @Override
    public String toString() {
        String output = super.toString(); 
        output += " Customer Since: "+customerSince;
        return output;
    }
}
