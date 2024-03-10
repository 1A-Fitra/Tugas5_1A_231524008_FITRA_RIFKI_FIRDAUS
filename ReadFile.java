import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            Scanner scanner = new Scanner(new File("textInput.txt")).useDelimiter(";");

            @SuppressWarnings("unused")
            String str;

            while (scanner.hasNext()) {
                if (scanner.hasNext("\n")) {
                    scanner.skip("\n");
                }

                String employeeType = scanner.next();
                String storeDetails = scanner.next();
                String empName = scanner.next();
                double basePay = scanner.nextDouble();
                double numberOfHoursWorked = scanner.nextDouble();
                double hourlyRate = scanner.nextDouble();

                if (employeeType.equals("Manager")) {
                    double currentSales = scanner.nextDouble();
                    double CurrentStoreSales = scanner.nextDouble();

                    Manager manager = new Manager(CurrentStoreSales, currentSales, numberOfHoursWorked,
                            hourlyRate, storeDetails, basePay, empName);
                    System.out.println(manager.toString());

                    if (scanner.hasNext())
                        str = scanner.nextLine();

                } else if (employeeType.equals("SalesAssociate")) {
                    double salesRate = scanner.nextDouble();

                    SalesAssociate salesAssociate = new SalesAssociate(salesRate, numberOfHoursWorked, hourlyRate,
                            storeDetails, empName, basePay);
                    System.out.println(salesAssociate.toString());

                    if (scanner.hasNext())
                        str = scanner.nextLine();
                } else {
                    int itemIn = scanner.nextInt();
                    int itemLoss = scanner.nextInt();

                    InventoryControl inventoryControl = new InventoryControl(numberOfHoursWorked, hourlyRate,
                            storeDetails,
                            basePay, empName, itemIn, itemLoss);
                    System.out.println(inventoryControl.toString());

                    if (scanner.hasNext())
                        scanner.nextLine();
                }
            }

            scanner.close();
        } catch (Exception FileNotFoundException) {
            System.err.println("File Not Found.");
        }
    }
}
