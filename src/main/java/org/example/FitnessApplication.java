package org.example;

import org.example.dao.WorkoutDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessApplication {
    private WorkoutDAO workoutDAO;

    public FitnessApplication(WorkoutDAO workoutDAO) {
        this.workoutDAO = workoutDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(FitnessApplication.class, args);
    }
}