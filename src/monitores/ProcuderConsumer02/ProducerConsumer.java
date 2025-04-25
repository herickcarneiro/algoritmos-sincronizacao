package monitores.ProcuderConsumer02;

import java.util.Scanner;

public class ProducerConsumer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        Buffer buffer = new Buffer();
        Producer p = new Producer(buffer, message);
        Consumer c = new Consumer(buffer);
        p.start();
        c.start();
    }
}
