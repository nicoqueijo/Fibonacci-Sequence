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
        To provide a method to retrieve the sequence of the first n Fibonacci numbers with an iterative implementation.
 */
package fibtester;

public class LoopFib implements Series {

    /**
     * Finds the next number in a Fibonacci series using an iterative method.
     * The first two numbers are always automatically 1. Numbers higher than 2
     * are the addition of the previous two numbers.
     *
     * @param limit the number of the max element in the series.
     * @return the next number in the series.
     */
    @Override
    // Source of algorithm: section_3/LoopFib.java found in Big Java Early Objects by Cay Horstmann
    public long fib(int limit) {
        if (limit <= 2) {
            return 1;
        } else {
            long olderValue = 1;
            long oldValue = 1;
            long newValue = 1;
            for (int index = 3; index <= limit; index++) {
                newValue = oldValue + olderValue;
                olderValue = oldValue;
                oldValue = newValue;
            }
            return newValue;
        }
    }
}
