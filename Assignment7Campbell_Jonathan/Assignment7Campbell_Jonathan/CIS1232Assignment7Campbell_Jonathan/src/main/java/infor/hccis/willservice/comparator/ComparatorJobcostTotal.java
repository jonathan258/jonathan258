/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infor.hccis.willservice.comparator;

import info.hccis.wills.services.entity.Job;
import java.util.Comparator;

/**
 *
 * @author Jonathan
 */
public class ComparatorJobcostTotal implements  Comparator<Job>{

    @Override
    public int compare(Job thisObject, Job thatObject) {

double compareValue = thisObject.calculateCost() - thatObject.getCostTotal();

        //1st - positive
        //2nd - negative
        //3rd - 0
        if(compareValue > 0) {
            return 1;
        } else if (compareValue < 0) {
            return -1;
        } else {
            return 0;
        }

    }

  
    
}
