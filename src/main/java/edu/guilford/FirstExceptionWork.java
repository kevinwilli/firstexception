package edu.guilford;

import java.util.Scanner;

public class FirstExceptionWork {
    public static void main(String[] args) // throws BadNumberException
    {
        Scanner scan = new Scanner(System.in);
        String entered = "";
        int n = 0;
        boolean valid = false; // did the user enter correct content?

        do { // a do loop is guaranteed to run at least once; a while loop may not run at all
             // difference between checking the condition at the end of a loop (for do)
             // and at the beginning of the loop (for while)
            try {
                System.out.println("Enter an integer: ");
                entered = scan.next(); // next gets the next token (not the whle line of input including the end of
                                       // line) from the input
                n = Integer.parseInt(entered); // try to convert the string to an integer
                if (n == 0) {
                    throw new BadNumberException("Bad number " + n);
                }
                valid = true; // we want to get here because it worked
            } catch (NumberFormatException e) {
                // print out the stack trace for more detailed debugging
                // e.printStackTrace();
                System.err.println("Input was not an integer " + entered);
                System.err.flush(); // flush the error stream so that the error
                // message is printed before the next prompt
            } catch (BadNumberException ex) {
                // print out the stack trace
                ex.printStackTrace();
                System.exit(1); // normal exit is and menas there was an arror
                // and it
                // exit the program with an error code
            }

        } while (!valid);

        System.out.println("The user entered " + n + "; valid = " + valid);
    }

    // We can write our own exception classes
    private static class BadNumberException extends Exception {
        // all we need in this class is a constructor that tells what is supposed to
        // happen
        // when this exception is thrown
        public BadNumberException(String message){
            //our constructor has one parameter: the message we want to send when this execption is thrown
            super(message);
        }
    }

}
