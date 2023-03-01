package org.example.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class DifficultyDeserializer extends JsonDeserializer<Difficulty> {
    @Override
    public Difficulty deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return Difficulty.valueOf(jsonParser.getValueAsString().toUpperCase());
    }
}
