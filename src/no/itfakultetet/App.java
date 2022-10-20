
// [Console]::OutputEncoding = [Text.UTF8Encoding]::UTF8

package no.itfakultetet;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        String menyvalg;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Meny");
            System.out.println("-".repeat(30));
            System.out.println("1. Legg til nytt dyr");
            System.out.println("2. Vis dyr");
            System.out.println("q. Avslutt programmet");
            menyvalg = in.nextLine();

            if (menyvalg.equals("q")) {
                System.out.println("Bye....");
                System.exit(0);
            } else if (menyvalg.equals("1")) {
                // Legg til nytt dyr

                Dyr.leggtilDyr();
            } else if (menyvalg.equals("2")) {
                // Skriv til skjerm eksisterende dyr
                if (Files.exists(Paths.get("dyr.csv"))) {
                    Dyr.visDyr();
                } else {
                    System.out.println("Det er ingen lagrede dyr å vise. Lage ett?");
                }
            } else {
                System.out.println(menyvalg + "er et ukjent menyvalg");
            }
        }
    }
}
