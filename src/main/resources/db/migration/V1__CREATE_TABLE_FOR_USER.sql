create table users (
    id serial primary key,
    username varchar(30),
    encoded_password varchar(100)
)