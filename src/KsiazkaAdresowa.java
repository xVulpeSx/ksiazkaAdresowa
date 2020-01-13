import java.io.IOException;
import java.util.*;

public class KsiazkaAdresowa {
    private Map<String, Osoba> rejestry = new HashMap<>();

    public void wyswietl(){
        Reset.reset();

        System.out.println("Książka adresowa - dane:\n");

        StringBuilder buff = new StringBuilder();
        for(Map.Entry<String, Osoba> entry : rejestry.entrySet()){
            System.out.println(entry.getValue().getNazwiskoImieDoWyswietlenia());
            System.out.println("\nNumer telefonu: ");
            System.out.println(entry.getKey());
            System.out.println("\n");
            System.out.println(entry.getValue().adres.getAdresDoWyswietlenia());
        }
    }
    public void wstaw(){
        //tu można chyba zrobić wyjątek, że osoba już jest, narazie orbie jednak bez tego
        Scanner scanner = new Scanner(System.in);
        String numerTelefonu = new String();
        Reset.reset();

        do {
            System.out.println("Podaj numer telefonu: ");
            numerTelefonu = scanner.next();
        }while(rejestry.containsKey(numerTelefonu));

        Osoba nowyRejestr = new Osoba();

        nowyRejestr.edycja();

        rejestry.put(numerTelefonu, nowyRejestr);
    }

    public void usun(){
        //usuwanie
    }

    public void wczytywanie(){
        //wczytywanie z pliku
    }

    public void zapisywanie(){
        //zapisywanie do pliku
    }

}
