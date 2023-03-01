package org.example.dao;

import org.example.model.Workout;

import java.util.List;

public interface WorkoutDAO {
    void addWorkout(Workout workout);
    void deleteWorkout(int id);
    Workout getWorkout(int id);
    void updateWorkout(int id, Workout workout);
    List<Workout> listAllWorkouts();
}
