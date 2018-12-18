# Comcast code challenge

Prog that  takes in a string and returns the sum of its digits according to set parameters

## Getting Started

Download a copy into your local computer

### Prerequisites

You need to have java installed

### Building

Once java is installed, run :
<code> javac MyProg.java</code> <br>
this will build the MyProg class
To run , 
<code>java MyProg</code>


## Running the tests
To test compile the Testing class
<code> javac Testing.java</code> <br>
To run tests after compilation is successful, <br>
<code>java Testing</code>
the testing class has different methods to enable testing. Each method has comments that explain functionality
*  <code>testProgSystemIn(String line, String input,String expOut,String name)</code>
*  <code>testProg(String line, String expRes, String testName)</code>
*  <code>testErr(String line, String expRes,String testName)</code>
To add custom test, please use these methods in the main function in the testing class

### Arguments
* -f file.txt --> takes in a file path after the parameter
* -x --> sets the hex flag so that digits are evaluated in hex 
<br>
Program will indicate if arguments are not set correctly / if there are any alien arguments

## Built With

* Java

## Authors

* **Jie Shen Ong** 
