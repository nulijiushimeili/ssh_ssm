package com.ibeifeng.hibernate.moduels;

public class HouseDTO {
    private String htitle ;
    private String uname;

    public HouseDTO(String htitle, String uname) {
        this.htitle = htitle;
        this.uname = uname;
    }

    public HouseDTO() {
    }

    public String getTitle() {
        return htitle;
    }

    public void setTitle(String htitle) {
        this.htitle = htitle;
    }

    public String getName() {
        return uname;
    }

    public void setName(String uname) {
        this.uname = uname;
    }
}
