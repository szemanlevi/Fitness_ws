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

    public Exercise(String name, int caloriesBurned, MuscleGroup muscleGroup) {
        this.name = name;
        this.caloriesBurned = caloriesBurned;
        this.muscleGroup = muscleGroup;
    }

    public Exercise(String name, int caloriesBurned, String muscleGroup) {
        this.name = name;
        this.caloriesBurned = caloriesBurned;
        this.muscleGroup = MuscleGroup.valueOf(muscleGroup.toUpperCase().replace(" ",""));
    }
}
