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
        To compare the efficiency in terms of execution time for three different methods who have the same objective;
        that is, to retrieve the series of the first n Fibonacci numbers.
 */
package fibtester;

import java.io.File; // Used to create a File object to be further processed by the Scanner.
import java.util.Scanner; // Used to parse the input file for an integer value.
import java.io.PrintWriter; // Used to write the output to a file.
import java.io.FileNotFoundException; // Used to catch errors where a file cannot be found.

public class FibTester {

    /**
     * @param args the command line arguments.
     */
    public static void main(String[] args) {

        try {
            final int INPUT_ARG = 0;
            final int OUTPUT_ARG = 1;

            String inFileName = verifyCommandLineArgs(args)[INPUT_ARG];
            String outFileName = verifyCommandLineArgs(args)[OUTPUT_ARG];

            Scanner in = null;
            PrintWriter out = null;

            try {
                out = new PrintWriter(outFileName);
                File inputFile = new File(inFileName);

                Series recursiveFib = new RecursiveFib();
                Series loopFib = new LoopFib();
                Series fastRecursiveFib = new FastRecursiveFib();

                StopWatch recursiveFibTimer = new StopWatch();
                StopWatch loopFibTimer = new StopWatch();
                StopWatch fastRecursiveFibTimer = new StopWatch();

                final int LIMIT = processInputFile(in, inputFile, inFileName);
                printHeader(LIMIT, out);
                final int ROUGHLY_SQUARED = (int) Math.sqrt(LIMIT);
                printTable(out, recursiveFibTimer, LIMIT, ROUGHLY_SQUARED, recursiveFib);
                printTable(out, loopFibTimer, LIMIT, ROUGHLY_SQUARED, loopFib);
                printTable(out, fastRecursiveFibTimer, LIMIT, ROUGHLY_SQUARED, fastRecursiveFib);

                out.close();

            } catch (FileNotFoundException | NullPointerException noFileEx) {
                System.out.println("       Please assure file is in correct directory.");
            } finally {
                out.close();
            }

        } catch (ArrayIndexOutOfBoundsException cmdLineArgEx) {
            System.out.println("ERROR: There must be exactly two command line arguments.");
        }

    }

    /**
     * Generates a separator using a solid line of underscores for each column
     * of numbers. Loops from the first element to the square root of the limit
     * to determine the number of lines to print.
     *
     * @param roughlySquared truncated square root of the amount of Fibonacci
     * numbers.
     * @param out PrintWriter object used to write to the output file.
     */
    public static void printSolidLine(int roughlySquared, PrintWriter out) {
        for (int index = 1; index <= roughlySquared; index++) {
            out.print("____________");
        }
    }

    /**
     * Prints a separator using underscores to separate each table.
     *
     * @param roughlySquared truncated square root of the amount of Fibonacci
     * numbers.
     * @param out PrintWriter object used to write to the output file.
     */
    public static void printSeparator(int roughlySquared, PrintWriter out) {
        out.println();
        printSolidLine(roughlySquared, out);
        out.println("\n");
    }

    /**
     * Prints the series of the first n Fibonacci numbers in a right-aligned,
     * well-presented table. Loops from the first element to the last printing a
     * new line after every multiple of the square root of the limit to make the
     * table roughly squared.
     *
     * @param limit amount of Fibonacci numbers.
     * @param roughlySquared truncated square root of the amount of Fibonacci
     * numbers.
     * @param series an object that implements the Series interface.
     * @param out PrintWriter object used to write to the output file.
     */
    public static void printSeries(int limit, int roughlySquared, Series series, PrintWriter out) {
        if (series instanceof RecursiveFib) {
            out.println("Recursive method:\n");
        }
        if (series instanceof LoopFib) {
            out.println("Iterative method:\n");
        }
        if (series instanceof FastRecursiveFib) {
            out.println("Fast Recursive method:\n");
        }
        for (int index = 1; index <= limit; index++) {
            out.printf("%12d", series.fib(index));
            if (index % roughlySquared == 0) {
                out.println();
            }
        }
    }

    /**
     * Prints a header according to the plurality of the Fibonacci number(s).
     *
     * @param limit amount of Fibonacci numbers.
     * @param out PrintWriter object used to write to the output file.
     */
    public static void printHeader(int limit, PrintWriter out) {
        if (limit > 1) {
            out.print("The following tables display the first " + limit + " Fibonacci numbers:");
        } else {
            out.print("The following tables display the first Fibonacci number:");
        }
    }

    /**
     * Prints the series of the first n Fibonacci numbers and in addition it
     * measures and prints the execution time of each computation method in
     * nanoseconds.
     *
     * @param out PrintWriter object used to write to the output file.
     * @param timer a StopWatch object that keeps track of method execution
     * time.
     * @param limit amount of Fibonacci numbers.
     * @param roughlySquared truncated square root of the amount of Fibonacci
     * numbers.
     * @param series an object that implements the Series interface.
     */
    public static void printTable(PrintWriter out, StopWatch timer, int limit, int roughlySquared, Series series) {
        printSeparator(roughlySquared, out);
        timer.start();
        printSeries(limit, roughlySquared, series, out);
        timer.stop();
        out.print("\n\nExecution time: " + timer.getElapsedTime() + " nanoseconds");
        printSeparator(roughlySquared, out);
    }

    /**
     * Verifies that exactly two command line arguments were passed. If they
     * were, they are assigned as input and output file names, else an exception
     * is thrown.
     *
     * @param args the command line arguments.
     * @return the input and output file names as stated in the command line.
     */
    public static String[] verifyCommandLineArgs(String[] args) throws ArrayIndexOutOfBoundsException {
        final int EXPECTED_ARGS = 2;
        if (args.length != EXPECTED_ARGS) {
            throw new ArrayIndexOutOfBoundsException("There is not two command line arguements.");
        }
        return args;
    }

    /**
     * Attempts to open the input file passed via the command line arguments.
     * Throws exceptions for any of the following reasons: the file does not
     * exist, it exists but it is empty, not empty but does not contain an
     * integer, not empty but contains an integer outside the permitted range.
     *
     * @param in Scanner object used to read from the input file.
     * @param inputFile File object to be passed to the Scanner.
     * @param inFileName input file name as retrieved from the command line
     * arguments.
     * @return the number inside the file assuming validity.
     */
    public static int processInputFile(Scanner in, File inputFile, String inFileName) {
        final int MIN_LIMIT = 1;
        final int MAX_LIMIT = 49;
        int limit = 0;
        try {
            in = new Scanner(inputFile);
            if (!in.hasNext()) {
                throw new EmptyFileException("File has no content inside.");
            } else if (!in.hasNextInt()) {
                throw new NonIntegerInputException("The first element in the file is not an integer.");
            }
            limit = in.nextInt();
            if (limit < MIN_LIMIT || limit > MAX_LIMIT) {
                throw new InvalidInputException("The integer value in the file is either under 1 or over 49.");
            }
            in.close();
        } catch (FileNotFoundException | NullPointerException noFileEx) {
            System.out.println("ERROR: File named \"" + inFileName + "\" does not exist.");
        } catch (EmptyFileException emptyFileEx) {
            System.out.println("ERROR: File named \"" + inFileName + "\" is empty.");
        } catch (NonIntegerInputException nonIntEx) {
            System.out.println("ERROR: File named \"" + inFileName + "\" does not contain a valid integer.");
        } catch (InvalidInputException invIntEx) {
            System.out.println("ERROR: File named \"" + inFileName + "\" contains an integer value out of range.");
            System.out.println("       Only integer values 1-49 are permitted.");
        } finally {
            in.close();
        }
        return limit;
    }
}
