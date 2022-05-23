import java.util.ArrayList;
import java.util.Scanner;

public class HumanResources {

    // Tạo ArrayList lưu danh sách nhân viên
    static ArrayList<Staff> staffList = new ArrayList<>();

    // Tạo ArrayList lưu danh sách phòng ban
    static ArrayList<Department> departmentList = new ArrayList<>();

    // Tạo các phòng ban mới
    static Department designDepartment = new Department("PTK", "Phòng Thiết kế", 0);
    static Department humanDepartment = new Department("PNS", "Phòng Nhân sự", 0);
    static Department maintenanceDepartment = new Department("PBT", "Phòng Bảo trì", 0);

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        addDepartment();
        intro();
        selection(console);
    }

    // Add các phòng ban vào ArrayList
    public static void addDepartment() {
        departmentList.add(designDepartment);
        departmentList.add(humanDepartment);
        departmentList.add(maintenanceDepartment);
    }

    // * "intro"
    public static void intro() {
        introShow();
        mainFunction();
    }
    
    // *.1. "intro show"
    public static void introShow() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++                                            ++");
        System.out.println("++__________Human Resources Software__________++");
        System.out.println("++                                            ++");
        System.out.println("++_________Developed by QuangFX15898__________++");
        System.out.println("++                                            ++");
        System.out.println("++_____Contact: QuangFX15898@funix.edu.vn_____++");
        System.out.println("++                                            ++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    // *.2. "main function"
    public static void mainFunction() {
        System.out.println("\n1. Hiển thị danh sách nhân viên hiện có trong công ty.");
        System.out.println("2. Hiển thị các bộ phận trong công ty.");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
        System.out.println("4. Thêm nhân viên mới vào công ty.");
        System.out.println("5. Tìm kiếm thông tin nhân viên.");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty.");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần\n");
        System.out.print("Chọn 1 ~ 7 để thực hiện các chức năng tương ứng: ");
    }

    // **. "selection" method
    public static void selection(Scanner console) {
        int select = console.nextInt();
        switch (select) {
            case 1:
                showStaffList(console);
                break;
            case 2:
                showAllDepartment(console);
                break;
            case 3:
                showMemberByDepartment(console);
                break;
            case 4:
                addStaff(console);
                break;
            case 5:
                findMember(console);
                break;
            case 6:
                showSalaryTable(console);
                break;
            case 7:
                // sortSalaryTable(console);
        }
    }

    // 1. Hàm "Hiển thị danh sách nhân viên hiện có trong công ty"
    public static void showStaffList(Scanner console) {
        if (staffList.size() == 0) {
            checkStaffList(console);
        } else {
            System.out.println("\nDanh sách nhân viên hiện có trong công ty:");
            for (int i = 0; i < staffList.size(); i++) {
                System.out.println("\nNhân viên " + (i + 1));
                staffList.get(i).displayInformation();
            }
            mainFunction();
            selection(console);
        }
    }

    // 2. Hàm "Hiển thị các bộ phận trong công ty."
    public static void showAllDepartment(Scanner console) {
        System.out.println("\nCác bộ phận của công ty gồm có: \n");
            for (int i = 0; i < departmentList.size(); i++) {
                System.out.println(departmentList.get(i));
            }
        mainFunction();
        selection(console);
    }

    // 3. Hàm "Hiển thị các nhân viên theo từng bộ phận"
    public static void showMemberByDepartment(Scanner console) {
        if (staffList.size() == 0) {
            checkStaffList(console);
        } else {
            // Show design department member ( chạy depart, xong chạy staff)
            if (designDepartment.getTotalMember() == 0) {
                System.out.println("\nPhòng Thiết kế chưa có nhân viên");
            } else {
                System.out.println("\nPhòng Thiết kế có các nhân viên sau: ");
                int iTemp = 1;
                for (int i = 0; i < staffList.size(); i++) {
                    if (staffList.get(i).getDepartment() == "Phòng Thiết kế") {
                        System.out.println("Nhân viên " + iTemp);
                        staffList.get(i).displayInformation();
                        iTemp += 1;
                    }
                }
            }

            // Show human department member
            if (humanDepartment.getTotalMember() == 0) {
                System.out.println("\nPhòng Nhân sự chưa có nhân viên");
            } else {
                System.out.println("\nPhòng Nhân sự có các nhân viên sau: ");
                int iTemp = 1;
                for (int i = 0; i < staffList.size(); i++) {
                    if (staffList.get(i).getDepartment() == "Phòng Nhân sự") {
                        System.out.println("Nhân viên " + iTemp);
                        staffList.get(i).displayInformation();
                        iTemp += 1;
                    }
                }
            }

            // Show maintenance department member
            if (maintenanceDepartment.getTotalMember() == 0) {
                System.out.println("\nPhòng Bảo trì chưa có nhân viên");
            } else {
                System.out.println("\nPhòng Bảo trì có các nhân viên sau: ");
                int iTemp = 1;
                for (int i = 0; i < staffList.size(); i++) {
                    if (staffList.get(i).getDepartment() == "Phòng Bảo trì") {
                        System.out.println("Nhân viên " + iTemp);
                        staffList.get(i).displayInformation();
                        iTemp += 1;
                    }
                }
            }
            mainFunction();
            selection(console);
        }
    }
    
    // 4. Hàm "Thêm nhân viên mới vào công ty"
    public static void addStaff(Scanner console) {
        System.out.print("\nBạn muốn thêm nhân viên gì? (1: Nhân viên thông thường, 2: Nhân viên cấp quản lý) ");
        int answer = console.nextInt();
        switch (answer) {
            case 1:
                addEmployee(console);
                break;
            case 2:
                addManager(console);
        }
    }

    // 4.1 Hàm thêm nhân viên thông thường
    public static void addEmployee(Scanner console) {
        Employee newEmployee = new Employee();       
        System.out.print("\nMã số nhân viên: ");
        String answerString = console.next();
        newEmployee.setStaffId(answerString);
        System.out.print("Tên nhân viên: ");
        answerString = console.next();
        newEmployee.setName(answerString);
        System.out.print("Tuổi nhân viên: ");
        int answerInt = console.nextInt();
        newEmployee.setAge(answerInt);
        System.out.print("Hệ số lương: ");
        Double answerDouble = console.nextDouble();
        newEmployee.setSalaryFactor(answerDouble);
        System.out.print("Ngày vào làm: ");
        answerString = console.next();
        newEmployee.setDayJoined(answerString);
        System.out.print("Bộ phận làm việc: (1. Phòng Thiết kế, 2. Phòng Nhân sự, 3. Phòng Bảo trì) ");
        answerInt = console.nextInt();
            switch (answerInt) {
                case 1:
                    newEmployee.setDepartment("Phòng Thiết kế");
                    addDesignMember();
                    break;
                case 2:
                    newEmployee.setDepartment("Phòng Nhân sự");
                    addHumanMember();
                    break;
                case 3:
                    newEmployee.setDepartment("Phòng Bảo trì");
                    addMaintenanceMember();
            }
        System.out.print("Số ngày nghỉ phép: ");
        answerInt = console.nextInt();
        newEmployee.setAbsent(answerInt);
        System.out.print("Số giờ làm thêm: ");
        answerInt = console.nextInt();
        newEmployee.setOverTime(answerInt);
        staffList.add(newEmployee);
        System.out.print("Thêm nhân viên mới thành công!\n");
        System.out.print("\nBạn muốn thêm nhân viên mới nữa không? (1. Có, 2. Trở về màn hình chính) ");
        answerInt = console.nextInt();
            switch (answerInt) {
                case 1:
                    addStaff(console);
                    break;
                case 2:
                    mainFunction();
                    selection(console);
            }
    }

    // 4.2 Hàm thêm nhân viên cấp quản lý
    public static void addManager(Scanner console) {
        Manager newManager = new Manager();

        System.out.print("\nMã số nhân viên: ");
        String answerString = console.next();
        newManager.setStaffId(answerString);
        System.out.print("Tên nhân viên: ");
        answerString = console.next();
        newManager.setName(answerString);
        System.out.print("Tuổi nhân viên: ");
        int answerInt = console.nextInt();
        newManager.setAge(answerInt);
        System.out.print("Hệ số lương: ");
        Double answerDouble = console.nextDouble();
        newManager.setSalaryFactor(answerDouble);
        System.out.print("Ngày vào làm: ");
        answerString = console.next();
        newManager.setDayJoined(answerString);
        System.out.print("Bộ phận làm việc: (1. Phòng Thiết kế, 2. Phòng Nhân sự, 3. Phòng Bảo trì) ");
        answerInt = console.nextInt();
            switch (answerInt) {
                case 1:
                    newManager.setDepartment("Phòng Thiết kế");
                    addDesignMember();
                    break;
                case 2:
                    newManager.setDepartment("Phòng Nhân sự");
                    addHumanMember();
                    break;
                case 3:
                    newManager.setDepartment("Phòng Bảo trì");
                    addMaintenanceMember();
            }
        System.out.print("Số ngày nghỉ phép: ");
        answerInt = console.nextInt();
        newManager.setAbsent(answerInt);
        System.out.print("Chức danh: (1. Business Leader, 2. Project Leader, 3. Technical Leader) ");
        answerInt = console.nextInt();
        switch (answerInt) {
            case 1:
                newManager.setLevel("Business Leader");
                break;
                case 2:
                newManager.setLevel("Project Leader");
                break;
                case 3:
                newManager.setLevel("Technical Leader");
        }
        staffList.add(newManager);
        System.out.print("\nThêm nhân viên mới thành công!\n");
        System.out.print("\nBạn muốn thêm nhân viên mới nữa không? (1. Có, 2. Trở về màn hình chính) ");
        answerInt = console.nextInt();
            switch (answerInt) {
                case 1:
                    addStaff(console);
                    break;
                case 2:
                    mainFunction();
                    selection(console);
            }
    }

    // 5. Hàm "Tìm kiếm thông tin nhân viên"
    public static void findMember(Scanner console) {
        if (staffList.size() == 0) {
            checkStaffList(console);
            }
        else {
            System.out.print("\nBạn muốn tìm kiếm nhân viên theo tiêu chí nào? (1. Theo tên, 2. Theo mã số nhân viên) ");
            int answerInt = console.nextInt();
            switch (answerInt) {
                case 1:
                    findMemberByName(console);
                    break;
                    case 2:
                    findMemberById(console);
            }
        }
    }
    
    // 5.1 Tìm kiếm thông tin nhân viên theo tên
    public static void findMemberByName(Scanner console) {
        System.out.print("Nhập tên nhân viên bạn muốn tìm: ");
        String answeString = console.next();
        boolean gg = true;
        for (int i = 0; i < staffList.size(); i++) {
            if (answeString.equalsIgnoreCase(staffList.get(i).getName()) == true) {
                gg = false;
                staffList.get(i).displayInformation();
            }
        }
        if (gg == true) {
            System.out.println("\nKhông tìm thấy nhân viên tên " + answeString);
        }
        mainFunction();
        selection(console);
    }

    // 5.2 Tìm kiếm thông tin nhân viên theo ID
    public static void findMemberById(Scanner console) {
        System.out.print("Nhập ID nhân viên bạn muốn tìm: ");
        String answeString = console.next();
        boolean gg = true;
        for (int i = 0; i < staffList.size(); i++) {
            if (answeString.equalsIgnoreCase(staffList.get(i).getStaffId()) == true) {
                gg = false;
                staffList.get(i).displayInformation();
            }
        }
        if (gg == true) {
            System.out.println("\nKhông tìm thấy nhân viên có ID " + answeString);
        }
        mainFunction();
        selection(console);
    }

    // 6. Hàm "Hiển thị bảng lương của nhân viên toàn công ty"
    public static void showSalaryTable(Scanner console) {
        if (staffList.size() == 0) {
            checkStaffList(console);
        } else {
            for (int i = 0; i < staffList.size(); i++) {
                long salary;
                try {
                    salary =  ((Employee) staffList.get(i)).calculatorSalary();
                } catch (Exception e) {
                    salary =  ((Manager) staffList.get(i)).calculatorSalary();
                }
                System.out.println("\nNhân viên " + (i + 1));
                System.out.println("ID: " + staffList.get(i).getStaffId() + " - Tên: " + staffList.get(i).getName() + " - Lương: " + salary);
                
            }
            mainFunction();
            selection(console);
        }
    }
    
    // 7. Hàm "Hiển thị bảng lương của nhân viên theo thứ tự tăng dần"
    // public static void sortSalaryTable(Scanner console) {
    //     if (staffList.size() == 0) {
    //         checkStaffList(console);
    //     } else {
    //         mainFunction();
    //         selection(console);
    //     }
    // }

    // Hàm thêm Design Member vào ArrayList
    public static void addDesignMember() {
        designDepartment.addMember();
    }

    // Hàm add Human Member vào ArrayList
    public static void addHumanMember() {
        humanDepartment.addMember();
    }

    // Hàm add Maintenance Member vào ArrayList
    public static void addMaintenanceMember() {
        maintenanceDepartment.addMember();
    }

    // Hàm kiểm tra danh sách nhân viên
    public static void checkStaffList(Scanner console) {
        System.out.println("\nDanh sánh nhân viên đang trống, hãy thêm nhân viên mới để thực hiện chức năng này!");
            System.out.print("Bạn có muốn thêm nhân viên mới ngay bây giờ không? (1. Có, 2. Không - Trở về màn hình chính) ");
            int answerInt = console.nextInt();
            switch (answerInt) {
                case 1:
                    addStaff(console);
                    break;
                case 2:
                    mainFunction();
                    selection(console);
            }
    }
}