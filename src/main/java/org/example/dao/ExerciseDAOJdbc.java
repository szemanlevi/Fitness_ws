package org.example.dao;

import org.example.model.Exercise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ExerciseDAOJdbc implements ExerciseDAO {

    private static final Logger logger = LoggerFactory.getLogger(ExerciseDAOJdbc.class);
    JdbcTemplate jdbcTemplate;
    ExerciseRowMapper exerciseRowMapper;

    @Autowired
    public ExerciseDAOJdbc(JdbcTemplate jdbcTemplate, ExerciseRowMapper exerciseRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.exerciseRowMapper = exerciseRowMapper;
    }

    @Override
    public void addExercise(Exercise exercise) {
        final String sql = """
                INSERT INTO exercise 
                (name, calories_burned, muscle_group)
                VALUES (?, ?, ?)
                """;
        int log = jdbcTemplate.update(sql, exercise.getName(), exercise.getCaloriesBurned(), exercise.getMuscleGroup().toString().toUpperCase().replace(" ",""));
        if (log == 1) {
            logger.info("new exercise added");
        } else {
            logger.warn("problem occured while adding exercise");
        }
    }

    @Override
    public void deleteExercise(int id) {
        final String sql = """
                DELETE FROM exercise
                WHERE id = ?
                """;
        int log = jdbcTemplate.update(sql, id);
        if (log == 1) {
            logger.info("exercise with id = {} deleted", id);
        } else {
            logger.warn("problem occured while deleting exercise");
        }
    }

    @Override
    public Exercise getExercise(int id) {
        final String sql = """
                SELECT * FROM exercise
                WHERE id = ?
                """;
        Exercise exercise = new Exercise();
        try {
            exercise = jdbcTemplate.queryForObject(sql, new Object[]{id}, exerciseRowMapper);
        } catch (DataAccessException e) {
            logger.warn("id not found");
        } catch (Exception e) {
            logger.warn("unexpected error occured");
        }
        return exercise;
    }

    @Override
    public void updateExercise(int id, Exercise exercise) {
        final String sql = """
                UPDATE exercise
                SET name = ?,
                calroies_burned = ?,
                muscle_group = ?
                WHERE id = ?
                """;
        int log = jdbcTemplate.update(sql, exercise.getName(), exercise.getCaloriesBurned(), exercise.getMuscleGroup(), id);
        if (log == 1) {
            logger.info("exercise with id = {} updated", id);
        } else {
            logger.warn("problem occured while updating exercise");
        }
    }

    @Override
    public List<Exercise> listAllExercises() {
        final String sql = """
                SELECT * FROM exercise
                """;
        List<Exercise> exercises = new ArrayList<>();
        try {
            exercises = jdbcTemplate.query(sql, exerciseRowMapper);
        } catch (DataAccessException e) {
            logger.warn("exercises not found");
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("unexpected error occured");
        }
        return exercises;
    }
}
