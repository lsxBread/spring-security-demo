insert into users (username, encoded_password) values
('leo', '$2a$10$mFWhalbw1vhT5dhjNnoYZu9uiSS7bF4LssnP.mbPyLP9tsEMEgT.6'),
('mary', '$2a$10$mFWhalbw1vhT5dhjNnoYZu9uiSS7bF4LssnP.mbPyLP9tsEMEgT.6'),
('tom', '$2a$10$mFWhalbw1vhT5dhjNnoYZu9uiSS7bF4LssnP.mbPyLP9tsEMEgT.6');

insert into authorities (permission) values
('student:read'),
('student:write'),
('ROLE_ADMIN'),
('ROLE_STUDENT'),
('ROLE_ADMINTRAINEE');

insert into users_authorities (user_id, authority_id)
select users.id, authorities.id from users, authorities
where users.username='leo' and authorities.permission='ROLE_STUDENT';

insert into users_authorities (user_id, authority_id)
select users.id, authorities.id from users, authorities
where users.username='mary' and authorities.permission='ROLE_ADMIN';

insert into users_authorities (user_id, authority_id)
select users.id, authorities.id from users, authorities
where users.username='mary' and authorities.permission='student:read';

insert into users_authorities (user_id, authority_id)
select users.id, authorities.id from users, authorities
where users.username='mary' and authorities.permission='student:write';

insert into users_authorities (user_id, authority_id)
select users.id, authorities.id from users, authorities
where users.username='tom' and authorities.permission='ROLE_ADMINTRAINEE';

insert into users_authorities (user_id, authority_id)
select users.id, authorities.id from users, authorities
where users.username='tom' and authorities.permission='student:read';
