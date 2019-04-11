# Assignment2Test
This is the 2nd assignment for PBA Test soft2019spring<br>
This is a Java Maven project.<br>
<br>
[Link to assignment](https://github.com/datsoftlyngby/soft2019spring-test/blob/master/Assignments/02%20Unit%20Testing%20Assignment.pdf)


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
<br>
*Please note that the tests might fail when run due to exercise 6 (the randomizer) <br>
Please note that the tests will certainly fail when run due to exercise 7 (the timeout)* <br>
<br>
<b>Disable test 6 and 7 to verify successfully</b>
