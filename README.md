# GroupAdamMike
Group Project which user will input birth date and receive enlightened message.

## Initial Database configuration
* CREATE DATABASE fortune;
* USE fortune;
* CREATE TABLE message ( <br />
id INT NOT NULL AUTO_INCREMENT, <br />
text VARCHAR(250) NOT NULL, <br />
PRIMARY KEY (id) <br />
);
* INSERT INTO message (text) <br />
VALUE (“You will live a happy life.”); <br />
* INSERT INTO message (text) <br />
VALUE (“Do your homework tonight. Tomorrow will be too late.”); <br />
* INSERT INTO message (text) <br />
VALUE (“Remember to wash your hands after using the restroom. I always do.”); <br />

           