// Problema Produtor-Consumidor de mensagem única

package semaforos.ProducerConsumer01;

import java.util.Scanner;

public class ProducerConsumer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer, message);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
        scanner.close();

    }
}
