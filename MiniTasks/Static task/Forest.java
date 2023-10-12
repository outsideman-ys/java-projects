import java.util.List;

public class Forest {
    private List<MountainHare> hares;
    private static String season;

    Forest(String newSeason, List<MountainHare> hares) {
        season = newSeason;
        if (season == "Winter") {
                MountainHare.SetColor("White");
            } else if (season == "Summer") {
                MountainHare.SetColor("Gray");
            } else {
                System.out.println("Bad input");
            }
        this.hares = hares;
    }

    public static void setSeason(String newSeason) {
        if (season != newSeason) {
            season = newSeason;
            if (season == "Winter") {
                MountainHare.SetColor("White");
            } else if (season == "Summer") {
                MountainHare.SetColor("Gray");
            } else {
                System.out.println("Bad input");
            }
        }
    }

	public void printHares() {
        for(MountainHare hare : hares) {
            System.out.println(hare.toString());
        }
    }
    
}
