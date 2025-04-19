package semaforos.ProducerConsumer03;

public class Consumer extends Thread {
    Buffer buffer;
    String value;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            value = buffer.fetch();
            System.out.println("Consumidor: " + value);
        }
    }
}
