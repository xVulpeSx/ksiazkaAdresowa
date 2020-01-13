import java.io.IOException;

public class Reset {
    public static void reset(){
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
