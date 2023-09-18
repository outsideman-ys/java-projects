import java.util.Scanner;

public class Menu {
    private static int newGoal = 0;
    private static int monthNumb;

    private static void printChangeGoalMode(StepTracker stepTracker) {
        System.out.println("Input your new goal, your goal for now is: " + StepTracker.goal);
        Scanner in = new Scanner(System.in);
        newGoal = in.nextInt();
        if(!(StepTracker.checkInputNumb(newGoal))) {
            System.out.println("Bad input, try again!\n");
            printChangeGoalMode(stepTracker);
        }
        else {
            StepTracker.changeGoal(newGoal);
            printMenu(stepTracker);
        }
        in.close();
    }

    private static void printMonthStatusMod(StepTracker stepTracker) {
        System.out.println("Input month number from 0 to 11");
        Scanner in = new Scanner(System.in);
        monthNumb = in.nextInt();
        if(!(StepTracker.checkInputNumb(newGoal))) {
            System.out.println("Bad input, try again!\n");
            printMonthStatusMod(stepTracker);
        }
        else {
            stepTracker.printMonthStatus(stepTracker.monthToData.get(monthNumb));
            printMenu(stepTracker);
        }
        in.close();
        
    }

    public static void printMenu(StepTracker stepTracker) {
        System.out.println("What do you want?\n 0 - exit\n 1 - input steps\n 2 - print month's status\n 3 - change goal\n");
        Scanner in = new Scanner(System.in);
        switch(in.nextInt()) {
            case 1: {
            break;
        }
        case 2: {
            printMonthStatusMod(stepTracker);
            break;
        }
        case 3: {
            printChangeGoalMode(stepTracker);
            break;
        }
        case 0: {
            System.out.println("The end!");
            in.close();
            return;
        }
        default: {
            System.out.println("Wrong input! Try again.");
            printMenu(stepTracker);
        }
        }
        in.close();
    }

    

}
