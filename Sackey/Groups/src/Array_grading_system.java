import java.util.InputMismatchException; // To catch input errors when user enters wrong data type
import java.util.Scanner; // To get input from the user

public class Array_grading_system {
    // Create a single Scanner object for user input
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n; // This will store the number of students

        // Loop to safely get a valid number of students from the user
        while (true) {
            System.out.println("Enter the number of Students");
            try {
                n = scanner.nextInt(); // Get the input
                scanner.nextLine(); // Clear the newline character left by nextInt()

                // Check if user entered 0 or a negative number
                if (n <= 0) {
                    throw new IllegalArgumentException("Enter a positive number greater than 0 ");
                }
                break; // If valid, break the loop

            } catch (IllegalArgumentException ex) {
                // If number is 0 or less
                System.err.println(ex.getMessage());
            } catch (InputMismatchException ex) {
                // If input is not a number (e.g., a letter)
                System.err.println("Enter a number");
                scanner.nextLine(); // Clear the invalid input
            } catch (NegativeArraySizeException ex) {
                // This catch block is not really needed here
                System.err.println("Enter positive integer ");
            }
        }

        // Create arrays to store information for all students
        String[] names = new String[n];
        double[] Exam_score = new double[n];
        double[] Ass_score = new double[n];
        double[] Acc_fee = new double[n];
        double[] Total_score = new double[n];

        // Loop to collect input for each student
        for (int i = 0; i < n; i++) {
            // This loop repeats until all input for a student is correct
            while (true) {
                System.out.println("Enter name of student " + (i + 1) + ":");
                try {
                    names[i] = scanner.nextLine(); // Read name input

                    // Check if name is empty or contains anything other than letters
                    if (names[i].trim().isEmpty() || !names[i].matches("[a-zA-Z]+")) {
                        throw new IllegalArgumentException("Name cannot be empty or Name must be alphabets");
                    }

                    // Get exam score
                    System.out.println("Enter Exam score for " + names[i] + ":");
                    Exam_score[i] = scanner.nextDouble();

                    // Get assessment score
                    System.out.println("Enter Assessment score for " + names[i] + ":");
                    Ass_score[i] = scanner.nextDouble();

                    // Get percentage of paid fees
                    System.out.println("Enter percentage of paid fees for " + names[i] + ":");
                    Acc_fee[i] = scanner.nextDouble();

                    scanner.nextLine(); // Clear any leftover input

                    // Calculate total score for the student
                    Total_score[i] = Exam_score[i] + Ass_score[i];

                    // Check for negative values
                    if (Ass_score[i] < 0 || Exam_score[i] < 0 || Acc_fee[i] < 0) {
                        throw new IllegalArgumentException("Negative scores and fees are not allowed");
                    }

                    // Check if scores exceed allowed limits
                    if (Exam_score[i] > 70 || Ass_score[i] > 30) {
                        throw new IllegalArgumentException("Exam score is not more than 70 and Assessment score is not more than 30!");
                    } else {
                        break; // If everything is correct, exit the loop
                    }

                } catch (IllegalArgumentException ex) {
                    // Handles all validation errors

                    System.err.println(ex.getMessage());
                } catch (InputMismatchException ex) {
                    // Handles errors when input is not a number

                    System.err.println("Scores should be numbers");
                    scanner.nextLine(); // Clear invalid input
                }
            }
        }

        // Loop to calculate grades and print results
        for (int i = 0; i < n; i++) {
            System.out.println("Student: " + names[i]);

            // Check if student passed (minimum exam and assessment scores)
            if (Exam_score[i] >= 25 && Ass_score[i] >= 15) {
                if (Acc_fee[i] == 100) { // Check if full fees were paid

                    // Grade the student based on their total score
                    switch ((int) (Total_score[i] / 10)) {
                        case 10:
                        case 9:
                        case 8:
                        case 7:
                            System.out.println("Congratulations, You had grade A \nYou have a certificate");
                            break;
                        case 6:
                            System.out.println("Congratulations, you had grade B \nYou have certificate");
                            break;
                        case 5:
                            System.out.println("Congratulations, you had grade C \nYou have a certificate");
                            break;
                        case 4:
                            System.out.println("Passed \nYou have been issued certificate");
                            break;
                    }
                } else {
                    // Passed but didn't pay full fees
                    System.out.println("Passed, No certificate! \nPay fees to view grades");
                }
            }
            // Special case: borderline pass
            else if ((Exam_score[i] >= 25 && Ass_score[i] >= 14) || (Exam_score[i] >= 24 && Ass_score[i] >= 15)) {
                if (Acc_fee[i] == 100) {
                    System.out.println("Condoned! \nCertificate issued");
                } else {
                    System.out.println("Condoned! \nNo certificate");
                }
            } else {
                // Failed case
                System.out.println("Poor " + names[i] + " You failed!! \nYou have been repeated");
            }
        }

        scanner.close(); // Close scanner to free resources
    }
}
// Again, I couldn't catch all exceptions
