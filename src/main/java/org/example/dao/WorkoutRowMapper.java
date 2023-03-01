package org.example.dao;

import org.example.model.Difficulty;
import org.example.model.Workout;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class WorkoutRowMapper implements RowMapper<Workout> {

    @Override
    public Workout mapRow(ResultSet rs, int rowNum) throws SQLException {
        Workout workout = new Workout();
        workout.setId(rs.getInt("id"));
        workout.setName(rs.getString("name"));
        workout.setDuration(rs.getInt("duration"));
        workout.setDifficulty(Difficulty.valueOf(rs.getString("difficulty").toUpperCase()));
        return workout;
    }
}
