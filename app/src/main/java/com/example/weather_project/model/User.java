package com.example.weather_project.model;

public class User {
    private String name;
    private String city;
    private Profile profile;
    private String image;


    public User(String name, String city, Profile profile, String image) {
        this.name = name;
        this.city = city;
        this.profile = profile;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
