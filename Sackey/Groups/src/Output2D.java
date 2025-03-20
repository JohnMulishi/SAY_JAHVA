import java.util.Scanner;
public class Output2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Prompting user to enter the number of rows.
        System.out.println("Hey there, welcome to where we print arrays \n Enter your number of rows");

        int R = scanner.nextInt();//Assigning the first input to a variable named R.

        System.out.println("enter the number of columns");//Prompting user to enter the number of columns.

        int C = scanner.nextInt();//Assigning input to a variable named C.
        int[][] Out = new int[R][C];//Declaring an array of rows R and columns C.

        int[] Diagonal = new int[C];//Declaring an array of length C.

        //Prompting user to enter elements in the array.
        System.out.println("Enter your array elements to print");

        //Accepting elements one after the other into the aray  using for loop.
        for (int i = 0; i < Out.length; i++) {
            for (int j = 0; j < Out[i].length; j++) {
                Out[i][j] = scanner.nextInt();
            }
        }
//Printing elements one after the other using for loop.
        for (int i = 0; i < Out.length; i++) {
            for (int j = 0; j < Out[i].length; j++) {
                System.out.print(Out[i][j] + " ");
            }
            System.out.println();
        }
        //Looping through array elements to see the elements with the same row index and column index
        //(R=C)
        for (int i = 0; i < Out.length; i++) {
            for (int j = 0; j < Out[i].length; j++) {
                if (i ==j){
                    Diagonal[i]=Out[i][j];//Assigning the diagonal elements into Diagonal array.
                }

            }


        }
        //Print the diagonal array.
        System.out.println("The diagonal elements are:");
        for(int i=0; i<Diagonal.length;i++){
            System.out.print(Diagonal[i] +" ");
        }
    }
}
