package com.example.siirimnew1.model;

import com.google.gson.annotations.SerializedName;

public class Poet {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("biography")
    private String biography;

    @SerializedName("photoUrl")
    private String photoUrl;

    @SerializedName("birthDate")
    private String birthDate;

    @SerializedName("deathDate")
    private String deathDate;

    public Poet(int id, String name, String biography, String photoUrl, String birthDate, String deathDate) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.photoUrl = photoUrl;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    // Getter ve Setter metodları
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }
} 