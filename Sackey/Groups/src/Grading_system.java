
import java.util.InputMismatchException;
import java.util.Scanner;
public class Grading_system {
    static Scanner scanner =new Scanner (System.in);
    public static void main (String[] args) {
        // Declaring my variables
        String name;
        double Exam_score;
        double Ass_score;
        double Acc_fee;

        while (true) {// Loops again until the right input is entered for name
            System.out.println("Enter your name:");

            try {// Checking to make sure name is not empty or numbers
                name = scanner.nextLine();
                if(name.trim().isEmpty() || !name.matches("[a-zA-Z]+")){
                    System.err.println("Name cannot be empty or Name must be alphabets");
                }

                else { break;}// End loop if the right inputs are entered

            }catch(IllegalArgumentException ex){
                System.err.println( ex.getMessage());
            }
        }
        while (true) {// Loops again until the right inputs for scores are entered
            System.out.println("Enter your exam score");
            try {
                Exam_score = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Enter percentage paid fees");
                Acc_fee = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Enter your assessment score");
                Ass_score = scanner.nextDouble();

//  Making sure exam scores are not negative

                if (Ass_score < 0 || Exam_score < 0 || Acc_fee < 0 ) {
                    throw new IllegalArgumentException("Negative scores and fees are not allowed ");
                }

                // Making sure exam score is not more than 70 and Assessment score is not more than 30
                if (Exam_score > 70 || Ass_score > 30) {
                    throw new IllegalArgumentException("Exam score is not more than 70 and Assessment score is not more than 30 !");
                }

                else break;// End the loop if the right input is entered.

            }catch(IllegalArgumentException ex){
                System.err.println(ex.getMessage());

            }
            catch(InputMismatchException ex){
                System.err.println("Scores should be numbers");
            }
        }double Total_score = Exam_score + Ass_score; //Computing total score

        // Computing grades
        if (Exam_score >= 25 && Ass_score >= 15) {
            if (Acc_fee == 100) {
                switch ((int) (Total_score / 10)) {
                    case 10:
                    case 9:
                    case 8:
                    case 7:
                        System.out.println("Congratulations , You had grade A \n You have a certificate");
                        break;
                    case 6:
                        System.out.println("Congratulations ,you had grade B \n You have certificate");
                        break;
                    case 5:
                        System.out.println("Congratulations, you had grade C \n You have a certificate");
                        break;
                    case 4:
                        System.out.println("Passed \n YOu have been issued certificate");
                        break;
                }
            } else {
                System.out.println("Passed , No certificate! \n Pay fees to view grades");
            }
        } else if ((Exam_score >= 25 && Ass_score >= 14) || (Exam_score >= 24 && Ass_score >= 15)) {
            if (Acc_fee == 100) {
                System.out.println("Condoned ! \n Certificate issued ");
            } else {
                System.out.println("Condoned! \n No certificate");
            }
        } else {
            if (Exam_score < 25 || Ass_score < 15) {
                System.out.println("Poor" +" " + name + " "+ "You failed!! \n You have been repeated");
            }
        }





    }
}//End of code
//I couldn't catch all exceptions


