package com.example.claudine.reservetables.models;

/**
 * Created by salmaali on 12/3/15.
 */
public class Comment {

    private String text;
    private String imageUrl;
    private String user;

    public Comment(String imageUrl, String text, String user) {
        this.imageUrl = imageUrl;
        this.text = text;
        this.user = user;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getText() {
        return text;
    }

    public String getUser() {
        return user;
    }
}
