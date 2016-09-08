package com.epam.task1;

/**
 * Contains methods that perform basic mathematical operations.
 * To list all the math operations supported by the actual version of the class use {@code getSymbols} method.
 *
 * @author Valiantsin Shamiako
 * @version 1.0
 */
public final class MathOperations {

    private static double total;
    private static String[] symbols = {"+", "-", "*", "/", "^"};
    private static String[] symbDefinition = {"addition", "subtraction", "multiplication", "division", "raising to a power"};

	/**
	 * Performs basic mathematical operations.
	 * In some cases simply calls a method of the {@code Math} class.
	 *
	 * @param a numberic value that should be passed.
	 * @param s string value which stands for desired mathematical operation.
	 * @param b another numberic value that should be passed.
	 * @return the result of performed operation.
	 */
    public static double doOperations(double a, String s, double b) {
        switch(s) {
            case "+": total = a + b;
                break;
            case "-": total = a - b;
                break;
            case "*": total = a * b;
                break;
            case "/": total = a / b;
                break;
            case "^": total = Math.pow(a, b);
                break;
            default: break;
        }
        return total;
    }

	/**
	 * Checks whether a {@code symbols} array contains a symbol and returns true assuring that tested symbol has
	 * corresponding mathematical operation implemented in {@code doOperations} method.
	 *
	 * @param s string value whose presence in the array is to be tested.
	 * @return true if the array contains specified string.
	 */
    public static boolean checkSymbols(String s) {
        for (String q : symbols) {
            if (q.equals(s)) {
                return true;
            }
        }
        return false;
    }

	/**
	 * Prints to the standard output all the symbols and their corresponding definitions of mathematical operations 
	 * implemented in {@code doOperations} method.
	 */
    public static void getSymbols() {
        for (int i = 0; i < symbols.length; i++) {
            System.out.println(symbols[i] + " - " + symbDefinition[i]);
        }
    }
}