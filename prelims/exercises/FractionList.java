package prelims.exercises;

import java.util.Scanner;

public class FractionList {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        FractionList myProgram = new FractionList();
        myProgram.run();
    }
    public void run() {

        int myChoice = 0;
        Fraction fraction1 = retrieveFractionFromConsole(1);
        Fraction fraction2 = retrieveFractionFromConsole(2);
        stall();

        do {
            showMainMenu();
            myChoice = enterChoice(1,8);
            switch (myChoice) {
                case 1:
                   fraction1 = retrieveFractionFromConsole(1);
                    stall();
                   break;

                case 2:
                    fraction2 = retrieveFractionFromConsole(2);
                    stall();
                    break;

                case 3:
                    Fraction sum = fraction1.add(fraction2);
                    System.out.printf("The sum of fraction 1 (%s) and fraction 2 (%s) is (%s) or (%f)\n" ,
                            fraction1, fraction2, sum, sum.toDecimal());
                    stall();
                    break;
                case 4:

                case 5:

                case 6:

                case 7:
                    System.out.println("Which fraction do you want to reduce? ");
                    System.out.println("1. Fraction 1: "+ fraction1);
                    System.out.println("2. Fraction 2: "+ fraction2);
                    System.out.println("3. Both 1 and 2: ");
                    System.out.print("Your choice: ");
                    int c = keyboard.nextInt();
                    switch (c) {
                        case 1:
                            fraction1.reduce();
                            System.out.printf("The reduced form of fraction 1 is (%s) or (%s)\n", fraction1,
                                    fraction1.toDecimal());
                           break;
                        case 2:
                            fraction2.reduce();
                            System.out.printf("The reduced form of fraction 2 is (%s) or (%s)\n", fraction2,
                                    fraction2.toDecimal());
                            break;
                        case 3:
                            fraction1.reduce();
                            fraction2.reduce();
                            System.out.printf("The reduced form of fraction 1 is (%s) or (%s)\n", fraction1,
                                    fraction1.toDecimal());
                            System.out.printf("The reduced form of fraction 2 is (%s) or (%s)\n", fraction2,
                                    fraction2.toDecimal());
                            break;
                        default: System.out.print("Invalid choice! " + c);
                    }
                    stall();
                    break;
                case 8:

            }
        } while (myChoice != 8);
    }
    public static void showMainMenu() {
        System.out.println("M E N U");
        System.out.println("1. Enter value of fraction 1");
        System.out.println("2. Enter a value of fraction 2");
        System.out.println("3. Addition");
        System.out.println("4. Subtraction");
        System.out.println("5. Multiplication");
        System.out.println("6. Division");
        System.out.println("7. Reduce a fraction");
        System.out.println("8. Quit");
    }

    public static int enterChoice(int min, int max) {
        int choice = 0;
        do {
            System.out.print("Enter the number corresponding to your choice: ");
            choice = keyboard.nextInt();
            if (choice < min || choice > max)
                System.out.println("You have to enter an integer in the range of 1 to 8");
        } while (choice < min || choice > max);

        return (choice);
    }

    public static Fraction retrieveFractionFromConsole(int fractionId) {
        System.out.printf("Enter a numerator for fraction %d: ", fractionId);
        int n = keyboard.nextInt();
        System.out.printf("Enter a denominator for fraction %d: ", fractionId);
        int d = keyboard.nextInt();

        //To Do
        //Verify or check if denominator is 0 use try catch
        while (d == 0) {
            System.out.println("The denominator must not be zero. ");
            System.out.printf("Enter a denominator for fraction %d: ", fractionId);
            d = Integer.parseInt(keyboard.nextLine());
        }
        return new Fraction(n,d);
    }
    public static void stall() {
        System.out.println("Please enter a key to continue");
        keyboard.nextLine();
    }
}
