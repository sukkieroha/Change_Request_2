import javax.swing.*;
import java.util.Scanner;
public class SalaryCalculator {
    public static void main(String[] args) {
        // Create an instance of the SalaryCalculatorGUI class and display it
        SwingUtilities.invokeLater(() -> {
            SalaryCalculatorGUI gui = new SalaryCalculatorGUI();
            gui.setVisible(true);
        });

        Scanner input = new Scanner(System.in);

        // Declare and initialize variables
        int employeeNumber;
        String firstName, lastName, birthDate, payCoverage;
        double hourlyRate, hoursWorked, riceAllowance, phoneAllowance, clothingAllowance, sssNumber, pagIbigNumber, philHealthNumber, tin, sssDeduction, philHealthDeduction, pagIbigDeduction, grossPay, netPay, taxDeduction;

        // Prompt user for employee details
        System.out.print("Enter first name: ");
        firstName = input.nextLine();
        System.out.print("Enter last name: ");
        lastName = input.nextLine();
        System.out.print("Enter employee ID: ");
        employeeNumber = Integer.parseInt(input.nextLine());
        System.out.print("Enter employee birthdate: ");
        birthDate = input.nextLine();

        // Exception handling for pay coverage
        boolean isValidPayCoverage = false;
        do {
            System.out.print("Enter pay coverage (weekly): ");
            payCoverage = input.nextLine();
            if (payCoverage.equalsIgnoreCase("weekly")) {
                isValidPayCoverage = true;
            } else {
                System.out.println("Invalid pay coverage. Please try again.");
            }
        } while (!isValidPayCoverage);

        // Employee array
        Employee[] employees =
                new Employee[]{new Employee(10001, "Crisostomo", "Jose", "01-01-1990", "49-1632020-8", "382189453145", "317-674-022-000", "441093369646", 150, 1500, 1200, 1000)};
                 new Employee(10002, "Mata", "Christian", "02-02-1990", "49-2959312-6", "824187961962", "103-100-522-000", "631052853464", 200, 1200, 1400, 1300);
                 new Employee(10003, "San Jose", "Brad", "03-03-1990", "40-2400714-1", "239192926939", "672-474-690-000", "210850209964", 100, 1200, 1300, 1400);

        // Prompt user for hours worked
        System.out.print("Enter hours worked: ");
        hoursWorked = input.nextDouble();

        // Find index of employee in array
        int index = 1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeNumber() == employeeNumber) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found");
        } else {
            grossPay = employees[index].computeGrossPay(hoursWorked);
            netPay = employees[index].computeNetPay(grossPay);
            System.out.println("Gross pay: Php" + String.format("%.2f", grossPay));
            System.out.println("Net pay: Php" + String.format("%.2f", netPay));


        }
    }
}
