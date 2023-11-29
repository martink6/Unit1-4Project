import java.util.Scanner;

public class OregonVisual {
    static Scanner scan = new Scanner(System.in);
    public OregonVisual() { }
    Menus menu = new Menus();

    public static String LearnTheTrail() {
        return """
                            Try taking a journey by 
                            covered wagon across 2000 
                            miles of plains, rivers, and 
                            mountains. Try! On the 
                            plains, will you slosh your 
                            oxen through mud and 
                            water-filled ruts or will you 
                            plod through the dust six inches 
                            deep?"
      """;
    }

    public static String userCareer() {
        System.out.println("Many kinds of people made the trip to Oregon. \nYou may: \n1. Be a banker from Boston\n2. Be a carpenter from Ohio\n3. Be a farmer from Illinois\n4. Find out the difference between these choices\nWhat is your choice?");
        return
                switch (scan.nextInt()) {
                    case 1 -> "A";
                    case 2 -> "B";
                    case 3 -> "C";
                    case 4 -> "D";
                    default -> "Invalid choice";
                } ;
    }

    public static String menuOptions(int choice) {
        return
                switch (choice) {
                    case 1 -> userCareer();
                    case 2 -> LearnTheTrail();
                    default -> "Invalid choice";
                } ;
    }
}
