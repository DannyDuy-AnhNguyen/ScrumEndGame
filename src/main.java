import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        // Import for the user of different classes

        System.out.println("Welkom bij de Scrum End Game. Ben je klaar voor de EndGame?\nWat is je naam?");
        String name = scanner.nextLine();
        System.out.println("Speler " + name + " is er klaar voor!");

    }
}
