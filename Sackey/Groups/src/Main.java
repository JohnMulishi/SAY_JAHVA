import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number of array elements");
        while(true) {//helps to take input again until user enters the correct input.

            try {
                int n = scanner.nextInt();//Assign input to variable named n
                if (n <= 0) {
                    throw new IllegalArgumentException("Enter positive number");
                }

                int[] Array = new int[n];//Declare an array of length=n.
                int sum = 0;
                int product = 1;

                //Prompt user to enter array elements.
                System.out.println("Enter  numbers to find the sum,product and average for you");
                for (int i = 0; i < Array.length; i++) {//Assign inputs to array named Array.
                    Array[i] = scanner.nextInt();

                }
                for (int i = 0; i < Array.length; i++) {//Finding the sum and product of elements in Array.
                    sum += Array[i];
                    product *= Array[i];
                }

                double average = (double) sum / n;//Find the average of elements in Array.

                //Print sum,product, and average
                System.out.println("The sum is:" + sum + "\nThe product is :" + product + "\nThe average is:" + average);

                break;
            }
            catch (IllegalArgumentException exe){//Ensures user enters positive number not negative
                System.err.println("Enter positive number");

            }
            catch(InputMismatchException exe){ //InputMismatchException Ensures user enters an inter not double
                System.err.println("Enter an integer");
                scanner.nextLine(); //allows user to enter new input.
            }
        }

    }
}

