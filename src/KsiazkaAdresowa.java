import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KsiazkaAdresowa {
    private Map<String, Osoba> rejestry = new HashMap<>();

    public void wyswietl(){
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
