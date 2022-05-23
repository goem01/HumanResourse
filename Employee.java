/**
 * Employee
 */
public class Employee extends Staff implements ICalculator{

    // Property
    private int overTime;

    // Constructor
    public Employee() {
        
    }
    public Employee(String staffId, String name, int age, double salaryFactor, String address, String dateJoined, String department, int absent, int overTime) {
        super(staffId, name, age, salaryFactor, address, dateJoined, department, absent);
        this.overTime = overTime;
    }

    // Setter
    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    // Getter
    public int getOverTime() {
        return overTime;
    }

    @Override
    public void displayInformation() {
        System.out.println("Mã số\t\t\t: " + getStaffId());
        System.out.println("Tên\t\t\t: " + getName());
        System.out.println("Tuổi\t\t\t: " + getAge());
        System.out.println("Hệ số lương\t\t: " + getSalaryFactor());
        System.out.println("Ngày vào làm\t\t: " + getDayJoined());
        System.out.println("Bộ phận làm việc\t: " + getDepartment());
        System.out.println("Số ngày nghỉ phép\t: " + getAbsent());
        System.out.println("Số giờ làm thêm\t\t: " + getOverTime());
    }

    @Override
    public long calculatorSalary() {
        // Hệ số lương * 3,000,000 + số giờ làm thêm * 200,000
        long salary = (long) (getSalaryFactor() * 3000000 + getOverTime() * 200000);
        return salary;
    }
}