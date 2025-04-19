// Problema Produtor-Consumidor com Buffer circular e múltiplos atores

package semaforos.ProducerConsumer03;

import java.util.Scanner;

public class ProducerConsumer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int nprod = scanner.nextInt();
        int nconsu = scanner.nextInt();
        scanner.nextLine();
        String message = scanner.nextLine();
        Buffer buffer = new Buffer(size);
        for (int i = 0; i < nprod; i++) {
            (new Producer(buffer, message)).start();
        }
        for (int i = 0; i < nconsu; i++) {
            (new Consumer(buffer)).start();
        }
        scanner.close();
    }
}
