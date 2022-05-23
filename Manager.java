public class Manager extends Staff implements ICalculator{

    // Property
    private String level;

    // Constructor
    public Manager(){
        
    }
    public Manager(String staffId, String name, int age, double salaryFactor, String address, String dateJoined,
            String department, int absent, String level) {
        super(staffId, name, age, salaryFactor, address, dateJoined, department, absent);
        this.level = level;
    }

    // Setter
    public void setLevel(String level) {
        this.level = level;
    }

    // Getter
    public String getLevel() {
        return level;
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
        System.out.println("Chức danh\t\t: " + getLevel());
    }

    @Override
    public long calculatorSalary() {
        long salary = 0;
        switch (getLevel()) {
            case "Business Leader":
                salary = (long) (getSalaryFactor() * 5000000 + 8000000);
                break;
            case "Project Leader":
                salary = (long) (getSalaryFactor() * 5000000 + 5000000);
                break;
            case "Technical Leader":
                salary = (long) (getSalaryFactor() * 5000000 + 6000000);
        }
        return salary;
    }
}
