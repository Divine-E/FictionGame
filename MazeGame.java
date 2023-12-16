import java.util.Scanner; //This line imports the Scanner class from the java.util package to handle user input.

public class MazeGame {
    private static boolean hasGold = false;
    //Defines the MazeGame class and declares a private static boolean variable hasGold to track whether the player found the real gold.

    public static void main(String[] args) {
        System.out.println("Welcome to the Maze Game!");
        System.out.println("Your boss has sent you on a errand across a maze");
        System.out.println("If you bring back real gold, you are promoted and if not, you lose your job!");
        start();
    }

    private static void start() {
        System.out.println("You find yourself in a maze. There are paths to the left and right.");
        System.out.println("Do you: 0. Take the left path");
        System.out.println("Do you: 1. Take the right path");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //Uses a switch statement to handle the user's choice. If the user enters "0," it calls leftPath;if "1," it calls
        // rightPath. If the input is invalid, it prompts the user to enter a valid choice and recalls the start method.
        switch (input) {
            case "0":
                leftPath();
                break;
            case "1":
                rightPath();
                break;
            default:
                System.out.println("Invalid choice. Please enter 0 or 1.");
                start();
                break;
        }
    }

    //The leftPath method represents the scenario when the user takes the left path.
    // It presents new choices and calls methods based on the user's input.
    private static void leftPath() {
        System.out.println("You take the left path and encounter an obstacle in the road.");
        System.out.println("Do you: 0. Go straight");
        System.out.println("Do you: 1. Take a turn to the left");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "0":
                System.out.println("You continue straight and find the gold!");
                choiceA();
                break;
            case "1":
                System.out.println("You take a left turn and encounter a dead end.");
                start();
                break;
            default:
                System.out.println("Invalid choice. Please enter 0 or 1.");
                leftPath();
                break;
        }
    }

    //The rightPath method represents the scenario when the user takes the right path.
    // It presents new choices and calls methods accordingly.
    private static void rightPath() {
        System.out.println("You take the right path and come across a dark tunnel.");
        System.out.println("Do you: 0. Enter the tunnel");
        System.out.println("Do you: 1. Turn back");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "0":
                System.out.println("You enter the tunnel and find a trap door.");
                System.out.println("Do you: 0. Open the trap door");
                System.out.println("Do you: 1. Leave the tunnel");

                input = scanner.nextLine();
                if (input.equals("0")) {
                    System.out.println("The trap door leads to a hidden room with the gold!");
                    choiceB();
                } else {
                    System.out.println("You leave the tunnel.");
                    start();
                }
                break;
            case "1":
                System.out.println("You turn back from the dark tunnel.");
                start();
                break;
            default:
                System.out.println("Invalid choice. Please enter 0 or 1.");
                rightPath();
                break;
        }
    }

    //The endGame method is called when the game ends. It congratulates or
    // informs the player based on whether they found the gold.
    private static void endGame() {
        if (hasGold) {
            System.out.println("Congratulations! You found real gold!");
            System.out.println("You will be promoted by your boss!");
        } else {
            System.out.println("Unfortunately, you found fake gold! You are sacked by your boss!");
        }
        System.exit(0);
        start();
    }

    //The choiceA method handles the scenario when the user finds gold on the left path and presents further choices.
    private static void choiceA() {
        System.out.println("Congratulations! You found some gold! It could be fake or real");
        System.out.println("Do you want to leave with the gold?");
        System.out.println("Do you: 0. leave with the gold");
        System.out.println("Do you: 1. Go back and keep looking");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "0":
                hasGold = true;
                endGame();
                break;
            case "1":
                leftPath();
                break;
            default:
                System.out.println("Invalid choice. Please enter 0 or 1.");
                choiceA();
                break;
        }
    }

    //The choiceB method handles the scenario when the user finds gold on the right path and presents further choices.
    private static void choiceB() {
        System.out.println("Congratulations! You found some gold! It could be fake or real");
        System.out.println("Do you want to leave with the gold?");
        System.out.println("Do you: 0. leave with the gold");
        System.out.println("Do you: 1. Go back and keep looking");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "0":
                endGame();
                break;
            case "1":
                rightPath();
                break;
            default:
                System.out.println("Invalid choice. Please enter 0 or 1.");
                choiceB();
                break;
        }
    }
}