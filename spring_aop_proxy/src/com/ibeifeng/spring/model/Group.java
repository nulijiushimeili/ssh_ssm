package com.ibeifeng.spring.model;

import org.springframework.stereotype.Component;

/**
 * Created by zmzy on 2017/2/15.
 */
@Component("grp1")
public class Group {
    private int id;
    private String name;

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


    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
