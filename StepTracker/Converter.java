import java.util.ArrayList;

public class Converter {
    
    private static double km = 0.0;
    private static int kl = 0;

    public static double convertKm(ArrayList<Integer> status) {
        for(int i = 0; i < status.size(); i++) {
            km += status.get(i) * 0.75;
        }
        km /= 1000;
        return km;
    }

    public static int convertKl(ArrayList<Integer> status) {
        for(int i = 0; i < status.size(); i++) {
            kl += status.get(i) * 50;
        }
        kl /= 1000;
        return kl;
    }
}
