package io.zipcoder.persistenceapp.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DEPT_NAME")
    private String deptName;
    @Column(name = "MANAGER_ID")
    private Long managerId;

    public Department() {}

    public Long getId() { return id; }

    public String getDeptName() {
        return deptName;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) && Objects.equals(deptName, that.deptName) && Objects.equals(managerId, that.managerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deptName, managerId);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", managerId=" + managerId +
                '}';
    }
}
