package pojo;

import java.util.List;

public class Department {
    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Department() {
    }

    int deptid;
    String deptname;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    List<Employee> employeeList;

    @Override
    public String toString() {
        return "Department{" +
                "deptid=" + deptid +
                ", deptname='" + deptname + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }

    public Department(int deptid, String deptname) {
        this.deptid = deptid;
        this.deptname = deptname;
    }
}
