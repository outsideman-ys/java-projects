import java.util.List;

public class Calculator {

    private static double result;

    private Calculator() {}

    public static double calculate(List<MediaItem> mediaItems) {
        result = 0;
        for (MediaItem item : mediaItems) {
            if (item instanceof Movie) {
                result += item.getRuntime();
            } else if (item instanceof Series) {
                result += item.getRuntime() * ((Series)item).getSeriesCount();
            }
        }
        result /= 1440;
        return result;
    }

}