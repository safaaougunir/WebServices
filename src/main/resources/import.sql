INSERT INTO LIGHT (ID, LEVEL, STATUS) VALUES (1, 20,'ON');
INSERT INTO LIGHT (ID, LEVEL, STATUS) VALUES (2, 20,'OFF');
INSERT INTO LIGHT (ID, LEVEL, STATUS) VALUES (3, 20,'ON');
INSERT INTO NOISE (ID, LEVEL, STATUS) VALUES (1, 30,'ON');
INSERT INTO NOISE (ID, LEVEL, STATUS) VALUES (2, 30,'ON');
INSERT INTO NOISE (ID, LEVEL, STATUS) VALUES (3, 30,'ON');

INSERT INTO ROOM (ID, LIGHT_ID, NOISE_ID) VALUES (1, 1, 1);
INSERT INTO ROOM (ID, LIGHT_ID, NOISE_ID) VALUES (2, 2, 1);
INSERT INTO ROOM (ID, LIGHT_ID, NOISE_ID) VALUES (3, 3, 1);

INSERT INTO BUILDING (ID, NAME) VALUES (1,'Ecole des mines');
INSERT INTO BUILDING (ID, NAME) VALUES (2,'Espace fauriel');
INSERT INTO BUILDING (ID, NAME) VALUES (3,'Telecome saint étienne');

INSERT INTO BUILDING_ROOMS (BUILDING_ID, ROOMS_ID) VALUES (1,1);
INSERT INTO BUILDING_ROOMS (BUILDING_ID, ROOMS_ID) VALUES (2,2);
INSERT INTO BUILDING_ROOMS (BUILDING_ID, ROOMS_ID) VALUES (3,3);


