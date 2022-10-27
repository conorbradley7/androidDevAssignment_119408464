package com.example.androiddevassignment_119408464;

import java.io.Serializable;

public class Player implements Serializable {
    // Player Class describing player objects
    // Data to be taken from XML

    private String name, nationality, position, shirt_num, image;

    public Player(String name, String nationality, String position, String shirt_num, String image) {
        this.name = name;
        this.nationality = nationality;
        this.position = position;
        this.shirt_num = shirt_num;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getShirt_num() {
        return shirt_num;
    }

    public void setShirt_num(String shirt_num) {
        this.shirt_num = shirt_num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String url) {
        this.image = url;
    }


}