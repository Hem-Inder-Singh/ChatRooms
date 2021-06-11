# ChatRooms
A Java GUI based chatting desktop project made with *Swings, AWT, JDBC and MySQL.*
<br>
# Basic Overview :technologist:
This is Client-Server based Chatting Desktop Application made using Java Programming Language. In this project we have Server-side admin controls in which I have created Admin Login and Admin Home from which Admin can manage rooms, add rooms and Change his password etc. It supports the most basic functions of sending text, image messages and also sending document files within a Room members.
It is made on LocalHost.
# What You will Need ?
- NetBeans 8.2 IDE 
- JDK 8
- Download and unzip the source repository for this guide.
- cd into the path that you previous Download.<br>
*After doing the above setup download MySQL Workbench by installing it from below links*
<b> MySQL Download Links:--</b><br>
Step1:<br>
https://drive.google.com/file/d/1A8qc0vnjJsD7oS9KSwn1dLzYcUk-ecBu/view?usp=sharing <br>
Step2:<br>
https://drive.google.com/file/d/1iN0qSu7GJ7ZpYyj1O0ooLmYvyfIgyX6E/view?usp=sharing
<br></br>
# Build the Sample:smile::thumbsup:
If you download the sample ZIP, be sure to unzip the entire archive.</ol>
- Start Netbeans and select <b> File > Open > Project.</b><br>
- <b>Importing Database(Schema+Data)</b>
-- Import the Database in the MySQL database using MySQL WorkBench
MySQL Workbench->Data Import/Restore->Load Folder Contents->SQL-> dumpfiles present in the src folder.
<br></br>
- Connect the JDBC driver(JConnector) by including the it's JAR File in the Project<br>
Expand Project->Libraries->(Right Click)ADD JAR File->include file: mysql-connector-java-5.1.40-bin.jar
<h2>Working with Images explained</h2><br>
1. Run :running_man: ServerGUI.java <br>
2. Click on Start Server<br>
3. Minimize the GUI window.<br>
4. Run :running_man: UserLogin.java<br>
5. Put Credentials:- Username and Password and then click on login.<br>
If not a user SignUp and Then Login.<br>
6. User Home will open.<br>
7. Click on Any Room under any category that you want to join.<br>
8. Click on Join <br>
9. Start Chatting....:smile: <br>
10. After you are done Click on Logout and you will land back to UserLogin GUI.
<br>
</br>
<h3><i>On the Admin Side/Server Side</i></h3><br>
You have similar controls as User's controls.<br>
Steps for that are:
1. Run ServerGUI.java<br> 
2. Click on Start Server<br>
<b>If already running then no need to re-run.</b><br>
3. Fill credentials: Username and password.<br>
4.Click on Login and You will see Admin Home page.<br>
5. And perform any of the required function shown.<br>
After you are done...:star_struck: <br>
Don't forget to stop the server from ServerGUI.java opened at back or minimized. 
<br>
Check Out ScreenShots of the project in Screenshot project folder in src folder 







