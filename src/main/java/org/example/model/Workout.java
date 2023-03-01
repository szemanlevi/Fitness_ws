package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workout {
    private int id;
    private String name;
    private int duration;
    private Difficulty difficulty;

    public Workout(String name, int duration, Difficulty difficulty) {
        this.name = name;
        this.duration = duration;
        this.difficulty = difficulty;
    }

    public Workout(String name, int duration, String difficulty) {
        this.name = name;
        this.duration = duration;
        this.difficulty = Difficulty.valueOf(difficulty.toUpperCase());
    }
}
