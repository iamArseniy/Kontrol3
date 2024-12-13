CREATE TABLE gifts
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    giver_name    VARCHAR(255) NOT NULL,
    receiver_name VARCHAR(255) NOT NULL,
    delivery_date DATE         NOT NULL
);
