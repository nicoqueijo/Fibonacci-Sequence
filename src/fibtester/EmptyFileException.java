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
        To provide information about errors concerning empty files.
 */
package fibtester;

public class EmptyFileException extends Exception {

    /**
     * Constructs an EmptyFileException with no detail message.
     */
    public EmptyFileException() {
    }

    /**
     * Constructs a EmptyFileException with the specified detail message.
     *
     * @param message the detail message.
     */
    public EmptyFileException(String message) {
        super(message);
    }

    /**
     * Returns a short description of this throwable.
     *
     * @return a string representation of this throwable.
     */
    @Override
    public String toString() {
        return "EmptyFileException{" + '}';
    }

}
