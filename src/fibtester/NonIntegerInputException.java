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
        To provide information about errors concerning non-integer input.
 */
package fibtester;

import java.io.IOException; // Needed to extend the more specific NonIntegerInputException

public class NonIntegerInputException extends IOException {

    /**
     * Constructs an NonIntegerInputException with no detail message.
     */
    public NonIntegerInputException() {
    }

    /**
     * Constructs a NonIntegerInputException with the specified detail message.
     *
     * @param message the detail message.
     */
    public NonIntegerInputException(String message) {
        super(message);
    }

    /**
     * Returns a short description of this throwable.
     *
     * @return a string representation of this throwable.
     */
    @Override
    public String toString() {
        return "NonIntegerInputException{" + '}';
    }

}
