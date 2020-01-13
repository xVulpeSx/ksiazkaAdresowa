public class Osoba extends Edytowalne{
    private String imie;
    private String nazwisko;
    Adres adres;

    public Osoba(){};
    public Osoba(String imie, String nazwisko, Adres adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
    }

    @Override
    public void edycja() {
        //edycja wszystkiego
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    };

    public String getNazwiskoImieDoWyswietlenia(){
        StringBuilder result = new StringBuilder();
        result.append(getNazwisko()).append(" ").append(getImie());
        return result.toString();
    }
}
