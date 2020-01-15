import java.io.IOException;

public class Reset {
    public static void reset() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
