package com.example.myapplication;

public class Post {
    private String id, userId, title, body;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Post(String id, String userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
}
