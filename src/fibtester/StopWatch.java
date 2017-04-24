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
        To provide way to measure the execution time of different algorithms.
 */
package fibtester;

/**
 * A stopwatch accumulates time when it is running. You can repeatedly start and
 * stop the stopwatch. You can use a stopwatch to measure the running time of a
 * program.
 */
// Source of class: section_2/StopWatch.java found in Big Java Early Objects by Cay Horstmann
public final class StopWatch {

    private long elapsedTime;
    private long startTime;
    private boolean isRunning;

    /**
     * Constructs a stopwatch that is in the stopped state and has no time
     * accumulated.
     */
    public StopWatch() {
        reset();
    }

    /**
     * Starts the stopwatch. Time starts accumulating now.
     */
    public void start() {
        if (isRunning) {
            return;
        }
        isRunning = true;
        startTime = System.nanoTime();
    }

    /**
     * Stops the stopwatch. Time stops accumulating and is is added to the
     * elapsed time.
     */
    public void stop() {
        if (!isRunning) {
            return;
        }
        isRunning = false;
        long endTime = System.nanoTime();
        elapsedTime = elapsedTime + endTime - startTime;
    }

    /**
     * Returns the total elapsed time.
     *
     * @return the total elapsed time
     */
    public long getElapsedTime() {
        if (isRunning) {
            long endTime = System.nanoTime();
            return elapsedTime + endTime - startTime;
        } else {
            return elapsedTime;
        }
    }

    /**
     * Stops the watch and resets the elapsed time to 0.
     */
    public void reset() {
        elapsedTime = 0;
        isRunning = false;
    }
}
