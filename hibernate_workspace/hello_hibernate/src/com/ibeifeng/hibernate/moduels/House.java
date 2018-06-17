package com.ibeifeng.hibernate.moduels;

import java.util.Date;

public class House {
    private int id;
    private String title;
    private String descreption;
    private double price;
    private Date pubDate;
    private double floorage;
    private String concat;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    public House() {
    }

    public House( String title, String descreption, double price, Date pubDate, double floorage, String concat) {
        this.id = id;
        this.title = title;
        this.descreption = descreption;
        this.price = price;
        this.pubDate = pubDate;
        this.floorage = floorage;
        this.concat = concat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public double getFloorage() {
        return floorage;
    }

    public void setFloorage(double floorage) {
        this.floorage = floorage;
    }

    public String getConcat() {
        return concat;
    }

    public void setConcat(String concat) {
        this.concat = concat;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descreption='" + descreption + '\'' +
                ", price=" + price +
                ", pubDate=" + pubDate +
                ", floorage=" + floorage +
                ", concat='" + concat + '\'' +
                '}';
    }
}
