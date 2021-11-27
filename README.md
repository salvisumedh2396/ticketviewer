<h1 align="center">==== Zendesk TicketViewer System ====</h1>
  
<h2 align="center"> A place to view all the available tickets on your zendesk platform </h1>

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/salvisumedh2396/ticketviewer)
![Lines of code](https://img.shields.io/tokei/lines/github/salvisumedh2396/ticketviewer)

## Development Environment Used and Dependencies:
- Java (Version 9 or higher)
- Maven project (all required dependencies have been added to pom)
- IDE used : Intellij
- OS used and tested on : Windows 10

## New to Java..??
1. Install Java 7 or higher from here: https://www.java.com/en/download/manual.jsp
2. Install java JDK from here: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html?
3. Add JDK path 
4. Windows: First determine the location of your JDK bin. Typically this will be C:\Program Files\Java\bin followed by the JDK directory.
	- Enter control Panel -> System and Security -> System -> Advanced System Settings
	- Click 'Environment Variables' button
	- find the PATH environment variable and select it -> Click Edit. If the PATH environment variable does not exist, click New.
	- In the Edit System Variable (or New System Variable) window, specify the value of the PATH environment variable. Click OK. Close all remaining windows by clicking OK.

## Usage Instructions:
1. Download the project from github to you computer, extract the project to any folder.
2. If you are using an IDE like Intellij then:
   - open the IDE, 
   - open the project in the IDE, 
   - If prompted to, set the Java configurations to version 9
   - Add your zendesk credentials (username, password, subdomain) to the cred.properties file as shown in image (a)
   - Make sure that you have atleast some tickets added in your account, without this the project will still run and display appropriate messages but you might receive some errors in the test suite.
   - Run the MainMenu.java file as Java application and you are good to go..!!
4. If you are working through CLI then,
   - Open the comman line interface (CLI), go to your project folder and navigate to src/main/resources. Here you will find the cred.properties file. Open this file, and your zendesk credentials (username, password, subdomain)
   - Once you have entered the credentials, go back to your main project folder. (inside the ticketviewer project) and type or copy paste the following command:
   `mvn clean compile assembly:single`
   This will run a series of steps to build your project and create a jar file. At the end, if everything goes well, you will receive a 'BUILD SUCCESS' message. 
   -  After this, a jar will be generated in your target folder. Use the following command to run the project:
   `java -jar .\target\ticketviewer-1.0-SNAPSHOT-jar-with-dependencies.jar`
   OR
   `java -jar .\target\{name of your jar}.jar`
   - This will start the ticketViewer system. Have fun using it..!!
