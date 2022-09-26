package info.hccis.wills.services.entity;

import info.hccis.wills.services.base.CustomerBase;

/**
 * Represents a senior customer
 * @author bjmac
 * @since 10-Jun-2021
 */
public class SeniorCustomer extends CustomerBase{

    public static final double DISCOUNT_SENIOR = 0.15;

    @Override
    public String getCustomerTypeDesctipion() {
        return "Senior";
    }

    @Override
    public double getDisountRate() {
        return DISCOUNT_SENIOR;
    }

    
}
