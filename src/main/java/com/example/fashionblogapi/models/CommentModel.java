package com.example.fashionblogapi.models;

public class CommentModel {
    private String text;
    private Long posttId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getPosttId() {

        return posttId;
    }

    public void setPosttId(Long posttId) {
        this.posttId = posttId;
    }
}
