package org.example.dao;

import org.example.model.Exercise;
import org.example.model.Workout;

import java.util.List;

public interface ExerciseDAO {
    void addExercise(Exercise exercise);
    void deleteExercise(int id);
    Exercise getExercise(int id);
    void updateExercise(int id, Exercise exercise);
    List<Exercise> listAllExercises();
}
