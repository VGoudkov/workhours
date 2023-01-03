INSERT INTO wh_division(id, description)
VALUES (100, 'Division 100');
INSERT INTO wh_position(id, description,  division_fk)
VALUES (200, 'Position 200',  100);
INSERT INTO wh_position(id, description,  division_fk)
VALUES (201, 'Position 201', 100);
