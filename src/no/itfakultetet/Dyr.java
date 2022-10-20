package no.itfakultetet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.Scanner;

public class Dyr implements DyreMetoder {

    private String navn, art, lyd;
    static int antallDyr = 0;

    public Dyr() {
        antallDyr++;
        // System.out.println("Tom konstruktør ble kalt opp");
    }

    public Dyr(String navn, String art, String lyd) {
        this(); // kaller oppp tom konstruktør
        this.navn = navn;
        this.art = art;
        this.lyd = lyd;
    }

    public Dyr(String navn, String art) {
        this();
        this.navn = navn;
        this.art = art;
    }

    public static void leggtilDyr() {
        Dyr nyttDyr = new Dyr();
        Scanner dyrIn = new Scanner(System.in,StandardCharsets.UTF_8);
        System.out.println("Nytt dyr");
        System.out.print("Navn: ");
        nyttDyr.setNavn(dyrIn.nextLine());
        System.out.print("Art: ");
        nyttDyr.setArt(dyrIn.nextLine());
        System.out.print("Lyd: ");
        nyttDyr.setLyd(dyrIn.nextLine());
        System.out.println();

        System.out.println("Slik ble dyret:");
        System.out.println(nyttDyr.toString());

        lagre(nyttDyr);
    }

    private static void lagre(Dyr nyttDyr) {

        try {
            if(!Files.exists(Paths.get("dyr.csv"))) {
                Files.createFile(Paths.get("dyr.csv"));
            }

            BufferedWriter fil = Files.newBufferedWriter(Paths.get("dyr.csv"), StandardCharsets.UTF_8,StandardOpenOption.APPEND);
            fil.append(nyttDyr.getNavn() + "," + nyttDyr.getArt() + "," + nyttDyr.getLyd()+"\n");
            fil.flush();
            fil.close();
        } catch (IOException e) {
            System.out.println("Noe gikk galt. Her er beskjeden fra systemet: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static void visDyr() {

        try {
            BufferedReader filInn = Files.newBufferedReader(Paths.get("dyr.csv"),StandardCharsets.UTF_8);
            System.out.println("-".repeat(40));
            System.out.printf("%-15s %-15s %-15s\n", "Navn", "Art","Lyd" );
            System.out.println("-".repeat(40));
            filInn.lines().forEach(l -> {
                String[] ord = l.split(",");
                System.out.printf("%-15s %-15s %-15s\n",ord[0],ord[1],ord[2]);
            });
            System.out.println("-".repeat(40));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getLyd() {
        return lyd;
    }

    public void setLyd(String lyd) {
        this.lyd = lyd;
    }

    @Override
    public void snakk() {
        System.out.println(this.navn + " sier " + this.lyd);
    }

    @Override
    public void sov() {
        System.out.println(this.navn + " sover nå.");
    }

    @Override
    public String toString() {
        return "Dyr{" +
                "navn='" + navn + '\'' +
                ", art='" + art + '\'' +
                ", lyd='" + lyd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dyr dyr = (Dyr) o;

        if (!Objects.equals(navn, dyr.navn)) return false;
        if (!Objects.equals(art, dyr.art)) return false;
        return Objects.equals(lyd, dyr.lyd);
    }

    @Override
    public int hashCode() {
        int result = navn != null ? navn.hashCode() : 0;
        result = 31 * result + (art != null ? art.hashCode() : 0);
        result = 31 * result + (lyd != null ? lyd.hashCode() : 0);
        return result;
    }
}
