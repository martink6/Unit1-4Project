import java.util.Scanner;

public class Menus {
    Scanner scan = new Scanner(System.in);
    public Menus() { }

    public String logo() {
        return """
                  _______ _             ____                               _______        _ _ \s
                 |__   __| |           / __ \\                             |__   __|      (_) |\s
                    | |  | |__   ___  | |  | |_ __ ___  __ _  ___  _ __      | |_ __ __ _ _| |\s
                    | |  | '_ \\ / _ \\ | |  | | '__/ _ \\/ _` |/ _ \\| '_ \\     | | '__/ _` | | |\s
                    | |  | | | |  __/ | |__| | | |  __/ (_| | (_) | | | |    | | | | (_| | | |\s
                    |_|  |_| |_|\\___|  \\____/|_|  \\___|\\__, |\\___/|_| |_|    |_|_|  \\__,_|_|_|\s
                                                        __/ |                                 \s
                                                       |___/                                  \s
                """;
    }

    public String menu() {
        System.out.println("You may:\n1. Travel the trail\n2. Learn about the trail\n\nWhat is your choice? ");
        int choice = scan.nextInt();

        return switch (choice) {
            case 1 -> "Travel the trail";
            case 2 -> "Learn about the trail";
            default -> "Invalid choice";
        };
    }


}
