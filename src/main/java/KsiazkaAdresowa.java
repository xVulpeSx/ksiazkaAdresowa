import java.io.IOException;
import java.util.*;

public class KsiazkaAdresowa {
    private Map<String, Osoba> rejestry = new HashMap<>();

    public String doWyswietlenia(){
        Reset.reset();
        StringBuilder buff = new StringBuilder();

        for(Map.Entry<String, Osoba> entry : rejestry.entrySet()) {
           buff.append(entry.getValue().getNazwiskoImieDoWyswietlenia())
                   .append("\nNumer telefonu: ")
                   .append(entry.getKey())
                   .append("\n")
                   .append(entry.getValue().adres.getAdresDoWyswietlenia())
                   .append("\n\n");
        }
        return buff.toString();
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

    public void ultraSetter(String numer, Osoba osoba){
        rejestry.put(numer, osoba);
    }
}
