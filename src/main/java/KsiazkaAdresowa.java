import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class KsiazkaAdresowa {
    private Map<String, Osoba> rejestry = new HashMap<>();

    public String rejestrDoWyswietlenia(String numerTelefonu){
        StringBuilder buff = new StringBuilder();

        for(Map.Entry<String, Osoba> o: rejestry.entrySet()){
            if(o.getKey().compareTo(numerTelefonu) == 0){
                buff.append(o.getValue().getNazwiskoImieDoWyswietlenia())
                        .append("\nNumer telefonu: ")
                        .append(o.getKey())
                        .append("\n")
                        .append(o.getValue().adres.getAdresDoWyswietlenia())
                        .append("\n\n");
            }
        }
        return buff.toString();
    }

    public String doWyswietlenia(){
        StringBuilder buff = new StringBuilder();

        for(Map.Entry<String, Osoba> entry : rejestry.entrySet()) {
            buff.append(rejestrDoWyswietlenia(entry.getKey()));
        }
        return buff.toString();
    }

    public void wstaw(){
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
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj numer telefonu do usuniecia:");
        String numerTelefonu= s.next();
        rejestry.remove(numerTelefonu);
    }

    public void edycja(){
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj numer telefonu do edycji:");
        String numerTelefonu= s.next();
        rejestry.remove(numerTelefonu);
        this.wstaw();
    }

    public void wczytywanie(String fileName){
        String wczytane = new String(readAllBytesJava7(fileName));

        Type type = new TypeToken<Map<String, Osoba>>(){}.getType();
        rejestry = new Gson().fromJson(wczytane, type);
    }

    public String poNazwisku(String naziwskoDoWyszukania){
        String result = new String("Nie znaleziono nazwiska :<\n");
        for(Map.Entry<String, Osoba> o : rejestry.entrySet()){
            if(naziwskoDoWyszukania.compareTo(o.getValue().getNazwisko()) == 0){
                return rejestrDoWyswietlenia(o.getKey());
            }
        }

        return result;
    }

    public void zapisywanie(String fileName) throws IOException {
        String wartosci = new Gson().toJson(rejestry);

        FileWriter openedFile = new FileWriter(fileName);
        openedFile.write(wartosci);
        openedFile.close();
    }

    public void ultraSetter(String numer, Osoba osoba){
        rejestry.put(numer, osoba);
    }

    private static String readAllBytesJava7(String filePath)
    {
        String content = "";
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return content;
    }
}
