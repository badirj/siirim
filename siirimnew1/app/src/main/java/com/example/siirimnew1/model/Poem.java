package com.example.siirimnew1.model;

import com.google.gson.annotations.SerializedName;

public class Poem {
    @SerializedName("id")
    private String id;
    
    @SerializedName("title")
    private String title;
    
    @SerializedName("content")
    private String content;
    
    @SerializedName("poetId")
    private String poetId;
    
    @SerializedName("createdAt")
    private String createdAt;

    public Poem() {
        // Firestore için boş constructor
    }

    public Poem(String id, String title, String content, String poetId, String createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.poetId = poetId;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPoetId() {
        return poetId;
    }

    public String getCreatedAt() {
        return createdAt;
    }
} 