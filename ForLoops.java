/*
Sandilya Parimi
12/11/2021
Program uses nested for loops to produce the expected output of numbers or symbols.
*/
public class ForLoops {
    public static void main(String[] args) {
        System.out.println("Figure One looks like: ");
        figureOne();
        System.out.println("\nFigure Two looks like: ");
        figureTwo();
        System.out.println("\nFigure Three looks like: ");
        figureThree();
        System.out.println("\nFigure Four looks like: ");
        figureFive();
        System.out.println("\nFigure Five looks like: ");
        figureFour();
        System.out.println("\nFigure Six looks like: ");
        figureSix();
    }
    public static void figureOne() {
        //Outer loop runs from 1 to 6 inclusive
        for (int x = 1; x <= 6; x++) {
            //Inner loop prints the x's
            for (int y = 0; y < x; y++) {
                System.out.print(x);
            }
            System.out.println();
        }
    }
    public static void figureTwo() {
        //Outer loop runs 1 to 6 inclusive
        for (int x = 1; x <= 6; x++) {
            //First inner loop prints the spaces
            for (int s = 0; s <= (5 - x); s++) {
                System.out.print(" ");
            }
            //Second inner loop prints the x's
            for (int y = 0; y < x; y++) {
                System.out.print(x);
            }
            System.out.println();
        }
    }
    public static void figureThree() {
        //Outer loop runs from 1 to 6 inclusive
        for (int x = 1; x <= 6; x++) {
            //First inner loop prints the spaces
            for (int s = 0; s < (x - 1); s++) {
                System.out.print(" ");
            }
            //Second inner loop prints the numbers
            for (int y = 0; y < (7 - x); y++) {
                System.out.print((x - 1) % 3);
            }
            System.out.println();
        }
    }
    public static void figureFour() {
        //Outer loop runs from 1 to 6 inclusive
        for (int x = 1; x <= 6; x++){
            //First inner loop prints the forward slashes on the left
            for (int f = 0; f < (x - 1); f++) {
                System.out.print("/");
            }
            //Second inner loop prints the asterisks in the middle
            for (int a = 0; a < (11-((x - 1) * 2)); a++) {
                System.out.print("*");
            }
            //Third inner loop prints the back slashes on the right
            for (int b = 0; b < (x - 1); b++){
                System.out.print("\\");
            }
            System.out.println();
        }
    }
    public static void figureFive() {
        //Outer loop runs 1 to 5 inclusive
        for (int x = 1; x <= 5; x++) {
            //First inner loop prints the spaces
            for (int s = 0; s < (6 - x); s++) {
                System.out.print(" ");
            }
            //Second inner loop prints the forward slashes on the left
            for (int f = 0; f < 1; f++) {
                System.out.print("/");
            }
            //Third inner loop prints the colon in the middle
            for (int a = 0; a < ((x * 2) - 1); a++) {
                System.out.print(":");
            }
            //Fourth inner loop prints the back slashes on the right
            for (int b = 0; b < 1; b++){
                System.out.print("\\");
            }
            System.out.println();
        }
    }
    public static void figureSix() {
        //Outer loop runs 1 to 5 inclusive
        for (int x = 1; x <= 5; x++) {
            //First inner loop runs 1 to 5 inclusive
            for (int y = x; y <= 5; y++) {
                //Second inner loop prints the numbers
                for (int z = 1; z <= y; z++) {
                    System.out.print(y);
                }
            }
            System.out.println();
        }
    }
}