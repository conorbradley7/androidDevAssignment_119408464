package com.example.androiddevassignment_119408464;

import java.io.Serializable;

public class Player implements Serializable {
    // Player Class describing player objects
    // Data to be taken from XML

    private String name, nationality, age, position, shirt_num, image, appearances, goals, assists, major_trophies, bio, quote;

    public String getAppearances() {
        return appearances;
    }

    public void setAppearances(String appearances) {
        this.appearances = appearances;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getMajor_trophies() {
        return major_trophies;
    }

    public void setMajor_trophies(String major_trophies) {
        this.major_trophies = major_trophies;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Player(String name, String nationality, String age, String position, String shirt_num, String image, String appearances, String goals, String assists, String major_trophies, String bio, String quote) {
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.position = position;
        this.shirt_num = shirt_num;
        this.image = image;
        this.appearances = appearances;
        this.goals = goals;
        this.assists = assists;
        this.major_trophies = major_trophies;
        this.bio = bio;
        this.quote = quote;
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