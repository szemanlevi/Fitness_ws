-- DROP TABLE workout;
-- DROP TABLE exercise;
CREATE TABLE IF NOT EXISTS workout
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(50) NOT NULL,
    duration   INT         NOT NULL,
    difficulty VARCHAR(20) NOT NULL
);
CREATE TABLE IF NOT EXISTS exercise
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(50) NOT NULL,
    calories_burned INT         NOT NULL,
    muscle_group    VARCHAR(20) NOT NULL,
    workout_id      INT         NOT NULL,
    FOREIGN KEY (workout_id) REFERENCES workout (id)
);

-- ALTER TABLE exercise
-- ADD COLUMN workout_id INTEGER REFERENCES workout(id) DEFAULT NULL;