public class Adres extends Edytowalne{
    private String ulica;
    private int nrDomu;
    private int nrMieszkania;
    private int kodPocztowy;
    private String urzadPocztowy;

    public Adres() {
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
        this.kodPocztowy = kodPocztowy;
        this.urzadPocztowy = urzadPocztowy;
    }

    @Override
    public void edycja() {
        //edycja wszystkiego
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(int nrDomu) {
        this.nrDomu = nrDomu;
    }

    public int getNrMieszkania() {
        return nrMieszkania;
    }

    public void setNrMieszkania(int nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }

    public int getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(int kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getUrzadPocztowy() {
        return urzadPocztowy;
    }

    public void setUrzadPocztowy(String urzadPocztowy) {
        this.urzadPocztowy = urzadPocztowy;
    }
}
