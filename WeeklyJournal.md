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
CREATE USER 'administrator'@'localhost' IDENTIFIED BY 'admin'; <br />
GRANT SELECT ON fortune.* TO 'administrator'@'localhost'; <br />
GRANT INSERT ON fortune.* TO 'administrator'@'localhost'; <br />

### 11/20 - Update
Completed jsp and servlets for project. I had a lot of issues with the configuration. Tomcat needed the JSTL jar 
placed in the lib directory. I fought the hibernate file locations for the web app forever. Also had a hard time
figuring out how to add the frameworks into intellij and not screw up the git version control. Bottomline, I spent
way more time on this than I thought I would have.
    
## 11/23 - Update
Think we are on the same page once again.  Broke some methods into smaller methods.  Believe I had added jDoc to all 
classes and methods. Will double check after getting some sleep.
Some code will need to go through to get full understanding. -AJF

## 11/25 - Update
hibernate was not allowed access to delete records from the web page. Corrected with: <br />
GRANT DELETE ON fortune.* TO 'administrator'@'localhost'; <br />

<br />
started testing 

## 11/28 - Update
Completed tests on the MessageDao. Mike, I am sending you a message on Slack after I push this about the update
method test.  <br /><br />
For the DAOTest, we are sitting at 100% class test coverage (assuming for package), 100% method test coverage, and 85% Line Coverage

<br />
I will be clicking off a couple classes a night before monday.

<br />
Disregard note about update test not working. Solved with
GRANT UPDATE ON fortune.* to 'administrator'@'localhost';