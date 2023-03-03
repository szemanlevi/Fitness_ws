package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workout {
    private int id;
    private String name;
    private int duration;
    private Difficulty difficulty;
    private List<Exercise> exercises;

    public Workout(String name, int duration, Difficulty difficulty, List<Exercise> exercises) {
        this.name = name;
        this.duration = duration;
        this.difficulty = difficulty;
        this.exercises = exercises;
    }

    public Workout(String name, int duration, String difficulty, List<Exercise> exercises) {
        this.name = name;
        this.duration = duration;
        this.difficulty = Difficulty.valueOf(difficulty.toUpperCase());
        this.exercises = exercises;
    }
}
