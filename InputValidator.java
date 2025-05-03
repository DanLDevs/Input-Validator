import java.util.*;

public class InputValidator
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int pin = getValidPin(scan);
	    
	    // call getValidPassword() method
	    String password = getValidPassword(scan);
	    
	    // display validated input
	    System.out.println("\nRegistration Successful!");
	    System.out.println("Pin: " + "*".repeat(String.valueOf(pin).length())); // mask pin
	    System.out.println("Password: " + "*".repeat(password.length())); // mask password
	}
	
	public static int getValidPin(Scanner scan) {
	    int pin;
	    do {
	        System.out.print("Enter your pin (0000-9999): ");
	        while (!scan.hasNextInt()) {
	            System.out.print("Invalid input. Reenter pin: ");
	            scan.next(); // discard invalid input - clear buffer
	        }
	        pin = scan.nextInt();
	        if (pin < 0 || pin > 9999) {
	            System.out.println("Pin must be between 0000 and 9999.");
	        }
	    } while (pin < 0 || pin > 9999);
	    return pin;
	}
	
	public static String getValidPassword(Scanner scan) {
	    String password;
	    do {
	        System.out.print("Enter a password (at least 8 characters, 1 uppercase, 1 digit): ");
	        password = scan.next();
	        if (!isValidPassword(password)) {
	            System.out.println("Invalid password. Try again.");
	        }
	    } while (!isValidPassword(password));
	    return password;
	}
	
	// helper method to check password validity
	public static boolean isValidPassword(String password) {
	    return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*");
	}
}