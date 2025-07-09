package com.chefmanager.common.util;

import java.util.List;

/**
 * String structure to organize documentation or explanatory topics.
 * */

public class StringDocTopic {

    private String title;
    private List<String> subtopics;
    private List<String> descriptionSubTopic;

    public StringDocTopic(String title, List<String> subtopics, List<String> descriptionSubTopic) {
        this.title = title;
        this.subtopics = subtopics;
        this.descriptionSubTopic = descriptionSubTopic;
    }

    public String toString(){

    }

    public String toJson(){

    }

    public String fromJson(){

    }
}
