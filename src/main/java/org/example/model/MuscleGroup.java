package org.example.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = MuscleGroupDeserializer.class)
public enum MuscleGroup {
    ARMS, LEGS, CHEST, BACK, ABS, CORE, FULLBODY;
}
