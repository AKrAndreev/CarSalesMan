package CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Employee> employees =new ArrayList<>();




    public Department(String departmentName, Employee employee) {
        this.departmentName = departmentName;
        this.employees.add(employee);
    }



    public void setEmployees(Employee employee) {
        this.employees.add(employee);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
