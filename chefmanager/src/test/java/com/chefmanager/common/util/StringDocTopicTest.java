package com.chefmanager.common.util;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringDocTopicTest {

    @Test
    public void shouldReturnJsonString(){
        String jsonString = "\"{ \\\"title\\\": \\\"Modo de preparo\\\", \\\"description\\\": \\\"misturar ovo, manteiga e farinha\\\" }\"";
        StringTopic topic = new StringTopic("Modo de preparo", "misturar ovo, manteiga e farinha");
        assertEquals(jsonString, topic);
    }

}
