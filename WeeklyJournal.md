# Weekly Journal
### 11/13 - Update
Been having a hard time adding the javaEE application and the web module into the project. Spent nearly six hours <br />
trying to figure this out. My main issue was adding those modules into the existing project module. I ended up <br />
making a new module and somehow making it work. Mainly to get the version control to stay with Git. I then had <br /> 
an issue with the deployment still using the newly created module name even after I refactored the module. <br />
Finally found that under Run/Edit Configuration/Deployment tab. Like I said, way more time than I anticipated for <br />
for the setup.

### 11/14 - Update
Added user to table <br />
CREATE USER 'administrator'@'localhost' IDENTIFIED BY 'admin';
GRANT SELECT ON fortune.* TO 'administrator'@'localhost';
GRANT INSERT ON fortune.* TO 'administrator'@'localhost';
    
    