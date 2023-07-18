import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.println("List of operations: add subtract multiply divide alphabetize");
       System.out.println("Enter an operation:");
       String operation = input.next().toLowerCase();
       int num_1;
       int num_2;
       double numb_1;
       double numb_2;
       String word_1_or;
       String word_2_or;

        switch(operation) {
            case "add":
                System.out.println("Enter two integers:");
                if (input.hasNextInt()) {
                    num_1 = input.nextInt();
                    if (input.hasNextInt()) {
                        num_2 = input.nextInt();
                        System.out.println("Answer: " + (num_1 + num_2));
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                    }
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "subtract":
                System.out.println("Enter two integers:");
                if (input.hasNextInt()) {
                    num_1 = input.nextInt();
                    if (input.hasNextInt()) {
                        num_2 = input.nextInt();
                        System.out.println("Answer: " + (num_1 - num_2));
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                    }
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                    break;

            case "multiply":
                System.out.println("Enter two doubles:");
                 if (input.hasNextDouble()) {
                     numb_1 = input.nextDouble();
                     if (input.hasNextDouble()) {
                         numb_2 = input.nextDouble();
                         System.out.printf("Answer: %.2f", numb_1 * numb_2);
                         System.out.print('\n');
                            }
                     else {
                         System.out.println("Invalid input entered. Terminating...");
                     }
                 }
                 else {
                     System.out.println("Invalid input entered. Terminating...");
                 }
                        break;

            case "divide":
                System.out.println("Enter two doubles:");
                if (input.hasNextDouble()) {
                    numb_1 = input.nextDouble();
                    if (input.hasNextDouble()) {
                        numb_2 = input.nextDouble();
                        if(numb_2 != 0){
                            System.out.printf("Answer: %.2f", numb_1 / numb_2);
                            System.out.print('\n');
                        }
                        else{
                            System.out.println("Invalid input entered. Terminating...");
                        }
                    }
                    else {
                        System.out.println("Invalid input entered. Terminating...");
                    }
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case "alphabetize":
                System.out.println("Enter two words:");
                word_1_or = input.next();
                word_2_or = input.next();
                String word_1 = word_1_or.toLowerCase();
                String word_2 = word_2_or.toLowerCase();
                int w1w2Compare = (word_1.compareTo(word_2));
                if(word_1.equals(word_2)){
                    System.out.println("Answer: Chicken or Egg.");
                }
                else if (w1w2Compare < 0) {
                    System.out.println("Answer: " + word_1_or + " comes before " + word_2_or + " alphabetically.");
                }
                else if (w1w2Compare > 0) {
                    System.out.println("Answer: " + word_2_or + " comes before " + word_1_or + " alphabetically.");
                }
                else {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
                break;


        }
    }
}