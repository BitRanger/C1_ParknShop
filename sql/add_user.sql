-- create user
create user 'bitranger'@'localhost' identified by '123456';
grant all privileges on *.* to 'bitranger'@'localhost';

-- change password
set password for 'bitranger'@'localhost' = password('123456')