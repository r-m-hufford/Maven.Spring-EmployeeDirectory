package io.zipcoder.persistenceapp.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "HIRE_DATE")
    private String hireDate;
    @Column(name = "MANAGER_ID")
    private Long managerId;
    @Column(name = "DEPT_NUM")
    private Long deptNum;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getHireDate() {
        return hireDate;
    }

    public Long getManagerId() {
        return managerId;
    }

    public Long getDeptNum() {
        return deptNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public void setDeptNum(Long deptNum) {
        this.deptNum = deptNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(title, employee.title) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(email, employee.email) && Objects.equals(hireDate, employee.hireDate) && Objects.equals(managerId, employee.managerId) && Objects.equals(deptNum, employee.deptNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, title, phoneNumber, email, hireDate, managerId, deptNum);
    }

    @Override
    public String toString() {
        return "Employee{" +
                " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", manager='" + managerId + '\'' +
                ", department='" + deptNum + '\'' +
                '}';
    }
}
