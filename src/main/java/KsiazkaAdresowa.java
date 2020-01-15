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

    public void wczytywanie(String fileName){
        String wczytane = new String(readAllBytesJava7(fileName));

        Type type = new TypeToken<Map<String, Osoba>>(){}.getType();
        rejestry = new Gson().fromJson(wczytane, type);
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
