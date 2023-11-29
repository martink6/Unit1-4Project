import java.util.Scanner;

public class Menus {
    Scanner scan = new Scanner(System.in);
    public Menus() { }

    public void logo() {
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

    public void menu() {
        System.out.println("You may:\n1. Travel the trail\n2. Learn about the trail\n\nWhat is your choice? ");
        System.out.println(OregonVisual.menuOptions(scan.nextInt()));
    }


}
