import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        // Import for the user of different classes

        System.out.println("Welkom bij de Scrum End Game. Ben je klaar voor de EndGame?\nWat is je naam?");
        String name = scanner.nextLine();
        System.out.println("Speler " + name + " is er klaar voor!");
        System.out.println("Naar welke kamer wil je gaan?");

        // Adding 'kamer objects' based on the sub class.
        ArrayList<String> kamer = new ArrayList<>();
        kamer.add("kamer 1");
        kamer.add("kamer 2");
        kamer.add("kamer 3");
        kamer.add("kamer 4");

        System.out.print("Kies tussen kamers: ");
        // Each created classes can be added in the for loop. That's why the System.out is on 'print'.
        for(int i = 0; i < kamer.size(); i++){
            if(i == kamer.size() - 1){
                System.out.println(kamer.get(i)+ ", ");
            } else {
                System.out.print(kamer.get(i)+ ", ");
            }

        }


        String answer = scanner.nextLine();

        while(!answer.equals("stop")){
            System.out.println("Speler "+ name + " kiest voor " + answer);
            System.out.print("Kies tussen kamers: ");
            // Each created classes can be added in the for loop. That's why the System.out is on 'print'.
            for(int i = 0; i < kamer.size(); i++){
                if(i == kamer.size() - 1){
            System.out.println(kamer.get(i)+ ", ");
                } else {
            System.out.print(kamer.get(i)+ ", ");
                }

            }

            answer = scanner.nextLine();
        }
        System.out.println("Bye Bye👋");

    }
}
