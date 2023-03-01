package org.example.dao;

import org.example.model.Exercise;
import org.example.model.MuscleGroup;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ExerciseRowMapper implements RowMapper<Exercise> {

    @Override
    public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
        Exercise exercise = new Exercise();
        exercise.setId(rs.getInt("id"));
        exercise.setName(rs.getString("name"));
        exercise.setCaloriesBurned(rs.getInt("calories_burned"));
        exercise.setMuscleGroup((MuscleGroup) rs.getObject("muscle_group"));
        return exercise;
    }
}
