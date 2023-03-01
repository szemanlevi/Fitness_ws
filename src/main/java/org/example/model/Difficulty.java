package org.example.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = DifficultyDeserializer.class)
public enum Difficulty {
    BEGINNER, INTERMEDIATE, ADVANCED;
}
