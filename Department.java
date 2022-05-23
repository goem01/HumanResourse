/**
 * Department
 */
public class Department {
    // Property
    private String departmentId;
    private String departmentName;
    private int totalMember = 0;

    // Constructor
    public Department(){

    }
    public Department(String departmentId, String departmentName, int totalMember) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMember = totalMember;
    }

    //Setter
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public void setTotalMember(int totalMember) {
        this.totalMember = totalMember;
    }

    // Getter
    public String getDepartmentId() {
        return departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public int getTotalMember() {
        return totalMember;
    }

    // Method
    public void addMember() {
        totalMember += 1;
    }
    public String toString() {
        return "ID: " + departmentId + " - Tên bộ phận: " + departmentName + " - Số lượng nhân viên: " + totalMember;
    }
}