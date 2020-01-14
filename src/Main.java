import java.io.*;
import java.util.Arrays;

public class Main {
    private static void zapis(String fileName, KsiazkaAdresowa ksiazka) throws IOException {
       FileWriter openedFile = new FileWriter(fileName);
       openedFile.write(ksiazka.doWyswietlenia());
       openedFile.close();
   }

   // 0 - imie, 1 - nazwisko, 2 - numer, 3 - ulica, 4 - nrUlicy, ew 5 - nr mieszkania, 6 - kod pocztowy 7 - urzad pocztowy
   private static void poprawienieDanych(KsiazkaAdresowa ksiazka, char[] input){

        Osoba osoba = new Osoba();
        String numerTelefonu = new String();
        StringBuilder buff = new StringBuilder();
        int i = 0;
       for (char c : input) {
           if(c == ' ' || c == '\n'){
               switch (i) {
                   case 0:
                       osoba.setImie(buff.toString());
                       break;
                   case 1:
                       osoba.setNazwisko(buff.toString());
                       break;
                   case 2:
                       numerTelefonu = buff.toString();
                   case 3:
                       osoba.adres.setUlica(buff.toString());
                       break;
                   case 4:
                       osoba.adres.setNrDomu(buff.toString());
                       i++;
                       break;
                   case 5:
                       osoba.adres.setNrMieszkania(buff.toString());
                       break;
                   case 6:
                       osoba.adres.setKodPocztowy(buff.toString());
                       break;
                   case 7:
                       osoba.adres.setUrzadPocztowy(buff.toString());
                       ksiazka.ultraSetter(numerTelefonu, osoba);
                       i = -1;
                       break;
               }
               i++;
               buff.delete(0, buff.capacity());
           }else if (c == '/'){
               osoba.adres.setNrDomu(buff.toString());
               buff.delete(0, buff.capacity());
               i++;
           }else{
               buff.append(c);
           }
       }
   }

   private static void wczytywanie(String fileName, KsiazkaAdresowa ksiazka) throws IOException {
       FileReader openedFile=null;
       try
       {
           openedFile = new FileReader(fileName);
       }
       catch (FileNotFoundException fe)
       {
           System.out.println("File not found");
       }

       char[] cBuff = new char[2048];

       openedFile.read(cBuff);

       poprawienieDanych(ksiazka, cBuff);
       openedFile.close();
   }

    public static void main(String[] args){
        KsiazkaAdresowa ksiazka = new KsiazkaAdresowa();
        /*
        ksiazka.wstaw();
        Adres adres = new Adres("a", "b", "c","d", "e");
        Osoba osoba = new Osoba("j", "b", adres);
        ksiazka.ultraSetter("123123123", osoba);

        try {
            zapis("ksiazka.txt", ksiazka);
        } catch (IOException e) {
            e.printStackTrace();
        }
         */
        try {
            wczytywanie("ksiazka.txt", ksiazka);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(ksiazka.doWyswietlenia());
    }
}
