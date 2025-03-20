import java.util.Scanner;
public class Output {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[5];//declaring an array of length= 5.

        System.out.println("Enter five numbers to print them for you");

        for(int i=0; i<num.length ;i++){    //Assign inputs into array named num.
            num[i] = scanner.nextInt();
        }
        for (int i=0;i<num.length;i++){     //Print array called num.
            System.out.print(num[i] +",");
        }
    }
}
