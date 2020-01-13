public class Main {
    public static void main(String[] args){
        KsiazkaAdresowa ksiazka = new KsiazkaAdresowa();

        Adres adres = new Adres("a", "b", "c","d", "e");
        Osoba osoba = new Osoba("j", "b", adres);
        ksiazka.ultraSetter("123123123", osoba);

        ksiazka.wyswietl();
    }
}
