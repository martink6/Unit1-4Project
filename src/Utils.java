import java.io.IOException;
import java.util.Scanner;

public class Utils {
    static Scanner scan = new Scanner(System.in);

    public static int randInt(int a, int b) {
        return (int) (Math.random() * (b - a)) + a;
    }

    public static int askQuestionInt(String ques) {
        return Integer.parseInt(askQuestion(ques));
    }

    public static String askQuestion(String ques) {
        System.out.print(ques);
        return scan.nextLine();
    }

    public static void clearScreen() {
        try {
            String operatingSystem = System.getProperty("os.name");

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("An error occurred while trying to clear the screen: " + e.getMessage());
        }
    }

}
