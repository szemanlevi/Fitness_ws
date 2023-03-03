package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
    private int id;
    private String name;
    private int caloriesBurned;
    private MuscleGroup muscleGroup;
    private int workoutId;

    public Exercise(String name, int caloriesBurned, MuscleGroup muscleGroup, int workoutId) {
        this.name = name;
        this.caloriesBurned = caloriesBurned;
        this.muscleGroup = muscleGroup;
        this.workoutId = workoutId;
    }

    public Exercise(String name, int caloriesBurned, String muscleGroup, int workoutId) {
        this.name = name;
        this.caloriesBurned = caloriesBurned;
        this.muscleGroup = MuscleGroup.valueOf(muscleGroup.toUpperCase().replace(" ",""));
        this.workoutId = workoutId;
    }
}
