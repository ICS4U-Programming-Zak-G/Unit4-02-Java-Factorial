// Import libraries
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
* This program uses recursion calculate the factorial of a list of numbers.
*
* @author  Zak Goneau
* @version 1.0
* @since   2025-04-23
*/

// Creating class
public final class Factorial {

    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Factorial() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     * @throws Exception - Input/Output exception
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // Write output string to output file
        final FileWriter myWriter = new FileWriter("output.txt");

        // Introduce program to user
        System.out.println("This program uses recursion to calculate the"
                + " factorial of a number from a file.");

        // Pass the path to the file as a parameter
        final File file = new File("./input.txt");
        final Scanner scanner = new Scanner(file);

        // Loop while there's another line in the file
        while (scanner.hasNextLine()) {

            // Get current line from file
            final String line = scanner.nextLine();

            // try to convert line to integer
            try {
                // Convert line to integer
                final int numberLine = Integer.parseInt(line);

                // Check if number is positive
                if (numberLine < 0) {
                    // Add to output string
                    outputStr += numberLine + " is not a positive integer.\n";
                } else {
                    // Call function to calculate factorial
                    final int factorial = factorial(numberLine);

                    // Add result to output string
                    outputStr += "The factorial of " + numberLine
                         + " is " + factorial + "\n";

                }
            // Catch invalid input and add to output string
            } catch (NumberFormatException error) {
                outputStr += line + " is not a positive integer.\n";
            }
        }

        // Write to output file
        myWriter.write(outputStr);

        // Display success message
        System.out.println("Success, the factorials "
                + "are printed in the output file.");

        // Close scanner
        scanner.close();

        // Close writer
        myWriter.close();
    }

    // Function to calculate factorial of a number
    /**
    * This function calculates the factorial of a number.
    *
    * @param number The number to calculate the factorial of
    * @return The factorial of the number
    */

    // Define function to calculate factorial
    public static int factorial(final int number) {
        // Set base case
        if (number == 0) {
            // Return 1
            return 1;

        // Otherwise, calculate factorial
        } else {
            // Call function
            return number * factorial(number - 1);
        }
    }
}
