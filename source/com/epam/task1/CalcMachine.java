package com.epam.task1;

import java.util.Scanner;

/**
 * Simplified version of the command line calculator. Accepts user input and performs basic mathematical operations.
 * 
 * @author Valiantsin Shamiako
 * @version 1.0
 */
public class CalcMachine {

    private double totalDouble; // Intended to hold the result of a mathematical operation.
    private boolean count; // Is used for branching in calculate method.
    private Scanner scan;

	/**
	 * Prints out some greeting messages prompting a user for an action.
	 * Depending on user input runs either core {@code calculate} method, help notes or terminates the program.
	 */
    public void initiate() {
        scan = new Scanner(System.in);
		// Greeting messages
        System.out.println("Hello and welcome to the CalcMachine.\n" +
                "To proceed please press 'Enter'.\n" +
                "Type 'help' keyword in to view help guide.\n" +
                "To quit CalcMachine type 'q' letter in.");
		// Loop block which accepts user input and run appropriate methods
        while (true) {
            System.out.println("\nPlease perform an action:");
            String cond = scan.nextLine();

            if (cond.equals("help")) {
                getHelp();
            } else if (cond.equals("")) {
                calculate();
				System.out.println("Thank you for your time and consideration.");
                break;
            } else if(cond.equals("q")) {
                System.out.println("Thank you for your time and consideration.");
                break;
            } else {
                System.out.println("An error occurred. Please repeat your input:\n" +
                        "Button 'Enter' - run the program.\n" +
                        "Keyword 'help' - invokes help notes.\n" +
                        "Letter 'q' - terminate the program.");
            }
        }
    }

	// Accepts user's input to pass the values to the doOperations method from the MathOperations class unless a user
	// will type 'q' symbol in to break the outerloop and terminate the program.
    private void calculate() {
        outerloop:
        while (true) {
			// The first local variable declaration which is followed by the conditional block which defines what value
			// it will store: either user's input or the result of the priviously performed mathematical operation.
            double a;
            if (!count) {
                a = setNumber();
            } else {
                a = totalDouble;
                System.out.println("Calculations will be performed with the following number:\n" + a);
            }
			// Declaration and initialization of the string variable. Its value will define the type of operation
			// to be performed.
            String s = setSign();
			// Declaration and initialization of the second local double variable.
            double b = setNumber();
			// Passing obtained values to the doOperations method which will return calculated result.
            totalDouble = MathOperations.doOperations(a, s, b);
			// States that everything went ok and that CalcMachine can use obtained result for further calculations.
            count = true;
			// Prints out the result of the operation.
            System.out.println("Calculation result:\n" + totalDouble);
			System.out.println("");
            System.out.println("To proceed calculations with the obtained result press 'Enter' button.\n" +
                    "To start over type 'z' letter in.\n" +
                    "To quit CalcMachine type 'q' letter in.");				
			// Accepts user's input which defines what CalcMachine will do next: whether terminates or proceed.
            String cond = scan.nextLine();
            switch (cond) {
                case "": break;
                case "z": count = false;
                    break;
                case "q": break outerloop;
            }
        }
    }
	
	// Accepts user's numerical input and returns it to a caller of the method. Otherwise will catch
	// NumberFormatException and will print warning message awaiting for the new input.
    private double setNumber() {
        while (true) {
            try {
                System.out.println("Enter a number:");
                return Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Numeric input error occurred. Please repeat your input. Only numbers are allowed.");
            }
        }
    }
	
	// Accepts user's input and checks whether there's corresponding mathematical symbol to perform math operation.
	// Otherwise prints warning message and propmts a user to try once again.
    private String setSign() {
        while (true) {
            System.out.println("Enter mathematical symbol:");
            String q = scan.nextLine();
            if (MathOperations.checkSymbols(q)) {
				return q;
			} else {
                System.out.println("Wrong mathematical symbol has been entered. Please repeat your input with the " +
				        "appropriate symbol.");
			}
        }
    }
	
	// Prints to the standard output notes about how to use a CalcMachine.
    private void getHelp() {
        String help = "To make the CalcMachine perform a mathematical operation you have to follow simple steps.\n" +
                "Successively enter the following values:\n" +
                "The first numerical value and press 'Enter' button.\n" +
                "A symbol of a mathematical operation and press 'Enter' button.\n" +
                "The second numerical value and press 'Enter'";
        String example = "Input example:\n" +
                "23\n" +
                "+\n" +
                "33\n" +
                "Calculation result:\n" +
                "56";

        System.out.println(help);
		
        System.out.println("Allowed mathematical symbols are the following: ");
        MathOperations.getSymbols();
		
		System.out.println("");
        System.out.println(example);
    }
}