import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        KsiazkaAdresowa ksiazka = new KsiazkaAdresowa();

        ksiazka.wczytywanie("ksiazkaAdresowa.json");

        while(true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("KSIAZKA ADRESOWA");
            System.out.println("Jaka akcje chcesz wykonac\n" +
                    "0. Wyswietl rejestry.\n" +
                    "1. Dodaj rejestr.\n" +
                    "2. Usun rejestr.\n" +
                    "3. Edytuj rejestr.\n" +
                    "4. Wyswietl rejestr po nazwisku.\n" +
                    "5. Zapisz i wyjdz.\n");

            int option = scanner.nextInt();

            switch (option){
                case 0:
                    System.out.println(ksiazka.doWyswietlenia());
                    break;
                case 1:
                    ksiazka.wstaw();
                    break;
                case 2:
                    ksiazka.usun();
                    break;
                case 3:
                    ksiazka.edycja();
                    break;
                case 4:
                    System.out.println("Podaj nazwisko do wyszukania:");
                    System.out.println(ksiazka.poNazwisku(scanner.next()));
                    break;
                case 5:
                    try {
                        ksiazka.zapisywanie("ksiazkaAdresowa.json");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;

                default:
                    break;
            }
        }
    }
}
