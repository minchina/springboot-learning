CREATE TABLE IF NOT EXISTS person  (
  id INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(64),
  age   INTEGER);


CREATE TABLE IF NOT EXISTS station (
  id INTEGER IDENTITY PRIMARY KEY,
  stationCode VARCHAR(64),
  stationName VARCHAR(64)
  );