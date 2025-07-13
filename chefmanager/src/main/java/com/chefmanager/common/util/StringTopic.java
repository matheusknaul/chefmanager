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

    /**
     * Use this only when getting json from database.
     * */
    public StringTopic(String jsonString){

        /**
         * Make the code safer and better in the next refactoring.
         * */

        jsonString = jsonString.replaceAll("[\\{\\}\\n\\r\"]","");
        jsonString = jsonString.replace("description: ", "");
        jsonString = jsonString.replace("title: ", "");
        String[] elements = jsonString.split(",",2);
        this.setTitle(elements[0]);
        this.setDescription(elements[1]);
    }

    public String toJsonString(){
        StringBuilder str = new StringBuilder();
        str.append("{\n");
        str.append("\"title\": \"").append(getTitle()).append("\",\n");
        str.append("\"description\": \"").append(getDescription()).append("\"\n");
        str.append("}");

        return str.toString();
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
