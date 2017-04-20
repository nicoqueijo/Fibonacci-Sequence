# Computes the first n fibonacci numbers in three different manners and compares the execution time of each.

Assignment 6 Specifications

Due: 1 December 2016 - class time.

Description: Write a suite of programs to compute and create three tables of the Fibonacci numbers, one recursive, one iterative and one ‘fast recursive’. The number of Fibonacci numbers in the tables will be determined by an integer value located in an input file, and the tables will be displayed in an output file, both file names to be found on the command-line (refer to section 11.3, pages 527-529) upon execution of the FibTester class. Refer to problem E13.20 on page 624, which expands section 13.3 - the RecursiveFib on pages 598-600 - how to ‘fast’ recursively compute the Fibonacci numbers. 

Input: The name of the input file and the output file will be found on the command-line. Input validation and exception handling are expected. All input should be handled by the tester class. Integer value in input file will be less than 50.

Output: The output file will contain one table of recursively-computed Fibonacci numbers; followed by a second table of “expected” values - using an iterative algorithm like LoopFib, found on pages 601-602 in the text; followed by a third table of ‘fast’ recursively-computed Fibonacci numbers.

All tables should be labeled, right-aligned and “well-presented” (roughly square) and obviously have identical values. Additionally, the execution time (in milliseconds or nanoseconds) to complete each table will be printed/labeled, following each table, for comparison purposes - refer to section 14.2 (page 634) or http://www.tutorialspoint.com/java/java_date_time.htm . All output should be handled by the tester or exception-handling classes. 

Requirements: FibTester will access the input (and output) files and read the number of entries for each table. A trio of separate loops will then be executed, calling each version of the Fibonacci algorithm the requisite number of times. System time, before and after each loop, will facilitate determining execution time for each table. At a minimum, exceptions for File-Not-Found, Empty-File, Non-Integer-Input, and Invalid-Input (negative) should be handled for input/output. Other exceptions should be included, as required - section 11.5 (page 545) may prove useful. All files must be closed properly, even if there are exceptions.

Your program will have several classes: a RecursiveFib to compute the Fibonacci numbers, a FastRecursiveFib to ‘fast’ compute the Fibonacci numbers, and a LoopFib to iteratively compute the Fibonacci numbers; a FibTester to test all three Fibonacci classes, and to access the command-line and input/output files; one or more classes to handle the exception handling; other classes as required. 

Use only material covered in the first fourteen chapters. Style requirements as discussed in class expected. Class design guidelines as discussed in class and described in chapters 8/12 expected. Import libraries as required. Execution could look like:
          $ java FibTester infile.txt outfile.txt
	
Submission: Include program documentation that provides clear instructions for how to compile and execute your program on the FIU SCIS.  Your program must be able to compile and execute on FIU SCIS, using the “java” compiler. 

Algorithm (pseudocode) should be submitted in a separate text file and included with the Moodle posting and class submission. 

Print out a copy of all source code and both text files and submit in class. Post a .zip file — with all source code files and text files — on the Moodle web site. 

Program should include a signed disclaimer (comment) in the heading, as follows:

	"I hereby certify that this collective work is my own and none of it is the work of any other person or entity." 

Include your name and student id. Class submission must include your signature and be stapled.
