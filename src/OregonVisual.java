import java.util.Scanner;

public class OregonVisual {
    static Scanner scan = new Scanner(System.in);
    private OregonVisual() { }

    public static void runOregon() {
        logo();
        menuOptions();
    }

    private static void logo() {
        System.out.println( """
                  _______ _             ____                               _______        _ _ \s
                 |__   __| |           / __ \\                             |__   __|      (_) |\s
                    | |  | |__   ___  | |  | |_ __ ___  __ _  ___  _ __      | |_ __ __ _ _| |\s
                    | |  | '_ \\ / _ \\ | |  | | '__/ _ \\/ _` |/ _ \\| '_ \\     | | '__/ _` | | |\s
                    | |  | | | |  __/ | |__| | | |  __/ (_| | (_) | | | |    | | | | (_| | | |\s
                    |_|  |_| |_|\\___|  \\____/|_|  \\___|\\__, |\\___/|_| |_|    |_|_|  \\__,_|_|_|\s
                                                        __/ |                                 \s
                                                       |___/                                  \s
                """ );
    }
    private static String LearnTheTrail() {
        System.out.print( """
                            Try taking a journey by 
                            covered wagon across 2000 
                            miles of plains, rivers, and 
                            mountains. Try! On the 
                            plains, will you slosh your 
                            oxen through mud and 
                            water-filled ruts or will you 
                            plod through the dust six inches 
                            deep?"           
      """);
        return menuOptions();
    }

    private static String LearnTheCareers() {
        System.out.print( """
                          Traveling to Oregon isn't easy!
                          But if you're a banker, you'll
                          have more money for supplies 
                          and services than a carpenter
                          or a fermer . 
        \n                However, the harder you have
                          to try, the more points you 
                          deserve! Therefore, the  
                          farmer earns the greatest
                          number of points and the
                          banker earns the least.\n                   
      """);
        return userCareer();
    }

    private static String career(int choice) {
        if (choice == 1) {
            System.out.println("You have chosen to be a banker!");
            OregonLogic user = new OregonLogic(400.00, 9, 2);
        } else if (choice == 2) {
            System.out.println("You have chosen to be a carpenter!");
            OregonLogic user = new OregonLogic(250.00, 6, 5);
        } else {
            System.out.println("You have chosen to be a farmer!");
            OregonLogic user = new OregonLogic(100.00, 3, 8);
        }
        return "";
    }

    private static String userCareer() {
        int choice = askQuestionInt("Many kinds of people made the trip to Oregon. \nYou may: \n1. Be a banker from Boston\n2. Be a carpenter from Ohio\n3. Be a farmer from Illinois\n4. Find out the difference between these choices\nWhat is your choice?");
        return
                switch (choice) {
                    case 1 -> career(choice);
                    case 2 -> career(choice);
                    case 3 -> career(choice);
                    case 4 -> LearnTheCareers();
                    default -> "";
                } ;
    }

    private static String menuOptions() {
        int choice = askQuestionInt("\nYou may:\n1. Travel the trail\n2. Learn about the trail\n\nWhat is your choice? ");
        return
                switch (choice) {
                    case 1 -> userCareer();
                    case 2 -> LearnTheTrail();
                    default -> "Invalid choice";
                } ;

        }
    public static int askQuestionInt(String ques) {
        Scanner scan = new Scanner(System.in);
        System.out.println(ques);
        return scan.nextInt();
    }
}
