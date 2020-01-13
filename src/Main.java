import java.io.*;
public class Main {
   private static void zapis(String fileName, KsiazkaAdresowa ksiazka) throws IOException {
       FileWriter openedFile = new FileWriter(fileName);
       openedFile.write(ksiazka.doWyswietlenia());
       openedFile.close();
   }

    public static void main(String[] args){
        KsiazkaAdresowa ksiazka = new KsiazkaAdresowa();

        ksiazka.wstaw();
        Adres adres = new Adres("a", "b", "c","d", "e");
        Osoba osoba = new Osoba("j", "b", adres);
        ksiazka.ultraSetter("123123123", osoba);

        try {
            zapis("ksiazka.txt", ksiazka);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
