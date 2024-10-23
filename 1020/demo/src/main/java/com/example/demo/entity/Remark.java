package com.example.demo.entity;

public class Remark {


    private String type;

    private String content;

    public Remark(String type, String content) {
        this.content = content;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }


}
