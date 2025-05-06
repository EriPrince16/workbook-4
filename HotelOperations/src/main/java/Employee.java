public class Employee {
    String employeeId;
    String name;
    String department;
    double payRate;
    double hoursWorked;
    double startTime; // time the employee last punched in
    boolean isWorking; // whether the employee is currently punched in

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.isWorking = false;
    }

    public void punchIn(double time) {
        if (isWorking) {
            System.out.println(name + " is already punched in.");
        } else {
            startTime = time;
            isWorking = true;
            System.out.println(name + " punched in at " + time);
        }
    }

    public void punchOut(double time) {
        if (!isWorking) {
            System.out.println(name + " hasn't punched in yet.");
        } else {
            double hours = time - startTime;
            if (hours < 0) {
                System.out.println("Invalid time. Punch out must be after punch in.");
            } else {
                hoursWorked += hours;
                System.out.println(name + " punched out at " + time + ", worked " + hours + " hours.");
            }
            isWorking = false;
        }
    }

    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    public double getTotalPay() {
        double regularPay = getRegularHours() * payRate;
        double overtimePay = getOvertimeHours() * payRate * 1.5;
        return regularPay + overtimePay;
    }

    // Getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }
}
