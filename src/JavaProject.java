import java.util.Scanner;

public class JavaProject {
    private static String username;
    private static String password;
    private static boolean isLoggedIn;
    private static boolean isProfileUpdated;
    private static boolean isPasswordUpdated;
    private static boolean isMCQAnswered;
    private static boolean isSessionClosed;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Select answers for MCQs");
            System.out.println("4. Timer and Auto Submit");
            System.out.println("5. Close Session and Logout");
            System.out.println("6. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    updateProfileAndPassword(scanner);
                    break;
                case 3:
                    selectMCQAnswers(scanner);
                    break;
                case 4:
                    timerAndAutoSubmit();
                    break;
                case 5:
                    closeSessionAndLogout();
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void login(Scanner scanner) {
        if (isLoggedIn) {
            System.out.println("You are already logged in.");
        } else {
            System.out.println("Please enter your username:");
            String enteredUsername = scanner.nextLine();

            System.out.println("Please enter your password:");
            String enteredPassword = scanner.nextLine();

            // Validate the username and password
            if (enteredUsername.equals("admin") && enteredPassword.equals("password")) {
                username = enteredUsername;
                password = enteredPassword;
                isLoggedIn = true;
                System.out.println("Login successful. Welcome, " + username + "!");
            } else {
                System.out.println("Invalid username or password. Login failed.");
            }
        }
    }

    private static void updateProfileAndPassword(Scanner scanner) {
        if (!isLoggedIn) {
            System.out.println("Please log in to update your profile and password.");
        } else {
            System.out.println("Please enter your new profile information:");
            // Code to update profile information

            isProfileUpdated = true;

            System.out.println("Please enter your new password:");
            String newPassword = scanner.nextLine();

            // Code to update password
            password = newPassword;
            isPasswordUpdated = true;

            System.out.println("Profile and password updated successfully.");
        }
    }

    private static void selectMCQAnswers(Scanner scanner) {
        if (!isLoggedIn) {
            System.out.println("Please log in to select answers for MCQs.");
        } else {
            System.out.println("Please select the answers for the MCQs:");
            // Code to present MCQs and record answers

            isMCQAnswered = true;

            System.out.println("MCQ answers submitted successfully.");
        }
    }

    private static void timerAndAutoSubmit() {
        if (!isLoggedIn) {
            System.out.println("Please log in to use the timer and auto submit.");
        } else if (!isProfileUpdated || !isPasswordUpdated || !isMCQAnswered) {
            System.out.println("Please update your profile, password, and answer the MCQs before using the timer and auto submit.");
        } else {
            System.out.println("Timer started. Auto submission will occur after the specified time.");
            // Code for timer and auto submission
        }
    }

    private static void closeSessionAndLogout() {
        if (!isLoggedIn) {
            System.out.println("You are not logged in.");
        } else {
            isSessionClosed = true;
            isLoggedIn = false;
            isProfileUpdated = false;
            isPasswordUpdated = false;
            isMCQAnswered = false;

            System.out.println("Session closed and logged out successfully.");
        }
    }
}