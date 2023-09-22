import java.util.HashMap;
import java.util.ArrayList;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    public static int goal = 10_000;
    private float middle = 0;
    private int sum = 0;
    private int max = 0;
    private int goodDays = 0;
    private int maxGoodDays = 0;

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
            System.out.println(i + " day: " + numb);
            sum += numb;
            if(max < numb) {
                max = numb;
            }
            if(numb >= goal) {
                goodDays+=1;
                maxGoodDays = goodDays;
            }
            else if(numb < goal && goodDays > 0) {
                goodDays = 0;
            }
        }
        System.out.println("Sum of steps: " + sum);
        middle = (float)sum/(float)hueta.dayNumb;
        System.out.println("Middle of steps: " + middle);
        System.out.println("Max of steps: " + max);
        System.out.println("Good days: " + maxGoodDays);
        System.out.println("Kilometers: " + Converter.convertKm(hueta.data));
        System.out.println("Kallories: " + Converter.convertKl(hueta.data));
    }

    public void changeStatus(int monthNumb, int dayNumb, int steps) {
        monthToData.get(monthNumb).data.remove(dayNumb);
        monthToData.get(monthNumb).data.add(dayNumb, steps);
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
