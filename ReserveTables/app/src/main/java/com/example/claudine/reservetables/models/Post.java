package com.example.claudine.reservetables.models;

/**
 * Created by salmaali on 12/3/15.
 */
public class Post {

    private String text;
    private int comments;
    private String imageUrl;
    private String user;

    public String getUser() {
        return user;
    }

    public Post(int comments, String text, String user) {
        this.comments = comments;
        this.text = text;
        this.user = user;
    }

    public Post(int comments, String text, String user, String imageUrl) {
        this.comments = comments;
        this.text = text;
        this.user = user;
        this.imageUrl = imageUrl;
    }

    public int getComments() {
        return comments;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getText() {
        return text;
    }
}
