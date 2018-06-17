package moduels;


import java.util.HashSet;
import java.util.Set;

public class Admin {
    private int id;
    private String name;

    private Set<Role> roles;

    public void addRoles(Role role){
        roles.add(role);
    }

    public Admin (){}

    public Admin(String name){
        roles = new HashSet<>();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}
