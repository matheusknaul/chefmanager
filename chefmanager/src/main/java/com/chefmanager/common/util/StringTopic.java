package com.chefmanager.common.util;

/**
 * String structure to organize documentation or explanatory topics.
 * */

public class StringTopic {

    private String title;
    private String description;

    public StringTopic(String title, String description) {
        this.setTitle(title);
        this.setDescription(description);
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("{\n");
        str.append("  \"title\": \"").append(getTitle()).append("\",\n");
        str.append("  \"description\": \"").append(getDescription()).append("\n");
        str.append("}");

        return str.toString();
    }

    public String toJson(){
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"title\": \"").append(getTitle()).append("\",\n");
        json.append("  \"description\": \"").append(getDescription()).append("\n");
        json.append("}");

        return json.toString();
    }

    public String fromJson(){
        String done = new String();
        return done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
