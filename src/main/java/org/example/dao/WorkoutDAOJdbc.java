package org.example.dao;

import org.example.model.Workout;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkoutDAOJdbc implements WorkoutDAO {

    JdbcTemplate jdbcTemplate;

    WorkoutRowMapper workoutRowMapper;
    private static final Logger logger = LoggerFactory.getLogger(WorkoutDAOJdbc.class);

    @Autowired
    public WorkoutDAOJdbc(JdbcTemplate jdbcTemplate, WorkoutRowMapper workoutRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.workoutRowMapper = workoutRowMapper;
    }

    @Override
    public void addWorkout(Workout workout) {
        final String sql = """
                INSERT INTO
                workout (name, duration, difficulty)
                VALUES
                (?, ?, ?)
                """;
        int log = jdbcTemplate.update(sql, workout.getName(), workout.getDuration(), workout.getDifficulty());
        if (log == 1) {
            logger.info("new workout added");
        } else {
            logger.warn("problem occured while adding workout");
        }
    }

    @Override
    public void deleteWorkout(int id) {

    }

    @Override
    public Workout getWorkout(int id) {
        return null;
    }

    @Override
    public void updateWorkout(int id, Workout workout) {

    }

    @Override
    public List<Workout> listAllWorkouts() {
        return null;
    }
}
