# Operated environment
windows 10, 64bit<br>

# Needs
tomcat v9.0<br>
: https://tomcat.apache.org/download-90.cgi - 32-bit/64-bit Windows Service Installer<br>
<br>
MySQL<br>
: https://dev.mysql.com/downloads/installer/ - Windows (x86, 32-bit), MSI Installer<br>
<br>
mysql-connector-java-8.0.19.jar(included)<br>
<br>
eclipse ee 2019-12<br>
: https://www.eclipse.org/downloads/packages/release/neon/3/eclipse-ide-java-ee-developers
<br>
jdk1.8.0_241<br>
: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html - jdk-8u241-windows-x64.exe<br>
<br>
bootstrap v4.1.3(included)<br>
<br>
dbcp-1.4.jar(included)<br>
<br>
pool-1.6.jar<br>
<br>
MySQL Workbench(optional)<br>
: https://dev.mysql.com/downloads/workbench/ - Windows (x86, 64-bit), MSI Installer<br>
<br>


# How to install or use this
1. Install jdk, oracle database, tomcat, eclipse ee<br>
  1-1.<br>
  Tomcat admin port : 8005<br>
  HTTP/1.1 : 8090<br>
  AJP/1.3 : 8009<br>
2. File - Import - General - Existing Projects into Workspace - Choose directory -JSP-WhatShouldWeEat - Finish
3. Create a new server - Apache - Tomcat v9.0 Server - Choose your tomcat directory (like C:\Program Files\Apache Software Foundation\Tomcat 9.0) - Next - Add WhatFood - Finish
4. Set up your environment properly such as jre, tomcat in Project(WhatFood) - Java Build Path<br>
4. Modify some source for database<br>
  4-1. Project Explorer - Tomcat v9.0.. - server - change port "-1" to "8005" next to "shutdown"<br>
  4-2. Project Explorer - Tomcat v9.0.. - context - change your database information<br>
5. Create tables with 'MySQL Workbench' or 'on cmd' by WhatFood.sql<br>
6. Open WebContent - FoodMain.jsp - Run


![Screenshot](https://user-images.githubusercontent.com/37391569/68544379-417a4d00-03cb-11ea-9d17-2f4a34cb6ac4.JPG)
<br>
<br>
<br>
Here demonstrations on youtube
<br>
[![demonstrations](https://img.youtube.com/vi/qnrUlDF8amw/0.jpg)](https://www.youtube.com/watch?v=qnrUlDF8amw)
<br>
<br>
<br>

## Class Diagram
![class Diagram](https://user-images.githubusercontent.com/37391569/72594819-c34aa180-394b-11ea-9916-9568bf74288d.png)
## Sequence Diagram Board
![sequence Diagram Board](https://user-images.githubusercontent.com/37391569/72594828-c6459200-394b-11ea-8258-2382709efdc6.png)
## Sequence Diagram Food
![sequence Diagram Food](https://user-images.githubusercontent.com/37391569/72594829-c6459200-394b-11ea-8f76-deedf10b64e6.png)
## Sequence Diagram Member
![sequence Diagram Member](https://user-images.githubusercontent.com/37391569/72594830-c6de2880-394b-11ea-872a-05b2dcfe13ef.png)
## Usecase Diagram
![Usecase Diagram](https://user-images.githubusercontent.com/37391569/72594840-c9d91900-394b-11ea-8a8b-1352e7967fb4.png)

# 10.11.19 fixed the application

### Recommit<br>
<ul>
<li>This project was the team project.</li>
<li>We did this project at the Dongseo University on 09/2018 - 12/2018.</li>
<br>
<li>This project has some databases which are necessary data of food and about temporary users.</li>
<li>The database is based on MySQL and we used MySQL Workbench tools.</li>
<br>
<li>Also, It has some extra files.</li>
<li>UML of this project.</li>
<li>PPT file of this project in Korean.</li>
</ul>

---------------------------------------------------------------------------------------

# WebProgramming

A web programming project of 'Software development practice 4' at the Dongseo University<br>

The project name : What Should we eat today<br>

The team name : 3 idiots<br>

Members :<br>

한창기(code main functions and design DB and make UML)<br>

박현빈(Me)(code boards and make UML)<br>

박우현(apply CSS and give a presentation)<br>
<br>
<br>
<br>
Made in December, 2018
