package moduels;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_emp")
@NamedQuery( name = "findEmpById" , query = "from Emp where id = :id")
@Cacheable(true)
public class Emp {
    private int id;
    private String empNo;
    private String empName;

    private Dept dept;

    public Emp() {
    }



    public Emp(String empNo, String empName) {
        this.empNo = empNo;
        this.empName = empName;
    }



    @Id
    @GenericGenerator(name = "native" , strategy = "native")
    @GeneratedValue(generator = "native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "emp_no")
    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +

                '}';
    }

    @ManyToOne
    @JoinColumn(name = "dept_id")
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
