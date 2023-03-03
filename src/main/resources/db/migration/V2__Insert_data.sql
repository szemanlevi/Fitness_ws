INSERT INTO workout (name, duration, difficulty)
VALUES ('Full Body Workout', 60, 'Intermediate'),
       ('Cardio Blast', 30, 'Advanced'),
       ('Yoga Flow', 45, 'Beginner');

INSERT INTO exercise (name, calories_burned, muscle_group, workout_id)
VALUES ('Squats', 100, 'Legs', 1),
       ('Push-ups', 80, 'Chest', 1),
       ('Bicep curls', 60, 'Arms', 1),
       ('Plank', 50, 'Core', 3),
       ('Lunges', 90, 'Legs', 2),
       ('Burpees', 120, 'Full Body', 2),
       ('Tricep dips', 70, 'Arms', 1),
       ('Crunches', 40, 'Core', 2);