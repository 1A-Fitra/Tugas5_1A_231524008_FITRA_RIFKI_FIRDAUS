/**
 * This is the InventoryControl file extends the AbstractStoreemployee
 * clsss file.
 * 
 * @author - Fitra Rifki Firdaus
 */
public class InventoryControl extends AbstractStoreEmployee {

    private int itemIn;
    private int itemLoss;

    /**
     * This is a constructor which initializes all the attributes for
     * an Inventory Specialist object.
     * 
     * @param numberOfHoursWorked - Number of hours workd by the
     *                            Inventory specialist passed
     * @param hourlyRate          - The parameter Hourly rate for the Manager is
     *                            passed.
     * @param storeDetails        - The parameterDetails of the Store is passed.
     * @param basePay             - The parameter Base Pay Rate is passed.
     * @param employeeName        - The parameter Name of the Manager is passed.
     * @param itemIn              - The parameter item shipped in by Inventory
     *                            Specialist
     * @param itemLoss            - The parameter item lost during sales
     */
    public InventoryControl(double numberOfHoursWorked, double hourlyRate, String storeDetails, double basePay,
            String employeeName, int itemIn, int itemLoss) {
        super(numberOfHoursWorked, hourlyRate, storeDetails, basePay, employeeName);
        this.itemIn = itemIn;
        this.itemLoss = itemLoss;
    }

    /**
     * Returns the total commission of the Sales Associate in dollars.
     *
     * @return - This method returns the commission in dollars.
     */
    @Override
    public double calculateCommission() {
        if ((getItemIn() / (getItemIn() + getItemLoss())) * 100 > 80)
            return super.getBasePay() * COMMISSION_RATE;
        else
            return 0;
    }

    /**
     * Returns calculated Pay of the Sales Associate. The calculated pay is the
     * sum of basePay, commission and the product of number of hours worked and
     * hourly rate.
     *
     * @return - This method returns Payment of the Sales Associate.
     */
    @Override
    public double calculatePay() {
        return super.getBasePay() + calculateCommission() + (super.getNumberOfHoursWorked() * super.getHourlyRate());
    }

    /**
     * Checks if the employee should be awarded with a promotion.
     *
     * @return - This method returns boolean the eligibility status for
     *         promotion for an employee.
     */
    @Override
    public boolean checkPromotionEligibility() {
        double itemLossPercentage = ((double) getItemLoss() / (double) getItemIn()) * 100;
        if (itemLossPercentage < 10)
            return true;
        else
            return false;
    }

    /**
     * Check if the employee should be terminated.
     * 
     * @return - This method returns boolean the eligibility status for
     *           termination of an employee.
     */
    @Override
    public boolean checkTerminationEligiblity() {
        if ((getItemLoss() / getItemIn()) > 0.3) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void leavePermission() {
        if (getItemIn() > 500) {
            System.out.println(getEmployeeName() + " is allowed to leave.");
        }
        else {
            System.out.println(getEmployeeName() + " is not allowed to leave.");
        }
    }

    /**
     * Returns the String representation of Sales. Append Super Class toString()
     * along with the Sales Rate.
     *
     * @return - This method returns a String representation of Sales and
     *         Employee details.
     */
    @Override
    public String toString() {
        return super.toString() + "Item Shipped In: " + getItemIn() + "\nItem Loss: " + getItemLoss();
    }

    /**
     * Item shipped in by Inventory Specialist
     * 
     * @return - Return the amount of item shipped in by inventory specialist
     */
    public int getItemIn() {
        return itemIn;
    }

    /**
     * Set a value for itemIn attribute
     * 
     * @param itemIn - The parameter itemIn is passed.
     */
    public void setItemIn(int itemIn) {
        this.itemIn = itemIn;
    }

    /**
     * Item loss during sales
     * 
     * @return - Return the amount of item lost during sales
     */
    public int getItemLoss() {
        return itemLoss;
    }

    /**
     * Set a value for itemLoss attribute
     * 
     * @param itemIn - The parameter itemLoss is passed.
     */
    public void setItemLoss(int itemLoss) {
        this.itemLoss = itemLoss;
    }
}