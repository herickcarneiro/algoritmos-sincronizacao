package semaforos.BufferCircular;

import java.util.Scanner;

public class ProducerConsumer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        String message = scanner.nextLine();
        Buffer buffer = new Buffer(size);
        Producer producer = new Producer(buffer, message);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
        scanner.close();
    }
}
