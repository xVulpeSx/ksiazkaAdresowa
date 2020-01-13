import java.lang.*;
import java.util.Scanner;

public class Adres extends Edytowalne{
    private String ulica;
    private String nrDomu;
    private String nrMieszkania = "";
    private String kodPocztowy;
    private String urzadPocztowy;

    public Adres(){};
    public Adres(String ulica, String nrDomu, String nrMieszkania, String kodPocztowy, String urzadPocztowy) {
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
        this.kodPocztowy = kodPocztowy;
        this.urzadPocztowy = urzadPocztowy;
    }

    @Override
    public void edycja() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPodaj ulice: ");
        setUlica(scanner.next());
        System.out.println("Podaj numer domu: ");
        setNrDomu(scanner.next());
        System.out.println("Czy posiadasz numer mieszkania? (y/n)\n");
        if(scanner.next().equals("y")){
            System.out.println("Podaj numer mieszkania: ");
            setNrMieszkania(scanner.next());
        }
        System.out.println("Podaj kod pocztowy (XX-XXX)");
        setKodPocztowy(scanner.next());
        System.out.println("Podaj urząd pocztowy; ");
        setUrzadPocztowy(scanner.next());
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    public String getNrMieszkania() {
        return nrMieszkania;
    }

    public void setNrMieszkania(String nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getUrzadPocztowy() {
        return urzadPocztowy;
    }

    public void setUrzadPocztowy(String urzadPocztowy) {
        this.urzadPocztowy = urzadPocztowy;
    }

    public String getAdresDoWyswietlenia(){
        StringBuilder result = new StringBuilder();

        result.append("Adres: ul. ")
                .append(getUlica())
                .append(" ")
                .append(getNrDomu());
        if(getNrMieszkania().equals("")){
            result.append("/")
                    .append(getNrMieszkania());
        }
        result.append(", ")
                .append(getKodPocztowy())
                .append(", urząd pocztowy: ")
                .append(getUrzadPocztowy());
        return result.toString();
    }
}
