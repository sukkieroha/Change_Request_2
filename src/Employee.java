public class Employee {
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String birthdate;
    private String sssNumber;
    private String philHealthNumber;
    private String tin;
    private String pagIbigNumber;
    private  String payCoverage;
    private double hourlyRate;
    private double riceAllowance;
    private double phoneAllowance;
    private double clothingAllowance;
    private double netPay;

    public Employee(int employeeNumber,String lastName,String firstName,String birthDate, String sssNumber,
                    String philHealthNumber, String tin,String pagIbigNumber, double hourlyRate, double riceAllowance, double phoneAllowance, double clothingAllowance) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthDate;
        this.sssNumber = sssNumber;
        this.philHealthNumber = philHealthNumber;
        this.tin = tin;
        this.pagIbigNumber = pagIbigNumber;
        this.hourlyRate = hourlyRate;
        this.riceAllowance = riceAllowance;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
    }
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    public  String getBirthdate(){ return birthdate;}
    public void setBirthdate(String birthdate){ this.birthdate = birthdate;}
    public String  getPayCoverage(){return payCoverage;}
    public void  setPayCoverage(String payCoverage){ this.payCoverage = payCoverage;}

    public String getPhilhealthNumber() {
        return philHealthNumber;
    }

    public void setPhilHealthNumber(String philHealthNumber) {
        this.philHealthNumber = philHealthNumber;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getPagIbigNumber() {
        return pagIbigNumber;
    }

    public void setPagIbigNumber(String pagIbigNumber) {
        this.pagIbigNumber = pagIbigNumber;
    }

    // methods for calculating weekly salary, etc.//
    public double computeBasicPay() {
        double hoursWorked = 0;
        double basicPay = hourlyRate * hoursWorked;
        return basicPay;
    }

    public double computeGrossPay(double basicPay) {
        double hoursWorked = 0;
        basicPay = hourlyRate * hoursWorked;;
        return basicPay + computeAllowances();
    }

    public double computeAllowances() {
        double riceAllowance = this.riceAllowance / 4;
        double phoneAllowance = this.phoneAllowance / 4;
        double clothingAllowance = this.clothingAllowance / 4;
        double totalAllowances = riceAllowance + phoneAllowance + clothingAllowance;

        return totalAllowances;
    }

    public double computeSSSDeduction(double basicPay) {
        double sssDeduction = 0.0;
        if (basicPay >= 1000.00 && basicPay <= 1249.99) {
            sssDeduction = 36.30;
        } else if (basicPay >= 1250.00 && basicPay <= 1749.99) {
            sssDeduction = 54.50;
        } else if (basicPay >= 1750.00 && basicPay <= 2249.99) {
            sssDeduction = 72.70;
        } else if (basicPay >= 2250.00 && basicPay <= 2749.99) {
            sssDeduction = 90.80;
        }
        return sssDeduction;
    }
    public double computeTax(double taxableIncome) {
        double taxDeduction = 0.0;
        if (taxableIncome > 250000) {
            double taxableAmount = taxableIncome - 250000;
            if (taxableAmount <= 400000) {
                taxDeduction = taxableAmount * 0.2;
            } else if (taxableAmount <= 800000) {
                taxDeduction = 40000 + ((taxableAmount - 400000) * 0.25);
            } else {
                taxDeduction = 200000 + ((taxableAmount - 800000) * 0.3);
            }
        }
        return taxDeduction;
    }
    public double computeNetPay(double basicPay) {
        double philHealthDeduction = computeBasicPay() * .03;
        double pagIbigDeduction = computeBasicPay() * .03;
        double taxableIncome = computeGrossPay(basicPay)- pagIbigDeduction - philHealthDeduction-computeSSSDeduction(basicPay);
        return computeGrossPay(basicPay) - computeSSSDeduction(basicPay) - philHealthDeduction - pagIbigDeduction - computeTax(taxableIncome);
    }
}

