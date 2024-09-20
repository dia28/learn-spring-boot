package com.learning.mvcdemo.model;

import java.util.List;

public class Student {
    private String lastName;
    private String firstName;
    private String country;
    private String favouriteLanguage;
    private List<String> favouriteOSs;

    public Student() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public List<String> getFavouriteOSs() {
        return favouriteOSs;
    }

    public void setFavouriteOSs(List<String> favouriteOSs) {
        this.favouriteOSs = favouriteOSs;
    }
}
