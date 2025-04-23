package com.example.siirimnew1.data.model;

public class Poem {
    private String id;
    private String title;
    private String content;
    private String poetId;

    public Poem() {
        // Firestore için boş constructor
    }

    public Poem(String id, String title, String content, String poetId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.poetId = poetId;
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
} 