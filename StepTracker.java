import java.util.HashMap;
import java.util.ArrayList;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    public static int goal = 10_000;
    private float middle = 0;
    private int sum = 0;
    private int max = 0;

    public static boolean checkInputNumb(int number) {
        if(number < 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public void printMonthStatus(MonthData hueta) {
        for(int i = 0; i < hueta.dayNumb; i++) {
            int numb = hueta.data.get(i);
            System.out.println(numb);
            sum += numb;
            if(max < numb) {
                max = numb;
            }
        }
        System.out.println("Sum of steps: " + sum);
        middle = (float)sum/(float)hueta.dayNumb;
        System.out.println("Middle of steps: " + middle);
        System.out.println("Max of steps: " + max);
    }

    StepTracker() {
        for(int i = 0; i <= 11; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public static void changeGoal(int numb) {
        goal = numb;
    }

    class MonthData {
        private int dayNumb = 30;
        protected ArrayList<Integer> data = new ArrayList<Integer>(30);

        MonthData() {
            for(int i = 0; i < dayNumb; i++) {
                data.add(i, i*10);
            }
        }

        protected void printStatus(int monthNumb) {
            for(int i = 0; i < dayNumb; i++) {
                System.out.println(data.get(i));
            }
        }

    }
}
