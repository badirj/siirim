package com.example.siirimnew1.data.model;

public class Poet {
    private String id;
    private String name;
    private String dates;
    private String bio;
    private String imageUrl;

    public Poet() {
        // Firestore için boş constructor
    }

    public Poet(String id, String name, String dates, String bio, String imageUrl) {
        this.id = id;
        this.name = name;
        this.dates = dates;
        this.bio = bio;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDates() {
        return dates;
    }

    public String getBio() {
        return bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }
} 