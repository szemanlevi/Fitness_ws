package org.example.controller;

import jakarta.websocket.server.PathParam;
import org.example.dao.ExerciseDAO;
import org.example.model.Exercise;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {
    private ExerciseDAO exerciseDAO;

    public ExerciseController(ExerciseDAO exerciseDAO) {
        this.exerciseDAO = exerciseDAO;
    }

    @GetMapping("/")
    public List<Exercise> listAllExercises() {
        return exerciseDAO.listAllExercises();
    }

    @GetMapping(value = "/", params = {"q"})
    public List<Exercise> searchExercises(@RequestParam("q") String searchTerm) {
        return  exerciseDAO.listAllExercises().stream()
                .filter(exercise -> exercise.getName().equals(searchTerm))
                .toList();
    }

    @GetMapping("/{id}")
    public Exercise getExercise(@PathParam("id") int id) {
        return exerciseDAO.getExercise(id);
    }

    @DeleteMapping("/{id}")
    public void deleteExercise(@PathParam("id") int id) {
        exerciseDAO.deleteExercise(id);
    }

    @PostMapping("/")
    public void postExercise(@RequestBody Exercise exercise) {
//        { "name": "Bench press", "caloriesBurned": 100, "muscleGroup": "Chest"}
        exerciseDAO.addExercise(exercise);
    }
}
