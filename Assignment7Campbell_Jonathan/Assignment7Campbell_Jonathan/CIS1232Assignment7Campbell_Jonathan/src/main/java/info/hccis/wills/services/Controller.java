package info.hccis.wills.services;

import info.hccis.util.CisUtility;
import info.hccis.wills.services.entity.Job;
import infor.hccis.willservice.comparator.ComparatorJobDate;
import infor.hccis.willservice.comparator.ComparatorJobcostTotal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Main class
 *
 * @author bjmaclean
 */
public class Controller {

    /* Assignment 7 requirements
    todo Add new attribute 
    In the Job class refactor the code to have a dateOfJob attribute which is 
    obtained from the user when providing the information about the job.  Fully 
    integrate this attribute into the class (ie. all methods as appropriate.

    todo Add sorting options.
    When showing all jobs, add the ability for the user to specify if they would 
    like to show by the cost of job OR by the date of the job.  Enhance the program 
    to allow these two options.
    
     */
    public static final int EXIT = 0;

    public static final String MENU = "1) Add Job" + System.lineSeparator()
            + "2) Show total of all jobs" + System.lineSeparator()
            + "3) Show all jobs" + System.lineSeparator()
            + "4) Show distinct customers" + System.lineSeparator()
            + EXIT + ") Exit"
            + System.lineSeparator();

    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";
    public static final String MESSAGE_SUCCESS = "Success";
    private static double total = 0;

    //Assignment #3 collections
    private static HashSet<String> names = new HashSet();
    private static ArrayList<Job> jobs = new ArrayList();

    public static void main(String[] args) {

        System.out.println("---------------------------------");
        System.out.println("- Welcome to " + Job.BUSINESS_NAME);
        System.out.println("---------------------------------");
        System.out.println("");

        int menuOption;

        do {
            menuOption = CisUtility.getInputInt(MENU);

            switch (menuOption) {
                case EXIT:
                    System.out.println(MESSAGE_EXIT);
                    break; //Break out of the loop as we're finished.
                case 1:
                    addJob();
                    break;
                case 2:
                    showTotal();
                    break;
                case 3:
                    showJobs();
                    break;
                case 4:
                    showDistinctCustomers();
                    break;
                default:
                    System.out.println(MESSAGE_ERROR);
                    break;
            }
        } while (menuOption != EXIT);
    }

    /**
     * Show distinct customers. (Assignment #3)
     *
     * @since 20210609
     * @author BJM
     */
    public static void showDistinctCustomers() {
        for (String current : names) {
            CisUtility.display(current);

        }
    }

    /**
     * Show jobs from the jobs array. (Assignment #1)
     *
     * @since 20210609
     * @author BJM
     */
    public static void showJobs() {
// make a swithc statment for the sorting 

        String sorting = CisUtility.getInputString("Sort by 1=Cost 2=Date of Job?");

        Collections.sort(jobs, new ComparatorJobcostTotal());
        Collections.sort(jobs, new ComparatorJobDate());

        /**
         * @author Jonathan Switch selection in order to select the comparator
         * to sort between the dates or the total
         */
        switch (sorting) {
            case "1":
                Collections.sort(jobs, new ComparatorJobcostTotal());
                break;
            case "2":
                Collections.sort(jobs, new ComparatorJobDate());
                break;
            default:
                System.out.println("Invalid entry");
        }

        for (Job current : jobs) {
            if (current != null) {
                current.display();
            }
        }
    }

    /**
     * Allow the user to add a new job.
     *
     * @since 20210519
     * @author BJM
     */
    public static void addJob() {
        Job job = new Job();
        job.getInformation();
        job.calculateCost();
        job.display();
        total += job.getCostTotal();

        //Assignment #1 Add to the array
        names.add(job.getCustomer().getFirstName() + " " + job.getCustomer().getLastName());
        jobs.add(job);
    }

    /**
     * show the total of all jobs
     *
     * @since 20210519
     * @author BJM
     */
    public static void showTotal() {
        System.out.println("\nTotal so far: " + CisUtility.getCurrency(total) + System.lineSeparator());
    }

}
