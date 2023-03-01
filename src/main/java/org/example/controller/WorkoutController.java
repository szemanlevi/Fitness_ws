package org.example.controller;

import org.example.dao.WorkoutDAO;
import org.example.model.Workout;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    private WorkoutDAO workoutDAO;

    public WorkoutController(WorkoutDAO workoutDAO) {
        this.workoutDAO = workoutDAO;
    }

    @GetMapping("/")
    public List<Workout> listAllWorkouts() {
        return workoutDAO.listAllWorkouts();
    }

    @GetMapping(value = "/", params = {"q"})
    public List<Workout> searchWorkouts(@RequestParam("q") String searchTerm) {
        return workoutDAO.listAllWorkouts().stream()
                .filter(workout -> workout.getName().equals(searchTerm))
                .toList();
    }


    @GetMapping("/{id}")
    public Workout getWorkout(@PathVariable("id") int id) {
        return workoutDAO.getWorkout(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable("id") int id) {
        workoutDAO.deleteWorkout(id);
    }

//    MŰKÖDŐ REQUESTPARAM MEGOLDÁS

//    @PostMapping("/")
//    public void postWorkout(@RequestParam("name") String name,
//                            @RequestParam("duration") int duration,
//                            @RequestParam("difficulty") String difficulty) {
//    //        { "name": "Songoku workout", "duration": 30, "difficulty": "Advanced" }
//
//        workoutDAO.addWorkout(new Workout(name, duration, Difficulty.valueOf(difficulty.toUpperCase())));
//    }

    @PostMapping("/")
    public void postWorkout(@RequestBody Workout workout) {
        //        { "name": "Songoku workout", "duration": 30, "difficulty": "Advanced" }

        workoutDAO.addWorkout(workout);
    }
}
