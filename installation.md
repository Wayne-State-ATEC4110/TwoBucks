## Two Bucks ##
For information on the application, view the README.md file located in this same directory or visit our (GitHub Wiki)[https://github.com/Wayne-State-ATEC4110/TwoBucks/wiki] for the most current news regarding the project.

## Install Java ##
TwoBucks runs on the Java Virtual Machine (JVM) Version 8 Update 241. (Download the newest installer of JVM from Oracle)[https://www.java.com/en/download/] and find an installer appropriate for your system specifications.

Run the installer and follow the prompts to install the JVM to your machine.

To verify that Java has installed properly, open the command line and type the command:

java -version

If Java has been successfully installed, it should indicate what version of Java is installed on your machine.

## Install IDE ##
TwoBucks was developed using JetBrains' IntelliJ IDEA, although the project should compile with any modern Java IDE. To obtain IntelliJ, navigate to https://www.jetbrains.com/idea/download/#section=windows and download the Community .exe installer and run it, following all prompts until the installer has finished successfully.

## Acquire Source Files ##
Navigate to (the TwoBucks GitHub page)[https://github.com/Wayne-State-ATEC4110/TwoBucks/] and click the "Clone or Download" button to download the source files as a .zip.

To un-zip the source code, right-click the zipped folder and unzip it using the Windows unzip function or a free .zip file handler such as 7zip.

Alternatively, you can download the source files using the command line. Navigate to where you would like to clone the repository to and enter the command:

git clone https://github.com/Wayne-State-ATEC4110/TwoBucks/

## Build Executable ##
Executable .jar files an be build with many modern Java IDEs, but for the purpose of this installation guide we will only direct you how to build a .jar file in IntelliJ.

### Artifact Configuration ###
Open the project source code in IntelliJ. Then, from the main menu, navigate to the File button at the top left. Click Project Structure, then Artifacts. Press the "+" button near the top of the screen and click JAR from the drop-down menu and select "From modules with dependencies". To the right of where it says "Main Class", open the file explorer and navigate to the src/TwoBucks folder and select "Main.java". Click "OK" to proceed.

### Building JAR Artifact ###
From the main IDE menu, select "Build" and then "Build Artifacts...". Select "Main.java" and then "Build"

## Run Application ##
To run the application, open the command line and navigate to the TwoBucks project folder. If the above steps have been followed successfully, the JAR file will be located in "TwoBucks/out/Artifacts/TwoBucks_jar/". Navigate inside this directory using the command line and then type the command: "java -jar TwoBucks.jar"

Currently, the application requires that the Users.txt file be present in the same directory as the TwoBucks.jar file. You may copy the Jar into the main TwoBucks directory or alternativey, copy the Users.txt file to where the Jar file is located.
