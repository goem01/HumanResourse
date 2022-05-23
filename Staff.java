public abstract class Staff{

    // Property
    private String staffId;
    private String name;
    private int age;
    private double salaryFactor;
    private String dateJoined;
    private String department;
    private int absent;

    // Constructor
    public Staff(){
        
    }
    public Staff(String staffId, String name, int age, double salaryFactor, String address, String dateJoined, String department, int absent) {
        this.staffId = staffId;
        this.name = name;
        this.age = age;
        this.salaryFactor = salaryFactor;
        this.dateJoined = dateJoined;
        this.department = department;
        this.absent = absent;
    }
    
    // Setter
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSalaryFactor(double salaryFactor) {
        this.salaryFactor = salaryFactor;
    }
    public void setDayJoined(String dayJoined) {
        this.dateJoined = dayJoined;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setAbsent(int absent) {
        this.absent = absent;
    }

    // Getter
    public String getStaffId() {
        return staffId;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getSalaryFactor() {
        return salaryFactor;
    }
    public String getDayJoined() {
        return dateJoined;
    }
    public String getDepartment() {
        return department;
    }
    public int getAbsent() {
        return absent;
    }
    
    public abstract void displayInformation();
}