package pojo;

import java.io.Serializable;

public class Employee implements Serializable {
   Integer empid;
    String empname;
    String age;
    String email;
    String sex;

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", department=" + department +
                '}';
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    Department department;

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Employee(Integer empid, String empname, String age, String email, String sex) {
        this.empid = empid;
        this.empname = empname;
        this.age = age;
        this.email = email;
        this.sex = sex;
    }

    public Employee() {
    }
}
