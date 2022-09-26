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
public class ComparatorJobDate implements Comparator<Job>{

    @Override
    public int compare(Job thisObject, Job thatObject) {
        return thisObject.getJobDates().compareTo(thatObject.getJobDates());
    }
    
}
