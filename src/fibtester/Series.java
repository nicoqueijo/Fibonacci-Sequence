/*
    Nicolas Queijo
    PID: 5152398
    Assignment 6
    COP3337 - U04
    T/R 2:00 PM - 3:15 PM
    William Feild
    I hereby certify that this collective work is my own and none of it is the work of any other person or entity. 

    To compile and execute in FIU SCIS:
        > Have files somewhere in your buffalo server
        > Navigate to directory where files is stored using cd and ls to guide you
        > Compile using javac FibTester.java RecursiveFib.java LoopFib.java FastRecursiveFib.java Series.java StopWatch.java
                              EmptyFileException.java InvalidInputException.java NonIntegerInputException.java
        > Execute using java FibTester input.txt output.txt
 
    PURPOSE:
        To provide an interface that all classes who computate Fibonacci series must abide by.
 */
package fibtester;

public interface Series {

    /**
     * Finds the next number in a Fibonacci series.
     *
     * @param limit the number of the max element in the series.
     * @return the next number in the series.
     */
    long fib(int limit);
}
