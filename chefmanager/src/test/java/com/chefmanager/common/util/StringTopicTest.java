package com.chefmanager.common.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTopicTest {

    @Test
    public void shouldReturnJsonString() {
        String expected = "{\n" +
                "  \"title\": \"Modo de preparo\",\n" +
                "  \"description\": \"misturar ovo, manteiga e farinha\"\n" +
                "}";

        StringTopic topic = new StringTopic("Modo de preparo", "misturar ovo, manteiga e farinha");

        assertEquals(expected, topic.toString());
    }
}
