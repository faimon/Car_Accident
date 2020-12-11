CREATE TABLE accident
(
    id          serial primary key,
    description TEXT,
    carNumber   varchar(50),
    address     varchar(200),
    photoPath   varchar(200),
    status      varchar(200)
);