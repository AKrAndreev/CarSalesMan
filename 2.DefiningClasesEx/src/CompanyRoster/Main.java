package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Department> departments = new ArrayList<>();

        for (int i = 0; i <n ; i++) {

            String[] data = reader.readLine().split(" ");
            if (data.length==6){
                String name = data[0];
                double salary = Double.parseDouble(data[1]);
                String position = data[2];
                String department = data[3];
                String email = data[4];
                int age = Integer.parseInt(data[5]);
                boolean flag = true;
                Employee employee = new Employee(name,salary,position,department,email,age);
                for (Department department1 : departments) {
                    if (department1.getDepartmentName().equals(department)) {
                        department1.setEmployees(employee);
                        flag = false;
                    }
                }
                if (flag) {
                    Department department1 = new Department(department,employee);
                    departments.add(department1);
                }



            }else if(data.length==4){
                String name = data[0];
                double salary = Double.parseDouble(data[1]);
                String position = data[2];
                String department = data[3];
                boolean flag = true;
                Employee employee = new Employee(name, salary, position, department);

                for (Department department1 : departments) {
                    if (department1.getDepartmentName().equals(department)) {
                        department1.setEmployees(employee);
                        flag = false;
                    }
                }
                if (flag) {
                    Department department1 = new Department(department,employee);
                    departments.add(department1);
                }
            }else {
                String name = data[0];
                double salary = Double.parseDouble(data[1]);
                String position = data[2];
                String department = data[3];
                String last = data[4];

                boolean flag = true;
                Employee employee = isNumEmployee(name, salary, position, department,last);

                for (Department department1 : departments) {
                    if (department1.getDepartmentName().equals(department)) {
                        department1.setEmployees(employee);
                        flag = false;
                    }
                }
                if (flag) {
                    Department department1 = new Department(department,employee);
                    departments.add(department1);
                }
            }
        }


        departments.stream().sorted((d1,d2)->{
            double a = d1.getEmployees().stream().mapToDouble(Employee::getSalary).sum()/d1.getEmployees().size();
            double b = d2.getEmployees().stream().mapToDouble(Employee::getSalary).sum()/d2.getEmployees().size();

            return Double.compare(b,a);
        }).limit(1)
                .forEach(d ->{
                    List<Employee> tempList = d.getEmployees().stream().sorted((e1,e2)->{
                        double x = e1.getSalary();
                        double y = e2.getSalary();

                        return Double.compare(y,x);
                    }).collect(Collectors.toList());
                    System.out.printf("Highest Average Salary: %s%n",d.getDepartmentName());
                    for (Employee employee : tempList) {
                        System.out.println(employee.toString());
                    }
                });
    }

    private static Employee isNumEmployee(String name, double salary, String position, String department, String last) {

        Employee tempEmp = new Employee();
    try {
        int a = Integer.parseInt(last);

        tempEmp=new Employee(name,salary,position,department,a);
        return tempEmp;
    }catch (Exception e){
        tempEmp = new Employee(name,salary,position,department,last);
    return tempEmp;
    }
    }
}
