package org.example.dao;

import org.example.model.Workout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WorkoutDAOJdbc implements WorkoutDAO {

    private static final Logger logger = LoggerFactory.getLogger(WorkoutDAOJdbc.class);
    JdbcTemplate jdbcTemplate;
    WorkoutRowMapper workoutRowMapper;

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
        int log = jdbcTemplate.update(sql, workout.getName(), workout.getDuration(), workout.getDifficulty().toString().toUpperCase());
        if (log == 1) {
            logger.info("new workout added");
        } else {
            logger.warn("problem occured while adding workout");
        }
    }

    @Override
    public void deleteWorkout(int id) {
        final String sql = """
                DELETE FROM workout
                WHERE id = ?
                """;
        int log = jdbcTemplate.update(sql, id);
        if (log == 1) {
            logger.info("workout with id = {} deleted", id);
        } else {
            logger.warn("problem occured while deleting workout");
        }
    }

    @Override
    public Workout getWorkout(int id) {
        final String sql = """
                SELECT * FROM workout
                WHERE id = ?
                """;
        Workout workout = new Workout();
        try {
            workout = jdbcTemplate.queryForObject(sql, new Object[]{id}, workoutRowMapper);

        } catch (DataAccessException e) {
            logger.warn("id not found");
        } catch (Exception e) {
            logger.warn("unexpected error occured");
        }
        return workout;
    }

    @Override
    public void updateWorkout(int id, Workout workout) {
        final String sql = """
                UPDATE workout
                SET name = ?,
                duration = ?,
                difficulty = ?
                WHERE id = ?
                """;
        int log = jdbcTemplate.update(sql, workout.getName(), workout.getDuration(), workout.getDifficulty(), id);
        if (log == 1) {
            logger.info("workout with id = {} updated", id);
        } else {
            logger.warn("problem occured while updating workout");
        }
    }

    @Override
    public List<Workout> listAllWorkouts() {
        final String sql = """
                SELECT * FROM workout
                """;
        List<Workout> workouts = new ArrayList<>();
        try {
            workouts = jdbcTemplate.query(sql, workoutRowMapper);
        } catch (DataAccessException e) {
            logger.warn("workouts not found");
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("unexpected error occured");
        }
        return workouts;
    }
}
