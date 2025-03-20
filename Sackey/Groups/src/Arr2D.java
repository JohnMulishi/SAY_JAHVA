public class Arr2D {
    public static void main(String[] args){
        int product=1;
        int[][] scores={//Initializing  2D Array named (scores).
                {2,4,6},
                {8,10,12},
                {14,16,18},
        };
        System.out.println(scores[0][2]);//Printing array of index (0,2)=6
        System.out.println(scores[1][0]);//Printing array of index (1,0)=8
        System.out.println(scores[2][0]);//Printing array of index (2,0)=14

        for(int i=0; i<scores.length;i++){//Printing array elements using for loop.
            for(int j=0; j<scores[i].length;j++){
                System.out.print(scores[i][j] +" ");
            }
            System.out.println();
        }

        for(int i=0; i<scores.length;i++){//Find the product of elements in array using for loop.
            for(int j=0; j<scores[i].length;j++){
                product*=scores[i][j];
            }
            System.out.println();
        }


        System.out.print("The product is" +product);//Print product.

    }
}
