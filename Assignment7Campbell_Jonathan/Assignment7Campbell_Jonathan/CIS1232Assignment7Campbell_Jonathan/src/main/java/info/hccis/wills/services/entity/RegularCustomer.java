package info.hccis.wills.services.entity;

import info.hccis.wills.services.base.CustomerBase;

/**
 * Represents a regular customer.  No special functionality or attributes but 
 * can be used to create a basic customer object.
 * @author bjmac
 * @since 11-Jun-2021
 */
public class RegularCustomer extends CustomerBase{

    //Nothing special but will need the constructors

    public RegularCustomer() {
    }

    public RegularCustomer(String name) {
        super(name);
    }

    public RegularCustomer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    
    
    
}
