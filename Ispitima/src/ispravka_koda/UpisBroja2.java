package ispravka_koda;

import java.io.*;

public class UpisBroja2 {

    public static void upisiBroj(String fajl) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fajl))) {
            int i = 1, j = 1;
            while (i < 7) {
                if (j == 4 || i + j == 5 || i == 4)
                    out.print('0');
                else out.print(' ');
                j++;
                if (j == 6) {
                    j = 1;
                    i++;
                    out.println();
                }
            }
        } catch (Exception e) {}
    }
}