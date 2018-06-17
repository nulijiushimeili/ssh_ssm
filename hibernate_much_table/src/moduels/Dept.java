package moduels;

public class Dept {
    private int id ;
    private String deptNo;
    private String deptName;

    public Dept() {
    }

    public Dept( String deptNo, String deptName) {
        this.deptNo = deptNo;
        this.deptName = deptName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptNo='" + deptNo + '\'' +
                ", deptName='" + deptName + '\'' +
                  +
                '}';
    }
}
