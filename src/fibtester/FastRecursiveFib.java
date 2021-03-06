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
        To provide a method to retrieve the sequence of the first n Fibonacci numbers with a recursive implementation
        while also eliminating duplicate calls in the call stack.
 */
package fibtester;

public class FastRecursiveFib implements Series {

    private final int DEFAULT_ELEMENT_VALUE = 0;
    private final int MAX_LIMIT_SIZE = 50;
    private long[] auxiliaryArray = new long[MAX_LIMIT_SIZE];

    /**
     * Finds the next number in a Fibonacci series using a recursive method that
     * keeps track of values that have already been computed. The first two
     * numbers are always automatically 1. Numbers higher than 2 are the
     * addition of the previous two numbers.
     *
     * @param limit the number of the max element in the series.
     * @return the next number in the series.
     */
    @Override
    public long fib(int limit) {
        if (limit <= 1) {
            return limit;
        }
        if (auxiliaryArray[limit] != DEFAULT_ELEMENT_VALUE) {
            return auxiliaryArray[limit];
        }
        auxiliaryArray[limit] = fib(limit - 1) + fib(limit - 2);
        return auxiliaryArray[limit];
    }
}
