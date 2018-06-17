package com.ibeifeng.hibernate.moduels;

public class User {
    private int id;
    private String name;
    private String password;
    private String telephone;
    private String username;
    private String isAdmin;    //Y | N

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(){}

    public User(int id, String name, String password, String telephone, String username, String isAdmin) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.username = username;
        this.isAdmin = isAdmin;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", username='" + username + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                '}';
    }
}
