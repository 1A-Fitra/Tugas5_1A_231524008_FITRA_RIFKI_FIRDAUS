/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Application launches from this class
 *
 * @author Goteti Santosh Ravi Teja
 */
public class StoreDriver {
        /**
         *
         * @param args the command line arguments
         * @throws java.io.FileNotFoundException
         */
        public static void main(String[] args) throws FileNotFoundException {

                // 1. Declare variables managerCount, salesAssociateCount of type integer and
                // initialize them to 0.
                int managerCount = 0;
                int salesAssociateCount = 0;
                int inventoryControlCount = 0;
                // 2. Declare & initialize an object for PrintWriter class and use the file name
                // "outputFile.txt" to write the corresponding data
                PrintWriter pwd = new PrintWriter(new File("outputFile.txt"));
                // 3. Declare and initialize a scanner object "scanner" to read from the file
                // "inputFile.txt"
                Scanner sc = new Scanner(new File("inputFile.txt")).useDelimiter(";");
                // 4. Declare and initialize a List object of type Manager as "managerList", and
                // initialize the object as an ArrayList.
                List<Manager> managerList = new ArrayList<Manager>();
                // 5. Declare and initialize a List object of type SalesAssociate as
                // "salesAssociateList", and initialize the object as an ArrayList.
                List<SalesAssociate> SalesAssociateList = new ArrayList<SalesAssociate>();
                List<InventoryControl> InventoryControlList = new ArrayList<InventoryControl>();
                // 6. While inputFile.txt has more data(While loop starts here) {
                while (sc.hasNext()) {
                        String employeeType = sc.next();
                        String storeDetails = sc.next();
                        String empName = sc.next();
                        double basePay = sc.nextDouble();
                        double numberOfHoursWorked = sc.nextDouble();
                        double hourlyRate = sc.nextDouble();

                        // Read in the data, and store them to the respective variables such as,
                        // employeeType, storeDetails, empName variables of type String.
                        // basePay, numberOfHoursWorked and hourlyRate as type double
                        // 7. If the employee type in the inputFile is "Manager" , then declare
                        // variables currentSales, CurrentStoreSales of type double
                        // and read the data.
                        if (employeeType.equals("Manager")) {
                                double currentSales = sc.nextDouble();
                                double CurrentStoreSales = sc.nextDouble();

                                // 7a. create an object for Manager named as "manager"
                                // and initialize the multiple argument constructor with above mentioned
                                // variables in (question 6 & 7).
                                // Then add the manager object to the arrayList of managerList.If the employee
                                // type is not manager then
                                // declare a variable salesRate of type double and scan the element, now create
                                // an object for salesAssociate named as "salesAssociate",
                                // initialize the sales associate by invoking the constructor of SalesAssociate
                                // class with above mentioned variables (question 6 & 7).
                                // Then add the salesAssociate object to the arrayList of salesAssociateList
                                Manager manager = new Manager(CurrentStoreSales, currentSales, numberOfHoursWorked,
                                                hourlyRate, storeDetails, basePay, empName);
                                if (sc.hasNext()) {
                                        @SuppressWarnings("unused")
                                        String str = sc.nextLine();
                                }
                                managerList.add(manager);

                        } else if (employeeType.equals("SalesAssociate")) {
                                double salesRate = sc.nextDouble();
                                SalesAssociate salesAssociate = new SalesAssociate(salesRate, numberOfHoursWorked,
                                                hourlyRate,
                                                storeDetails, empName, basePay);
                                if (sc.hasNext()) {
                                        @SuppressWarnings("unused")
                                        String str = sc.nextLine();
                                }
                                SalesAssociateList.add(salesAssociate);
                        } else {
                                int itemIn = sc.nextInt();
                                int itemLoss = sc.nextInt();

                                InventoryControl inventoryControl = new InventoryControl(numberOfHoursWorked,
                                                hourlyRate, storeDetails,
                                                basePay, empName, itemIn, itemLoss);
                                if (sc.hasNext()) {
                                        @SuppressWarnings("unused")
                                        String str = sc.nextLine();
                                }
                                InventoryControlList.add(inventoryControl);
                        }

                }

                // While Loop ends here
                // 8. Print the size of the managerList to the console and outputfile. See the
                // sample output for sample formatting
                System.out.println("******************************************************");
                System.out.println("Number of employees working as MANAGER are: " + managerList.size());
                System.out.println("******************************************************");
                pwd.println("******************************************************");
                pwd.println("Number of employees working as MANAGER are: " + managerList.size());
                pwd.println("******************************************************");
                // 9. Use an enhanced for loop and iterate through managerList which is of type
                // Manager and use "manager" as variable.
                // Increment the count of the managerCount by one every time loop is started.
                // Now test the toString() method of manager class. Also write this output to
                // the console & outputFile. Test the salesPercentByManager of manager class and
                // write the output to both console and output file.
                // Test the calculatePay(), calculateRemainingStoreRevenue(double), and
                // checkPromotionEligibility() method of manager class and write the output to
                // both console and output file. Do the required String formatting by seeing the
                // sample output

                for (Manager manager : managerList) {
                        managerCount++;
                        System.out.println(managerCount + ". Manager Details:");
                        System.out.println(manager);
                        pwd.println(managerCount + ". Manager Details:");
                        pwd.println(manager);
                        System.out.println(
                                        "Percentage of sales done: "
                                                        + String.format("%.2f", manager.salesPercentByManager()) + "%");
                        pwd.println("Percentage of sales done: "
                                        + String.format("%.2f", manager.salesPercentByManager()) + "%");
                        System.out.println("Gross Payment: $" + String.format("%.1f", manager.calculatePay()));
                        pwd.println("Gross Payment: $" + String.format("%.1f", manager.calculatePay()));
                        System.out.println("Remaining store revenue: $"
                                        + manager.calculateRemainingStoreRevenue(manager.getTotalStoreSales()));
                        pwd.println("Remaining store revenue: $"
                                        + manager.calculateRemainingStoreRevenue(manager.getTotalStoreSales()));

                        System.out.println("Is " + manager.getEmployeeName() + " eligible for promotion? "
                                        + ((manager.checkPromotionEligibility())
                                                        ? "Yes, he is"
                                                        : "No, he needs to work harder"));
                        System.out.println("Should " + manager.getEmployeeName() + " be terminated? "
                                        + ((manager.checkTerminationEligiblity())
                                                        ? "Consider termination"
                                                        : "Keep " + manager.getEmployeeName()));
                }

                // For Loop ends here
                // 10.Print the size of the salesAssociateList to the console and outputfile.
                // See the sample output for sample formatting
                System.out.println("******************************************************");
                System.out.println("Number of employees working as SALES ASSOCIATES are: " + SalesAssociateList.size());
                System.out.println("******************************************************");
                pwd.println("******************************************************");
                pwd.println("Number of employees working as SALES ASSOCIATES are: " + SalesAssociateList.size());
                pwd.println("******************************************************");

                // 11. Use a enhanced for loop and iterate through salesAssociateList which is
                // of type SalesAssociate and use "salesAssociate" as variable.
                // Increment the count of the salesAssociateCount by one every time loop is
                // started. Now test the toString() method of SalesAssociate class. Also write
                // this output to
                // the console & outputFile.
                // Test the calculatePay(), calculateCommission(), and
                // checkPromotionEligibility() method of salesAssociate class and write the
                // output to both console and output file. Do the required String formatting by
                // seeing the sample output
                for (SalesAssociate salesAssociate : SalesAssociateList) {
                        salesAssociateCount++;
                        System.out.println(salesAssociateCount + ". Sales Associate Details:");
                        System.out.println(salesAssociate);
                        pwd.println(salesAssociate);
                        System.out.println("Total commission: $" + salesAssociate.calculateCommission());
                        System.out.println("Gross Payment: $" + salesAssociate.calculatePay());

                        pwd.println("Total commission: $" + salesAssociate.calculateCommission());
                        pwd.println("Gross Payment: $" + salesAssociate.calculatePay());
                        System.out.println("Is " + salesAssociate.getEmployeeName() + " eligible for promotion? "
                                        + ((salesAssociate.checkPromotionEligibility())
                                                        ? "Yes, he/she is eligible"
                                                        : "No, he/she needs to work harder"));
                        System.out.println("Should " + salesAssociate.getEmployeeName() + " be terminated? "
                                        + ((salesAssociate.checkTerminationEligiblity())
                                                        ? "Consider termination."
                                                        : "Keep " + salesAssociate.getEmployeeName()));
                }

                System.out.println("******************************************************");
                System.out.println(
                                "Number of employees working as INVENTORY CONTROL are: " + InventoryControlList.size());
                System.out.println("******************************************************");
                pwd.println("******************************************************");
                pwd.println("Number of employees working as INVENTORY CONTROL are: " + InventoryControlList.size());
                pwd.println("******************************************************");

                for (InventoryControl inventoryControl : InventoryControlList) {
                        inventoryControlCount++;
                        System.out.println(inventoryControlCount + ". Inventory Control Details: ");
                        System.out.println(inventoryControl);
                        pwd.println(inventoryControl);
                        System.out.println("Total comission: $" + inventoryControl.calculateCommission());
                        System.out.println("Gross Payment: $" + inventoryControl.calculatePay());

                        pwd.println("Total comission: $" + inventoryControl.calculateCommission());
                        pwd.println("Gross Payment: $" + inventoryControl.calculatePay());

                        System.out.println("Is " + inventoryControl.getEmployeeName() + " eligible for promotion? "
                                        + ((inventoryControl.checkPromotionEligibility())
                                                        ? "Yes, he/she is eligible"
                                                        : "No, he/she needs to work harder"));
                        System.out.println("Should " + inventoryControl.getEmployeeName() + " be terminated? "
                                        + ((inventoryControl.checkTerminationEligiblity())
                                                        ? "Consider termination of"
                                                        : "Keep " + inventoryControl.getEmployeeName()));
                }

                sc.close();
                pwd.close();
                // For loop ends after this
        }
}
