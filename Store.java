/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 * This is the Store interface file.
 *
 * @author Goteti Santosh Ravi Teja
 */
public interface Store {

    /**
     * It is a constant field value.
     */
    static final double COMMISSION_RATE = 0.10;

    /**
     * It is a constant field value.
     */
    static final double TAX = 0.14;

    /**
     *
     * @return- This method returns the calculateCommission.
     */
    public double calculateCommission();

    /**
     *
     * @param storeSales - The parameter storeSales is passed.
     * @return - This method returns the remaining store revenue.
     */
    public double calculateRemainingStoreRevenue(double storeSales);

    /**
     * 
     * @param managersList - List of all the managers.
     * @param salesList - List of all the sales associate.
     * @param inventoryControlsList - List of all the inventory controls.
     * @return - This method returns the total pay for all employees.
     */
    public double calculateTotalEmployeePay(ArrayList<Manager> managersList, ArrayList<SalesAssociate> salesList,
            ArrayList<InventoryControl> inventoryControlsList);
}
