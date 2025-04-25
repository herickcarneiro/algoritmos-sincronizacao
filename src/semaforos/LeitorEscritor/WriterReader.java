package semaforos.LeitorEscritor;

import java.util.Scanner;

public class WriterReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nr = scanner.nextInt();
        int nw = scanner.nextInt();
        scanner.nextLine();
        String message = scanner.nextLine();
        Buffer buffer = new Buffer("");
        for (int i = 0; i < nr; i++) {
            new Reader(buffer).start();
        }
        for (int i = 0; i < nw; i++) {
            new Writer(buffer, message + String.valueOf(i)).start();
        }

    }

}
