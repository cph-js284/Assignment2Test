# Assignment2Test
This is the 2nd assignment for PBA Test soft2019spring
This is a Java Maven project.

# Custom testrunner
To run the custom testrunner execute the command<br>
*for linux*<br>
```
mvn exec:java -Dexec.mainClass="com.cphjs284.MyTestRunner" -Dexec.classpathScope="test"
```
*for windows*<br>
```
mvn exec:java -D"exec.mainClass"="com.cphjs284.MyTestRunner" -D"exec.classpathScope"="test"
```
