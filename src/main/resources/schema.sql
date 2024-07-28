CREATE TABLE IF NOT EXISTS list (
    id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(100) NOT NULL,
    description varchar(250) NOT NULL
);