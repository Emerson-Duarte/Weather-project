package com.example.weather_project.model;


import com.example.weather_project.R;

public enum Profile {

    SIMPLE(R.string.profile_name_simple, R.string.profile_description_simple),
    SURF(R.string.profile_name_surf, R.string.profile_description_surf);



    int name, description;

    Profile(int name, int description) {
        this.name = name;
        this.description = description;
    }

    public int getName() {return this.name; }

    public int getDescription() {return this.description; }


}
