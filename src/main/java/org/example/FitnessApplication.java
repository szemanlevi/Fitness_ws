package org.example;

import org.example.dao.WorkoutDAO;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessApplication {
//    private WorkoutDAO workoutDAO;

//    public FitnessApplication(WorkoutDAO workoutDAO) {
//        this.workoutDAO = workoutDAO;
//    }

    public static void main(String[] args) {
        // Create the Flyway instance and point it to the database
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:~/fitness", "sa", null).load();
        // Start the migration
        flyway.migrate();
        SpringApplication.run(FitnessApplication.class, args);
    }
}