package io.zipcoder.persistenceapp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptNum;
    private String deptName;
    private String manager;

    public Department() {}

    public Long getDeptNum() {
        return deptNum;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getManager() {
        return manager;
    }

    public void setDeptNum(Long deptNum) {
        this.deptNum = deptNum;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(deptNum, that.deptNum) && Objects.equals(deptName, that.deptName) && Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptNum, deptName, manager);
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptNum=" + deptNum +
                ", deptName='" + deptName + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
